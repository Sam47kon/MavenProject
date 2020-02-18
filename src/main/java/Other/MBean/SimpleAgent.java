package Other.MBean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class SimpleAgent {
    private MBeanServer mbs = null;

    public SimpleAgent() {
        // Получить экземпляр MBeanServer
        mbs = ManagementFactory.getPlatformMBeanServer();

        // Создаем наш MBean
        Hello helloBean = new Hello();
        ObjectName helloName = null;

        try {
            // И регистрируем его на платформе MBeanServer
            helloName = new ObjectName("SimpleAgent:name=helloThere");
            mbs.registerMBean(helloBean, helloName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Это вспомогательный метод – он позволяет нашей программе
    // остановиться и ждать
    private static void waitForEnterPressed() {
        try {
            System.out.println("Press  to continue...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        SimpleAgent agent = new SimpleAgent();
        System.out.println("SimpleAgent is running...");
        SimpleAgent.waitForEnterPressed();
    }
}

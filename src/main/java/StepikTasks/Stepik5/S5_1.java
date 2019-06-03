package StepikTasks.Stepik5;

import java.util.logging.*;

public class S5_1 {

    private static void configureLogging() {
        Logger logger = Logger.getLogger("org.stepic.java");
        Handler handler = new ConsoleHandler();

        handler.setFormatter(new XMLFormatter());
        handler.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);

        Logger.getLogger("org.stepic.java.logging.ClassA").setLevel(Level.ALL);
        Logger.getLogger("org.stepic.java.logging.ClassB").setLevel(Level.WARNING);
    }
}

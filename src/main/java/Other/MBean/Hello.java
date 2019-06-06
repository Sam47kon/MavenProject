package Other.MBean;


public class Hello implements HelloMBean {
    private String message = null;

    public Hello() {
        message = "Hello there";
    }

    public Hello(String message) {
        this.message = message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void sayHello() {
        System.out.println(message);
    }
}

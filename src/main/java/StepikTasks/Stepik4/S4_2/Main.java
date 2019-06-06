package StepikTasks.Stepik4.S4_2;

public class Main {
    public static void main(String[] args) {
        Main.moveRobot(new Rcm(), 0, 0);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 1; i <= 3; i++) {
            try (RobotConnection rb = robotConnectionManager.getConnection()) {
                rb.moveRobotTo(toX, toY);
                i = 4;
            } catch (RobotConnectionException rce) {
                if (i == 3) throw rce;
            }
        }
    }
}
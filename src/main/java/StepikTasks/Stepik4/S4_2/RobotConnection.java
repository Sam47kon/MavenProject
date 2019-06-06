package StepikTasks.Stepik4.S4_2;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}

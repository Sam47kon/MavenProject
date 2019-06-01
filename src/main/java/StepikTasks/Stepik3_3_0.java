package StepikTasks;

import java.util.Scanner;

public class Stepik3_3_0 {

    public static void moveRobot(Stepik3_3 robot, int toX, int toY) {
        try {
            java.lang.reflect.Field field = robot.getClass().getDeclaredField("x");
            field.setAccessible(true);
            field.set(robot, toX);

            field = robot.getClass().getDeclaredField("y");
            field.setAccessible(true);
            field.set(robot, toY);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Stepik3_3 robot = new Stepik3_3();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Before: x = " + robot.getX() + ", y = " + robot.getY());
            moveRobot(robot, x, y);
            System.out.println("After: x = " + robot.getX() + ", y = " + robot.getY());
        }
    }
}

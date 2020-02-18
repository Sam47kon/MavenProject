package StepikTasks.Stepik3.S3_3;

import java.util.Scanner;

public class Robot {
    private Direction direction = Direction.UP;
    private int x = 0;
    private int y = 0;

    Robot() {
    }
    Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int dx = robot.getX() - toX;
        int dy = robot.getY() - toY;

        Direction dirX = dx > 0 ? Direction.LEFT : Direction.RIGHT;
        Direction dirY = dy > 0 ? Direction.DOWN : Direction.UP;

        dx = Math.abs(dx);
        dy = Math.abs(dy);

        while (robot.getDirection() != dirX) {
            robot.turnRight();
        }
        while (dx-- > 0) {
            robot.stepForward();
        }

        while (robot.getDirection() != dirY) {
            robot.turnRight();
        }
        while (dy-- > 0) {
            robot.stepForward();
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Before: x = " + robot.getX() + ", y = " + robot.getY());
            moveRobot(robot, x, y);
            System.out.println("After: x = " + robot.getX() + ", y = " + robot.getY());
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }
    }

    public void stepForward() {
        switch (direction) {
            case UP:
                y++;
                return;
            case DOWN:
                y--;
                return;
            case LEFT:
                x--;
                return;
            case RIGHT:
                x++;
        }
    }


    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}


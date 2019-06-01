package StepikTasks;

import java.util.Scanner;

public class Stepik3_3 {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    Stepik3_3() {
    }

    Stepik3_3(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    private Direction direction = Direction.UP;
    private int x = 0;
    private int y = 0;

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

    public static void moveRobot(Stepik3_3 robot, int toX, int toY) {
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


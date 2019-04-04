package JavaHeadFirst.OOP;

class Robot {
    String name;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    private int id;

    Robot(String dataName) {
        name = dataName;
    }

    Robot(int i) {
        id = i;
        Brain brain = new Brain();
        brain.think();
    }

    private class Brain {
        void think() {
            System.out.println(id + " is thinking...");
        }
    }
}


public class ProgramRobots {
    public static void main(String[] args) {
        Robot robot1 = new Robot(1);
        robot1.setName("Vally");
        System.out.println("robot1 name is: " + robot1.getName());

        Robot robot2 = new Robot("Sam");
        System.out.println("robot2 name is: " + robot2.getName());
        robot2.setName("Vally");
        System.out.println("robot2 new name is: " + robot2.getName());

        System.out.println("Does the robot and the robot have the same name? " + (robot1.name.equals(robot2.name) ? "yes" : "no"));
    }
}

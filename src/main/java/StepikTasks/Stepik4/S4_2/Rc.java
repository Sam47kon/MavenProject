/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepikTasks.Stepik4.S4_2;

/**
 * @author afaust
 */
public class Rc extends Throwable implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("ПОЛУЧИЛОСЬ");
    }

    @Override
    public void close() {
        System.out.println("CLOSE");
    }

}

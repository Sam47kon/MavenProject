package StepikTasks.Stepik5;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo {

    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {

        LOGGER.log(Level.FINE, "Started with arguments: {0}", Arrays.toString(args));

        try {
            randomlyFailingAlgorithm();
        } catch (IllegalAccessError e) {
            LOGGER.log(Level.SEVERE, "Exception caught: ", e);
            System.exit(2);
        }
        LOGGER.fine("Finished successfully");


    }

    private static void randomlyFailingAlgorithm() {
        double randomNum = Math.random();
        LOGGER.log(Level.FINE, "Generated random number: {0}", randomNum);
        if (randomNum < 0.5) {
            throw new IllegalStateException("Invalid phase of the Moon");
        }
    }
    }

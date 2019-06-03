package StepikTasks.Stepik5.MailSystem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static StepikTasks.Stepik5.MailSystem.MailSystem.Package;
import static StepikTasks.Stepik5.MailSystem.MailSystem.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class MailSystemTest {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public Logger logger = Logger.getLogger(Main.class.getName());

    @Test
    void testInspector_StoneTrue() {
        AbstractSendable test = new MailPackage("FBR", "NASA", new Package("stones ", 1000));
        try {
            new Inspector().processMail(test);
            fail("Не выбросило исключение StolenPackageException");
        } catch (Exception e) {
            assert (StolenPackageException.class == e.getClass());
        }
    }

    @Test
    void testInspector_IllegalTrue1() {
        AbstractSendable test = new MailPackage("FBR", "NASA", new Package("banned substance ", 1000));
        try {
            new Inspector().processMail(test);
            fail("Не выбросило исключение IllegalPackageException");
        } catch (Exception e) {
            assert (IllegalPackageException.class == e.getClass());
        }
    }

    @Test
    void testInspector_IllegalTrue2() {
        AbstractSendable test = new MailPackage("FBR", "NASA", new Package("weapons substance ", 1000));
        try {
            new Inspector().processMail(test);
            fail("Не выбросило исключение IllegalPackageException");
        } catch (Exception e) {
            assert (IllegalPackageException.class == e.getClass());
        }
    }

    @Test
    void testInspector_TrueMailPackage() {
        MailPackage test = new MailPackage(AUSTIN_POWERS, "NASA", new Package(" asdda", 1000));
        try {
            MailPackage result = (MailPackage) new Inspector().processMail(test);
            assert (test.equals(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testInspector_TrueMailMessage() {
        MailMessage test = new MailMessage(AUSTIN_POWERS, "NASA", "AAAAA");
        try {
            MailMessage result = (MailMessage) new Inspector().processMail(test);
            assert (test.equals(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testSpy_SpyCorrectResultReturn() {
        logger.setLevel(Level.OFF);
        MailPackage test = new MailPackage(AUSTIN_POWERS, "NASA", new Package(" asdda", 1000));
        MailPackage result = (MailPackage) new Spy(logger).processMail(test);
        assert (test.equals(result));
    }

    class myFilter implements Filter {
        public boolean compare = false;
        private String findStr;
        private Object[] arrStr;

        public myFilter(String findStr, Object[] arrStr) {
            this.findStr = findStr;
            this.arrStr = arrStr;
        }

        @Override
        public boolean isLoggable(LogRecord record) {
            if (record.getMessage().equals(findStr)) {
                compare = Arrays.equals(record.getParameters(), arrStr);
            }
            return false;
        }
    }

    @Test
    void testSpy_SpyCorrectLogRec1() {
        MailMessage test = new MailMessage(AUSTIN_POWERS, "NASA", "SOS");
        logger.setLevel(Level.WARNING);
        logger.setFilter(new myFilter("Detected target mail correspondence: from {0} to {1} \"{2}\"",
                new Object[]{"Austin Powers", "NASA", "SOS"}));
        new Spy(logger).processMail(test);
        if (!((myFilter) logger.getFilter()).compare) {
            fail();
        }
    }

    @Test
    void testSpy_SpyCorrectLogRec2() {
        MailMessage test = new MailMessage("CCCP", "NASA", "SOS");
        logger.setLevel(Level.INFO);
        logger.setFilter(new myFilter("Usual correspondence: from {0} to {1}",
                new Object[]{"CCCP", "NASA"}));
        new Spy(logger).processMail(test);
        if (!((myFilter) logger.getFilter()).compare) {
            fail();
        }
    }

    @Test
    void testThief_TheThiefSteals() {
        MailPackage test = new MailPackage("CCCP", "NASA", new Package("asdda", 1000));
        MailPackage result = (MailPackage) new Thief(1000).processMail(test);
        assertEquals("stones instead of asdda", result.getContent().getContent(), "Содержимое посылки некоректно!");
        assertEquals(0, result.getContent().getPrice(), "Цена не 0");
    }

    @Test
    void testThief_CorrectReturnMailMessage() {
        MailMessage test = new MailMessage("CCCP", "NASA", " Z ");
        MailMessage result = (MailMessage) new Thief(1000).processMail(test);
        assertEquals(test, result);
    }

    @Test
    void testThief_CorrectReturnMailPackage() {
        MailPackage test = new MailPackage("CCCP", "NASA", new Package("asdda", 999));
        MailPackage result = (MailPackage) new Thief(1000).processMail(test);
        assertEquals(test, result);
    }

    @Test
    void testUntrustworthyMailWorker() {
        MailMessage test = new MailMessage("CCCP", "NASA", "1");
        MailMessage result = (MailMessage) new UntrustworthyMailWorker(new MailService[]{
                new testMailService(), new testMailService(), new testMailService()
        }).processMail(test);
        assertEquals(4, Integer.parseInt(result.getMessage()));
    }

    private class testMailService implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            int i = Integer.parseInt(((MailMessage) mail).getMessage());
            return new MailMessage(mail.getFrom(), mail.getTo(), String.valueOf(++i));
        }
    }

}
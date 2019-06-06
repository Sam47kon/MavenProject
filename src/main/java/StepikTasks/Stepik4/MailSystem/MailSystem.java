package StepikTasks.Stepik4.MailSystem;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSystem {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
<<<<<<< HEAD
    public interface Sendable {
=======
    public static interface Sendable {
>>>>>>> origin/master
        String getFrom();

        String getTo();
    }


    /*
    Абстрактный класс,который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {
        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;
            if (!from.equals(that.from)) return false;
<<<<<<< HEAD
            return to.equals(that.to);
=======
            if (!to.equals(that.to)) return false;
            return true;
>>>>>>> origin/master
        }
    }


    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {
        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

<<<<<<< HEAD
            return message != null ? message.equals(that.message) : that.message == null;
=======
            if (message != null ? !message.equals(that.message) : that.message != null) return false;
            return true;
>>>>>>> origin/master
        }
    }


    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;
<<<<<<< HEAD
            return content.equals(that.content);
=======
            if (!content.equals(that.content)) return false;
            return true;
>>>>>>> origin/master
        }
    }


    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;
            if (price != aPackage.price) return false;
<<<<<<< HEAD
            return content.equals(aPackage.content);
=======
            if (!content.equals(aPackage.content)) return false;
            return true;
>>>>>>> origin/master
        }
    }


    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
<<<<<<< HEAD
    public interface MailService {
=======
    public static interface MailService {
>>>>>>> origin/master
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------
    ---------------------------------------------------------------------------------------------------------------------*/
    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException(String message) {
            super(message);
        }

        public IllegalPackageException() {
            super();
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException(String text) {
            super(text);
        }

        public StolenPackageException() {
            super();
        }
    }

    public static class UntrustworthyMailWorker implements MailService {
        MailService[] mailServices;
        RealMailService realMailService;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
            realMailService = new RealMailService();
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService otherMailService : mailServices) {
                mail = otherMailService.processMail(mail);
            }
            return realMailService.processMail(mail);
        }
    }


    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                Package pack = ((MailPackage) mail).getContent();
                String content = pack.getContent();
                if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException("IllegalPackageException");
                }
                if (content.contains("stones")) {
                    throw new StolenPackageException("StolenPackageException");
                }
            }
            return mail;
        }
    }


    public static class Spy implements MailService {
        final Logger LOGGER;

        public Spy(Logger logger) {
            LOGGER = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage mailMessage = (MailMessage) mail;
                String from = mailMessage.getFrom();
                String to = mailMessage.getTo();
                if (to.equals(AUSTIN_POWERS) || from.equals(AUSTIN_POWERS)) {
                    String message = mailMessage.getMessage();
                    LOGGER.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[]{from, to, message});
                } else {
                    LOGGER.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{from, to});
                }
            }
            return mail;
        }
    }


    public static class Thief implements MailService {
        final private int minCost;
        private int stolenValue;

        public Thief(int minCost) {
            this.minCost = minCost;
            stolenValue = 0;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                Package pack = ((MailPackage) mail).getContent();
                int prise = pack.getPrice();
                if (prise >= minCost) {
                    stolenValue += prise;
                    String content = pack.getContent();
                    return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + content, 0));
                }
            }
            return mail;
        }
    }
}


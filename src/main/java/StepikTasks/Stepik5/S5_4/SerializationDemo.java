package StepikTasks.Stepik5.S5_4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        infoFromHabr();
//        info();

    }

    private static void info() throws IOException, ClassNotFoundException {
        Client originalClient = new Client();
        originalClient.setID(1);
        originalClient.setName("Chuck Norris");
        originalClient.setBirthDate(LocalDate.of(1940, 3, 10));

        Path path = Paths.get("object.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(originalClient);
        }

        Client deserializedClient;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            deserializedClient = (Client) ois.readObject();
        }

        System.out.printf("%-15s %-30s\n", "ID", deserializedClient.getID());
        System.out.printf("%-15s %-30s\n", "Name", deserializedClient.getName());
        System.out.printf("%-15s %-30s\n", "Date of Birth", deserializedClient.getBirthDate());
        System.out.printf("%-15s %-30s\n", "Age", deserializedClient.getAgeInYears());
    }


    public static class Client implements Serializable {
        private long id;
        private String name;
        private LocalDate birthDate;
        private transient int ageInYears;

        public long getID() {
            return id;
        }

        public void setID(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public int getAgeInYears() {
            if (ageInYears == 0) {
                ageInYears = birthDate.until(LocalDate.now()).getYears();
            }
            return ageInYears;
        }
    }


    private static void infoFromHabr() throws IOException, ClassNotFoundException { // https://habr.com/ru/post/431524/
        Home home = new Home("Vishnevaia 1");
        Person igor = new Person("Igor", 2, "Raphael", home);
        Person renat = new Person("Renat", 2, "Raphael", home);

        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(igor);
        objectOutputStream.writeObject(renat);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Person igorRestored = (Person) objectInputStream.readObject();
        Person renatRestored = (Person) objectInputStream.readObject();
        objectInputStream.close();


        //Сериализация с помощью класса ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream2.writeObject(igor);
        objectOutputStream2.writeObject(renat);
        objectOutputStream2.flush();

        //Восстановление с помощью класса ByteArrayInputStream
        ObjectInputStream objectInputStream2 = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Person igorRestoredFromByte = (Person) objectInputStream2.readObject();
        Person renatRestoredFromByte = (Person) objectInputStream2.readObject();
        objectInputStream2.close();

        System.out.println("Before Serialize: " + "\n" + igor + "\n" + renat);
        System.out.println("After Restored From Byte: " + "\n" + igorRestoredFromByte + "\n" + renatRestoredFromByte);
        System.out.println("After Restored: " + "\n" + igorRestored + "\n" + renatRestored);
    }
}

class Home implements Serializable {
    private String home;

    public Home(String home) {
        this.home = home;
    }

    public String getHome() {
        return home;
    }

    @Override
    public String toString() {
        return home;
    }
}

class Person implements Serializable {
    private String name;
    private int countOfNiva;
    private String fatherName;
    private Home home;

    public Person(String name, int countOfNiva, String fatherName, Home home) {
        this.name = name;
        this.countOfNiva = countOfNiva;
        this.fatherName = fatherName;
        this.home = home;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", countOfNiva=" + countOfNiva +
                ", fatherName='" + fatherName + '\'' +
                ", home=" + home +
                '}';
    }

}


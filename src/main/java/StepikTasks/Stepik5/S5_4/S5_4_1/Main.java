package StepikTasks.Stepik5.S5_4.S5_4_1;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = {new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]);
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());

        System.out.println(Arrays.toString(animalM2));
    }


    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int count = objectInputStream.readInt();
            Animal[] animals = new Animal[count];
            for (int i = 0; i < count; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
            return animals;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new java.lang.IllegalArgumentException();
        }
    }
}


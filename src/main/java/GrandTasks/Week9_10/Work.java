package GrandTasks.Week9_10;

import java.util.HashMap;

public class Work {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Ilya");
        hashMap.put(2, "Alina");

        System.out.println("hashMap.toString() = " + hashMap.toString());
        System.out.println("hashMap.isEmpty() = " + hashMap.isEmpty());

        System.out.println("hashMap.containsKey(1) = " + hashMap.containsKey(1));
        System.out.println("hashMap.containsKey(2) = " + hashMap.containsKey(2));
        System.out.println("hashMap.containsKey(3) = " + hashMap.containsKey(3));

        System.out.println("hashMap.containsValue(\"Ilya\" = )" + hashMap.containsValue("Ilya"));
        System.out.println("hashMap.containsValue(\"Alina\" = )" + hashMap.containsValue("Alina"));
        System.out.println("hashMap.containsValue(\"nothing\") = " + hashMap.containsValue("nothing"));

        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println("hashMap.remove(1) = " + hashMap.remove(1));
        System.out.println("hashMap.remove(3) = " + hashMap.remove(3));
    }
}

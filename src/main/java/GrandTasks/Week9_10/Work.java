package GrandTasks.Week9_10;

public class Work {
    public static void main(String[] args) {
//        HashMap<Integer, String> hashMap = new HashMap<>();
//        hashMap.put(1, "Ilya");
//        hashMap.put(2, "Alina");
//
//        System.out.println("hashMap.toString() = " + hashMap.toString());
//        System.out.println("hashMap.isEmpty() = " + hashMap.isEmpty());
//
//        System.out.println("hashMap.containsKey(1) = " + hashMap.containsKey(1));
//        System.out.println("hashMap.containsKey(2) = " + hashMap.containsKey(2));
//        System.out.println("hashMap.containsKey(3) = " + hashMap.containsKey(3));
//
//        System.out.println("hashMap.containsValue(\"Ilya\" = )" + hashMap.containsValue("Ilya"));
//        System.out.println("hashMap.containsValue(\"Alina\" = )" + hashMap.containsValue("Alina"));
//        System.out.println("hashMap.containsValue(\"nothing\") = " + hashMap.containsValue("nothing"));
//
//        System.out.println("hashMap.size() = " + hashMap.size());
//        System.out.println("hashMap.remove(1) = " + hashMap.remove(1));
//        System.out.println("hashMap.remove(3) = " + hashMap.remove(3));

        CustomHashMap<Integer, String> myMap = new CustomHashMap<>();
        myMap.put(1, "Ilya");
        myMap.put(1, "Alina");
        myMap.put(2, "22");
        myMap.put(3, "33");
        myMap.put(4, "44");
        myMap.put(5, "55");
        myMap.put(6, "66");
        myMap.put(7, "77");
        myMap.put(8, "88");
        myMap.put(9, "99");
        myMap.put(10, "100");
        myMap.put(11, "110");
        myMap.put(12, "120");
        myMap.put(13, "130");
        myMap.put(14, "140");
        myMap.put(15, "150");
        myMap.put(16, "160");

        System.out.println("myMap.toString() = " + myMap.toString());
        System.out.println("myMap.size() = " + myMap.size());
        System.out.println("myMap.get(1) = " + myMap.get(1));
        System.out.println("myMap.get(0) = " + myMap.get(0));
        System.out.println("myMap.containsKey(1) = " + myMap.containsKey(1));
        System.out.println("myMap.containsKey(0) = " + myMap.containsKey(0));
        System.out.println("myMap.containsValue(\"Alina\") = " + myMap.containsValue("Alina"));
        System.out.println("myMap.containsValue(\"false\") = " + myMap.containsValue("false"));
        System.out.println("myMap.remove(1) = " + myMap.remove(1));
        System.out.println("myMap.remove(0) = " + myMap.remove(0));
        System.out.println("myMap.get(1) = " + myMap.get(1));
        System.out.println("myMap.size() = " + myMap.size());

    }
}

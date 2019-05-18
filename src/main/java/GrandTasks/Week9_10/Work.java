package GrandTasks.Week9_10;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Work {
    public static void main(String[] args) {
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

        Set<Integer> keySet = myMap.keySet();
        System.out.println("keySet.toString() = " + keySet.toString());
        Collection<String> values = myMap.values();
        System.out.println("values.toString() = " + values.toString());
        Set<Map.Entry<Integer, String>> entrySet = myMap.entrySet();
        System.out.println("entrySet.toString() = " + entrySet.toString());


        Map<Integer, String> addMap = new CustomHashMap<>();
        addMap.put(9, "gdf");
        addMap.put(10, "gdf");
        addMap.put(11, "gdf");
        addMap.put(12, "gdf");
        addMap.put(15, "gdf");
        addMap.put(20, "gdf");
        addMap.put(99, "gdf");
        addMap.put(45, "gdf");
        addMap.putAll(myMap);
        System.out.println("addMap.toString() = " + addMap.toString());

        myMap.clear();
        System.out.println("myMap.clear(); " + myMap.toString());
    }
}

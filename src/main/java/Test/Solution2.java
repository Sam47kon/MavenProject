package Test;

import MyMethods.MyMethods;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {

  private static List<String> sequences(int n) {
    List<String> list = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        for (int j = i; j >= 1; j--) {
          list.add(String.valueOf(j));
        }
      } else {
        for (int j = 1; j <= i; j++) {
          list.add(String.valueOf(j));
        }
      }
    }
    return list;
  }

  private static void runCode() {
   sequences(1000);
  }

  public static void main(String[] args) {
    System.out.println(MyMethods.getRuntime(Solution2::runCode));
  }
}

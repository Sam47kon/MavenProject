package Test;

import MyMethods.MyMethods;
import java.util.List;

public class Solution3 {

  private static int pairDifferenceCount(List<Integer> arr, int k) {
    int result = 0;
    int tmp1;
    int tmp2;

    for (int i = 0; i < arr.size(); i++) {
      for (int j = 0; j < i; j++) {
        tmp1 = arr.get(i);
        tmp2 = arr.get(j);
        if (tmp1 >= tmp2) {
          if (tmp1 - tmp2 == k) {
            result++;
          }
        } else if (tmp2 - tmp1 == k) {
          result++;
        }
      }
    }
    return result;
  }

  private static void runCode() {
    pairDifferenceCount(List.of(4, 4, 4, 2, 2), 0);
  }


  public static void main(String[] args) {
    System.out.println(MyMethods.getRuntime(Solution3::runCode));
  }
}

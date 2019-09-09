package Test;

import java.util.Objects;

public class Solution {

  static int fourLetters(String sentence) {
    int wordLength = 0;
    int result = 0;
    char tmp;
    for (int i = 0; i < sentence.length(); i++) {
      tmp = sentence.charAt(i);
      if (!Objects.equals(tmp, ' ')) {
        wordLength++;
        if (wordLength == 4 && (sentence.length() == i + 1
            || Objects.equals(sentence.charAt(i + 1), ' '))) {
          result++;
          wordLength = 0;
        }
      } else {
        wordLength = 0;
      }
    }
    return result;
  }
}

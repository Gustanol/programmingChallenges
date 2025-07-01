import java.util.ArrayList;
import java.util.List;

class Solution {
  public static int lengthOfLongestSubstring(String s) {
    List<String> chars = new ArrayList<>();
    int maxSub = 0;
    
    for (int left = 0, right = 0; right < s.length(); right++) {
      while (chars.contains(String.valueOf(s.charAt(right)))) {
        chars.remove(String.valueOf(s.charAt(left)));
        left++;
      }
      chars.add(String.valueOf(s.charAt(right)));
      maxSub = Math.max(maxSub, right - left + 1);
    }
    return maxSub;
  }
}

public class Main {
  public static void main(String[] args) {
    System.out.println(Solution.lengthOfLongestSubstring("abcddev"));
    System.out.println(Solution.lengthOfLongestSubstring("bbbbb"));
    System.out.println(Solution.lengthOfLongestSubstring("pwwkew"));
  }
}
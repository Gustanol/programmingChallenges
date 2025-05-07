import java.util.ArrayList;
import java.util.List;

class Solution {
  public static int lengthOfLongestSubstring(String s) {
    // list to store chars in the current "window"
    List<String> chars = new ArrayList<>();
    
    // left pointer that indicates the start of the current window
    int left = 0;
    
    // longest substring in string
    int maxSum = 0;
    
    // loop that will iterate for string length
    for (int right = 0; right < s.length(); right++) {
      
      // it will verify if the current string right index is already in list
      while (chars.contains(String.valueOf(s.charAt(right)))) {
        
        // it will remove all back right index values from list
        chars.remove(String.valueOf(s.charAt(left)));
        
        // increases the left pointer to "create" a new window
        left++;
      }
      
      // for each iteration, it will keep the current string right index char in list
      chars.add(String.valueOf(s.charAt(right)));
      
      // it will determinate if the current length of window is bigger than the last bigger
      maxSum = Math.max(maxSum, right - left + 1);
    }
    return maxSum;
  }
}

public class Main {
  public static void main(String[] args) {
    System.out.println(Solution.lengthOfLongestSubstring("abcddev"));
  }
}

/*
Example - string "abcddev":

right 0 ->
  chars["a"]
  maxSum = max(0, 0 - 0 + 1) = 1
  
right 1 ->
  chars["a", "b"]
  maxSum = max(1, 1 - 0 + 1) = 

right 2 ->
  chars["a", "b", "c"]
  maxSum = max(2, 2 - 0 + 1) = 3
  
right 3 ->
  chars["a", "b", "c", "d"]
  maxSum = max(3, 3 - 0 + 1) = 4
  
right 4 ->
  chars["a", "b", "c", "d", "d"]
  
  Here, "d" is already in list. Therefore, the "while loop" is called
    
    left 0 -> remove 0 imdex from chars
      chars["b", "c", "d", "d"]
      left++
      
    left 1 -> 
      chars["c", "d", "d"]
    
    left 2 -> 
      chars["d", "d"]
      
    left 3 -> 
      chars["d"]
      left++
    
maxSum = max(4, 4 - 4 + 1) = 4
  
right 5 ->
  chars["d", "e"]
  maxSum = max(4, 5 - 4 + 1) = 4
  
right 6 ->
  chars["d", "e", "v"]
  maxSum = max(4, 6 - 4 + 1) = 4
  
Therefore, the maximum substring length without repeating characters is "4"
*/
# Longest Substring Without Repeating Characters

> Given a string s, find the length of the longest substring without duplicate characters.

---

### Testcases:

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.


Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.


Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

---

### Intuition:

The idea is use a two pointer technique. For each character in the string that didn't appear in the current substring will increment the counter.

---

### Step by step:

- Firstly, a list to store the characters of the current substring is created: `List<String> chars = new ArrayList<>();`

- Now, three variables are defined: `left` (to indicate the left point), `right` (to indicate the right point) and `maxSub` (to indicate the length of the longest substring).

- A main loop `for` is created to iterate for each character of the string.

- The inner loop `while` is used to verify if the current character of the string (`s.charAt(right)`) is already on the list.
  - If it is, the indexes of `left` are removed from the list, while the `left` value is incremented.
  - else, the current character is added to list and `maxSub` is modified:
    - if the current value of `maxSub` is bigger than `right - left + 1` (the length of the current substring), nothing happens. Else, the value of `maxSub` is modified.
 
---

### Example:

Input: s = "abcddev":

- right 0 ->
  - chars["a"]
  - maxSub = max(0, 0 - 0 + 1) = 1
  
- right 1 ->
  - chars["a", "b"]
  - maxSub = max(1, 1 - 0 + 1) = 

- right 2 ->
  - chars["a", "b", "c"]
  - maxSub = max(2, 2 - 0 + 1) = 3
  
- right 3 ->
  - chars["a", "b", "c", "d"]
  - maxSub = max(3, 3 - 0 + 1) = 4
  
- right 4 ->
  - chars["a", "b", "c", "d", "d"]
  
  - Here, "d" is already in list. Therefore, the "while loop" is called
    
    - left 0 -> remove 0 imdex from chars
      - chars["b", "c", "d", "d"]
      - left++
      
    - left 1 -> 
      - chars["c", "d", "d"]
    
    - left 2 -> 
      - chars["d", "d"]
      
    - left 3 -> 
      - chars["d"]
      - left++
    
- maxSub = max(4, 4 - 4 + 1) = 4
  
- right 5 ->
  - chars["d", "e"]
  - maxSub = max(4, 5 - 4 + 1) = 4
  
- right 6 ->
  - chars["d", "e", "v"]
  - maxSub = max(4, 6 - 4 + 1) = 4
  
Therefore, the maximum substring length without repeating characters is "4"
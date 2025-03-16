import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DistinctSubsequences {
  private String mainWord;
  private String anotherWord;
  private Integer count = 0;
  private Map<String, Integer> allLetters = new HashMap<>();
  //deal dealdeal
  
  public DistinctSubsequences(String mainWord, String anotherWord) {
    this.mainWord = mainWord;
    this.anotherWord = anotherWord;
    
    var firstLetter = mainWord.charAt(0);
    var firstAppear = anotherWord.indexOf(firstLetter);
    var lastAppear = anotherWord.lastIndexOf(mainWord.charAt(mainWord.length() - 1));
    
    for (char i : anotherWord.toLowerCase().toCharArray()) {
      allLetters.put(String.valueOf(i), allLetters.getOrDefault(String.valueOf(i), 0) + 1);  
      count = 0;
      for (Integer j = firstAppear; j <= lastAppear; j++) {
        if (String.valueOf(anotherWord.charAt(j)).equals(String.valueOf(i))) {
          count++;
          allLetters.replace(String.valueOf(i), count);
        } else if (mainWord == anotherWord) {
          allLetters.replace(String.valueOf(i), 1);
        }
      }
    }
  }
  
  public Integer calculateSubsequences() {  
    int result = 1;  
    for (char i : mainWord.toLowerCase().toCharArray()) {  
      if (!allLetters.containsKey(String.valueOf(i))) {  
        return 0;
      }  
      result *= allLetters.get(String.valueOf(i));
    }  
    return result;  
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter the main word: ");
    String mainString = scanner.nextLine();
    
    System.out.println("Enter the another word: ");
    String anotherString = scanner.nextLine();
    
    DistinctSubsequences distinctSubsequences = new DistinctSubsequences(mainString, anotherString);
    
    System.out.println("The word " + mainString + " can fit " + distinctSubsequences.calculateSubsequences() + " times in " + anotherString);
  }
}
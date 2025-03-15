import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DistinctSubsequences {
  private String mainWord;
  private String anotherWord;
  private Integer count = 0;
  private Map<String, Integer> allLetters = new HashMap<>();
  private Integer mult = 1;
  //deal dealdeal
  
  public DistinctSubsequences(String mainWord, String anotherWord) {
    this.mainWord = mainWord;
    this.anotherWord = anotherWord;
    
    var firstLetter = mainWord.charAt(0);
    var firstAppear = anotherWord.indexOf(firstLetter);
    var lastAppear = anotherWord.lastIndexOf(mainWord.charAt(mainWord.length() - 1));
    
    for (char i : anotherWord.toLowerCase().toCharArray()) {
      allLetters.put(String.valueOf(i), 1);
      count = 0;
      for (Integer j = firstAppear; j <= lastAppear; j++) {
        if (String.valueOf(anotherWord.charAt(j)).equals(String.valueOf(i))) {
          count++;
          allLetters.replace(String.valueOf(i), count);
        }
      }
    }
  }
  
  public Integer calculateSubsequences() {
    try {
      for (char i : mainWord.toLowerCase().toCharArray()) {
        mult *= allLetters.get(String.valueOf(i));
      }
      return mult;
    } catch (NullPointerException e) {
      return -1;
    }
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
    
    if (distinctSubsequences.calculateSubsequences() == -1) {
      System.out.println("The word " + mainString + " can't fit in " + anotherString);
    } else {
      System.out.println("The word " + mainString + " can fit " + distinctSubsequences.calculateSubsequences() + " times in " + anotherString);
    }
  }
}
import java.util.Scanner;

class StringCount {
  private String mainString;
  private String stringCount;
  private Integer count = 0;
  
  public StringCount(String mainString, String stringCount) {
    this.mainString = mainString;
    this.stringCount = stringCount;
    
    String[] words = mainString.split(" ");
    for (String word : words) {
      if (word.toLowerCase().equals(stringCount.toLowerCase())) count++;
    }
  }
  
  public Integer getCount() {
    return count;
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter a sentence: ");
    String sentence = scanner.nextLine();
    
    System.out.println("Enter a word you want to find in the sentence: ");
    String word = scanner.nextLine();
    
    StringCount stringCount = new StringCount(sentence, word);
    if (stringCount.getCount() == 0) {
      System.out.println("The word " + word + " is not in the sentence!");
    } else {
      System.out.println("The word '" + word + "' has " + stringCount.getCount() + " appearance(s) in the sentence!");
    }
  }
}
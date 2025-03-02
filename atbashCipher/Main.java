import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AtbashCipher {
  private String sentence;
  private String alp = "abcdefghijklmnopqrstuvwxyz";
  private List<String> newSentence = new ArrayList<>();
  
  public AtbashCipher(String sentence) {
    this.sentence = sentence;
    
    for (char i : sentence.toLowerCase().toCharArray()) {
      if (alp.contains(String.valueOf(i))) {
        int newIndex = alp.length() - 1 - alp.indexOf(String.valueOf(i));
        newSentence.add(String.valueOf(alp.charAt(newIndex)));
      } else {
        newSentence.add(String.valueOf(i));
      }
    }
  }
  
  public String getString() {
    return String.join("", newSentence);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter a sentence: ");
    String sentence = scanner.nextLine();
    
    AtbashCipher atbashCipher = new AtbashCipher(sentence);
    
    System.out.println("The encrypted sentence is: " + atbashCipher.getString());
    scanner.close();
  }
}
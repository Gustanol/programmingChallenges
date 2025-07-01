import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CaesarCipher {
  private String phrase;
  private Integer index;
  private String alp = "abcdefghijklmnopkrstuvwxyz";
  private List<String> newPhrase = new ArrayList<>();
  
  public CaesarCipher(String phrase, Integer index) {
    this.phrase = phrase;
    this.index = index;
    
    for (char i : phrase.toLowerCase().toCharArray()) {
      if (alp.contains(String.valueOf(i))) {
        var newIndex = alp.indexOf(String.valueOf(i)) + this.index;
        newPhrase.add(String.valueOf(alp.charAt((newIndex % 26 + 26) % 26))); // in Java, % will preserve dividend sinal, following the formula `a%b = a-(b x Math.floor(a/b))`.
      } else {
        newPhrase.add(String.valueOf(i));
      }
    }
  }
  
  public String getPhrase() {
    return String.join("", this.newPhrase);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter the phrase you want to encrypt: ");
    String currentPhrase = scanner.nextLine();
    
    System.out.println("\nEnter the index of the displacement: ");
    Integer currentIndex = scanner.nextInt();
    
    CaesarCipher caesarCipher = new CaesarCipher(currentPhrase, currentIndex);
    
    System.out.println("\nThe encrypted phrase is: " + caesarCipher.getPhrase());
  }
}
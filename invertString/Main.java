import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvertString {
  private String stringValue;
  private List<String> stringList = new ArrayList<>(); // contains each letter of string
  
  public InvertString(String stringValue) {
    this.stringValue = stringValue;
    
    for (int i = stringValue.length() - 1; i >= 0; i--) {
      stringList.add(Character.toString(stringValue.charAt(i)));
    }
  }
  
  public String getInvertedString() {
    return String.join("", stringList);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter the string you want to invert: ");
    String value = scanner.nextLine();
    
    InvertString invertString = new InvertString(value);
    System.out.println("The inverted string is: " + invertString.getInvertedString());
  }
}
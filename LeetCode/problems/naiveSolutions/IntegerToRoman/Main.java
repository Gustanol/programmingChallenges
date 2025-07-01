import java.util.Comparator;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

class IntegerToRoman {
  private Integer number;
  private Map<Integer, String> romanNumbers = new LinkedHashMap<>();
  private Map<String, Integer> valuesKeysRomanNumbers = new LinkedHashMap<>();
  private List<String> currentRomanNumber = new LinkedList<>();
  private Map<Integer, String> inverseRomanNumbers = new TreeMap<>(Comparator.reverseOrder());
  
  public IntegerToRoman(Integer number) {
    this.number = number;
    
    this.romanNumbers.put(1, "I");
    this.romanNumbers.put(5, "V");
    this.romanNumbers.put(10, "X");
    this.romanNumbers.put(50, "L");
    this.romanNumbers.put(100, "C");
    this.romanNumbers.put(500, "D");
    this.romanNumbers.put(1000, "M");
    
    inverseRomanNumbers.putAll(this.romanNumbers);
    
    for (Map.Entry<Integer, String> i : this.romanNumbers.entrySet()) {
      this.valuesKeysRomanNumbers.put(i.getValue(), i.getKey());
    }
    
    calculateRomanNumbers();
  }
  
  public void calculateRomanNumbers() {
    var persistentValue = this.number;
    var currentNumber = this.number;
    while (currentNumber > 0) {
      currentNumber = persistentValue;
      
      if (romanNumbers.containsKey(currentNumber)) {
        currentRomanNumber.add(romanNumbers.get(currentNumber));
        return;
      } else {
        currentNumber = persistentValue;
        var oldCurrentNumber = currentNumber;
        var remainingNumber = oldCurrentNumber;
        
        outerLoop:
        for (Map.Entry<Integer, String> j : this.inverseRomanNumbers.entrySet()) {
          if (currentNumber >= j.getKey()) {
            currentNumber = j.getKey();
            remainingNumber -= j.getKey();
            persistentValue = remainingNumber;
            currentRomanNumber.add(j.getValue());
            break outerLoop;
          }
        }
      }
    }
  }
  
  public String getRomanNumber() {
    String romanNumberString = String.join("", this.currentRomanNumber);
    
    Pattern pattern = Pattern.compile("(.)\\1{3,}");
    Matcher matcher = pattern.matcher(romanNumberString);
    
    int index = 0;
    while (matcher.find()) {
      Integer currentCharValue = this.valuesKeysRomanNumbers.get(String.valueOf(matcher.group(1).charAt(0)).toUpperCase());
      Integer newCharValue = currentCharValue * 5;
      Integer newCharValue1 = currentCharValue * 10;
      
      index = romanNumberString.indexOf(String.valueOf(matcher.group(1).charAt(0)));
      
      if (index != 0 && String.valueOf(romanNumberString.charAt(index - 1)).equals(this.romanNumbers.get(newCharValue))) {
        romanNumberString = romanNumberString.replace(this.romanNumbers.get(newCharValue) + matcher.group(), this.romanNumbers.get(currentCharValue) + this.romanNumbers.get(newCharValue1));
      } else {
        romanNumberString = romanNumberString.replace(matcher.group(), this.romanNumbers.get(currentCharValue) + this.romanNumbers.get(newCharValue));
      }
    }
    return romanNumberString;
  }
}

class RomanNumberTooHighException extends Exception {
  public RomanNumberTooHighException(String message) {
    super(message);
  }
}

class NegativeRomanNumberException extends Exception {
  public NegativeRomanNumberException(String message) {
    super(message);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer userNumber = 1;
    
    while (true) {
      System.out.println("Enter a number: ");
      String input = scanner.nextLine();
      
      try {
        int temp = Integer.parseInt(input);
        int result = userNumber * temp;

        if (result > 3999) {
          throw new RomanNumberTooHighException("\nEnter a number below 4000!\n");
        } else if (result < 0) {
          throw new NegativeRomanNumberException("\nEnter a positive number!\n");
        } else {
          userNumber = result;
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("\nEnter a valid number!\n");
      } catch (RomanNumberTooHighException f) {
        System.out.println(f.getMessage());
      } catch (NegativeRomanNumberException g) {
        System.out.println(g.getMessage());
      }
    }
    
    IntegerToRoman integerToRoman = new IntegerToRoman(userNumber);
    System.out.println("The roman number is: " + integerToRoman.getRomanNumber());
  }
}
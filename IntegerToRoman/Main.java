import java.util.Comparator;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class IntegerToRoman {
  private Integer number;
  private Map<Integer, String> romanNumbers = new LinkedHashMap<>();
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
    
    calculateRomanNumbers();
  }
  
  public static boolean powerOfTen(Integer num) {
    while (num > 1 && num % 10 == 0) {
      num /= 10;
    }
    if (num == 1) return true;
    return false;
  }
  
  public static boolean fiveTimesPowerOfTen(Integer num) {
    if (num % 5 != 0) return false;
    num /= 5;
    return powerOfTen(num);
  }
  
  public void calculateRomanNumbers() {
    var persistentValue = this.number;
    var currentNumber = this.number;
    while (currentNumber > 0) {
      currentNumber = persistentValue;
      System.out.println("aq " + currentNumber);
      if (romanNumbers.containsKey(currentNumber)) {
        currentRomanNumber.add(romanNumbers.get(currentNumber));
        return;
      }
      
      mainLoop:
      for (Map.Entry<Integer, String> i : this.romanNumbers.entrySet()) {
        if (currentNumber < i.getKey()) {
          System.out.println("i " + i.getKey());
          if (powerOfTen(i.getKey()) && i.getKey() % currentNumber <= i.getKey() * 0.1) {
            var oldCurrentNumber = currentNumber; // 95
            var remainingNumber = oldCurrentNumber;
            if (currentNumber % 100 == 0 || currentNumber % 10 == 0) currentNumber = 0;
            else if (currentNumber >= 10 && currentNumber < 100) currentNumber = (currentNumber / 10) * 10;
            else if (currentNumber >= 100) currentNumber = (currentNumber / 100) * 100;
            var varDividedByTen = i.getKey() * 0.1;
            for (Integer j : this.romanNumbers.keySet()) {
              if (j == varDividedByTen) {
                currentRomanNumber.add(this.romanNumbers.get(j));
                break;
              }
            }
            currentRomanNumber.add(i.getValue());
            
            remainingNumber -= currentNumber;
            if (currentNumber != 0) currentNumber = remainingNumber;
          } else if (fiveTimesPowerOfTen(i.getKey()) && i.getKey() % currentNumber <= i.getKey() * 0.2) {
            var oldCurrentNumber = currentNumber;
            var remainingNumber = oldCurrentNumber;
            if (currentNumber % 100 == 0 || currentNumber % 10 == 0) currentNumber = 0;
            else if (currentNumber >= 10 && currentNumber < 100) currentNumber = (currentNumber / 10) * 10;
            else if (currentNumber >= 100) currentNumber = (currentNumber / 100) * 100;
            var varDividedByFive = i.getKey() * 0.2;
            for (Integer j : this.romanNumbers.keySet()) {
              if (j == varDividedByFive) {
                currentRomanNumber.add(this.romanNumbers.get(j));
                break;
              }
            }
            currentRomanNumber.add(i.getValue());
            
            remainingNumber -= currentNumber;
            if (currentNumber != 0) currentNumber = remainingNumber;
          }
        } 
        else {
            currentNumber = persistentValue;
            var oldCurrentNumber = currentNumber;
            var remainingNumber = oldCurrentNumber;
            System.out.println("old " + oldCurrentNumber);
            System.out.println("current " + currentNumber);
            System.out.println("remaining " + remainingNumber);
            outerLoop:
            for (Map.Entry<Integer, String> j : this.inverseRomanNumbers.entrySet()) {
              if (currentNumber >= j.getKey()) {
                currentNumber = j.getKey(); // 50
                remainingNumber -= j.getKey(); // 24
                persistentValue = remainingNumber;
                currentRomanNumber.add(j.getValue());
                break outerLoop;
              }
            }
            System.out.println("remaining " + remainingNumber);
            System.out.println("persistent " + persistentValue);
          }
          break mainLoop;
        }
      }
    }
  
  
  public String getRomanNumber() {
    return String.join("", this.currentRomanNumber);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter the number: ");
    Integer userNumber = scanner.nextInt();
    
    IntegerToRoman integerToRoman = new IntegerToRoman(userNumber);
    System.out.println(integerToRoman.getRomanNumber());
  }
}
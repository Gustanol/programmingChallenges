import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BubbleSort {
  private List<Integer> intList = new ArrayList<>();
  
  public BubbleSort(List<Integer> intList) {
    this.intList = intList;
    
    for (Integer i = 0; i < intList.size(); i++) {
      
      // `i` is optional
      for (Integer j = 0; j < intList.size() - 1 - i; j++) {
        if (intList.get(j) > intList.get(j + 1)) {
          var temp = intList.get(j);
          intList.set(j, intList.get(j + 1));
          intList.set(j + 1, temp);
        }
      }
    }
  }
  
  public List<Integer> getList() {
    return intList;
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Integer> unorderedList = new ArrayList<>();
    
    while (true) {
      System.out.println("Enter a number: ");
      String input = scanner.nextLine();
      
      try {
        Integer number = Integer.parseInt(input);
        unorderedList.add(number);
      } catch (NumberFormatException e) {
        System.out.println("Enter a valid number!");
      }
      
      System.out.println("Do you want to continue? ");
      String YorN = scanner.nextLine();
      
      if (YorN.toLowerCase().equals("n")) {
        scanner.close();
        break;
      }
      
      continue;
    }
    
    BubbleSort bubbleSort = new BubbleSort(unorderedList);
    System.out.println("Ordered list: " + bubbleSort.getList());
  }
}
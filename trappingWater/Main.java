import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class TrappingRain {
  private List<Integer> elevationMap = new LinkedList<>();
  private Integer counter = 0;
  
  public TrappingRain(List<Integer> elevationMap) {
    this.elevationMap = elevationMap;
    var persistentElevationMap = this.elevationMap;
    
    if (this.elevationMap.size() <= 2) return;
    
    while (!(persistentElevationMap.isEmpty())) {
      var currentElevationMap = this.subList(persistentElevationMap);
      for (Integer i = 0; i < currentElevationMap.size(); i++) {
        if (currentElevationMap.get(i).equals(0)) {
          counter++;
        } else {
          currentElevationMap.set(i, currentElevationMap.get(i) - 1);
        }
      }
      persistentElevationMap = currentElevationMap;
    }
  }
  
  public List<Integer> subList(List<Integer> elevationMap) {
    while (elevationMap.get(0).equals(0) || elevationMap.get(elevationMap.size() - 1).equals(0)) {
      if (elevationMap.get(0).equals(0)) {
        elevationMap.remove(0);
      }
      if (elevationMap.get(elevationMap.size() - 1).equals(0)) {
        elevationMap.remove(elevationMap.size() - 1);
      }
      if (elevationMap.isEmpty() || elevationMap.size() == 1) {
        return List.of();
      }
    }
    return elevationMap;
  }
  public Integer getCounter() {
    return this.counter;
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter list elements separeted by commas: ");
    String stringList = scanner.nextLine();
    List<Integer> myList = new LinkedList<>();
    try {
      for (String i : stringList.split(",")) {
        Integer temp = Integer.parseInt(i);
        myList.add(temp);
      } 
    } catch (NumberFormatException e) {
        System.out.println("That's not a valid Integer list.");
      }
    TrappingRain trappingRain = new TrappingRain(myList);
    System.out.println(trappingRain.getCounter());
  }
}

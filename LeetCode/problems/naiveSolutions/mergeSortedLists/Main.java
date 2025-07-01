import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class MergeSortedLists {
  private List<List<Integer>> lists = new ArrayList<>();
  private List<Integer> sortedLists = new ArrayList<>();
  
  public MergeSortedLists(List<List<Integer>> lists) {
    this.lists = lists;
    
    for (List<Integer> i : lists) {
      for (Integer j : i) {
        sortedLists.add(j);
      }
    }
    Collections.sort(sortedLists);
  }
  
  public List<Integer> getSortedList() {
    return this.sortedLists;
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<List<Integer>> myLists = new ArrayList<>();
    List<Integer> list1 = List.of(0, 2, 4, 6, 8);
    List<Integer> list2 = List.of(1, 2, 3, 4, 5);
    List<Integer> list3 = List.of(4, 6, 4, 7, 10);
    
    myLists.add(list1);
    myLists.add(list2);
    myLists.add(list3);
    
    MergeSortedLists mergeSortedLists = new MergeSortedLists(myLists);
    
    System.out.println(mergeSortedLists.getSortedList());
  }
}
package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedList {

    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2){

        List<Integer> mergedList = new ArrayList<>();

        int i=0;
        int j=0;

        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) <= list2.get(j)){
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while(i < list1.size()){
            mergedList.add(list1.get(i));
            i++;
        }

        while(j < list2.size()){
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,3,5,7);
        List<Integer> list2 = Arrays.asList(2,4,6,8,10);

        List<Integer> result = mergeSortedLists(list1, list2);
        System.out.println(result);

    }
}

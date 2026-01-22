package map;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementMoores {

    public int majorityElement(int[] nums) {

        int element = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            } else if(element == nums[i]){
                count++;
            } else {
                count--;
            }
        }

        int check = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == element){
                check++;
            }
        }

        if(check > ((nums.length)/2)) return element;
      return -1;
    }
}

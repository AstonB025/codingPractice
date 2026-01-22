package map;

import java.util.*;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int number = nums[i];
            int required = target - number;

            if(map.containsKey(required)){
                return new int[]{map.get(required), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

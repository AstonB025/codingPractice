package map;

import java.util.*;
public class MajorityElement {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap();

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) +1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > ((nums.length)/2)){
                return entry.getKey();
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        MajorityElement mj = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int[] sum = {2,5,7,9,4,1};
        int target = 16; // returns [2,3]
        int result = mj.majorityElement(nums);
        System.out.println(result);
        System.out.println();

        System.out.println("Moore's Voting Algoeithm");
        MajorityElementMoores mjm = new MajorityElementMoores();
        int res = mjm.majorityElement(nums);
        System.out.println(res);

        TwoSum ts = new TwoSum();

    }
}

package set;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        int result = 0;
        for(int i=0; i<nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] num = {1,4,3,3,4,2,1};
        int ans = sn.singleNumber(num);
        System.out.println(ans);
        System.out.println();

        System.out.println("Using SET");
        SingleNumberSet sn1 = new SingleNumberSet();
        int ans2 = sn1.singleNumberSet(num);
        System.out.println(ans2);

        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(num));

    }
}
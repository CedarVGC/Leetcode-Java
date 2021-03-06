package problem1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*1. 两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]*/
public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        int[] b=new int[2];
        Map<Integer,Integer> maps = new HashMap<Integer,Integer>();
        lableA:
        for(int i=0;i<nums.length;i++) {
            for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
                if(nums[i]+entry.getValue()==target) {
                    b[0] = entry.getKey();
                    b[1] = i;
                    break lableA;
                }
            }
            maps.put(i,nums[i]);
        }
        return b;
    }
    /*在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。*/
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }
    public static void main(String[] args) {
        int[] nums ={2, 7, 11, 15};
        int target = 9;
        Question1 q=new Question1();
        int[] a=q.twoSum(nums,target);
        for(int s:a) {
            System.out.println(s);
        }
    }
}

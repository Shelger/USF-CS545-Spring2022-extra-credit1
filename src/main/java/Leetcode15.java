package main.java;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                return output;
            if(i>0 && nums[i]==nums[i-1])
                continue;

            int j = i+1;
            int k = nums.length-1;
            int sum = 0;


            while(j<k){
                List<Integer> temp = new ArrayList<Integer>();
                sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    output.add(temp);

                    while(j<k && nums[j] == nums[j+1]) j++;
                    while(j<k && nums[k-1] == nums[k]) k--;
                    j++;
                    k--;
                }
            }
        }
        return output;
    }
}

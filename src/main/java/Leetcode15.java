package main.java;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        if(nums.length>0)
            nums = mergeSort(nums);

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

    private static int[] mergeSort(int[] nums){
        return mergeSort(nums,0,nums.length-1);
    }

    private static int[] mergeSort(int[] nums, int start, int end){
        int mid = (start + end) / 2;
        if(start == end){
            int[] temp = new int[1];
            temp[0] = nums[start];
            return temp;
        }
        int[] temp1 = mergeSort(nums, start, mid);
        int[] temp2 = mergeSort(nums, mid+1, end);

        return merge(temp1, temp2);
    }

    private static int[] merge(int[] temp1, int[] temp2) {
        int[] output = new int[temp1.length + temp2.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < output.length; i++) {
            if (j < temp1.length && k < temp2.length && temp1[j] <= temp2[k]) {
                output[i] = temp1[j];
                j++;
            }
            else if (k < temp2.length && j < temp1.length && temp2[k] < temp1[j]) {
                output[i] = temp2[k];
                k++;
            }
            else if (j >= temp1.length) {
                output[i] = temp2[k];
                k++;
            }
            else if (k >= temp2.length) {
                output[i] = temp1[j];
                j++;
            }
        }
        return output;
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int value = Math.abs(nums[i]);
            int pos = value-1;
            if(nums[pos]>0){
                nums[pos]= -nums[pos];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                int value = i+1;
                result.add(value);
            }
        }
        return result;
        
    }
}
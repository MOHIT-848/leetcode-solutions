class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        for(int num:nums){
            if(result.contains(num)){
                return true;
            }
            result.add(num);
        }
        return false;
    }
}
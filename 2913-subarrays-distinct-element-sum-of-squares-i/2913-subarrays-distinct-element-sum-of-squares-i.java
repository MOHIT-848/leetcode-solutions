class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans =0;
        for(int i=0;i<n;i++){
            HashSet<Integer> result = new HashSet<>();
            for(int j=i;j<n;j++){
                result.add(nums.get(j));
                int count= result.size();
                ans+=count*count;
            }
        }
        return ans;
    }
}
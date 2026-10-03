class Solution {
    public int lengthOfLastWord(String s) {
       String[] result = s.trim().split("\\s+");
        String ans= result[result.length-1];
        return ans.length();
        
    }
}
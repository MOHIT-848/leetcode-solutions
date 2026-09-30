class Solution {
    public String reverseWords(String s) {
        String[] result = s.trim().split("\\s+");
        StringBuilder sb= new StringBuilder();

        for(int i= result.length-1;i>=0;i--){
            if(i==0){
                sb.append(result[i]);
            }
            else
            sb.append(result[i]).append(" ");
        }
        return sb.toString();
        
    }
}
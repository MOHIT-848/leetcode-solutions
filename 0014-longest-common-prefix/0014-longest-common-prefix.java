import java.util.Arrays;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String a= strs[0];
        String b= strs[strs.length-1];
        String result= "";
        int i=0;
        while(i<a.length()&& i<b.length() && a.charAt(i)==b.charAt(i) ){
            result+=a.charAt(i);
            i++;
        }
        return result;
    }
}
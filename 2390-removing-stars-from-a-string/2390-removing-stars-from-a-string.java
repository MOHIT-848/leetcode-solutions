class Solution {
    public String removeStars(String s) {
        char[] ch= s.toCharArray();
       int j=0;
       for(int i=0;i<s.length();i++){
        if(ch[i]=='*'){
            j--;
        }
        else{
            ch[j++]= ch[i];
        }
       }
       return new String(ch,0,j);
    }
}
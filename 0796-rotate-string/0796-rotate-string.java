class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        String concate ="";
        concate+=s;
        concate+=s;
        if(concate.contains(goal)){
            return true;
        }
        return false;
        
    }
}
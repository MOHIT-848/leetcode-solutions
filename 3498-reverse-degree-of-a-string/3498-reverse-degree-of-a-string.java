
class Solution {
    public int reverseDegree(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = 'z' - s.charAt(i) + 1;
            int pro = value * (i + 1);

            result += pro;
        }

        return result;
    }
}

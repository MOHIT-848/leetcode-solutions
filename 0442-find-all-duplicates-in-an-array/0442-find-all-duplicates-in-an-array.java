
import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> dup = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                dup.add(num);
            }
        }

        List<Integer> result = new ArrayList<>(dup);
        Collections.reverse(result);
        return result;
    }
}

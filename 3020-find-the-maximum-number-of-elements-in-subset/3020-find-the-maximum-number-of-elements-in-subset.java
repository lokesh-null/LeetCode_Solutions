public class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int ans = map.getOrDefault(1, 1);
        if (ans % 2 == 0) {
            ans--;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == 1) {
                continue;
            }
            if (entry.getValue() >= 2) {
                int c = 1;
                long a = entry.getKey();
                a *= a;
                while (a < Integer.MAX_VALUE && map.getOrDefault((int) a, 0) >= 2) {
                    a *= a;
                    c++;
                }
                if (a < Integer.MAX_VALUE && map.getOrDefault((int) a, 0) == 1) {
                    c++;
                }
                ans = Math.max(ans, 2 * c - 1);
            }
        }
        return ans;
    }
}
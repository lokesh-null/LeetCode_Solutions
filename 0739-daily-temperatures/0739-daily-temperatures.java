class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int next = i + 1;
            while (next < n && temperatures[i] >= temperatures[next]) {
                if (answer[next] == 0) break; 
                next += answer[next];        
            }
            if (next < n && temperatures[i] < temperatures[next]) {
                answer[i] = next - i; 
            }
        }

        return answer;
    }
}
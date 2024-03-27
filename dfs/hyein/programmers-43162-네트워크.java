import java.util.*;

class Solution {
    int answer = 0;
    ArrayList<Integer> visited = new ArrayList<>();

    public int solution(int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                answer++;
                dfs(computers, n, i);
            }
        }
        return answer;
    }

    public void dfs(int[][] computers, int n, int c) {
        visited.add(c);

        for (int i = 0; i < n; i++) {
            if (computers[c][i] == 1 && !visited.contains(i)) {
                dfs(computers, n, i);
            }
        }
    }
}


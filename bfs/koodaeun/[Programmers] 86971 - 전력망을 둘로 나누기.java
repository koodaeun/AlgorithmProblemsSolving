import java.util.LinkedList;
import java.util.Queue;

class Solution {
   static int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        int[][] arr = new int[n+1][n+1];
        for(int i=0; i<wires.length; i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        for(int i=0; i<wires.length; i++){
            int[] visited = new int[n+1];
            visited[wires[i][0]] = 1;
            visited[wires[i][1]] = 1;

            int cnt1 = bfs(wires[i][0], arr, visited);
            int cnt2 = bfs(wires[i][1], arr, visited);

            answer = Math.min(answer, Math.abs(cnt1-cnt2));
        }

        return answer;
    }

    static int bfs(int start, int[][] arr, int[] visited){
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = 1;


        while(!q.isEmpty()){
            int x = q.poll();
            cnt++;
            for(int i=1; i<arr.length; i++){
                if(arr[x][i] == 1 && visited[i] == 0){
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }

        return cnt;
    }
}

import java.util.Arrays;
class Solution {
    static int cnt=0;

    public static void main(String[] args){
        Solution solution = new Solution();
        int [][] c ={{1, 0, 0}, {0, 1, 0}, {0, 1, 1}};

        //System.out.println(Solution.solution(3,c));
    }
    public static int solution(int n, int[][] computers) {
        boolean [][] visited = new boolean[n][n];
        int answer = 0;


        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++) {
                if (computers[i][j] == 1){
                    //System.out.println(i+" "+j);
                    //computers[i][j]=0;
                    if(!visited[i][j]) {
                        //computers[i][j]=0;
                        dfs(0, i, j, computers, visited, n);
                        answer+=1;
                    }
                }
            }
        }
        //System.out.println(answer);

        return answer;
    }

    public static void dfs(int depth,int start,int end,int [][] computers,boolean[][] visited,int n){
        int [] dx = {0,1,-1,0};
        int [] dy = {1,0,0,-1};
        //computers[start][end]=0;


        if (!visited[start][end]) {

            visited[start][end] =true;
            
            computers[start][end] =0;

            for (int i = 0; i < 4; i++) {
                if(start+dx[i] >=0 && start+dx[i] <n && end+dy[i] >=0 && end+dy[i] <n )
                    if (computers[start + dx[i]][end + dy[i]] == 1) {
                        //computers[start + dx[i]][end + dy[i]] =0;
                        dfs(0, start + dx[i], end + dy[i], computers, visited, n);
                    }
            }

        }


    }
}
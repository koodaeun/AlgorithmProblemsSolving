import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
    static Set<Integer> set;
    public static int solution(String numbers) {
        int answer = 0;
        boolean [] visited = new boolean[numbers.length()];
        set = new HashSet<>();

        dfs(numbers,0,"",visited);
        for(int x:set){
            if(sosu(x)){
                answer+=1;
            }
        }

        return answer;
    }

    public static void dfs(String numbers,int depth,String start,boolean [] visited){

        for (int i=0;i<numbers.length();i++) {
            if(visited[i] == true){
                continue;
            }
            visited[i] =true;
            

            set.add( Integer.parseInt(start+numbers.charAt(i)));

            dfs(numbers, depth + 1, start + numbers.charAt(i), visited);
            visited[i]=false;
        }
    }




    public static boolean sosu(int num){
        if(num ==0){
            return false;
        }else if (num ==1){
            return false;
        }else{
            for (int i=2;i<num;i++){
                //System.out.println(num+" "+i+" "+num%i);
                if(num%i ==0){
                    return false;
                }
            }
        }
        return true;
    }
}
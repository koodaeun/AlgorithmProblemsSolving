import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String len = String.valueOf(n);
        
        for (int i=0;i<len.length();i++){
            answer+= n%10;

            n=n/10;
        }

        return answer;
    }
}
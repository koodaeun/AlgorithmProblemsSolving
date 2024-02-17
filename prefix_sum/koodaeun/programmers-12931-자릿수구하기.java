import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while (n > 0) {
            answer += n % 10; // n의 마지막 자릿수를 더함
            n /= 10; // n을 10으로 나누어 다음 자릿수 준비
        }
        
        return answer;
    }
}
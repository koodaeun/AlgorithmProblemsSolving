import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        int[] a = new int[order.length];
        for (int i = 0; i < order.length; i++) {
            a[order[i] - 1] = i;
        }

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == answer) {
                answer++;
            } else {
                s.push(a[i]);
            }
            while (!s.isEmpty() && s.peek() == answer) {
                s.pop();
                answer++;
            }
        }

        return answer;
    }
}

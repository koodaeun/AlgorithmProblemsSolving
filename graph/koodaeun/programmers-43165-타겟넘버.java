import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        List<Integer> parent = new ArrayList<>();
        parent.add(0);

        for (int i : numbers) {
            List<Integer> child = new ArrayList<>();
            for (int j : parent) {
                child.add(j + i);
                child.add(j - i);
            }
            parent = child;
        }

        for (int num : parent) {
            if (num == target)
                answer++;
        }

        return answer;
    }
}
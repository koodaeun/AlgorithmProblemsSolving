package implementation.khk;

import java.util.*;

public class Solution {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (String[] pt : photo) {
            int sum = 0;
            for (String nm : pt) {
                int idx = Arrays.asList(name).indexOf(nm);
                if (idx >= 0) sum += yearning[idx];
            }
            answer.add(sum);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
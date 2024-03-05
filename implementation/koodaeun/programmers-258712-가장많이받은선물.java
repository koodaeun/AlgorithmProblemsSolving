import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[] answerList = new int[n];
        Map<String, Integer> rate = new HashMap<>();
        Map<String, Integer> idxRecord = new HashMap<>();
        Map<Integer, String> valueRecord = new HashMap<>();
        int[][] chart = new int[n][n];

        for (int i = 0; i < n; i++) {
            chart[i][i] = -1;
        }

        for (int idx = 0; idx < n; idx++) {
            String value = friends[idx];
            idxRecord.put(value, idx);
            valueRecord.put(idx, value);
        }

        for (String gift : gifts) {
            String[] pair = gift.split(" ");
            String giver = pair[0];
            String receiver = pair[1];

            rate.put(giver, rate.getOrDefault(giver, 0) + 1);
            rate.put(receiver, rate.getOrDefault(receiver, 0) - 1);

            Integer idxGiver = idxRecord.get(giver);
            Integer idxReceiver = idxRecord.get(receiver);

            if (idxGiver != null && idxReceiver != null) {
                chart[idxGiver][idxReceiver]++;
                chart[idxReceiver][idxGiver]--;
            }
        }

        for (int giverIdx = 0; giverIdx < n; giverIdx++) {
            for (int receiverIdx = 0; receiverIdx < n; receiverIdx++) {
                if (chart[giverIdx][receiverIdx] > 0 || (chart[giverIdx][receiverIdx] == 0 && rate.getOrDefault(valueRecord.get(giverIdx), 0) > rate.getOrDefault(valueRecord.get(receiverIdx), 0))) {
                    answerList[giverIdx]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, answerList[i]);
        }

        return answer;
    }
}
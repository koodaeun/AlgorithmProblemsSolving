import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int size = friends.length;
        HashMap<String, Integer> dic = new HashMap<>();
        for (int i = 0; i < size; i++) {
            dic.put(friends[i], i);
        }

        int[] giftDegree = new int[size];
        int[][] giftGraph = new int[size][size];
        for (String gift : gifts) {
            String[] giftName = gift.split(" ");
            giftDegree[dic.get(giftName[0])]++;
            giftDegree[dic.get(giftName[1])]--;
            giftGraph[dic.get(giftName[0])][dic.get(giftName[1])]++;
        }

        int answer = 0;
        for (int i = 0; i < size; i++) {
            int num = 0;
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                if (giftGraph[i][j] > giftGraph[j][i] || (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])) {
                    num++;
                }
            }

            if (answer < num) {
                answer = num;
            }
        }

        return answer;
    }
}

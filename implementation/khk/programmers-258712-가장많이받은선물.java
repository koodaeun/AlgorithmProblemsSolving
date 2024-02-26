package implementation.khk;

import java.util.*;

public class Solution {
	
	public int solution(String[] friends, String[] gifts) {

		int n = friends.length;
		int [][] giftMap = new int[n][n];
		int [][] totalInfos = new int[n][3];
		int [] estimateResult = new int[n];

		Map<String, Integer> nameMap = new HashMap<>();
		for(int i=0; i<n; i++) {
			nameMap.put(friends[i], i);
		}

		for(String gift : gifts) {
			String [] targets = gift.split(" ");
			String giver = targets[0];
			String receiver = targets[1];
			int giverIdx = nameMap.get(giver);
			int receiverIdx = nameMap.get(receiver);
			giftMap[giverIdx][receiverIdx] += 1;
		}

		for(int i=0; i<n; i++) {
			int giveCnt = Arrays.stream(giftMap[i]).sum();
			int receiveCnt = 0;
			for(int j=0; j<n; j++) {
				receiveCnt += giftMap[j][i];
			}
			int numericIdx = giveCnt - receiveCnt;
			int [] totalInfo = {giveCnt, receiveCnt, numericIdx};
			totalInfos[i] = totalInfo;
		}

		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				int aCnt = giftMap[i][j];
				int bCnt = giftMap[j][i];
				if(aCnt == bCnt) {
					int aNumericIdx = totalInfos[i][2];
					int bNumericIdx = totalInfos[j][2];
					if(aNumericIdx == bNumericIdx) continue;
					int idx = aNumericIdx > bNumericIdx ? i : j;
					estimateResult[idx] ++;
					continue;
				}

				int idx = aCnt > bCnt ? i : j;
				estimateResult[idx] ++;
			}
		}

		int answer = Arrays.stream(estimateResult).max().orElse(0);
		return answer;
	}
}
package linesweeping.khk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * [BOJ] 5874 - 소를 찾아라
 * https://www.acmicpc.net/problem/5874
 */
public class BOJ_5874 {
	private static List<Integer> backLegs = new ArrayList<>();
	private static List<Integer> frontLegs = new ArrayList<>();
	private static String location = "";
	private static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		location = br.readLine();
		int idx = 0;
		while (idx != location.length()) {
			idx = getLegs("(", idx);
		}
		idx = 2; //유효한 앞다리는 뒷다리가 이전에 존재해야 하므로 2부터 시작
		while (idx != location.length()) {
			idx = getLegs(")", idx);
		}

		for (Integer backLeg : backLegs) {
			for (Integer frontLeg : frontLegs) {
				if (frontLeg > backLeg) cnt++; //유효한 뒷/앞다리를 비교하며 앞다리가 뒷다리보다 이후에 있으면 유효 카운트 증가
			}
		}

		bw.write(String.valueOf(cnt));
		br.close();
		bw.flush();
		bw.close();
	}

	private static int getLegs(String type, int idx) {
		int startIdx = location.indexOf(type.repeat(2), idx); //idx 위치에서부터 다리가 위치한 첫 번째 인덱스 찾기
		int endIdx = startIdx + 1;
		if (startIdx < 0) return location.length(); //idx 이후에 다리가 존재하지 않으면 종료

		for (int i = endIdx; i < location.length(); i++) {
			if (location.charAt(i) != type.charAt(0)) break; //연속성이 끊기면 종료
			endIdx = i; //연속적이면 유효한 마지막 인덱스 업데이트
			if (type.equals("(")) {
				backLegs.add(endIdx); //뒷다리(뒷다리는 두번째 다리로 비교해야 하고)
			}
			else {
				frontLegs.add(endIdx-1); //앞다리(앞다리는 첫번째 다리로 비교해야 함)
			}
		}
		return endIdx+1; //다음번에 순회를 시작할 인덱스 리턴
	}
}

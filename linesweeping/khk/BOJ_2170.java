package inesweeping.khk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [BOJ] 2170 - 선 긋기
 * https://www.acmicpc.net/problem/2170
 *
 * <반례>
 * 3
 * 1 3
 * 8 10
 * 2 9
 * answer : 9
 */
public class BOJ_2170 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] inputs = new int[n][2];
		List<Line> lines = new ArrayList<>();
		boolean isNew = true;
		int length = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			inputs[i][0] = Integer.parseInt(st.nextToken());
			inputs[i][1] = Integer.parseInt(st.nextToken());
		}

    //입력받은 선을 시작점 -> 종료점 순으로 정렬
		Arrays.sort(inputs, (o1, o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);

		for (int[] input : inputs) {
			int start = input[0];
			int end = input[1];
			for (Line line : lines) {
				if (start > line.end) continue; //시작점이 누적된 종료점을 초과하면 연장 불가(패스)
				if (end < line.start) continue; //종료점이 누적된 시작점 미만이면 연장 불가(패스)
        
        //위의 조건을 제외하면 겹치는 부분이 있으므로 최소 시작점/최대 종료점으로 업데이트(연장), isNew = false
				line.start = Math.min(line.start, start);
				line.end = Math.max(line.end, end);
				isNew = false;
				break;
			}

      //신규 선이면 리스트에 추가
			if (isNew) {
				lines.add(new Line(start, end));
			}
      //플래그 초기화
			isNew = true;
		}

    //누적된 선들의 길이 합산
		for (Line line : lines) {
			length += line.end - line.start;
		}

		System.out.println(length);
		br.close();
	}

	public static class Line {
		int start;
		int end;

		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}

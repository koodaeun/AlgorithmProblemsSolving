package implementation.khk;

import java.util.Stack;

public class Solution {

	public int solution(int[] order) {
		Stack<Integer> subContainer = new Stack<>();
		int answer = 0;
		int item = 1;

		for (int i = 0; i < order.length; i++) {
			if (item == order[i]) {
				item++;
				answer++;
			}
			else if (item < order[i]) {
				subContainer.push(item++);
				i--;
			}
			else {
				if (subContainer.empty()) break;

				int subItem = subContainer.pop();
				if (subItem != order[i]) break;
				answer++;
			}
		}

		return answer;
	}
}
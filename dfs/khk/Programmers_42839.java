package dfs.khk;

import java.util.HashSet;
import java.util.Set;

/**
 * programmers-42839-소수찾기
 *
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 *
 * 입출력 예
 * numbers	return
 * "17"	3
 * "011"	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 * */

public class Programmers_42839 {
	static boolean[] primes = new boolean[10000000];
	static Set<Integer> set = new HashSet<>();

	static void prime() {
		for (int i = 2; i < 10000000; i++) {
			// 2는 소수니 일단 넣어 줍니다.
			if (i == 2) {
				primes[i] = true;
				continue;
			}

			int j = 2;
			for (; j <= Math.sqrt(i); j++) {
				// 나눠지면 소수 아니니 패스
				if (i % j == 0)
					break;
			}

			// 마지막 루핑까지 살아있으면 나눠 떨어지는 것이 없으니 소수
			if (j > Math.sqrt(i)) {
				primes[i] = true;
			}
		}
	}

	static void tracking(String[] nums, int depth, int startIdx) {
		StringBuilder sb = new StringBuilder();
		for (int i = startIdx; i < startIdx + depth; i++) {
			sb.append(nums[i % nums.length]);
			int target = Integer.parseInt(sb.toString());
			if (primes[target]) set.add(target);
		}
	}

	static int solution(String numbers) {
		String[] nums = numbers.split("");
		for (int i = 1; i <= numbers.length(); i++) {
			for (int j = 0; j < numbers.length(); j++) {
				tracking(nums, i, j);
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
		prime();
//		String numbers = "17";
		String numbers = "011";
		int result = solution(numbers);
	}
}

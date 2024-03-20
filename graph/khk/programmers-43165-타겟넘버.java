class Solution {
    private static int cnt = 0;

    public int solution(int[] numbers, int target) {
        search(numbers, target, 0, numbers[0]);
        search(numbers, target, 0, -numbers[0]);
        return cnt;
    }

    private static void search(int[] numbers, int target, int depth, int accSum) {
        if (numbers.length-1 == depth) {
            if (target == accSum) cnt++;
            return;
        }

        search(numbers, target, depth+1, accSum+numbers[depth+1]);
        search(numbers, target, depth+1, accSum-numbers[depth+1]);
    }
}
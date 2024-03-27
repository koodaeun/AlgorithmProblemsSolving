import java.util.*;

class Solution {

    ArrayList<Integer> resultList = new ArrayList<>();

    public int solution(String numbers) {

        int len = numbers.length();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) arr[i] = numbers.charAt(i) - '0';
        for (int i = 1; i <= len; i++) permutation(arr, 0, len, i);

        return resultList.size();
    }

    public void permutation(int[] arr, int depth, int n, int r) {

        if (depth == r) {
            String number = "";
            for (int i = 0; i < r; i++) {
                number += arr[i];
            }

            if (isPrime(Integer.parseInt(number)) && !resultList.contains(Integer.valueOf(number))) {
                resultList.add(Integer.valueOf(number));
            }

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}


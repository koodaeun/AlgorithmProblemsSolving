class Solution {
    public int[] solution(String[] wallpaper) {
        int arrLength = wallpaper.length;
        int lux = 0, rdx = 0;
        int luy = wallpaper[0].length();
        int rdy = -1;
        boolean lxb = false, rxb = false;
        String targetStr = "#";

        for (int i = 0; i < arrLength; i++) {
            int lfileIdx = wallpaper[i].contains(targetStr) ? wallpaper[i].indexOf(targetStr) : luy;
            int rfileIdx = wallpaper[i].lastIndexOf(targetStr);
            int reverseIdx = arrLength-1-i;
            String forwardStr = wallpaper[i];
            String reverseStr = wallpaper[reverseIdx];

            if (!lxb && forwardStr.contains(targetStr)) {
                lux = i;
                lxb = true;
            }

            if (!rxb && reverseStr.contains(targetStr)) {
                rdx = reverseIdx + 1;
                rxb = true;
            }

            if (lfileIdx < luy) {
                luy = lfileIdx;
            }

            if (rfileIdx > rdy) {
                rdy = rfileIdx;
            }
        }

        int[] answer = {lux, luy, rdx, ++rdy};
        return answer;
    }
}
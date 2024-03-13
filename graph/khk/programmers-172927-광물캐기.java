class Solution {
    private static final int[][] fatigues = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    private static final int[][] order = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
    private static int min = 0;

    public static int solution(int[] picks, String[] minerals) {
        int[] minerals2 = convertMineral(minerals);

        for (int i = 0; i < order.length; i++) {
            int[] copyPicks = picks.clone();
            worker(copyPicks, minerals2, i, 0, 0, 0);
        }

        return min;
    }

    public static void worker(int[] picks, int[] minerals, int orderIdx, int pickIdx, int mineralIdx, int fatigue) {
        //pick : 곡갱이 인덱스
        int pick = order[orderIdx][pickIdx];
        if (picks[pick] == 0) {
            if (pickIdx == 2) {
                min = orderIdx == 0 ? fatigue : Math.min(min, fatigue);
            } else {
                //현재 곡갱이 개수가 모두 소진되었으면 다음 곡갱이로 이동
                worker(picks, minerals, orderIdx, ++pickIdx, mineralIdx, fatigue);
            }
            return;
        }

        //피로도 합산하고 곡갱이 수 차감
        for (int i = mineralIdx; i <= Math.min(mineralIdx+4, minerals.length-1); i++) {
            int targetMineral = minerals[i];
            fatigue += fatigues[pick][targetMineral];
        }
        mineralIdx = Math.min(mineralIdx+4, minerals.length-1);
        picks[pick] -= 1;

        //피로도가 최소 피로도를 초과하면 해당 순회는 종료
        if (orderIdx != 0 && fatigue > min) {
            return;
        }

        //광물을 모두 순회했거나 곡갱이를 모두 소진하면 순회 종료
        //종료되지 않았으면 다음 광물로 이동
        if (mineralIdx == minerals.length-1 || (pickIdx == 2 && picks[pick] == 0)) {
            min = orderIdx == 0 ? fatigue : Math.min(min, fatigue);
        } else {
            worker(picks, minerals, orderIdx, pickIdx, mineralIdx+1, fatigue);
        }
    }


    public static int[] convertMineral(String[] minerals) {
        int[] convertedMinerals = new int[minerals.length];
        for (int i = 0; i < minerals.length; i++) {
            int idx = 0;
            switch (minerals[i]) {
                case "diamond" :
                    idx = 0;
                    break;
                case "iron" :
                    idx = 1;
                    break;
                case "stone" :
                    idx = 2;
                    break;
            }
            convertedMinerals[i] = idx;
        }
        return convertedMinerals;
    }
}
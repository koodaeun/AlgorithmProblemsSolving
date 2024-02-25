import java.util.*;

class Solution {
    public static ArrayList<Integer[]> bookedInfo = new ArrayList<>();

    public int solution(String[][] book_time) {

        Arrays.sort(book_time, (o1, o2) -> {
            if (o1[0].toString().equals(o2[0].toString())) {
                return o1[1].toString().compareTo(o2[1].toString());
            }
            return o1[0].toString().compareTo(o2[0].toString());
        });

        for (String[] time : book_time) {
            booking(time);
        }

        return bookedInfo.size();
    }

    static void booking(String[] time) {
        int enterTime = Integer.parseInt(time[0].replace(":", ""));
        int exitTime = Integer.parseInt(time[1].replace(":", ""));
        exitTime = addMinutes(exitTime);
        Integer[] translateTime = {enterTime, exitTime};
        int size = bookedInfo.size();

        if (size == 0) {
            bookedInfo.add(translateTime);
            return;
        }

        int i = 0;
        for (i = 0; i < size; i++) {
            if (bookedInfo.get(i)[1] <= translateTime[0]) {
                bookedInfo.get(i)[1] = translateTime[1];
                break;
            }
        }
        if (i == size) {
            bookedInfo.add(translateTime);
        }

        bookedInfo.sort((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
    }

    static Integer addMinutes(Integer time) {
        int up = (time % 100 + 10) / 60;
        return (time / 100 * 100) + ((time % 100 + 10) % 60) + (100 * up);
    }
}
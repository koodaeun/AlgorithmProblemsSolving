import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int [][] present = new int[friends.length][friends.length];
        int[] score = new int[friends.length];
        int [] result =new int[friends.length];
        HashMap<String, Integer> friend = new HashMap<>();  //친구 위치
        for (int i = 0; i < friends.length; i++) {
            friend.put(friends[i], i);
        }

        for (int j=0;j<gifts.length;j++) {                     // 선물내역
            String[] temp = gifts[j].split(" ");

            int give = friend.get(temp[0]);
            int take = friend.get(temp[1]);

            present[give][take]+=1;
        }
        for (int x=0;x< present.length;x++){                //선물 지수
            for (int k=0;k<present[x].length;k++){
                score[x]+=present[x][k];
                score[x]-=present[k][x];
            }
        }

        for (int giver = 0; giver < present.length; giver++) {
            for (int taker = giver + 1; taker < present.length; taker++) {
                int give = present[giver][taker];
                int take = present[taker][giver];

                if (give > take) {
                    result[giver]+=1;
                }
                else if (give < take) {
                    result[taker]+=1;
                }

                else {
                    if (score[giver] > score[taker]) {
                        result[giver]+=1;
                    } else if (score[giver] < score[taker]) {
                        result[taker]+=1;
                    }
                }
            }
        }

        for (int m=0;m< result.length;m++){
            if(result[m]>answer){
                answer=result[m];
            }
        }



        return answer;
    }

    public static void main(String[]args){
        Solution s= new Solution();
        String []friends={"muzi", "ryan", "frodo", "neo"};
        String []gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(s.solution(friends,gifts));
    }
}
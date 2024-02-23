//x,y 의 최댓값과 최솟값을 찾으면 된다고 생각함
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {100,100,0,0};
        for (int i=0;i< wallpaper.length;i++){
            for (int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j) == '#') {
                    //System.out.println(i+" "+j);
                    if(i <answer[0]){
                        answer[0]=i;
                    }
                    if(j <answer[1]){
                        answer[1] =j;
                    }
                    if(i+1 >answer[2]){
                        answer[2]=i+1;
                    }
                    if(j+1 >answer[3]){
                        answer[3] =j+1;
                    }
                }
            }
        }

        return answer;
    }
}
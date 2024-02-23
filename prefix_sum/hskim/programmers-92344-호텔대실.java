import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


class Solution {
    public static int solution(String[][] book_time) {

        int answer = 0;

        //2차원 배열 정렬 
        Arrays.sort(book_time, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }
        });
        //시간을 분으로 바꿈
        String[] temp ;
        int convert;
        Map<Integer, Integer> conv = new HashMap<Integer, Integer>();
        ArrayList<Object> s = new ArrayList<Object>();
        for (int i=0;i<book_time.length;i++){
            for (int j=0;j<book_time[0].length;j++){
                temp = book_time[i][j].split(":");
                convert = Integer.valueOf(temp[0]) * 60 + Integer.valueOf(temp[1]) ;
                if (j ==1 ){
                    convert+=10;
                }
                s.add(convert);
            }
        }
        
        
        Stack<Integer> stack =new Stack<Integer>();

        int idx;
        int stackSize;
        for (int x=(Integer)s.get(0);x<=1440;x++){
            for (int k=0;k<s.size();k+=2){
                if((Integer)s.get(k) == x){
                    stack.push((Integer)s.get(k+1));
                }
                if((Integer)s.get(k+1) == x){
                    idx=stack.indexOf(x);
                    stack.remove(idx);
                }
                stackSize=stack.size();
                if(stackSize>answer){
                    answer=stackSize;
                }
            }
        }

        return answer;
    }
}
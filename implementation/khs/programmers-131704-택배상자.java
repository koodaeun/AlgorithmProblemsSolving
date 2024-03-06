import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> box = new Stack<>();
        Stack<Integer> belt = new Stack<>();

        for (int i= order.length;i>0;i--){
            box.push(i);
        }

        int idx =0;
        while(true){
            if(idx ==order.length){
                break;
            }
            for (int j=0;j<box.size();j++){
                if(box.peek()==order[idx]) {
                    box.pop();
                    answer+=1;
                    idx+=1;
                    break;
                } else if(!belt.isEmpty() && belt.peek()==order[idx] ){
                    belt.pop();
                    answer+=1;
                    idx+=1;
                    break;
                } else{
                    belt.push(box.pop());
                }
            }
            //System.out.println(box);
            //System.out.println(belt);
            int size = belt.size();
            if (box.isEmpty()){
                for (int x=0;x<size;x++){
                    if(!belt.isEmpty() && belt.peek()==order[idx] ){
                        belt.pop();
                        answer+=1;
                        idx+=1;
                    }
                }
                break;
            }
        }
        return answer;
    }
}
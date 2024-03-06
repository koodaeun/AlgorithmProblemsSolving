class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        System.out.println(photo[0].length);
        int idx=0;
        for (int i=0;i<photo.length;i++){
            int sum=0;
            for (int j=0;j<photo[i].length;j++){
                for (int x=0;x<name.length;x++){
                    if(photo[i][j].equals(name[x])){
                        sum+=yearning[x];

                    }
                }
            }
           answer[i] =sum;
        }
        return answer;
    }
    
    public static void main (String [] args){
        Solution s=new Solution();
        String [] a= {"may", "kein", "kain", "radi"};
        int [] b= {5, 10, 1, 3};
        String [][] c= {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println(s.solution(a,b,c));
    }
}
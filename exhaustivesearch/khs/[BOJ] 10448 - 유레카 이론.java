import java.util.*;

class Main {
    static LinkedList tri =new LinkedList<>();

    public static void main(String[] args){

        LinkedList l =new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=0;i<n;i++){
            l.add(sc.nextInt());

        }
        sc.close();

        int sum = 1;
        tri.add(sum);
        for (int x=2;x<=45;x++){
            tri.add(sum+x);
            sum += x;
        }

        for (int j=0;j<n;j++){
            System.out.println(Eureka((int)l.get(j)));
        }

    }

    public static int Eureka (int a){
        int sum=0;
        for (int i=0;i< tri.size();i++){
            for(int j=0;j< tri.size();j++){
                for (int x=0;x< tri.size();x++){
                    sum= (int)tri.get(i) + (int)tri.get(j) + (int)tri.get(x);
                    if( sum == a){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }



}
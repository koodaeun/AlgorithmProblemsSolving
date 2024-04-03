import java.io.*;

public class BOJ_9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < t;i++){
            String nm = br.readLine();
            String[] parts1 = nm.split(" ");
            int n = Integer.parseInt(parts1[0]);
            int m = Integer.parseInt(parts1[1]);
            for(int j = 0;j < m;j++){
                String ab = br.readLine();
                String[] parts2 = ab.split(" ");
                int a = Integer.parseInt(parts2[0]);
                int b = Integer.parseInt(parts2[1]);
            }
            sb.append(n - 1 + "\n");
        }
        System.out.println(sb);
    }
}

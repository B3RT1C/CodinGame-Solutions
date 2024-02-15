import java.util.Scanner;

public class BlowingFuse {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();
        int dis[] = new int [n];
        boolean rep[] = new boolean [n];
        boolean blown = false;
        for (int i = 0; i < n; i++) {
            int nx = in.nextInt();
            dis[i] = nx;
        }
        
        int totalv = 0, maxv = 0;
        for (int i = 0; i < m; i++) {
            int mx = in.nextInt();
            int pos = 0;
            pos = mx-1;
            if (rep[pos] == false){
                totalv = totalv + dis[pos];
                rep[pos] = true;
            } else if (rep[pos] == true){
                totalv = totalv - dis[pos];
                rep[pos] = false;
            }
            if (totalv > maxv){ 
                maxv = totalv;
            }
            if (totalv > c){
                System.out.println("Fuse was blown.");
                i=m;
                blown = true;
            }
        }
        if (!blown){
            System.out.println("Fuse was not blown.");
            System.out.println("Maximal consumed current was "+ maxv + " A.");
        }

        in.close();
    }
}
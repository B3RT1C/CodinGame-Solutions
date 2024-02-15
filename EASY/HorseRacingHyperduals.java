import java.util.Scanner;

public class HorseRacingHyperduals {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int speed [] = new int [N];
        int elega [] = new int [N];
        for (int i = 0; i < N; i++) {
            int V = in.nextInt();
            int E = in.nextInt();
            speed [i] = V;
            elega [i] = E;
        }

    int dist = -1;

    for (int i = 0;i < N;i++){
        for (int y = 0;y < N;y++){
            if (i != y){
                int distaux = Math.abs(speed[i]-speed[y]) + Math.abs(elega[i]-elega[y]);
                if (distaux < dist || dist == -1){
                    dist = distaux;
                }
            }
        }
    }
        
        System.out.println(dist);

        in.close();
    }
}
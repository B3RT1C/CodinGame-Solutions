import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HorseRacingDuals {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> str = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            str.add(pi);
        }

        Collections.sort(str);
        Collections.reverse(str);

        int dif = str.get(0)-str.get(1);
        for(int i = 1;i < str.size();i++){
            int difaux = str.get(i-1)-str.get(i);
            if(dif > difaux){
                dif = difaux;
            }
        }

        System.out.println(dif);

        in.close();
    }
}
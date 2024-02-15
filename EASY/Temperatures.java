import java.util.Scanner;

public class Temperatures {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num [];
        if (n != 0){
            num = new int [n];
        } else {
            num = new int [1];
        }
        int min = 0;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            num [i] = t;
        }

        if (n != 0){
            min = num[0];

            for (int i = 0;i < n;i++){
                if (Math.abs(min) > Math.abs(num[i])){
                    min = num[i];
                } else if (Math.abs(min) == Math.abs(num[i])){
                    if (min < 0 && num[i] < 0){
                        min = num[i];
                    } else {
                       min = Math.abs(num[i]);
                    }
                }
            }
            System.out.println(min);
        } else {
            System.out.println(0);
        }
        
        in.close();
    }
}
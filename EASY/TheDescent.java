import java.util.Scanner;

public class TheDescent {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        while (true) {
            int max = 0, act = 0;
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt();
                if (mountainH > max){
                    max = mountainH;
                    act = i;
                }
            }
    
            System.out.println(act);
        }
    }
}
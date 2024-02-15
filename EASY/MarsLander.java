import java.util.Scanner;

public class MarsLander {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt();
        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt();
            int landY = in.nextInt();
        }

        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt();
            int vSpeed = in.nextInt();
            int fuel = in.nextInt();
            int rotate = in.nextInt();
            int power = in.nextInt();
            
            if (vSpeed > -40 && power > 0){
                power--;
            }
            if (vSpeed <= -40 && power < 4){
                power++;
            }
        
            System.out.println(rotate + " " + power);
            System.err.println(vSpeed);
        }
    }
}
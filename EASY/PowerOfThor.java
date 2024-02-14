import java.util.Scanner;

public class PowerOfThor {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int lightX = in.nextInt();
        int lightY = in.nextInt();
        int initialTx = in.nextInt();
        int initialTy = in.nextInt();

        int diffY = Math.abs(lightY - initialTy);
        int diffX = Math.abs(lightX - initialTx);

        String pointY = lightY > initialTy? "S" : "N"; 
        String pointX = lightX > initialTx? "E" : "W";

        while (diffY != 0 || diffX != 0) {
          if (diffY > 0) {
            System.out.print(pointY);
            diffY--;
          }

          if (diffX > 0) {
            System.out.print(pointX);
            diffX--;
          }

          System.out.println();
        }
        in.close();
    }
}
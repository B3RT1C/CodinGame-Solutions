import java.util.Scanner;

public class AsciiArt {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        int actual;
        String T = in.nextLine().toUpperCase();
        
        for (int i = 0; i < H; i++) {

            String ROW = in.nextLine();

            for (int pos = 0;pos < T.length();pos++){

                int lstart = T.charAt(pos) - 65;
                
                if (lstart >= 0 && lstart <= 25){
                    actual = lstart * L;
                } else {
                    actual = 26 * L;
                }

                System.out.print(ROW.substring(actual,actual+L));
            }
            System.out.println();
        }
    }
}
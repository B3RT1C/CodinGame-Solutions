import java.util.Scanner;

public class Unary {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String M = in.nextLine();
        String converted = null;

        for (int i = 0;i < M.length();i++){

            String preconverted = Integer.toBinaryString(M.charAt(i));
            for (int y = preconverted.length();y < 7;y++){
                preconverted = "0" + preconverted;
            }
            if (converted == null){
                converted = preconverted;
            } else {
                converted = converted + preconverted;
            } 
        }

            char last = '2';

            for (int y = 0;y < converted.length();y++){

                if (converted.charAt(y) == '1'){
                    if (last == '0' || last == '2'){
                        if (last != '2'){
                            System.out.print(" ");
                        }
                        System.out.print("0 0");
                    } else if (last == '1'){
                        System.out.print("0");
                    }
                    last = '1';
                } else if (converted.charAt(y) == '0'){
                    if (last == '1' || last == '2'){
                        if (last != '2'){
                            System.out.print(" ");
                        }
                        System.out.print("00 0");
                    } else if (last == '0'){
                        System.out.print("0");
                    }
                    last = '0';
                }
            }
    }
}
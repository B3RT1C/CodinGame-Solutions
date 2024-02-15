import java.util.Hashtable;
import java.util.Scanner;

public class MimeType {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();

        Hashtable<String, String> MIMEs = new Hashtable<>();
        for (int i = 0; i < N; i++) {
            MIMEs.put(in.next().toLowerCase(), in.next());
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine().toLowerCase();
            int cont = 0;
            if (FNAME.contains(".")){
                for (int j = FNAME.length()-1;j >= 0;j--){
                    if (FNAME.charAt(j) != '.'){
                        cont++;
                    } else {
                        j = 0;
                    }
                }
            }
            if (cont != 0){
                String ext = FNAME.substring(FNAME.length()-cont);
                if (MIMEs.keySet().contains(ext)){
                    System.out.println(MIMEs.get(ext));
                } else {
                    System.out.println("UNKNOWN");
                }
            } else {
                System.out.println("UNKNOWN");
            }
        }

        in.close();
    }
}
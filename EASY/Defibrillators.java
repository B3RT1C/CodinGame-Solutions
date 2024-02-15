import java.util.Scanner;

public class Defibrilltors {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        double lon = Double.valueOf(LON.replace(",","."));
        double lat = Double.valueOf(LAT.replace(",","."));
        double closestdis = -1;
        String closest = "";
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[]defib = DEFIB.split(";");
            double lonb = Double.valueOf(defib[defib.length-2].replace(",","."));
            double latb = Double.valueOf(defib[defib.length-1].replace(",","."));
            double dis = Math.sqrt(Math.pow((lonb-lon)*Math.toDegrees(Math.cos((latb+lat)/2)), 2)+Math.pow((latb-lat),2)*6341);       
            if (dis < closestdis || closestdis == -1){
                closestdis = dis;
                closest = defib[1];
            }
        }
        System.out.println(closest);

        in.close();
    }
}

import java.util.Scanner;

public class BrushFire1D {
	
	public static  void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int totalCases = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i< totalCases; i++) {
			char[] strip = in.nextLine().toCharArray();
			
			int waterDrops = 0;
			int area = 0;
			
			for (char j : strip) {
				if (j == 'f' && area < 1) {
					waterDrops++;
					area = 3;
				}
                
				area--;
			}
			
			System.out.println(waterDrops);
		}
		
		in.close();
	}	
}

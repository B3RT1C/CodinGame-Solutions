import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PersonalBest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String[] gymnasts = in.nextLine().split(",");
		String[] categories = in.nextLine().split(",");
		
		boolean bars = false;
		boolean beam = false;
		boolean floor = false;
		for (String i : categories) {
			if (i.equals("bars")) {
				bars = true;
				
			} else if (i.equals("beam")) {
				beam = true;
				
			} else if (i.equals("floor")) {
				floor = true;
				
			}
		}
				
		int totalData = in.nextInt();
		in.nextLine();
		ArrayList<String[]> data = new ArrayList<>();
		for (int i = 0; i < totalData; i++) {
			data.add(in.nextLine().split(","));			
		}
		
		float[][] personalBest = new float[gymnasts.length][3];
		for (float[] i: personalBest) {
			Arrays.fill(i, -1);
		}
		
		for (int i = 0; i < gymnasts.length; i++) {
			for (String[] j : data) {
				if (j[0].equals(gymnasts[i])) {
					float aux = 0;
					if (bars) {
						aux = Float.valueOf(j[1]);
						personalBest[i][0] = personalBest[i][0] < aux? aux : personalBest[i][0];  

					}
					if (beam) {
						aux = Float.valueOf(j[2]);
						personalBest[i][1] = personalBest[i][1] < aux? aux : personalBest[i][1];  
						
					}
					if (floor) {
						aux = Float.valueOf(j[3]);
						personalBest[i][2] = personalBest[i][2] < aux? aux : personalBest[i][2];  
						
					}
				}	
			}
		}
		
		for (float[] i : personalBest) {
			String out = null;
			for (float j : i) {
				int num = (int)j;
					if (j >= 0 && out == null) {
						out =j-(int)j == 0? String.valueOf(num): String.valueOf(j);
					} else if (j >= 0) {
						out += j-(int)j == 0? "," + num: "," + j;
					}
			}
			System.out.println(out);
		}
				
		in.close();
	}	
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Annihilation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int height = in.nextInt();
		int width = in.nextInt();
		in.nextLine();
		
		ArrayList<int[]> pos = new ArrayList<>();
		
		locateArrows(height, width, in, pos);
		
		int totalTurns = 0;
		while (pos.size() > 0) {

			moveArrows(height, width, pos);
			
			totalTurns++;
			
			detectArrowColision(pos);
				
		}
		System.out.println(totalTurns);
		
		in.close();
	}
	
	static void locateArrows(int height, int width, Scanner in, ArrayList<int[]> pos) {
		for (int i = 0; i < height; i++) {
			String[] gridLine = in.nextLine().split("");
			
			for (int j = 0; j < width; j++) {
				int[] cords = new int[4];
				
				if (gridLine[j].equals("^")) {
					cords[0] = -1;
					cords[1] = 0;
					cords[2] = i;
					cords[3] = j;
					pos.add(cords);
					
				} else if (gridLine[j].equals("v")) {
					cords[0] = 1;
					cords[1] = 0;
					cords[2] = i;
					cords[3] = j;
					pos.add(cords);
					
				} else if (gridLine[j].equals("<")) {
					cords[0] = 0;
					cords[1] = -1;
					cords[2] = i;
					cords[3] = j;
					pos.add(cords);
					
				} else if (gridLine[j].equals(">")) {
					cords[0] = 0;
					cords[1] = 1;
					cords[2] = i;
					cords[3] = j;
					pos.add(cords);
				}
			}
		}
	}
	
	static void moveArrows(int height, int width, ArrayList<int[]> pos) {
		for (int i = 0; i < pos.size(); i++) {
			pos.get(i)[2] = pos.get(i)[2] + pos.get(i)[0];
			pos.get(i)[3] = pos.get(i)[3] + pos.get(i)[1];
			
			if (pos.get(i)[2] < 0) {
				pos.get(i)[2] = height - 1;
			} else if (pos.get(i)[2] == height) {
				pos.get(i)[2] = 0;
			}
			
			if (pos.get(i)[3] < 0) {
				pos.get(i)[3] = width - 1;
			} else if (pos.get(i)[3] == width) {
				pos.get(i)[3] = 0;
			}
		}
	}
	
	static void detectArrowColision(ArrayList<int[]> pos) {
		int[] arrowToBeDeleted = new int[pos.size()];
		Arrays.fill(arrowToBeDeleted, -1);
		 		
		for (int i = 0 ; i < pos.size(); i++) {
			for (int j = 0 ; j < pos.size(); j++) {
				if (pos.get(i)[2] == pos.get(j)[2] && pos.get(i)[3] == pos.get(j)[3] && i != j && arrowToBeDeleted[i] != i) {
					arrowToBeDeleted[i] = i;
				}
			}
		}
		
		
		for (int y = arrowToBeDeleted.length-1; y >= 0; y--) {
			if (arrowToBeDeleted[y] != -1) {
				pos.remove(arrowToBeDeleted[y]);
			}
		}
	}	
}
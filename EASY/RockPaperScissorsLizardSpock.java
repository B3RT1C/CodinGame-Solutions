

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RockPaperScissorsLizardSpock {
	
	// 0 to delete first entry of ArrayList players and 1 to delete the first
		static int looser(String p1Sign, String p2Sign, int p1Num, int p2Num) {
		int whoLost = p2Num;

		if (p1Sign.equals(p2Sign) && p1Num > p2Num) {
			whoLost = p1Num;

		} else if (p1Sign.equals("R") && (p2Sign.equals("P") || p2Sign.equals("S"))) {
			whoLost = p1Num;

		} else if (p1Sign.equals("P") && (p2Sign.equals("C") || p2Sign.equals("L"))) {
			whoLost = p1Num;

		} else if (p1Sign.equals("C") && (p2Sign.equals("S") || p2Sign.equals("R"))) {
			whoLost = p1Num;
				
		} else if (p1Sign.equals("L") && (p2Sign.equals("R") || p2Sign.equals("C"))) {
			whoLost = p1Num;

		} else if (p1Sign.equals("S") && (p2Sign.equals("L") || p2Sign.equals("P"))) {
			whoLost = p1Num;
		}
		return whoLost;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int nPlayers = in.nextInt();
	
		ArrayList<Integer> eliminatory = new ArrayList<>();
		HashMap<Integer, String> players = new HashMap<>();
		for (int i = 0; i < nPlayers; i++) {
			int num = in.nextInt();
			eliminatory.add(num);
			players.put(num, in.next());
		}
		
		int i = 0;
		String[] history = new String[nPlayers];
		while (eliminatory.size() > 1) {
			if (i >= eliminatory.size()) {
				i = 0;
			}
			int player1num = eliminatory.get(i);
			int player2num = eliminatory.get(i+1);
			String player1Sign = players.get(player1num);
			String player2Sign = players.get(player2num);
			
			int looser = looser(player1Sign, player2Sign, player1num, player2num);
			int winner = looser == player1num? player2num : player1num;
			
			history[winner-1] =history[winner-1] == null? "" + looser: history[winner-1] + " " + looser;
			
			int j = 0;
			while (eliminatory.get(j) != looser) {
				j++;
			}
			eliminatory.remove(j);
			
			i++;			
			}
		
		System.out.println(eliminatory.get(0));
		System.out.println(history[eliminatory.get(0)-1]);
		in.close();
	}
}

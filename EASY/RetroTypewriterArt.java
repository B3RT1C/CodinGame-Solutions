import java.util.Hashtable;
import java.util.Scanner;

public class RetroTypewriterArt {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Hashtable<String,Character> draw = new Hashtable<>();
        draw.put("sp", ' ');
        draw.put("bS", '\\');
        draw.put("sQ", '\'');
        String T = in.nextLine();
        String recipe[] = T.split(" ");
        for (int i = 0;i < recipe.length;i++){
            boolean isin = false, spc = false;
            for (String j : draw.keySet()){
                if (recipe[i].contains(j)){
                    isin = true;
                } else if (recipe[i].contains("nl")) {
                	spc = true;
                }
            }
            int numdraws = 0;
            String key = "";
            if (spc) {
            	System.out.println();
        	}else if (isin){
                numdraws = Integer.parseInt(recipe[i].substring(0, recipe[i].length()-2));
                key = recipe[i].substring(recipe[i].length()-2);

                for (int y = 0;y < numdraws;y++){
                    System.out.print(draw.get(key));
                }
            } else {
                numdraws = Integer.parseInt(recipe[i].substring(0, recipe[i].length()-1));
                key = recipe[i].substring(recipe[i].length()-1);

                for (int y = 0;y < numdraws;y++){
                    System.out.print(key);
                }
            }
        }
        
        in.close();
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Spreadsheet1D {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        //0 = N pos in sheet Array / 1 = operation / 2 = arg1 / 3 = arg2
        ArrayList<String[]> queue = new ArrayList<>();

        int[] sheet = new int[in.nextInt()];
        
        boolean[] done = new boolean[sheet.length];

        //Makes all possible operations and the ones that are not possible are added to the queue ArrayList
        processIn(in, sheet, done, queue);
        
        //Loops until all operations in the queue ArrayList are complete
        processQueue(queue, sheet, done);
        
        for (int i : sheet) {
        	System.out.println(i);
        }

        in.close();
    }

    public static int action(String operation, int arg1, int arg2) {
        switch (operation) {
            case "VALUE":
                return arg1;

            case "ADD":
                return arg1 + arg2;

            case "SUB":
                return arg1 - arg2;

            case "MULT":
                return arg1 * arg2;

            default:
                return 0;
        }
    }

    public static int toInt(String arg) {
        if (arg.charAt(0) == '$') {
        	return Integer.valueOf(arg.substring(1, arg.length()));

        } else if (arg.equals("_")){
            return 0;

        } else {
            return Integer.valueOf(arg);
        }
    }
    
    //This method returns the sheet value referenced by any arg starting with $
    public static int getSheetValue(String arg, int[] sheet) {
    	return sheet[toInt(arg)];
    }
    
    //Checks the done array to know if that index on the sheet array has a definitive value and returns true if it has one
    public static boolean hasValue(String arg, boolean[] done) {
    	if (arg.charAt(0) == '$') {
			return done[toInt(arg)];
			
		} else {
			return false;
		}
    }
    
    //Returns an int being a parse of a string or the referenced value in the sheet array if the string starts with $
    public static int asignVal(String arg, int[] sheet) {
    	if (arg.charAt(0) == '$') {
			return getSheetValue(arg, sheet);
			
		} else {
			return toInt(arg);	
		}
    }
    
    public static void processIn(Scanner in, int[] sheet, boolean[] done, ArrayList<String[]> queue) {
    	for (int i = 0; i < sheet.length; i++) {
        	String operation = in.next();
        	String arg1 = in.next();
        	String arg2 = in.next();
        	
        	boolean done1 = hasValue(arg1, done);
        	boolean done2 = hasValue(arg2, done);
        	
        	int val1 = asignVal(arg1, sheet);
        	int val2 = asignVal(arg2, sheet);
        
        	if (!(!done1 && arg1.charAt(0) == '$') && !(!done2 && arg2.charAt(0) == '$')) {
        		sheet[i] = action(operation, val1, val2);
    			done[i] = true;
        	
        	} else {
        		queue.add(new String[]{String.valueOf(i), operation, arg1, arg2});        		
        		
        	}
        }
    }
    
    public static void processQueue(ArrayList<String[]> queue, int[] sheet, boolean[] done) {
    	int index = 0;
        while (!queue.isEmpty()) {
        	index = index == queue.size()? 0 : index;
        	int sheetPos = Integer.parseInt(queue.get(index)[0]);
        	
        	String operation = queue.get(index)[1];
        	String arg1 = queue.get(index)[2];
        	String arg2 = queue.get(index)[3];
        	
        	boolean done1 = hasValue(arg1, done);
        	boolean done2 = hasValue(arg2, done);
        	
        	int val1 = asignVal(arg1, sheet);
        	int val2 = asignVal(arg2, sheet);
        	
        	//HELP D:
        	if (!(!done1 && arg1.charAt(0) == '$') && !(!done2 && arg2.charAt(0) == '$')) {
        		sheet[sheetPos] = action(operation, val1, val2);
           		done[sheetPos] = true;
           		queue.remove(index);
        	
        	} else {
        		index++;
        	}
        }
    }
}
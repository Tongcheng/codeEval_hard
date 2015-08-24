import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static boolean isOp(String s){
		if (s.equals("+") || s.equals("*") || s.equals("/")) return true;
		return false;
	}
	
	public static double _eval(String op, String in1, double in2){
		if (op.equals("+")){return Double.parseDouble(in1)+in2;}
		else if (op.equals("*")){return Double.parseDouble(in1)*in2;}
		else {return Double.parseDouble(in1)/in2;}
	}
	
	public static int eval(String[] C){
		double out=0;
		Stack<String> S=new Stack<String>();
		for (String curS:C){
			//special Op case
			if (curS.equals("+")){S.push("+");}
			else if (curS.equals("*")){S.push("*");}
			else if (curS.equals("/")){S.push("/");}
			else {
				out=Double.parseDouble(curS);
				while (!S.isEmpty() && !isOp(S.peek())){
					String in1=S.pop();
					out=_eval(S.pop(),in1,out);
				}
				S.push(Double.toString(out));
			}
		}
		return (int)out;
	}
	
	public static void main (String[] args) throws IOException{
		/*
		String S="+ 2 + 3 4";
		String[] C=S.split(" ");
		System.out.println(eval(C));
		*/
		
		File file = new File(args[0]);
		Scanner in=new Scanner(file);
		while (in.hasNextLine()){
			String line=in.nextLine();
			String[] C=line.split(" ");
			
			//System.out.println("input:"+line);
			System.out.println(eval(C));
			
		}
	    
	}
}

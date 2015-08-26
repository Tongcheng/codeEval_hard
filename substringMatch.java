import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void print2D(boolean[][] B){
		int m=B.length;
		int n=B[0].length;
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static String convertLL1(String pattern){
		StringBuilder output=new StringBuilder();
		for (int i=0;i<pattern.length();i++){
			if (pattern.charAt(i)=='\\' && i!=pattern.length()-1 && pattern.charAt(i+1)=='*'){
				output.append('*'); i++;
			}
			else if (pattern.charAt(i)=='\\') continue;//for robustness in ill-conditioned cases
			else if (pattern.charAt(i)=='*') output.append('.');
			else output.append(pattern.charAt(i));
		}
		return output.toString();
	}
	
	//P is the compiled pattern, normal characters include ('*' union alphabet), 
	//special character is '.' which means 0 or more any chars
	public static boolean isMatch(String S, String P){
		
		//M[i][j] == true iff M
		boolean[][] M=new boolean[S.length()+1][P.length()+1];
		//init
		for (int i=0;i<=S.length();i++) M[i][0]=true;
		for (int j=1;j<=P.length();j++) M[0][j]=M[0][j-1] && P.charAt(j-1)=='.';
		
		//recur
		for (int i=1;i<=S.length();i++){
			for (int j=1;j<=P.length();j++){
				if (P.charAt(j-1)=='.'){M[i][j]=M[i-1][j]||M[i][j-1];}
				else {M[i][j]=M[i-1][j-1] && (S.charAt(i-1)==P.charAt(j-1));}
			}
		}
		//print2D(M);
		boolean output=false;
		for (int i=0;i<=S.length();i++) output=output || M[i][P.length()];
		return output;
	}
	
	
	public static void main (String[] args) throws IOException{
		
		//Scanner in=new Scanner(new FileReader("myTest.txt"));
		//String p=in.nextLine();
		//System.out.println(convertLL1(p));
		
		
		File file = new File(args[0]);
		Scanner in=new Scanner(file);
		
		while (in.hasNextLine()){
			String line=in.nextLine();
			String[] spGroup=line.split(",");
			String str=spGroup[0];
			String pattern=spGroup[1];
			pattern=convertLL1(pattern);
			//System.out.println("pattern is "+pattern);
			System.out.println(isMatch(str,pattern));
		}
	    
	}
}

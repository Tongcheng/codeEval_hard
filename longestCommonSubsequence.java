import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void print2DArray(String[][] M){
		int m=M.length; int n=M[0].length;
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				System.out.print(M[i][j]+" ;");
			}
			System.out.println();
		}
	}
	
	
	//DP
	public static String LCS(String a,String b){
		//M[i][j] is the length of the LCS for a.substring(0,i) & b.substring(0,j)
		String[][] M=new String[a.length()+1][b.length()+1];
		for (int i=0;i<=a.length();i++)for(int j=0;j<=b.length();j++) M[i][j]="";
		//M[i][0] = 0 and M[0][j] = 0 automatically
		for (int i=1;i<=a.length();i++){
			for (int j=1;j<=b.length();j++){
				//about char a.charAt(i-1) and char b.charAt(j-1)
				if (a.charAt(i-1)==b.charAt(j-1)) {
					M[i][j]=M[i-1][j-1]+a.charAt(i-1);
				}
				else {M[i][j]=(M[i-1][j].length()>M[i][j-1].length()?M[i-1][j]:M[i][j-1]);}
				
				
			}
		}
		//print2DArray(M);
		return M[a.length()][b.length()];
	}
	
	public static void main (String[] args) throws IOException{
		//System.out.println(LCS("abcabc","cab"));
		
		
		File file = new File(args[0]);
		Scanner in=new Scanner(file);
		while (in.hasNextLine()){
			String total=in.nextLine();
			String[] s=total.split(";");
			String a=s[0]; String b=s[1];
		
			System.out.println(LCS(a,b));
		}
		
	}
}

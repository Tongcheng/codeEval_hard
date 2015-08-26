import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static void DFS(List<String> output, StringBuilder curA, char[] L,int n){
		//base case
		if (curA.length()==n) output.add(curA.toString());
		//normal case
		else {
			for (char c:L){
				curA.append(c);
			
				DFS(output,curA,L,n);
			
				curA.deleteCharAt(curA.length()-1);
			}
		}
	}
	
	public static List<String> stringList(int n,String S){
		HashSet<Character> H=new HashSet<Character>();
		for (int i=0;i<S.length();i++){H.add(S.charAt(i));}
		char[] L=new char[H.size()];
		int counter=0; 
		for (char c:H){
			L[counter]=c;
			counter++;
		}
		Arrays.sort(L);
		StringBuilder curA=new StringBuilder();
		List<String> output=new ArrayList<String>();
		DFS(output,curA,L,n);
		return output;		
	}
	
	public static void main (String[] args) throws IOException{
		
		//Scanner in=new Scanner(new FileReader("myTest.txt"));
		
		
		
		File file = new File(args[0]);
		Scanner in=new Scanner(file);
		
		while (in.hasNextLine()){
			String line=in.nextLine();
			String[] spGroup=line.split(",");
			int n=Integer.parseInt(spGroup[0]);
			String S=spGroup[1];
			List<String> listS=stringList(n,S);
			for (int i=0;i<listS.size();i++){
				System.out.print(listS.get(i));
				if (i!=listS.size()-1) System.out.print(',');
				else System.out.print("\n");
			}
		}
	    
	}
}

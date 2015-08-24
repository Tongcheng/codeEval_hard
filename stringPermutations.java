import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	//recursive
	//SB is the current configuration, L is todo list
	public static void DFS(List<String> output,StringBuilder SB, List<Character> L){
		//base case
		if (L.size()==0) output.add(SB.toString());
		//normal case
		for (int i=0;i<L.size();i++){
			char c=L.get(i);
			SB.append(c);
			L.remove(i);
			DFS(output,SB,L);
			SB.deleteCharAt(SB.length()-1);
			L.add(i,c);
		}
	}
	
	
	public static void main (String[] args) throws IOException{
		
		File file = new File(args[0]);
		Scanner in=new Scanner(file);
		while (in.hasNextLine()){
			String line=in.nextLine();
			//String line="asd";
			char[] C=line.toCharArray();
			Arrays.sort(C);
			List<Character> L=new ArrayList<Character>();
			for (char c:C) L.add(c);
			List<String> output=new ArrayList<String>();
			DFS(output,new StringBuilder(),L);
			for (int i=0;i<output.size();i++){
				System.out.print(output.get(i));
				if (i!=output.size()-1) System.out.print(",");
			}
			System.out.println();
		}
	    
	}
}

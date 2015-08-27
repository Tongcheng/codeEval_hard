import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static boolean isPalindrome(int a){
		//case defense: negative || nonzero tail
		if (a<0 || a!=0&&a%10==0) return false;
		int rev=0;
		while (rev<a){
			//pop out the tail of a and add it to the tail of rev
			rev=rev*10+a%10;
			a/=10;
		}
		return a==rev|| a==rev/10;
	}
	
	
	public static long countInterval(int L,int R){
		
		List<Integer> A=new ArrayList<Integer>(); A.add(L-1);
		long output=0;
		//evenSum:=sum(L.get(2k)-L.get(2k-1))
		//For example: L=2, A={1,5,10,15}
		//evenSum=()
		int evenSum=0; int oddSum=0;
		for (int i=L;i<=R;i++){
			//update even/odd Sum
			//System.out.println("i="+i);
			if (A.size()%2==0) {oddSum++;}//System.out.println("oddSum increment");}
			else {evenSum++;}//System.out.println("evenSum increment");}
			if (isPalindrome(i)) {A.add(i);}//System.out.println("append i="+i);}
			if (A.size()%2==0) {output+=oddSum;}//System.out.println("output add oddSum");}
			else {output+=evenSum;}//System.out.println("output add evenSum");}
		}
		//System.out.println(A);
		return output;
	}
	
	public static void main (String[] args) throws IOException{
		
		//Scanner in=new Scanner(new FileReader("myTest.txt"));
		/**
		 * CodeEval
		 */
		
		File file = new File(args[0]);
		Scanner in=new Scanner(file);
		
		while (in.hasNextLine()){
			String line=in.nextLine();
			String[] Slist=line.split(" ");
			int m=Integer.parseInt(Slist[0]);
			int n=Integer.parseInt(Slist[1]);
			System.out.println(countInterval(m,n));
		}
		//System.out.println(countInterval(10,25));
		
		/**SPOJ*/
		/*
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		in.nextLine();
		for (int t=0;t<N;t++){
			String S=in.nextLine();
			List<Integer> A=new ArrayList<Integer>();
			for (int j=0;j<S.length();j++) A.add(S.charAt(j)-'0');
			List<Integer> B=nextPalindrome(A);
			StringBuilder SB=new StringBuilder();
			for (int k:B) SB.append(k);
			System.out.println(SB.toString());
		}*/
	    
	}
}

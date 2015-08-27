import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	//only support '+' and '-' on long
	public static long operate(long Op1,long Op2,char Op){
		if (Op=='+'){return Op1+Op2;}
		else {return Op1-Op2;}
	}
	
	//one-pass interpretation/evaluation
	//A has length n, B has length n-1;
	public static long eval(int[] A,char[] B){
		long Op1=0L;
		long Op2=A[0];
		char Op='+';
		//for A is i+1, for B is i
		for (int i=0;i<B.length;i++){
			//examine B first 
			if (B[i]=='+' || B[i]=='-'){
				//System.out.println("Operation is:"+Op+";Operands are:"+Op1+" "+Op2);
				Op1=operate(Op1,Op2,Op);
				Op2=0L;
				Op=B[i];
			}
			//examine A next
			Op2=Op2*10+A[i+1];
		}
		//tail case
		return operate(Op1,Op2,Op);
	}
	
	public static boolean isUgly(long n){
		n=Math.abs(n);
		if (n%2==0 || n%3==0 || n%5==0 || n%7==0) return true;
		return false;
	}
	
	public static long DFS(int[] A,char[] B,int index){
		//leaf case
		if (index==B.length) return isUgly(eval(A,B))?1:0;
		//branch case
		long output=0L;
		//modify nothing
		output+=DFS(A,B,index+1);
		//plus
		B[index]='+'; output+=DFS(A,B,index+1);
		//minus
		B[index]='-'; output+=DFS(A,B,index+1);
		B[index]=' ';
		return output;
	}
	
	public static long count(String Num){
		int[] A=new int[Num.length()];
		for (int i=0;i<Num.length();i++){A[i]=Num.charAt(i)-'0';}
		char[] B=new char[A.length-1];
		for (int i=0;i<B.length;i++) B[i]=' ';
		return DFS(A,B,0);
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
			System.out.println(count(line));
		}
		
		
		
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

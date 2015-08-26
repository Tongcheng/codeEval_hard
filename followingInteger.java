import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	
	public static String proceed(String S){
		char[] C=new char[S.length()+1];
		C[0]='0';
		for (int i=0;i<S.length();i++){C[i+1]=S.charAt(i);}
		Arrays.sort(C);
		//find the first non-zero and swap the 0-th index
		int fstPositive=0;
		for (int i=1;i<C.length;i++) if (C[i]!='0'){fstPositive=i;break;}
		//swap 
		C[0]=C[fstPositive];
		C[fstPositive]='0';
		return String.valueOf(C);
	}
	
	//sort everything from start index to end of C
	public static void sortTail(char[] C,int start){
		char[] D=new char[C.length-start];
		for (int i=start;i<C.length;i++) D[i-start]=C[i];
		Arrays.sort(D);
		for (int i=start;i<C.length;i++) C[i]=D[i-start];
	}
	
	public static String getNext(String S){
		int prevPoint=-1;
		
		//find the last increase's first point
		for (int i=0;i<S.length()-1;i++) if (S.charAt(i+1)>S.charAt(i)) prevPoint=i;
		if (prevPoint==-1){return proceed(S);}
		char minVal=S.charAt(prevPoint+1); int laterPoint=prevPoint+1;
		for (int i=prevPoint+1;i<S.length();i++) if (S.charAt(i)<minVal && S.charAt(i)>S.charAt(prevPoint)){laterPoint=i;minVal=S.charAt(i);}
		char[] C=S.toCharArray();
	    char temp=C[prevPoint]; C[prevPoint]=C[laterPoint]; C[laterPoint]=temp;
	    sortTail(C,prevPoint+1);
	    return String.valueOf(C);
	
	}
	
	public static void main (String[] args) throws IOException{
		
		//Scanner in=new Scanner(new FileReader("myTest.txt"));
		/**
		String S="842";
		for (int i=0;i<10;i++){
			System.out.println(S);
			S=getNext(S);
		}*/
		
		
		
		File file = new File(args[0]);
		Scanner in=new Scanner(file);
		
		while (in.hasNextLine()){
			String line=in.nextLine();
			System.out.println(getNext(line));
		}
	    
	}
}

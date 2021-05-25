package Tollgate;
import java.util.*;
interface t{
	int biggest(int a,int b,int c);
}
class biginthree implements t{
	public int biggest(int a,int b,int c) {
		return(a>b)?(a>c)?a:c:(b>c)?b:c;
	}
}
class test{
	public static void main(String[] args){
		int a=8,b=10,c=9;
		biginthree obj=new biginthree();
		System.out.println(obj.biggest(a, b, c));
	}
}

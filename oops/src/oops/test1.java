package oops;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
class Pediatrician{
	int a=0,b=0,c=0;
	String doctorAday="TUESDAY";
	String doctorBday="TUESDAY";
	String doctorCday="MONDAY";
	List<Double>doctA=new ArrayList<>(Arrays.asList(2.00,2.30,3.00,3.30,4.0));
	List<Double>doctB=new ArrayList<>(Arrays.asList(1.00,1.30,2.00,2.30,3.00,3.30,4.00));
	List<Double>doctC=new ArrayList<>(Arrays.asList(1.00,1.30,2.00,2.30,3.00,3.30,4.00));
	public void availablity(String day,Double starttime,Double endtime) {
		if(day==doctorAday && doctA.contains(starttime)){
			System.out.println("A is confirmed");
			int i=doctA.indexOf(starttime);
			doctA.remove(i);
		}
		else if(day==doctorBday && doctB.contains(starttime)) {
			System.out.println("B is confirmed");
			int i=doctB.indexOf(starttime);
			doctB.remove(i);
		}
		else if(day==doctorCday && doctC.contains(starttime)){
			System.out.println("C is confirmed");
			int i=doctC.indexOf(starttime);
			doctC.remove(i);
		}
		else {
			System.out.print("Unavaiable");
		}
	}
}
class ENT{
	String doctDday="WEDNESDAY";
	String doctEday="THURSDAY";
	List<Double>doctD=new ArrayList<>(Arrays.asList(1.00,1.30,2.00,2.30,3.00,3.30,4.00));
	List<Double>doctE=new ArrayList<>(Arrays.asList(1.00,1.30,2.00,2.30,3.00,3.30,4.00));
	public void availablity(String day,double starttime,double endtime){
		if(day==doctDday && doctD.contains(starttime)) {
			System.out.println("D is confirmed");
			int i =doctD.indexOf(starttime);
			doctD.remove(i);
		}
		else if(day==doctEday && doctE.contains(starttime)) {
			System.out.println("E is confirmed");
			int i =doctE.indexOf(starttime);
			doctE.remove(i);
		}
		else {
			System.out.print("Unavaiable");
		}
}
}
public class test1{
	public static void main(String[] args){
		Scanner ob=new Scanner(System.in);
		String typeofdoc=ob.nextLine();
	   LocalDate localDate = LocalDate.of(2020,6,9);
       java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
       String day=(dayOfWeek.toString());
       System.out.println(day);     
       ENT obj1=new ENT();
       obj1.availablity(day, 1.00, 2.00);
       Pediatrician obj=new Pediatrician();
	   obj.availablity(day, 2.00, 3.00);   
} 
}


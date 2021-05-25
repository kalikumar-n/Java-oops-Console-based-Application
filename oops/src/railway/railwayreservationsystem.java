package railway;
import java.util.*;
import java.io.*;
public class railwayreservationsystem {
	static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in)); 
	static int confirmedtickets=0;
	static int rac=0;
	static int waitinglist=0;
	public static class userinfo{
		 static String name;
		 static String gender;
		 static String berthp;
		 static int age;
		userinfo(String name,int age,String gender,String berthprefer){
			this.name=name;
			this.age=age;
			this.gender=gender;
			this.berthp=getbook(age,berthprefer);
		}
	}
	static List<userinfo>users=new ArrayList<>();
	static void book() throws Exception{
		System.out.println("Enter your name");
		String name=obj.readLine();
		System.out.println("Enter your age");
		int age=Integer.parseInt(obj.readLine());
		if(age<5) {
			System.out.println("Age is under 5");
		}
		else {
		System.out.println("Enter your gender");
		String gender=obj.readLine();
		System.out.println("Enter your berth preference like Upperberth/Lowerberth");
		String berthprefer=obj.readLine();
		userinfo user=new userinfo(name,age,gender,berthprefer);
		users.add(user);
		}
	}
	static String getbook(int age,String berthprefer) {
		if(confirmedtickets<63) {
			confirmedtickets++;
			if(age<60 ){
				return berthprefer;
			
			}
			else {
				return "Lowerberth";
			}
		}
		else if(rac<18){
			rac++;
			if(age<60 ) {
				return "RAC:"+berthprefer;
			}
			else {
				return "RAC:Lowerberth";
			}
		}
		else if (waitinglist<10){
			waitinglist++;
			return "WaitingList";
		}
		else {
			return "Tickets Not available";
		}
	}
	static void checkbookedtickets() throws Exception {
		System.out.println("Enter your name");
		String name =obj.readLine();
		int flag=0;
		for(userinfo u:users) {
			if(u.name.equals(name)) {
				flag=1;
				System.out.println(userinfo.name);
				System.out.println(userinfo.age);
				System.out.println(userinfo.gender);
				System.out.println(userinfo.berthp);
			}
		}
		if(flag==0)System.out.println("No Booking Happened with this name");
		
	}
	 static void cancel() throws Exception{
		int flag=0;
		System.out.println("Enter your name");
		String name=obj.readLine();
		for(userinfo u:users) {
			if(u.name.equals(name)) {
				flag=1;
				if(u.berthp=="Upperberth" || u.berthp=="Lowerberth")
					confirmedtickets--;
				else if(u.berthp=="RAC:Upperberth" || u.berthp=="RAC:Lowerberth")
					rac--;
				else {
					waitinglist--;
				}
				users.remove(u);
				System.out.println("Request Accepted");
				break;
			}
		}
		if(flag==0)System.out.println("No Booking Happened with this name");
	}
	static void availability() {
		System.out.println("No of bookings in Confirmed Tickets:"+confirmedtickets);
		System.out.println("No of bookings in RAC Tickets:"+rac);
		System.out.println("No of bookings in Waiting List:"+waitinglist);
	}
	public static void main(String[] args) throws Exception {
		while(true) {
		System.out.println("Enter your choice:");
		System.out.println("1.Booking");
		System.out.println("2.Cancel");
		System.out.println("3.Check booked Tickets");
		System.out.println("4.Check Availability");
		System.out.println("5.exit");
		Scanner obj=new Scanner(System.in);
		int choice=obj.nextInt();
		switch(choice) {
		case 1:
			book();
			break;
		case 2:
			cancel();
			break;
		case 3:
			checkbookedtickets();
			break;
		case 4:
			availability();
			break;
		case 5:
			break;
	
		}
	}
	}
}

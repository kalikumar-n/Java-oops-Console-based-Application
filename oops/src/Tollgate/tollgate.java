package Tollgate;
import java.io.*;
import java.util.*;
public class tollgate {
	static ArrayList<String>highway=new ArrayList<>();
	static ArrayList<user>users=new ArrayList<>();
	static Map<String,ArrayList<String>>map=new HashMap<>();
	static class user{
		 String vtype;
		 String start;
		 String destination;
		 double amount;
		 double discount=0;
		 String vno;
		 user(String vno,String vtype,String start,String destination){
			this.vno=vno;
			this.vtype=vtype;
			this.start=start;
			this.destination=destination;
			if (vtype.equals("vip")) {
				this.discount=20;
			}
			this.amount=getamount(start,destination,discount,vno,vtype);
			System.out.println("Amount:"+amount);
		}
	}
	static void checkamount(String vno,String vtype,String start,String destination)throws Exception{
		user info=new user(vno,vtype,start,destination);
		users.add(info);
	}
	static void Vehicledetail() {
		System.out.println("Vehilce details");
		int si=1;
		for(user u:users){
			System.out.println(si++);
			System.out.println("VechileNumber:"+u.vno);
			System.out.println("VechileType:"+u.vtype);
			System.out.println("Travelled From "+u.start+" to "+u.destination);
			System.out.println("DiscountPercent on Tollgate:"+u.discount);
			System.out.println("Amount Collected From Toll:"+u.amount);
		}
	}
	static double getamount(String start,String destination,double discount,String vno,String vtype) {
		int toll=0;
		for(int i=highway.indexOf(start);i<highway.size();i++){
			String[]s=highway.get(i).split("-");
			if(s[0].equals("Tollgate")){
				double a=(20*(discount)/100);
				map.put(highway.get(i),new ArrayList<String>());
				map.get(highway.get(i)).add(vno);
				map.get(highway.get(i)).add(vtype);
				map.get(highway.get(i)).add(String.valueOf(20-a));
				toll++;
			}
			if(highway.get(i).equals(destination)) {
				break;
			}
			if(i==highway.size()-1)i=-1;
		}
		double d=(toll*20)*(discount/100);
		double amount=(toll*20)-d;
		return amount;
	}
	static void tolldetails(String tollgate) {
		if(map.get(tollgate)!=null) {
			for(String list:map.get(tollgate)) {
				System.out.println(list);
			}
		}
		else{
			System.out.println("No vehicle crossed this tollgate");
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
		highway.add("cbe");
		highway.add("Tollgate-1");
		highway.add("pondi");
		highway.add("Tollgate-2");
		highway.add("Tollgate-3");
		highway.add("chennai");
		highway.add("Tollgate-4");
		highway.add("salem");
		highway.add("Tollgate-5");
		while(true) {
		System.out.println("Enter the choice");
		System.out.println("1.Checkamount");
		System.out.println("2.Tolldetail");
		System.out.println("3.Allvechicledetails");
		System.out.println("4.exit");
		int choice=Integer.parseInt(obj.readLine());
		switch(choice) {
		case 1:
			System.out.println("Enter your vechile number");
			String vno=obj.readLine();
			System.out.println("Enter the vtype like vip/non-vip");
			String vtype=obj.readLine();
			System.out.println("Enter start location");
			String start=obj.readLine();
			System.out.println("Enter destination");
			String destination =obj.readLine();
			checkamount(vno,vtype,start,destination);
			break;
		case 2:
			System.out.println("Enter the tollgate");
			String tollgate=obj.readLine();
			tolldetails(tollgate);
			break;
		case 3:
			Vehicledetail();
			break;
		case 4:
			break;
		}
	}
	}
}

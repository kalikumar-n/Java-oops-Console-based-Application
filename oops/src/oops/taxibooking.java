package oops;
import java.util.*;
class tbook{
	static Scanner scan=new Scanner(System.in);
	static List<taxi>taxies=new ArrayList<>();
	static int bookid=1;
	tbook(int n){
		for(int i=1;i<=n;i++){
			taxi t=new taxi(i);
			taxies.add(t);
		}
	}
	static void getDetails() {
	        System.out.println("------Taxi Booking------");
	        System.out.println(" (work with four taxi) ");
	        System.out.println("1.Book Taxi  ");
	        System.out.println("2.Taxi Details  ");
	        System.out.println("3.Taxies Status ");
	        System.out.println("4.Exit ");
	        System.out.println("Enter your choice : ");
	        int ch = scan.nextInt();
	        switch (ch) {
	        case 1: {
	            bookTaxi();
	            getDetails();
	            break;
	        }
	        case 2: {
	            taxiDetails();
	            getDetails();
	            break;
	        }
	        case 3: {
	            taxiStatus();
	            getDetails();
	            break;
	        }
	        case 4: {
	            return;
	        }
	        default: {
	            System.out.println("Enter valid choice :");
	            getDetails();
	            break;
	            }
	        }
	     }
	static void bookTaxi() {
        System.out.println("Enter Customer ID: ");
        char cid = scan.next().charAt(0);
        System.out.println("Enter Pickup Point: ");
        char pp = scan.next().charAt(0);// from
        System.out.println("Enter Drop Point: ");
        char dp = scan.next().charAt(0);// to
        System.out.println("Enter Pickup Time: ");
        int pt = scan.nextInt();
        int rej = 1;// for reject a booking
		for (taxi t : taxies) {
            if ((t.isFree == true) && (t.currentPoint == pp)) {// assign a taxi when pickup point and current point of
                                                               // the taxi is matched
                t.assign(bookid, cid, pp, dp, pt);
                bookid++;
                taxiHold th = new taxiHold(t);
                th.start();
                
                return;
            }
            if (t.isFree == true)
                rej = 0;// means atleast one taxi is free
        }
        if (rej == 1) {// means no taxi is free, so reject the booking
            System.out.println(" sorry No taxi is Available Now :-( ");
            System.out.println("sorry your booking is rejected ");
            return;
        }
        ArrayList<taxi> nearestTaxies = new ArrayList<taxi>();
        for (taxi t1 : taxies) {// get nearest taxies in another array list
            if (t1.isFree == true) {
                if (Math.abs(t1.currentPoint - pp) == 1)
                    nearestTaxies.add(0, t1);// minimum distance element is set as first element in array list
                else
                    nearestTaxies.add(t1);// just add free taxi if distance exceed more than one
            }
        }
        if (nearestTaxies.size() == 1) {// if we have only one nearest taxi
            nearestTaxies.get(0).assign(bookid, cid, pp, dp, pt);
            bookid++;
            taxiHold th = new taxiHold(nearestTaxies.get(0));
            th.start();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            return;
        } 
        else if ((pp == 'A' || pp == 'F') && (Math.abs(nearestTaxies.get(0).currentPoint - pp) == 1)) {
            // just verify
            nearestTaxies.get(0).assign(bookid, cid, pp, dp, pt);
            bookid++;
            taxiHold th = new taxiHold(nearestTaxies.get(0));
            th.start();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            return;
        } 
        else {
            int min = Math.abs(nearestTaxies.get(0).currentPoint - pp);
            int iden = 0, loc = 0;
            for (int i = 1; i < nearestTaxies.size(); i++) {// getting minimum distance
                if (min > Math.abs(nearestTaxies.get(i).currentPoint - pp)) {
                    min = Math.abs(nearestTaxies.get(i).currentPoint - pp);
                    loc = i;
                } else
                    nearestTaxies.remove(i);
                if (min == Math.abs(nearestTaxies.get(i).currentPoint - pp))
                    iden++;
            }
            if (iden == 0) {
                nearestTaxies.get(loc).assign(bookid, cid, pp, dp, pt);
                bookid++;
                taxiHold th = new taxiHold(nearestTaxies.get(loc));
                th.start();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return;
            } 
            else {
                double minE = nearestTaxies.get(0).totalEarn;
                int mLoc = 0;
                for (int i = 1; i < nearestTaxies.size(); i++) {// get minimum earning taxi from minimum distance taxies
                    if (minE > nearestTaxies.get(i).totalEarn) {
                        minE = nearestTaxies.get(i).totalEarn;
                        mLoc = i;
                    }
                }

                nearestTaxies.get(mLoc).assign(bookid, cid, pp, dp, pt);
                bookid++;
                taxiHold th = new taxiHold(nearestTaxies.get(mLoc));
                th.start();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return;
            }
        }
	}
	static void taxiDetails() {
        for (taxi t : taxies) {
            System.out.println(" ");
            System.out.print("Taxi id " + t.id);
            System.out.print("\t\t Total Earnings " + t.totalEarn);
            System.out.println(" ");
            System.out.println("BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
            for (int i = 0; i < t.bookingId.size(); i++) {
                System.out.print(t.bookingId.get(i));
                System.out.print("      " + t.custId.get(i));
                System.out.print("      " + t.from.get(i));
                System.out.print("      " + t.to.get(i));
                System.out.print("      " + t.pickUpTime.get(i));
                System.out.print("      " + t.dropTime.get(i));
                System.out.print("      " + t.amount.get(i));
            }
            System.out.println(" ");
        }
    }
	static void taxiStatus() {
        for (taxi t : taxies) {
            if (t.isFree == true)
                System.out.println("Taxi id " + t.id + " is free( Available Now)");
            else
                System.out.println("Taxi id " + t.id + " is busy ( Not Available Now ) ");
        }
    }
}
public class taxibooking{
	public static void main(String[] args) {
		tbook obj=new tbook(4);
		obj.getDetails();
	}
}
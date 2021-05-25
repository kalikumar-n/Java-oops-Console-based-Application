package banking;

import java.util.*;
class banking {
  public static class user{
    String name;
    private int balance;
    String email;
    user(String name,String email){
        this.name=name;
        this.email=email;
    }
    void addbalance(int amt){
      this.balance+=amt;
    }
  }

  static List<user> users=new ArrayList<>();

  public static void fetchuser(String name,int amt){
    for(user m:users){
      if(m.name.equals(name)){
        m.addbalance(amt);
      }
    }
  }

  public static void userdetails(String name){
    int i=0;
    for(user m:users){
      if(m.name.equals(name)){
        System.out.println(m.name);
        System.out.println(m.email);
        System.out.println(m.balance);
        i=1;
      }
    }
    if(i==0) System.out.println("No user found");
  }

  public static void deleteuser(String name){
    for(user m:users){
      if(m.name.equals(name)){
        users.remove(m);
        break;
      }
    }
  }
  
  public static void createuser(String name,String email){
    user me=new user(name,email);
    users.add(me);
  }


  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    while(true){
      System.out.println("Please enter a choice");
      System.out.println("1) Display Details");
      System.out.println("2) Add money");
      System.out.println("3) Delete User");
      System.out.println("4) Create User");
      System.out.println("5) Exit");
      int op=sc.nextInt();
      if(op==5) break;
      switch(op){
        case 1:
          System.out.println("Enter Name");
          String mo=sc.next();
          userdetails(mo);
          break;
        case 2:
          System.out.println("Enter Name");
          mo=sc.next();
          System.out.println("Enter Amount");
          int amt=sc.nextInt();
          fetchuser(mo,amt);
          break;
        case 3:
          System.out.println("Enter Name");
          mo=sc.next();
          deleteuser(mo);
          break;
        case 4:
          System.out.println("Enter Name");
          mo=sc.next();
          System.out.println("Enter Email");
          String em=sc.next();
          createuser(mo,em);
          break;
      }
    }
  }
}
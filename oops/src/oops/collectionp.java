package oops;
import java.util.*;
class collectionp{   
    public static void main(String[] args){
      char arr[][]={{'A','X','E','F'},{'Y','P','R','T'},{'C','B','L','O'},{'M','W','D','C'}};
      HashSet<String>hashset=new HashSet<>();
      hashset.add("AXE");
      hashset.add("LOT");
      hashset.add("PBLD");
      hashset.add("COT");
      hashset.add("RLD");
      hashset.add("CPE");
      System.out.print(arr[1][0]);
}
}
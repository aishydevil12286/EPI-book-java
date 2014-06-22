import java.util.ArrayList ;
// take two strings containing integers and multiply em 

class P3 {


  public static ArrayList<Integer> addTwo(ArrayList<Integer> a, ArrayList<Integer> b ) {
    ArrayList<Integer> out = new ArrayList<Integer>() ;
    if (a.size() < b.size() ) {
      ArrayList<Integer> temp = a ;
      a = b ;
      b = temp ;
    }
    int a_digit ;
    int b_digit ;
    int carry = 0 ;
    for (int i = 0 ; i < a.size() ; i++) {
      
      a_digit = a.get(i) ;
      try {
        b_digit = b.get(i) ;
      } catch (IndexOutOfBoundsException e) {
        b_digit = 0 ;
      }
      
      out.add(((a_digit+b_digit+carry) % 10) ) ;

      if ((a_digit + carry + b_digit) > 9) {
        carry = 1 ;
      }  else {
        carry = 0 ;
      }

    }
    if (carry == 1) {
      out.add( 1  ) ;
    }
    return out ;
  }

  public static ArrayList<Integer> bigAdd(ArrayList<ArrayList<Integer>> a ) {
    ArrayList<Integer> total = new ArrayList<Integer>();
    total.add(0);
    for (int i = 0; i < a.size(); i++) {
      total = addTwo(total, a.get(i)) ;
    }
    return total ;
  }
  
  public static ArrayList<Integer> stringToArrayListOfInts (String  s ) {
    ArrayList<Integer> out = new ArrayList<Integer>() ;
    for (int i = s.length() -1 ; i >= 0 ; i--) {
      try  { 
        out.add(Character.getNumericValue(s.charAt(i))); 
      } catch (NumberFormatException e) {
        break ;
      }
    }
    return out ;
  }

  public static String bigMult(String a, String b) {
    int neg = 0 ;
    if ((a.charAt(0) == '-') != (b.charAt(0) == '-') ) {
      neg = 1 ;
    }
    if (a.charAt(0) == '-') {
      a = a.substring(1) ; 
    } 
    if (b.charAt(0) == '-') {
      b = b.substring(1) ; 
    } 

    if (a.length() < b.length() ) {
      String temp = a ;
      a = b ;
      b = temp ;
    }

    ArrayList<Integer> a_al = stringToArrayListOfInts(a ) ;
    ArrayList<Integer> b_al = stringToArrayListOfInts(b) ;
    

    ArrayList<ArrayList<Integer>> partial_products = new ArrayList<ArrayList<Integer>>() ;
    for (int i = 0 ; i < a_al.size() ; i++) {
      for (int j = 0 ; j < b_al.size() ; j++) {
        ArrayList<Integer> result_array = new ArrayList<Integer>();
        
        for (int k = 0; k < ( i +  j ); k++) {
          result_array.add(0);
        }
        
        int digit = (a_al.get(i) * b_al.get(j)) ;
        
        if (digit < 10) {
          result_array.add(digit);
        } else {
          result_array.add(digit % 10);
          result_array.add(digit / 10);
        }
        
        partial_products.add(result_array) ;
      
      }     
    }     
      
    
    ArrayList<Integer> out_int = bigAdd(partial_products);
    
    // return output as string
    String c = "";
    for (int i=out_int.size()-1 ; i >= 0 ; i--) {
      c += Integer.toString(out_int.get(i)) ;
    }

    if ( neg == 1 ) {
     c = "-" + c ;
    }
    System.out.println("neg: " + neg + " a: " + a + " b: " + b + " c: " + c); 
    return c;
  }

  public static void main(String args[]) {
    //String a = "10";
    //String b = "-1";
    //String c = "-10";
    String a = "193707721";
    String b = "-761838257287";
    String c = "-147573952589676412927";

    System.out.println( bigMult(a,b).equals( c) );

  }

}

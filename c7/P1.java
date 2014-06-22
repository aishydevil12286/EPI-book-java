// string to int and int to string
//
//

class P1 {

  public static int stringToInt(String s) {
    int out = 0;
    boolean isNeg = false ;

    if( s.charAt(0) == '-') {
      isNeg = true;
      s = s.substring(1);
    }
    
    int pow=1 ;
    for (int i = s.length() - 1 ; i>= 0; i--)   {
      out += pow*(s.charAt(i) - '0');
      pow *= 10 ;
    }

    if (isNeg) {
      out *= -1 ; 
    }

    return out ;
  }

  public static String intToString(Integer int_input) {
    String s = "";
    String temp = "" ;

    if (int_input < 0 ) {
      s += "-" ;
      int_input *= -1 ;
    }
    
    while (int_input > 0 ) {
      temp += Character.toString( (char) ('0' + (int_input % 10) )) ;
      int_input /= 10 ;
    }
    for (int i = temp.length()-1 ; i >= 0 ; i-- ) {
      s+= Character.toString(temp.charAt(i));
    }

    return s ;
  }

  public static void main(String[] args) {
    System.out.println(stringToInt("-14"));
    System.out.println(intToString(-14));
  }

}

//ppbb matching

import java.util.Stack ;

class P3 {

  private static boolean isOpenPunct(char s) {
    if ( (s == '(') || (s == '[')   ) return true ;
    return false;
  }
  private static boolean isClosePunct(char s) {
    if ((s==')') || (s ==']')  ) return true ;
    return false;
  }
  private static boolean comparePunct(String x, String y) {
    if ((x.equals("(")) && (y.equals(")") )  ) return true ;
    if ((x.equals("[")) && (y.equals("]"))  ) return true ;
    return false;
  }


  public static boolean ppbb(String s) {
    Stack<String> store = new Stack<String>() ;
    for (int i = 0; i < s.length() ; i++) {
      if (isOpenPunct(s.charAt(i)) ) {
        store.push( String.valueOf(s.charAt(i)) ) ;
      } else if (isClosePunct(s.charAt(i))) {
          String cmpr = store.pop() ;
          if (!(  comparePunct(   cmpr, String.valueOf(s.charAt(i)) )   )) {
            return false ;
          }
      }
    }
    return true ;
  }


  public static void main(String[] args) {
    String test1 = "()[o]((aa)x)";
    String test2 = "([)]";
    System.out.println(test1 + " " +ppbb(test1));
    System.out.println(test2 + " " +  ppbb(test2)  );
  }


}

//RPN calculator

import java.util.Stack;
import java.util.EmptyStackException;

class P2 {


  private static boolean isOperator(String y ) {
    if (y.equals("+") || y.equals("-") || y.equals("*") || y.equals("/") )  return true ; 
    return false ;
  }
  
  private static int rpnOperate( int x, int y, String o   ) {
    if (o.equals( "+")) return x+y;
    if (o.equals( "-")) return x-y;
    if (o.equals( "/")) return x/y;
    if (o.equals( "*")) return x*y;
    else return 0;
  }

  public static int rpn(String s) {
    Stack<Integer> store = new Stack<Integer>() ;
    String[] parts = s.split(",");
    for (int i = 0; i < parts.length ; i++) {
      if (isOperator(parts[i]) ) {
        Integer x =  store.pop() ;
        Integer y =  store.pop() ;
        store.push(rpnOperate(x, y,parts[i]));
      } else {
        store.push(Integer.parseInt(parts[i] ));
      }

    }
    return store.pop();
  }


  public static void main(String[] args) {
    String test1 = "3,4,*,1,2,+,+";
    String test2 = "1,1,+,-2,*";
    String test3 = "4,6,/,2,/";
    System.out.println(test1 + " " +rpn(test1));
    System.out.println(test2 + " " + rpn(test2));
    System.out.println(test3 + " " + rpn(test3));
  }

}

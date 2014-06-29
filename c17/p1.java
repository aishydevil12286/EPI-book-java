// scores in a game

import java.util.Arrays ;
import java.util.Collections;

class P1 {


  public static void waysHidden(int s, Integer[] w, int[] totals, int wIdx) {
    
    int total = 0 ;
    for (int i=0; i < wIdx ; i++) {
      total += w[i]*totals[i] ;
    }
    System.out.println( Arrays.toString(totals) + " : " + total) ;
  
    int[] newTotals = new int[totals.length] ;
    System.arraycopy(totals, 0, newTotals, 0, newTotals.length) ;

    if (total == s) {
      System.out.println("return: " + Arrays.toString(totals) + " : " + total) ;
      return ;
    } else if (wIdx >= w.length) return ;

    while (total <= s) {
      waysHidden(s, w, newTotals, wIdx+1);
      total += w[wIdx] ;
      newTotals[wIdx]++ ;
    }
    

  }
  
  public static void waysToAddToS(int s, Integer[] w) {
    int[] totals = new int[w.length] ;
    for (int i=0 ; i < totals.length ; i++ ) {
      totals[i] = 0 ;
    }
    waysHidden(s, w, totals, 0) ;
  }

  

  public static void main(String[] args) {
  
    Integer[] w = {7,3,2};
    int s = 12 ;
    Arrays.sort(w, Collections.reverseOrder()); 
    waysToAddToS(s, w) ;

  }


}

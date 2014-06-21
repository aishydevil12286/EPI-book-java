// decimal add one to numbers represented by arrays
class P2 {

  public static int[] addOneViaArray(int[] a) {
    int i = a.length - 1;
    while (a[i] == 9) {
      a[i] = 0 ;
      if (i == 0) {
        int[] b = new int[a.length+1]  ;
        b[0] = 1 ;
        for (int j = 0; j<a.length; j++) {
          b[j+1] = a[j] ;
        }
        return b ;
      }
      i--;
    }
    a[i]++ ;
    return a ;

  }

  public static void main(String args[]) {
    int[] a = {9,9,9,9} ;
    int[] b = addOneViaArray(a) ;
    for (int i=0; i< b.length; i++) {
      System.out.println( b[i]) ;
    }
  }

}

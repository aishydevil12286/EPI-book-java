//merge sort in place

class P2 {


  public static void mergeInPlace(int[] big, int lastEleInBig, int[] small ) {
    int i =lastEleInBig ;
    int j= small.length - 1;
    int x = big.length - 1 ;
    while (x >= 0 ) {
      if ( i < 0 ) {
        big[x] = small[j];
        x-- ;
        j--;
      } else if (j < 0 ) {
        big[x] = big[i] ;
        x-- ;
        i-- ;
      } else if (big[i] > small[j] ) {
        big[x] = big[i] ;
        x-- ;
        i-- ;
      } else {
        big[x] = small[j] ;
        x-- ;
        j-- ;
      }
    }
  }

  public static void main(String[] args ) {
    int[] a = {1,2,4,4,7,0,0,0,0,0,0};
    int[] b = {1,3,4,5,9,9} ;
    int aEndsAt = 4 ;

    mergeInPlace(a, aEndsAt, b) ;
    for (int i=0; i < a.length; i++ ) {
      System.out.println(a[i]) ;
    }

  }

}






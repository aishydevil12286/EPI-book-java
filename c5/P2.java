// flip bits at i and j

class P2 {

  public static Long flip(long x, int i, int j) {
    // can be made much less ugly by testing if the bits differ, if so then just XORING with an i,j = 1 long
    if (j > i ) {
      int temp = i; 
      i= j; 
      j=temp ;
    }
    return (((x & (1L << i)) >> (i-j) ) | ((x & (1L << j) ) << (i - j ) )) | ( (x & ~(1L << j)) & (x & ~(1L << i ))  );
    
  }

  public static void main(String args[]) {
    System.out.println(args[0]) ;    
    System.out.println(args[1]) ;    
    System.out.println(args[2]) ;    
    if (args.length == 0) {
      System.out.println(flip( 1L, 2, 0 ));
    } else {
      System.out.println(flip(Long.parseLong(args[0]), Integer.parseInt(args[1]) , Integer.parseInt(args[2] )   ));
    }
      
  }

}

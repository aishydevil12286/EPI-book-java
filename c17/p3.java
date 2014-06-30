class P3 {



  public static int binomialK(int n, int k) {
    if ((n==0) || (k == 0)) return 1 ;
    if (n==k) return 1 ;

    return (binomialK(n-1, k-1) + binomialK(n-1, k));
  
  }


  public static void main(String[] args) {
    System.out.println(binomialK(4,3)) ;
    System.out.println(binomialK(7,2)) ;
  
  }

}

class P2 {



  public static int searchForFirst(int[] data, int k) {
    int lowpt, midpt, endpt ;
    lowpt=0;
    endpt=data.length-1 ;
    midpt = (endpt + lowpt) / 2 ;
    while (( lowpt < endpt ) && ((endpt - lowpt) > 1)   ) {
      midpt = (endpt + lowpt) / 2 ;
      System.out.println("low: " +lowpt+ " mid: " +midpt+ " high: " + endpt );
      if (data[midpt] < k ) {
        lowpt = midpt + 1 ; 
      } else if (data[midpt] > k ) {
        endpt = midpt -1;
      } else if (data[midpt] == k) {
        lowpt = midpt ;
      }
    }
    midpt = (endpt + lowpt) / 2 ;
    System.out.println("low: " +lowpt+ " mid: " +midpt+ " high: " + endpt );
    if (data[endpt] <= k)   {
      if (endpt < data.length-1) return endpt+1 ;
      return -1 ;
    } else if ((data[midpt] <= k ))  {
      return midpt +1  ;
    } else if (data[lowpt] <= k) {
      return lowpt + 1 ;
    } else {
      return -1 ;
    } 
  }


  public static void main(String[] args) {
  
    int[] data = new int[10];
    data[0] = 1;
    data[1] = 2;
    data[2] = 2;
    data[3] = 4;
    data[4] = 5;
    data[5] = 6;
    data[6] = 6;
    data[7] = 6;
    data[8] = 7;
    data[9] = 7;


    System.out.println(searchForFirst( data, 3  ) == 3  );
    System.out.println(searchForFirst( data, 1  ) == 1  );
    System.out.println(searchForFirst( data, 7  ) == -1  );
  
  }


}

// heap sort a partially sorted array

class P3 {



  public static int[] heapSort(int[] data, int k) {
    Heep<Integer> h = new Heep<Integer>(k+1) ;
    for (int i =0 ; i <= k; i++ ) {
      h.insert(data[i]);
    }   
    for (int i = k+1; i < data.length; i++) {
      data[i-k-1] = h.findMin() ;
      h.deleteMin();
      h.insert(data[i]);
    }   
    for (int i =0 ; i <= k; i++ ) {
      data[data.length-k+i-1] = h.findMin() ;
      h.deleteMin();
    }   
    return data ;
  
  }

  public static void main(String[] args) {
    int[] test = new int[10] ;
    test[0] = 1 ;
    test[1] = 2 ;
    test[2] = 0 ;
    test[3] = 3 ;
    test[4] = 6 ;
    test[5] = 4 ;
    test[6] = 5 ;
    test[7] = 9 ;
    test[8] = 8 ;
    test[9] = 7 ;
 

    heapSort( test, 2  );
    
    for (int i: test) {
      System.out.println( i ) ;
    }
  }

}

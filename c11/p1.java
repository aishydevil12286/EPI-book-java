// heap sort

class P1 {



  public static int[] heapSort(int[] data) {
    int[] out = new int[ data.length] ;
    Heep<Integer> h = new Heep<Integer>(data.length) ;
    for (int i : data) {
      h.insert(i);
    }   
    for (int i =0 ; i<out.length; i++) {
      out[i] = h.findMin() ;
      h.deleteMin();
    }
    return out ;
  
  }

  public static void main(String[] args) {
    int[] test = new int[10] ;
    test[0] = 5 ;
    test[1] = 2 ;
    test[2] = 1 ;
    test[3] = 3 ;
    test[4] = 4 ;
    test[5] = 6 ;
    test[6] = 7 ;
    test[7] = 9 ;
    test[8] = 8 ;
    test[9] = 0 ;
 

    int[] test2 = heapSort( test  );
    
    for (int i: test2) {
      System.out.println( i ) ;
    }
  }

}

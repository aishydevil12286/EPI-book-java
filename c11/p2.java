// heap sort a k-increasing-decreasing array
// BROKEN - to fix --- i got bogged down in index arithmetic when i decided not to reverse the descending array subsets
// that said, i get the main idea of this problem: when facing memory constraints and you have several presorted lists,
// you can push the next element in each list into a heap. if there are k lists this keeps space use to O(k)  

class P2 {



  public static int[] heapSortKIncDec(int[] data, int k ) {
    int[] out = new int[ data.length] ;
    Heep<Integer> h = new Heep<Integer>(k) ;

    //find the critical points
    int[] critical_points = new int[k+1];
    critical_points[0] = 0 ;
    int cp_count = 1 ;
    int increasing = 1;
    int last = -99999999;
    for (int i=0; i< data.length; i++) {
      if (increasing == 1) {
        if (data[i] < last) {
          increasing = 0;
          critical_points[cp_count] = i ;
          cp_count++ ;
        }
      } else {
        if (data[i] > last) {
          increasing = 1;
          critical_points[cp_count] = i ;
          cp_count++ ;
        }
      }
      last = data[i];
    }
    critical_points[k] = data.length ;

    int[] idx_pointers = new int[k];
    for (int i=0 ; i< idx_pointers.length; i++) {
      idx_pointers[i] = 0 ;
    } 

    for (int i=0 ; i< idx_pointers.length; i++) {
        if ( i % 2 == 0) { 
          int data_idx = critical_points[i] + idx_pointers[i] ;
          System.out.println(data_idx);
          h.insert(data[  data_idx  ] ) ;
        } else {
          int data_idx = critical_points[i+1] - idx_pointers[i] ;
          System.out.println(data_idx);
          h.insert(data[  data_idx  ] ) ;
        }
        idx_pointers[i]++ ;
    }

    int data_idx ;
    int out_i  = 0;
    while (out_i < data.length) {
      out[out_i] = h.findMin();
      for (int i=0 ; i< idx_pointers.length; i++) {
          if ( i % 2 == 0) { 
            data_idx = critical_points[i] + idx_pointers[i] ;
            if ((out[out_i] ==  data[  data_idx  ] ) ) {
              h.deleteMin() ;
              out_i++;
              if (data_idx+1 < critical_points[i-1]) {
                idx_pointers[i]++ ;
                h.insert( data[data_idx+1]) ;
              }
            }
          } else {
            data_idx = critical_points[i+1] - idx_pointers[i] ;
            if ((out[out_i] == data[  data_idx  ] )) {
              out_i++;
              h.deleteMin() ;
              if (data_idx-1 > critical_points[i]) {
                idx_pointers[i]++ ;
                h.insert( data[data_idx-1]) ;
              }
            }
          }
        }
      }   
    return out ;
  
  }

  public static void main(String[] args) {
    int[] test = new int[10] ;
    test[0] = 1 ;
    test[1] = 2 ;
    test[2] = 5 ;
    test[3] = 3 ;
    test[4] = 4 ;
    test[5] = 6 ;
    test[6] = 7 ;
    test[7] = 9 ;
    test[8] = 8 ;
    test[9] = 0 ;
 

    int[] test2 = heapSortKIncDec( test , 4 );
    
    for (int i: test2) {
      System.out.println( i ) ;
    }
  }

}

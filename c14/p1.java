// iterate two indices along the sorted arrays like in merge sort to intersect two sorted arrays

class P1 {

  public static int[] arrayIntersection(int[] d1, int[] d2) {
    int i=0 ;
    int j=0 ;
    int maxlen = 0 ;
    
    if (d1.length > d2.length) {
      maxlen = d1.length ;
    } else {
      maxlen = d2.length ;
    }
    
    int[] out = new int[maxlen];

    int out_ctr = 0 ;
    while ((i < d1.length) && (j < d2.length)) {
      if (  d1[i] == d2[j]  ) {
        out[out_ctr] = d1[i] ;
        out_ctr++ ;
        i++;
        j++;
      } else if ( d1[i] < d2[j] ) {
        i++ ;
      } else if ( d1[i] > d2[j] ) {
        j++ ;
      }
    }
    int[] last_out = new int[out_ctr] ;
    for (int k=0 ; k < out_ctr ; k++ ) {
      last_out[k] = out[k] ;
    }
    return last_out ;
  }

  public static void main(String[] args) {
    int[] test1 = {1,2,3,4,5,6  } ; 
    int[] test2 = {2,3,4  } ; 
    int[] out = arrayIntersection(test1, test2) ;
    for (int i : out) {
      System.out.println(i) ;
    }
  }



}

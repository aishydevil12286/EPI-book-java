import java.util.Arrays ;

class MergeSorter {

  private static int[] merge(int[] d1, int[] d2) {
    int[] out = new int[ d1.length + d2.length ] ;
    int i = 0;
    int j = 0 ;
    while ((i < d1.length) || (j < d2.length)) {
      if (j == d2.length ) {
        out[i+j] = d1[i] ;
        i++ ; 
      } else if ( i == d1.length ) {
        out[i+j] = d2[j] ;
        j++ ;
      } else if (  d1[i] < d2[j]  ) {
        out[i+j] = d1[i] ;
        i++ ;
      } else {
        out[i+j] = d2[j] ;
        j++ ;
      }
    }        
    return out ;
  }
  
  public static int[] mergeSort(int[] data ) {

    if (data.length == 1) {
      return data ;
    }

    
    int[] left = new int[data.length / 2] ;
    int[] right = new int[data.length - (data.length / 2) ] ;
    for (int i=0; i < left.length; i++) {
      left[i] = data[i];
    }
    for (int i=0; i < right.length; i++) {
      right[i] = data[ i + left.length  ];
    }

    return merge(mergeSort( left ), mergeSort(right )   ) ; 
    
  }

  public static void main(String[] args) {
    int[] test = {9,2,5,7,1,3,4,0,8,6} ;
    for (int i: mergeSort(test)) {
      System.out.println( i );
    }
  }

}



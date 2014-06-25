class QuickSorter {

  public static int pivot(int[] data, int left, int right) {
    // choose pivot
    int x = (int) (Math.random() * ( right  - left  )) + left ;
    int x_val = data[x] ;
    // swap around pivot

    while ( left < right   ) {
      if (data[left] < x_val ) left++ ;
      if (data[right] > x_val ) right-- ;
      if ( (data[left] >= x_val   ) && ( data[right] <= x_val )   ) {
        int temp = data[left] ; 
        data[left] = data[right] ;
        data[right] = temp ;
        if (left == x) {
          x = right ;
          left++ ;
        } else if (right == x) {
          x = left ;
          right-- ;
        } else {
          left++ ;
          right-- ;
        }

      }
    }
    return x ;
  }

  public static void quickSort(int[] data, int left, int right) {
    if (left >= right ) return ;
    int x = pivot(data, left, right) ;
    quickSort( data, left, x-1  );
    quickSort(data, x+1, right) ;

  }

  public static void main(String[] args) {
    int[] test = {2,4,6,7,4,4,1,0} ;
    quickSort(test, 0, test.length-1) ;
    System.out.println("----- final ") ;
    for (int i : test) {
      System.out.println(i) ;
    }
  }


}

// function takes array and an index i
// rearranges array so all elements < a_i, then all elements == a_i, then all eles > a_i
// O(1) space, O(n) time
// this works but its possible to do it without going through twice, you can build 3 groups instead of 2.

class P1 {

  public static void rearrange(int[] array, int i) {
    int c = array[i] ;
    int temp = 0;
    int leftIdx = 0 ;
    int rightIdx = array.length -1 ;
    while (leftIdx < rightIdx) {
      temp = array[leftIdx];
      if (temp > c) {
        array[leftIdx] = array[rightIdx] ;
        array[rightIdx] = temp ;
        rightIdx-- ;
      } else { 
        leftIdx++;
      }
    }
    leftIdx = 0 ;
    while ( leftIdx < rightIdx  ) {
      temp = array[leftIdx];
      if (temp == c) {
        array[leftIdx] = array[rightIdx] ;
        array[rightIdx] = temp;
        rightIdx-- ;
      } else {
        leftIdx++ ;
      }
    } 
  }


  public static void  main(String[] args)  {
    int[] array = {10,9,3,6,3,3,7,8,2,1 } ;
    rearrange(array, 2);   
    for (int i=0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }

}

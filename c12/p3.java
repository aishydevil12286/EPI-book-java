//search a sorted array for A[i] = i
class P3 {

  public static int eleEqualsIdx(int[] data, int lowIdx, int hiIdx) {
    if ((lowIdx > hiIdx ) || (hiIdx > data.length -1 ) || ( lowIdx < 0)  ) return -1 ;
    int midpt = (hiIdx + lowIdx) / 2 ;
    if (data[midpt] > midpt) {
      int leftSide = eleEqualsIdx(data, lowIdx , midpt - 1 );
      if (leftSide != -1 ) return leftSide ;
      int rightSide = eleEqualsIdx(data, data[midpt] , hiIdx);
      if (rightSide != -1 ) return rightSide ;
    } else if (data[midpt] < midpt ) {
      int leftSide = eleEqualsIdx(data, lowIdx , data[midpt] );
      if (leftSide != -1 ) return leftSide ;
      int rightSide = eleEqualsIdx(data, midpt +1 , hiIdx);
      if (rightSide != -1 ) return rightSide ;
    } else if (data[midpt] == midpt) {
      return midpt ;
    } 
    return -1 ;
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


    System.out.println(eleEqualsIdx( data, 0, 9  ) == 2  );
    System.out.println(eleEqualsIdx( data, 4, 9  )  == 6 );
    System.out.println(eleEqualsIdx( data, 7, 8  ) == -1  );
    System.out.println(eleEqualsIdx( data, 2, 2  ) == 2  );
    System.out.println(eleEqualsIdx( data, 1, 2  ) == 2  );
    System.out.println(eleEqualsIdx( data, 2, 3  ) == 2  );
  
  }


}

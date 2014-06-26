import java.util.Arrays;

//count characters in a string
// choice 1 hash table, if k is number Of distinct characters in the string
// Hash table uses O(k) Additional storage And O(n) Time.
// Choice 2 Sort the string, Then iterate a counter, And print if the character under the index changes
//

class P3 {

  public static void countCharsNString(char[] data) {
    Arrays.sort(data) ;
    int ctr = 0 ;
    for (int i=1; i< data.length ; i++) {
      ctr++ ;
      if (data[i] != data[i-1] ) {
        System.out.println( data[i-1] + "   " + ctr) ;
        ctr = 0 ;
      } 
    }
    System.out.println( data[data.length-1] + "   " + (ctr+1)) ;
  }


  public static void main(String[] args) {
    String test = "hey friend whats the haps?" ;
    char[] test2 = test.toCharArray() ;
    System.out.println( test ) ;
    countCharsNString( test2 ) ; 
  }

}


// in alphabet [a b c d] replace 'a' by 'dd' and delete 'b' in a string
// use O(1) additional storage and assume the string has enough room allocated

public class P2 {

  public static String applyAlphabetRules(char[] s) {
    // iterate thru the string 
    // if you find 'a' then shift the rest of the string right 1 and assign d, d to the i, i+1 index
    // if you find b left shift the right part of string one idx 
    int i = 0 ;
    while (true) {
      if (s[i] == 'a')  {
        char last = 'd';
        char temp ;
        s[i] = 'd' ;
        for (int j = i+1; j < s.length ; j ++) {
          temp = s[j] ;
          s[j] = last ;
          last = temp;
        }
        i++ ;
        i++ ; 
      } else if (s[i] == 'b') { 
          for (int j = i; j < s.length-1 ; j ++) {
            s[j] = s[j+1] ;
          }
      } else if (s[i] == ' ') { 
          break ;
      } else {
        i++; 
      } 
    }

    //ok this line is a copout but there isn't an ascii representation of chararray for println.
    //anyway all the manipulations were in place.
    String b = new String(s);
    return b ;
  }

  public static void main(String[] args) {
    char[] test = {'a', 'a', 'b', 'a', 'c', 'd', ' ', ' ', ' ', ' ', ' '};
    System.out.println( new String(test) )  ;
    System.out.println( applyAlphabetRules(test) ) ;
  }

}


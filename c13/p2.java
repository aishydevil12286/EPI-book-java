import java.util.Map ;
import java.util.HashMap ;

// test if a string can be permuted to form a palindrome
// ie test if there are an even number of each letter
// solution 1: put the letters and counts in a hashmap O(n) time, O(n) space
// solution 2: for each index in the string, get the value, and then count total occurences in string. O(N^2 time), O(1) space
class P2 {

  public static boolean isPalindromePermute(String data) {
    HashMap<String, Integer> dict = new HashMap<String, Integer>() ;
    for (char c : data.toCharArray() ) {
      if (dict.get( Character.toString(c)) == null )  {
        dict.put(Character.toString(c), 1 );
      }  else {
        Integer cnt = dict.get( Character.toString(c)  ) ;
        dict.put(Character.toString(c), cnt+1 );
      }
    }
    int odd_cnt = 0;
    for (Map.Entry<String, Integer> entry : dict.entrySet()  ) {
      String key = entry.getKey();
      Integer val = entry.getValue();
      if (val % 2 == 1) {
        odd_cnt++;
      }
    }
    if (odd_cnt > 1) return false ;
    return true ;
  }

  public static void main(String[] args) {
    
    String[] data = {"cat", "a", "a man a plan a canal panama"};

    System.out.println( isPalindromePermute(data[0]) == false )  ; 
    System.out.println( isPalindromePermute(data[1]) == true )  ; 
    System.out.println( isPalindromePermute(data[2]) == true )  ; 

  }

}

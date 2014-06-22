//is palindrome

class P3 {

  public static boolean isPalindrome(String s) {
    boolean pal = true ;
    for (int left = 0 ; left < s.length(); left++ ) {
      int right = s.length() - 1 - left;
      if (left >= right) break ;
      if (s.charAt(left) != s.charAt(right)) {
        pal = false ;
      }
    } 

    return pal ; 
  }

  public static void main(String[] args) {
    System.out.println("Expected true: ");

    System.out.println(isPalindrome("abba"));
    System.out.println(isPalindrome("abcba"));
    System.out.println(isPalindrome("a"));
    System.out.println(isPalindrome("aa"));
    System.out.println(isPalindrome("xaaaaaaaaaax"));

    System.out.println("Expected false: ");
    System.out.println(isPalindrome("ab"));
    System.out.println(isPalindrome("abb"));
    System.out.println(isPalindrome("xaaaaaawaax"));

  }

}

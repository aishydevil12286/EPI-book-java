// regex implementation
// valid ESRE : ^ { RE } $

class P2 {


  public static boolean regexMatch(String regex, String data , int regexIdx, int dataIdx) {
    if (regex.equals("")) return true;
    if (data.equals("")) return false;

    if (regexIdx >= regex.length() ) return true ;
    if (dataIdx >= data.length() ) {
      return false ;
    }
    
    //System.out.println(regex + " " + data + " " + regexIdx + " " + dataIdx);
    
    if ((regex.charAt(regexIdx) == data.charAt(dataIdx)) && 
        (Character.isLetterOrDigit(regex.charAt(regexIdx)) &&
        (regexIdx == regex.length() -1) ) ) {
      return regexMatch(regex, data, regexIdx+1, dataIdx+1); 
    }

    if ((regex.charAt(regexIdx) == '.') && 
        (regexIdx == regex.length() -1) )  {
      return regexMatch(regex, data, regexIdx+1, dataIdx+1); 
    }

    // if r begins with alphanumeric character and next is not a star
    if ((regex.charAt(regexIdx) == data.charAt(dataIdx)) && 
        (Character.isLetterOrDigit(regex.charAt(regexIdx)) &&
        (regex.charAt(regexIdx+1) != '*') ) ) {
      return regexMatch(regex, data, regexIdx+1, dataIdx+1); 
    }
    // if r begins with alphanumeric and next char is star
    if ((regex.charAt(regexIdx) == data.charAt(dataIdx)) && 
        (Character.isLetterOrDigit(regex.charAt(regexIdx)) &&
        (regex.charAt(regexIdx+1) == '*') ) ) {
      //find first index that's not same char
      int j;
      for ( j=dataIdx; j<data.length(); j++) {
        if ((data.charAt(j) != data.charAt(dataIdx))) break ; 
        if (regexMatch(regex, data, regexIdx+2, j+1)) return true ; 
      }
    }
    // r is dot and then not star
    if ((regex.charAt(regexIdx) == '.') && 
        (regex.charAt(regexIdx+1) != '*') )  {
      return regexMatch(regex, data, regexIdx+1, dataIdx+1); 
    }
    // r is dot next is star
    if ((regex.charAt(regexIdx) == '.') && 
        (regex.charAt(regexIdx+1) == '*') )  {
      
      for (int j=dataIdx;j<data.length(); j++) {
        if (regexMatch(regex, data, regexIdx+2, j+1) == true ) return true ; 
      }
      return false ;
    }

    return regexMatch(regex, data, 0, dataIdx+1);
  
  }


  public static void main(String[] args) {
  
    String regex = "s.*le" ;
    String test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0)) ;
    
    regex = ".*" ;
    test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0)) ;
    
    regex = "." ;
    test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0)) ;
  
    regex = ".s*" ;
    test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0)) ;
    
    regex = "t" ;
    test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0)) ;
    
    regex = "thistextissearchable" ;
    test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0)) ;
    
    regex = "thistextissble" ;
    test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0) == false) ;
    
    regex = ".*z" ;
    test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0) == false) ;
    
    regex = "s*..z" ;
    test = "thistextissearchable";

    System.out.println(regexMatch(regex, test, 0, 0) == false) ;
  }

}


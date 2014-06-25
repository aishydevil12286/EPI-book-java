import java.util.Map ;
import java.util.HashMap ;

// test if a string can be formed from another
class P3 {

  public static HashMap<String, Integer> buildHashRepresentation(String data) {
    HashMap<String, Integer> dict = new HashMap<String, Integer>() ;
    for (char c : data.toCharArray() ) {
      if (dict.get( Character.toString(c)) == null )  {
        dict.put(Character.toString(c), 1 );
      }  else {
        Integer cnt = dict.get( Character.toString(c)  ) ;
        dict.put(Character.toString(c), cnt+1 );
      }
    }
    return dict ;
  }

  public static boolean isComposedFrom(String data, String test) {
    HashMap<String, Integer> dataHash = buildHashRepresentation(data) ;
    HashMap<String, Integer> testHash = buildHashRepresentation(test) ;
    for (Map.Entry<String, Integer> entry : testHash.entrySet()  ) {
      String key = entry.getKey();
      Integer val = entry.getValue();
      if ( dataHash.get(key) == null  ) return false;
      if ( dataHash.get(key) < val  ) return false;
    }
    return true ;
  }

  public static void main(String[] args) {
    
    String[] data = {"birds", "birds are cool", "birds are great"  };

    System.out.println( isComposedFrom(data[2], data[0]) == true )  ; 
    System.out.println( isComposedFrom(data[2], data[1]) == false )  ; 

  }

}

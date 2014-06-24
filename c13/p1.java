import java.util.Map ;
import java.util.HashMap ;
import java.util.ArrayList ;
import java.util.Arrays ;


class P1 {

  public static ArrayList<String> anagramPartition(String[] data) {
    HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>() ;
    for (String s : data ) {
      char[] word = s.toCharArray() ;
      Arrays.sort(word) ;
      if (dict.get( new String( word ) ) == null )  {
        ArrayList<String> sInAnArray = new ArrayList<String>() ;
        sInAnArray.add(s) ;
        dict.put(new String(word), sInAnArray );
      }  else {
        ArrayList<String> anagrams = dict.get( new String(word)  ) ;
        anagrams.add(s);
      }
    }
    ArrayList<String> out = new ArrayList<String>();
    for (Map.Entry<String, ArrayList<String>> entry : dict.entrySet()  ) {
      String key = entry.getKey();
      ArrayList<String> val = entry.getValue();
      out.addAll(val);
    }
    return out ;
  }

  public static void main(String[] args) {
    
    String[] data = {"cat", "tac", "burger", "grizzly", "dog", "god"};

    ArrayList<String> out = anagramPartition(data); 
    for (String s : out) {
      System.out.println( s );
    }

  }

}

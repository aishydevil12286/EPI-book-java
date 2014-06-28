//n queens
// solution via an initial permutation of 1-n yielding the rook placements
// then eliminating diagonally conflicting placements recursively

import java.util.HashMap ;
import java.util.Arrays ;

class P3 {

  
  public static void printBoard(int[] colPlacements) {
    
    System.out.println( Arrays.toString(colPlacements)  );
  }

  public static boolean isValidSolution(int[] colPlacements, int checkUpTo) {
    HashMap<Integer, Integer> ldValues = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> rdValues = new HashMap<Integer, Integer>();
    
    for (int i=0 ; i < checkUpTo + 1; i++ ) {
      //checkLeftDiagonals -- (i + j = k) 
      if (ldValues.get( i + colPlacements[i] ) == null)   {
        ldValues.put(  (i + colPlacements[i]), i) ;
      }  else return false ;
      //checkRightDiagonals -- ( i-j = k  )
      if (rdValues.get( i - colPlacements[i] ) == null)   {
        rdValues.put( (i - colPlacements[i]), i) ;
      }  else return false ;
    }  
    return true ;
  }

  public static void generatePermutedPlacements(int[] prefix, int[] suffix, int idxToFill) {
    //System.out.println("entering recursion with idx " + idxToFill) ; 
    //printBoard(prefix);
    //printBoard(suffix);

    if (idxToFill == prefix.length -1 ) {
      prefix[idxToFill] = suffix[0] ;
      if ( isValidSolution(prefix, idxToFill) ) printBoard(prefix) ;
      return; 
    }
    int[] nextSuffix = new int[suffix.length-1] ;
    for (int i=0 ; i  < suffix.length; i++ ) {
      prefix[idxToFill] = suffix[i] ;

      for (int j=0 ; j  < suffix.length; j++ ) {
        if (j == i) continue ;
        if (j < i) nextSuffix[j] = suffix[j] ;
        if (j > i) nextSuffix[j-1] = suffix[j] ;
      }
      
      if ( isValidSolution(prefix , idxToFill) ) generatePermutedPlacements(prefix, nextSuffix, idxToFill+1) ;

    }
  }
  
  public static void nQueens(int n) {
  
    int[] prefixPlacements = new int[n]  ;
    int[] suffixPlacements = new int[n]  ;
    for (int i=0 ; i < n; i++) {
      suffixPlacements[i] = i ;
    } 
    generatePermutedPlacements(prefixPlacements, suffixPlacements, 0) ;
  }

  public static void main(String[] args) {
    nQueens(5) ; 
  
  }

}

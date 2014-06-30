//  levienschtein distance
// edit is insertion, deletion, or substitution.
// suppose i instead break the string at the index
// and calculate the distance for each substring



class P2 {

  public static int min(int x, int y, int z) {
    if ((x <= y) && (x <= z)) return x ;
    if ((y <= x) && (y <= z)) return y ;
    return z ;
  }

  public static int computeLevenshteinDistance(String str1,String str2) {
    int[][] distance = new int[str1.length() + 1][str2.length() + 1];

   // if one word is blank and the other has i characters, i inserts are needed. 
    for (int i = 0; i <= str1.length(); i++)
      distance[i][0] = i;
    for (int j = 1; j <= str2.length(); j++)
      distance[0][j] = j;
 
    // build up the longer solutions - take the min of a deletion from i, a deletion from j, and a swap oof the last char
    for (int i = 1; i <= str1.length(); i++)
      for (int j = 1; j <= str2.length(); j++)
        distance[i][j] = min(
            distance[i - 1][j] + 1,
            distance[i][j - 1] + 1,
            distance[i - 1][j - 1]+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));
 
    return distance[str1.length()][str2.length()];    
  }

  public static void main(String[] args) {
    String t1 = "penguin" ;
    String t2 = "renuin" ;

    String t3 = "abcdefg" ;
    String t4 = "bcdefgi" ;

    System.out.println(computeLevenshteinDistance(t1, t2) == 2 );
    System.out.println(computeLevenshteinDistance(t3, t4) == 2 );
  }

}

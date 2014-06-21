//calc parity of array of n integers
import java.util.HashMap ;

class P1 {
  private Integer[] data ;
  private HashMap<Integer, Integer> precalcParityTable ;

  public  void populateData() {
    data = new Integer[20] ;
    for (int i=0; i<data.length; i++ ) {
      data[i] = 26 ;
    }
    precalcParityTable = new HashMap<Integer, Integer>() ;
  }
  public void printData() {
    for (int i=0; i<data.length; i++ ) {
      System.out.println(data[i]);
    }
  
  }

  public Integer calcParityOnce(Integer x) {
    Integer value = precalcParityTable.get(x) ;
    if (value != null) {
      return value ;
    }
    Integer parity = 0;
    while (x != 0) {
      x = x & (x -1)  ;
      parity++ ;
    }
    if ((parity % 2) == 0 ) {
      precalcParityTable.put(x, 0);
      return 0;
    } else {
      precalcParityTable.put(x, parity);
      return parity ;
    }
  }

  public Integer calcParityOverall( ) {
    Integer parity = 0 ;
    for (int i=0; i<data.length; i++ ) {
      parity += calcParityOnce(data[i]);
    }
    return parity;
  }

  public static  void main(String args[]) {
    P1 prob = new P1() ;

    prob.populateData();
    prob.printData();
    System.out.println(prob.calcParityOverall());
  
  }
}


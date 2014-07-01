// trapping water
// iterate over the array to find max
// on the left of the max, the water level rises, iterate from running max
//on the right water level falls, iterate from back


class P3 {

  public static int trapCalc(int[] tray) {
    int maxIdx =0 ;
    int maxVal = -99999 ;
    for (int i=0 ; i < tray.length ; i++) {
      if (tray[i] > maxVal) {
        maxIdx = i ; 
        maxVal = tray[i] ;
      }
    }
    int runMax = -99999 ;
    int total = 0 ;
    // left side
    for (int i=0 ; i < maxIdx ; i++) {
      if (tray[i] > runMax) {
        runMax = tray[i] ;
      } else {
        total += runMax - tray[i];
      }
    }
    //right side
    runMax = -99999 ;
    for (int i=tray.length - 1 ; i > maxIdx ; i--) {
      if (tray[i] > runMax) {
        runMax = tray[i] ;
      } else {
        total += runMax - tray[i];
      }
    }
    return total ;

  }

  public static void main(String[] args) {
    int[] tray = {1,4,3,7,9,2,6,1,3} ;
    System.out.println("total trapped water " + trapCalc(tray) ) ;
  }

}


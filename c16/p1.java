// tower of hanoi
import java.util.Stack ;
import java.util.EmptyStackException ;


class P1 {

  public Stack<Integer>[] tower ;

  public P1() {
    @SuppressWarnings("unchecked")
    Stack<Integer>[] tower = (Stack<Integer>[]) new Stack[3] ;  
    tower[0] =  new Stack<Integer>() ;  
    tower[1] =  new Stack<Integer>() ;  
    tower[2] =  new Stack<Integer>() ;  
    this.tower = tower ;

    tower[0].push(5);
    tower[0].push(4);
    tower[0].push(3);
    tower[0].push(2);
    tower[0].push(1);

  }

  public  int tryMove(int x, int y) {
    Integer ty ;
    try {
      ty = tower[y].peek() ;
    } catch (EmptyStackException e) {
      ty = 999999 ;
    }
    
    if (ty > tower[x].peek() ) {
      tower[y].push(tower[x].pop()) ;
      return 0 ;
    } else return -1 ;
  }


  public void printTower() {
    Integer t1 , t2, t3 ;
    try {
      t1 = tower[0].peek() ;
    } catch (EmptyStackException e) {
      t1 = null ;
    }
    try {
      t2 = tower[1].peek() ;
    } catch (EmptyStackException e) {
      t2 = null ;
    }
    try {
      t3 = tower[2].peek() ;
    } catch (EmptyStackException e) {
      t3 = null ;
    }

    System.out.println( t1 + " : " + t2 + " : " + t3 ) ;
  }

  public void moveNFromXToY( int n, int x, int y , int z   ) {
    if (n == 1) {
      printTower() ;
      tryMove( x, y  ) ;
    } else { 
      moveNFromXToY( n-1, x, z , y ) ; 
      moveNFromXToY( 1, x, y , z ) ; 
      moveNFromXToY( n-1, z, y, x  ) ; 
    }
  }

  public void solveTower( ) {
    moveNFromXToY( tower[0].size(), 0, 2 , 1 ) ;


  }

  public static void main(String[] args) {
    P1 prob = new P1() ;
    prob.solveTower() ;

  }

}




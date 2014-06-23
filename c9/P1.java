//stack with a max


class P1 {
 
  public P1() {}
 
  class Stack {
  
    private int max ;
    private List store ;
  
    public Stack() {
      store = new List() ;
    }

    public void push(Integer i) {
      if (i > max) {
        max = i ;
      }
      store.add(i) ;
    }

    public Integer pop() {
      Integer temp = (Integer) store.get(0) ;
      store.del(0) ;
      return temp ;
    }

    public int getMax() {
      if (store.size == 0) throw new NullPointerException("stack empty") ;
      return max ;
    }

  }

  public static void main(String[] args) {
    P1 prob = new P1() ;
    P1.Stack test = prob.new Stack() ;
    test.push(10) ;
    test.push(2) ;
    System.out.println(test.getMax());
    test.push(13) ;
    test.push(13) ;
    System.out.println(test.getMax());
    test.push(23) ;
    System.out.println(test.getMax());
  }



}

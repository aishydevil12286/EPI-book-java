  

class List {
    
  Link root ;
  int size ;

  public List() {
    root = null ;
    size = 0 ;
  }

  public void add(Object data) {
    Link temp = root ;
    root = new Link(data) ;
    root.next = temp ;
    size++ ;
  }

  public void del(int i) {
    if (size == 0) return ;
    if ((i > size - 1  ) || (i < 0)) return ;
    Link last = null ;
    Link next = null ;
    Link curr = root ;
    for (int j=0; j< i ; j++) {
      last = curr ;
      curr = curr.next;
    }
    
    next = curr.next ;
    if (last != null)  {
      last.next = next ;
      size--; 
    } else if (last == null) {
      root=next;
      size-- ;
    }
  }

  public Object get(int i) {
    if (size == 0) return null;
    if ((i > size - 1  ) || (i < 0)) return null;
    Link out = root ;
    for (int j=0; j< i ; j++) {
      out = out.next;
    }
    return out.data;
  }

  class Link {
    Object data ; 
    Link next  ;
    public Link(Object linkData) {
      data = linkData ; 
    }

  }


  public static void main(String[] args) {
    List testList = new List() ;
    testList.add(1);
    testList.add(2);
    //test get
    System.out.println( (Integer) testList.get(1) == 1);
    
    // test delete root
    testList.del(0);
    System.out.println( (Integer) testList.get(0) == 1);

    // test delete last
    testList.del(0);
    System.out.println( (Integer) testList.get(0) == null);

    // test delete normal element
    testList.add(1);
    testList.add(2);
    testList.add(3);
    testList.del(1);
    System.out.println( (Integer) testList.get(1) == 1);
    // test delete out of bounds
    testList.del(11);
    System.out.println( (Integer) testList.get(1) == 1);
    // test delete negative
    testList.del(-1);
    System.out.println( (Integer) testList.get(1) == 1);
    // test get negative number
    System.out.println( (Integer) testList.get(-1) == null);
    // test get out of bounds
    System.out.println( (Integer) testList.get(10) == null);
  }



}


//reverse a singly linked list
class P2 {

  public static void reverse(List a) {
    
    if (a.size < 2) return ;
    
    List.Link curr = a.root ;
    
    List.Link prev = null ;
    while (curr != null) {
      List.Link temp = curr.next ;
      curr.next = prev;
      prev = curr ;
      curr = temp ;
    }

    a.root = prev ;

  }


  public static void main(String[] args) {

    List a = new List();
    a.add(0) ;
    a.add(1) ;
    a.add(2) ;
    a.add(3) ;
    a.add(4) ;
    a.add(5) ;
    a.add(6) ;
    reverse(a);
    System.out.println((Integer) a.get(0) == 0  );
    System.out.println((Integer) a.get(1) == 1  );
    System.out.println((Integer) a.get(2) == 2  );
    System.out.println((Integer) a.get(3) == 3  );
    System.out.println((Integer) a.get(4) == 4  );
    System.out.println((Integer) a.get(5) == 5  );
    System.out.println((Integer) a.get(6) == 6  );
  }
}

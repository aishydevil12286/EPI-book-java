//reverse a subset of a singly ll


class P3 {

  public static void reverseASubset(List a, int i, int j) {
    if ((i >= j )||(i>=a.size)||(j>=a.size)) return ;

    List.Link prev = null ;
    List.Link curr = a.root ;
    
    for (int k = 0; k < i; k++ ) {
      prev = curr ;
      curr = curr.next ;
    }

    List.Link beforeFirst = prev ; 
    List.Link first = curr ; 

    int k= i;
    while (k <= j ) {
      List.Link temp = curr.next ;
      curr.next = prev ;
      prev = curr ;
      curr = temp ;
      k++;
    }
    

    first.next = curr ;
    // if root was affected, set it to be last
    if (i == 0 ) {
      a.root = prev ;
    } else {
      // otherwise make beforefirst point to last element
      beforeFirst.next = prev ;
    }

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
    reverseASubset(a, 2, 4);
    System.out.println((Integer) a.get(0) == 6  );
    System.out.println((Integer) a.get(1) == 5  );
    System.out.println((Integer) a.get(2) == 2  );
    System.out.println((Integer) a.get(3) == 3  );
    System.out.println((Integer) a.get(4) == 4  );
    System.out.println((Integer) a.get(5) == 1  );
    System.out.println((Integer) a.get(6) == 0  );
    
  }
}

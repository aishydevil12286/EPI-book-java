//merge 2 sorted lists

class P1 {
  
  private static void doOneMerge( List a, List b, List.Link a_link, List.Link b_link ){
    if ((a_link == null) || (b_link == null)) return ;

    if (!((Integer) b_link.data < (Integer) a_link.data )) {
      if (a_link.next == null) {
        a_link.next = b_link ;
      } else if (!((Integer) b_link.data < (Integer) a_link.next.data)) {
        doOneMerge(a, b, a_link.next, b_link);
      } else {
        // delete b_link from b and add to a
        List.Link b_next_to_recur =  b_link.next ;
        List.Link temp = a_link.next ;
        a_link.next = b_link ;
        b_link.next = temp ;
        doOneMerge(a, b, a_link.next, b_next_to_recur ) ;
      }
    } else {
      doOneMerge(a , b, a_link.next, b_link) ;
    }
  }
  
  public static void mergeTwoSortedLists( List a, List b ) {
    if (!((Integer) a.root.data < (Integer) b.root.data) ) {
      doOneMerge(b, a, b.root, a.root) ; 
    }  else {
      doOneMerge(a, b, a.root, b.root) ; 
    }
  }
  
  public static void main(String[] args) {
    List a = new List();
    List b = new List();
    a.add(9) ;
    a.add(7) ;
    a.add(4) ;
    a.add(2) ;
    a.add(1) ;
    a.add(0) ;
    b.add(8) ;
    b.add(6) ;
    b.add(5) ;
    b.add(3) ;
    mergeTwoSortedLists(a,b );
    System.out.println((Integer) a.get(0) == 0  );
    System.out.println((Integer) a.get(1) == 1  );
    System.out.println((Integer) a.get(2) == 2  );
    System.out.println((Integer) a.get(3) == 3  );
    System.out.println((Integer) a.get(4) == 4  );
    System.out.println((Integer) a.get(5) == 5  );
    System.out.println((Integer) a.get(6) == 6  );
    System.out.println((Integer) a.get(7) == 7  );
    System.out.println((Integer) a.get(8) == 8  );
    System.out.println((Integer) a.get(9) == 9  );

  }

}

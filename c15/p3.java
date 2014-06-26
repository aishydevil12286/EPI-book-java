// first key larger than k in a bst 


class P3 {

  public static BTree firstInstanceOfKGt(BTree bt, int k) {
    BTree leftSoln = null ;
    BTree rootSoln = null ;
    BTree rightSoln = null ;
    
    if (bt == null) return null ;
    
    if ( k < (Integer) bt.data  ) {
      leftSoln =  firstInstanceOfKGt(bt.left , k) ;
      if (leftSoln != null) return leftSoln ;
      return bt ;
    }
    if ( k >= (Integer) bt.data ) {
      rightSoln =  firstInstanceOfKGt(bt.right, k) ;
      if (rightSoln != null) return rightSoln ;
    }
    return null ;

  }


  public static void main(String[] args) {
    BTree btree = new BTree(108) ;
    
    btree.left = new BTree(108) ;
    btree.right = new BTree(285) ;
    
    btree.left.left = new BTree(-10) ;
    btree.left.right = new BTree(108) ;
    btree.right.left = new BTree(243) ;
    btree.right.right = new BTree(285) ;
    
    btree.left.left.left = new BTree(-14) ;
    btree.left.left.right = new BTree(2) ;
    btree.right.right.right = new BTree(401) ;
    
    
   System.out.println(  (Integer) firstInstanceOfKGt(btree, 108).data==243 ) ;
   System.out.println(  (Integer) firstInstanceOfKGt(btree, -10).data==2 ) ;
   System.out.println(  (Integer) firstInstanceOfKGt(btree, 285).data==401 ) ;
   System.out.println(  firstInstanceOfKGt(btree, 402) == null ) ;
 

  }

}



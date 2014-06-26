// find the first instance of k as in an inorder traversal in a bst, recursive AND iterative


class P2 {

  public static BTree firstInstanceOfKRecursive(BTree bt, int k) {
    BTree leftSoln = null ;
    BTree rootSoln = null ;
    BTree rightSoln = null ;
    
    if (bt == null) return null ;
    if ( k <= (Integer) bt.data ) {
      leftSoln =  firstInstanceOfKRecursive(bt.left , k) ;
      if (leftSoln != null) return leftSoln ;
    }
    if ( k == (Integer) bt.data ) {
      rootSoln =  bt ;
      if (rootSoln != null) return rootSoln ;
    }
    if ( k >= (Integer) bt.data  ) {
      rightSoln =  firstInstanceOfKRecursive(bt.right, k) ;
      if (rightSoln != null) return rightSoln ;
    }
    return null ;

  }

  public static BTree firstInstanceOfKIterative(BTree bt, int k) {
   
    BTree rootSoln = null ;

    BTree test = bt;
    while (test != null) {
      if ( k == (Integer) test.data )  {
        rootSoln = test ; 
      }

      if ( k <= (Integer) test.data )  {
        test = test.left ;
        continue ;
      }
      
      if ( k > (Integer) test.data )  {
        test = test.right ;
        continue ;
      }
      break ;
      
    }
    return rootSoln ;

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
    
    
   System.out.println(  (Integer) firstInstanceOfKRecursive(btree, 108).left.data==-10 ) ;
   System.out.println(  (Integer) firstInstanceOfKRecursive(btree, 285).left.data==243 ) ;
   System.out.println(  firstInstanceOfKRecursive(btree, 143) == null ) ;
 
   System.out.println(  (Integer) firstInstanceOfKIterative(btree, 108).left.data==-10 ) ;
   System.out.println(  (Integer) firstInstanceOfKIterative(btree, 285).left.data==243 ) ;
   System.out.println(   firstInstanceOfKIterative(btree, 143) == null ) ;

  }

}



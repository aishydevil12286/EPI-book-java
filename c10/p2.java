// k- balanced tree

class P2 {

  private static int getNodeCountDiff(BTree btree) {
    if (btree == null) return 0 ;
    int leftMax = getNodeCount(btree.left);
    int rightMax = getNodeCount(btree.right);
    if (leftMax > rightMax) return leftMax ;
    return rightMax ;
  }

  private static int getNodeCount(BTree btree) {
    if (btree == null) return 0;
    int leftCnt = getNodeCount(btree.left);
    int rightCnt = getNodeCount(btree.right);
    return leftCnt+rightCnt+1 ;
  }
  
  public static BTree kBalanced(BTree btree, int k) {
    //System.out.println("exploring node " + (Integer)btree.data + " with k " + k  ); 
    if ( (getNodeCountDiff(btree.left) <= k ) && (getNodeCountDiff(btree.right) <= k ) ) {
      //System.out.println( "both children are k balanced");
      //System.out.println( "left output is: " + getNodeCountDiff(btree.left) );
      //System.out.println( "right output is: " + getNodeCountDiff(btree.right) );
      if (getNodeCountDiff(btree) > k) return btree ;
      return null ;
    }  
    if (getNodeCountDiff(btree.left) > k ) {
      BTree leftKBal = kBalanced(btree.left, k);
      if (leftKBal != null) return leftKBal ;
    }
    if (getNodeCountDiff(btree.right) > k ) {
      BTree rightKBal = kBalanced(btree.right, k);
      if (rightKBal != null) return rightKBal ;
    }
    return null ;
  }
  
  public static void main(String[] args) {
    BTree btree = new BTree(1) ;
   
    btree.left = new BTree(2) ;
    btree.right = new BTree(3) ;
    
    btree.left.left = new BTree(4) ;
    btree.left.right = new BTree(5) ;
    btree.right.left = new BTree(6) ;
    btree.right.right = new BTree(7) ;
    
    btree.left.left.left = new BTree(8) ;
    //btree.left.right.left = new BTree(10) ;
    //btree.right.left.left = new BTree(12) ;
    //btree.right.right.left = new BTree(7) ;
    btree.left.left.right = new BTree(9) ;
    btree.left.right.right = new BTree(11) ;
    btree.right.left.right = new BTree(13) ;
    btree.right.right.right = new BTree(14) ;
    
    btree.right.left.right.left = new BTree(18) ;
    btree.left.right.right.left = new BTree(15) ;
    btree.right.left.right.right = new BTree(16) ;
    btree.right.left.right.left.right = new BTree(17) ;
    
    
    System.out.println( ((Integer) kBalanced(btree, 3).data ==  6 ) ) ;
    


  }

}




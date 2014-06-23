// is a tree balanced? use o(h) max recursion depth


class P1 {


  private static int getMaxDepth(BTree btree, int height) {
    if (btree == null) return height ;
    int leftMax = getMaxDepth(btree.left, height+1);
    int rightMax = getMaxDepth(btree.right, height+1);
    if (leftMax > rightMax) return leftMax ;
    return rightMax ;
  }

  private static int getMinDepth(BTree btree, int height) {
    if (btree == null) return height ;
    int leftMax = getMinDepth(btree.left, height+1);
    int rightMax = getMinDepth(btree.right, height+1);
    if (leftMax < rightMax) return leftMax ;
    return rightMax ;
  }

  private static int getMaxHeightDiff(BTree btree) {
    return (getMaxDepth(btree, 0) - getMinDepth(btree, 0) ); 
  }


  public static boolean isBalanced(BTree btree) {
    if (getMaxHeightDiff(btree) < 2 ) return true;
    return false ;
  }

  public static void main(String[] args) {
    BTree btree = new BTree(1) ;
    btree.left = new BTree(2) ;
    btree.right = new BTree(3) ;
    btree.left.left = new BTree(4) ;
    btree.left.right = new BTree(5) ;
    btree.right.left = new BTree(6) ;
    btree.right.right = new BTree(7) ;
    
    System.out.println(isBalanced(btree)==true) ;
    
    btree.right.right.right = new BTree(8) ;
    btree.right.right.right.left = new BTree(8) ;

    System.out.println(isBalanced(btree) == false) ;

  }

}



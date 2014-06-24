// symmetric tree

class P3 {

  public static boolean mirrorSymRecur(BTree left, BTree right) {
    if ((left == null)!=(right == null)) return false ;
    if ((left == null) && (right == null)) return true ;
    boolean lt = mirrorSymRecur(left.left, right.right) ;
    boolean rt = mirrorSymRecur(left.right, right.left) ;
    return lt && rt ;
  }
  
  public static boolean isMirrorSym(BTree btree) {
    return mirrorSymRecur(btree.left, btree.right) ;
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
    
    
    System.out.println( isMirrorSym(btree) == false) ;
    System.out.println( isMirrorSym(btree.left.left) ) ;
    


  }

}

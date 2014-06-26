// does a tree obey the bst property 


class P1 {


  public static boolean isObeysBST(BTree bt) {
    boolean left = true ;
    boolean right = true ;

    if (bt.left != null) {
      if ( (Integer) bt.left.data > (Integer)bt.data ) return false ;
      else left = isObeysBST( bt.left);
    }
    if (bt.right != null) {
      if ( (Integer)bt.right.data < (Integer) bt.data ) return false ;
      else right = isObeysBST( bt.right);
    }
    return (left && right) ;

  }

  public static void main(String[] args) {
    BTree btree = new BTree(2) ;
    btree.left = new BTree(1) ;
    btree.right = new BTree(3) ;
    
    System.out.println(  isObeysBST(btree)==true ) ;
    
    btree.left.left = new BTree(4) ;
    btree.left.right = new BTree(5) ;

    System.out.println(  isObeysBST(btree)==false ) ;

  }

}



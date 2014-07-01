import java.util.PriorityQueue ;
import java.util.BitSet ;


class HuffManTree {

  public Node root ;

  class Node implements Comparable {
  
    public Character data ;
    public Float freq ; 
    public Node parent ;
    public Node left ;
    public Node right ;

    public Node(Character c, Float freq) {
      data = c ;
      this.freq = freq ;
    }

    public int compareTo(Object node) throws ClassCastException {
    if (!(node instanceof Node))
      throw new ClassCastException("A Node object expected.");
    float nodeFreq = ((Node) node).freq;  
    return Float.compare(freq, nodeFreq);    
  }


  }

  public HuffManTree(char[] x , float[] freq) {
     PriorityQueue<Node> queue = new PriorityQueue<Node>( );  
     for (int i=0; i< x.length; i++) {
       queue.add(new Node(x[i], freq[i])) ;
     } 
     while (!queue.isEmpty()) {
       Node n1 = queue.poll() ;
       if (queue.isEmpty()) break ;
       Node n2 = queue.poll() ;
       Node n3 = new Node(null, n1.freq + n2.freq ) ;
       n1.parent = n3 ;
       n2.parent = n3 ;
       n3.left = n1 ; 
       n3.right = n2 ;
       root = n3 ;
       queue.add(n3) ;
       
     }
  }
  
  public BitSet lookup(Character x) {
    BitSet out = new BitSet() ;
    return lookup(x, root, out, 0 ) ;
  }

  public BitSet lookup(Character x, Node node, BitSet path, int level  ) {
    BitSet left = (BitSet) path.clone() ;
    BitSet right = (BitSet) path.clone() ;
    left.set(level) ;
    if (node == null) return null ;
    if (node.data == x) return path  ;
    BitSet out = lookup(x, node.left, left, level+1) ;
    if (out != null) return out ;
    out = lookup(x, node.right, right, level+1) ;
    return out ;
  }

}

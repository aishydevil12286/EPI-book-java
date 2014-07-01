//huffman code implementation
import java.util.HashMap ;
import java.util.BitSet  ;


class P1 {

  // build huffman tree



  public static BitSet[] huffmanCode(char[] x, float[] freq ) {
    HuffManTree htree = new HuffManTree(x, freq) ;
    BitSet[] out = new BitSet[x.length] ; 
    for (int i = 0 ; i < x.length ; i++ ) {
      out[i] = htree.lookup(x[i]) ;
    }
    return out ;
  }


  public static void main(String[] args) {
    char[] charsToCode = {'a', 'b' , 'c', 'd', 'e', 'f'} ;
    float[] freq = {0.1f, 0,1f, 0.2f, 0.20f, 0.4f} ;
    BitSet[] codes = huffmanCode(charsToCode, freq);
    for (BitSet i : codes) {
      System.out.println(i.toString()) ;
    }
  }

}

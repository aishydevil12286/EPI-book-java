@SuppressWarnings("unchecked")
class Heep<dataType extends Comparable<dataType>> {

  private dataType[] store ;
  public int size ;

  public Heep( int initSize) {
    store = (dataType[]) new Comparable[initSize+1]  ;
    size = 0 ;
  }


   private void percolatingDown(int k)
   {
      dataType tmp = store[k];
      int child;

      for(; 2*k <= size; k = child)
      {
         child = 2*k;

         if(child != size &&
            store[child].compareTo(store[child + 1]) > 0) child++;

         if(tmp.compareTo(store[child]) > 0)  store[k] = store[child];
         else
                break;
      }
      store[k] = tmp;
   }


  public void deleteMin() throws RuntimeException {
    if (store[1] == null) throw new RuntimeException("heap empty but you tried a delete");
    store[1] = store[size] ;
    store[size] = null ;
    size-- ;
    percolatingDown(1);
  }

  public dataType findMin() {
    final dataType out =  store[1] ;
    return out;
  }

  public void insert(dataType data) {
    size++ ;

    //Insert a new item to the end of the array
    int pos = size;

    //Percolate up
    for(; pos > 1 && data.compareTo(store[pos/2]) < 0; pos = pos/2 )
       store[pos] = store[pos/2];

    store[pos] = data; 

  }

  public static void main(String[] args) {
    Heep a = new Heep<Integer>(100) ;
    a.insert(4);
    a.insert(1);
    a.insert(6);
    a.insert(2);
    a.insert(5);
    a.insert(3);

    System.out.println( (Integer)   a.findMin() );
    a.deleteMin();
    System.out.println(   (Integer) a.findMin() );
    a.deleteMin();
    System.out.println( (Integer)  a.findMin() );
    a.deleteMin();
    System.out.println( (Integer)  a.findMin() );
    a.deleteMin();
    System.out.println( (Integer)  a.findMin() );
    a.deleteMin();
    System.out.println( (Integer)  a.findMin() );
    a.deleteMin();
    System.out.println( (Integer)  a.findMin() );
  }

}

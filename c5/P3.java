// reverse bits in a long

class P3 {

  
  
  public static long reverse(long x) {
   // brute force would be to test every bit via (x & (1 << i)) >> i << (63 - i) and anding with a new 1111111 long. O(32) steps
   // better way - swap two bits for each pair 
   int i =0 ;
   //java uses 2's complement long representation so bit 63 has weight -2^63, bit 62 has weight 2^62
   // i assume we don't want to play with flipping signs so last bit isnt touched.
   int j = 62 ;
   while (i < j) {
     if ((((x & (1L << i)) >> i) ^  ((x & (1L << j)) >> j ))  == 1L )   {
       x ^= ((1L << i) | (1L << j)); 
     }
     i++;
     j--;
   }
    return x;
   // better way --- create a precomputed table that for every 16 bit # contains the reversed bits
  }

  public static void main(String[] args) {
    long x;
    if (args.length == 0) {
      x=1L ;
    } else {
      x= Long.parseLong(args[0]); 
    }
    System.out.println( reverse(x)  ); 

  }

}


/** 
 * Implementation of the Union-Find ADT. 
 */
        /*
           Assignment number : 8
           File Name : UnionFind.java
           Name: Ran Zaaroor
           Student ID : 209374040
           Email : Ran.zaaroor@gmail.com
       */
public class UnionFind { 
 
   private static final int ROOT = 0; 
   private int up[]; 
   private int weight[]; 
   int numSets; 
 
 
   /** 
    * Constructor - initializes up and weight arrays. 
    * 
    * @param numElements initial number of singleton sets. 
    */ 
   public UnionFind (int numElements) { 
 
      up = new int[numElements + 1]; 
      for (int i = 1; i < up.length; i++) 
         up[i] = ROOT; 
 
      weight = new int[numElements + 1]; 
      for (int i = 1; i < weight.length; i++) 
         weight[i] = 1; 
 
      numSets = numElements; 
   } 
 
   /** 
    * Unites two sets using weigthed union. 
	* Assumes that the given elements are representatives of their sets.
    * 
    * @param i representative of first set. 
    * @param j representative of second set. 
    */ 
   public void union (int i, int j) { 
 
      if (up[i] != 0 || up[j] != 0) 
         throw new IllegalArgumentException ("i and j must be set representatives"); 
       
      if (i == j) 
         return; 
 
      numSets--; 
 
      int newWeight = weight[i] + weight[j]; 
      if (weight[i] < weight[j]) { 
         up[i] = j; 
         weight[j] = newWeight; 
      } 
      else { 
         up[j] = i; 
         weight[i] = newWeight; 
      } 
   } 
 
   /** 
    * Finds the set representative, and applies path compression. 
    * 
    * @param i the element to search. 
    * @return the representative of the group that contains i. 
    */ 
   public int find (int i) { 
 
      int r = i; 
 
      while (up[r] != ROOT) 
         r = up[r]; 
 
      // Compress path. 
      if (i != r) { 
         int k = up[i]; 
         while (k != r) { 
            up[i] = r; 
            i = k; 
            k = up[k]; 
         } 
      } 
 
      return r; 
   } 
 
   /** 
    * Find the current number of sets. 
    * 
    * @return the number of set. 
    */ 
   public int getNumSets() { 
      return numSets; 
   } 
 
   /** 
    * Prints the contents of the up array. 
    */ 
   public void debugPrintUp() { 
 
      System.out.print ("up:     "); 
      for (int i = 1; i < up.length; i++) 
         System.out.print (up[i] + " "); 
      System.out.println (""); 
   } 
 
   /** 
    * Prints the results of running find on all elements. 
    */ 
   public void debugPrintFind() { 
 
      System.out.print ("find:   "); 
      for (int i = 1; i < up.length; i++) 
         System.out.print (find (i) + " "); 
      System.out.println (""); 
   } 
 
   /** 
    * Prints the contents of the weight array. 
    */ 
   public void debugPrintWeight() { 
 
      System.out.print ("weight: "); 
      for (int i = 1; i < weight.length; i++) 
         System.out.print (weight[i] + " "); 
      System.out.println (""); 
   } 
 
   /** 
    * Various tests for the Union-Find functionality. 
    * 
    * @param args command line arguments - not used. 
    */ 
   public static void main (String[] args) { 
 
      UnionFind uf = new UnionFind (10); 
 
      uf.debugPrintUp(); 
      uf.debugPrintFind(); 
      uf.debugPrintWeight(); 
      System.out.println ("Number of sets: " + uf.getNumSets()); 
      System.out.println (""); 
 
      uf.union (2, 1); 
      uf.union (3, 2); 
      uf.union (4, 2); 
      uf.union (5, 2); 
 
      uf.debugPrintUp(); 
      uf.debugPrintFind(); 
      uf.debugPrintWeight(); 
      System.out.println ("Number of sets: " + uf.getNumSets()); 
      System.out.println(); 
 
      uf.union (6, 7); 
      uf.union (8, 9); 
      uf.union (6, 8); 
 
      uf.debugPrintUp(); 
      uf.debugPrintFind(); 
      uf.debugPrintWeight(); 
      System.out.println ("Number of sets: " + uf.getNumSets()); 
      System.out.println(); 
 
      uf.find (8); 
 
      uf.debugPrintUp(); 
      uf.debugPrintFind(); 
      uf.debugPrintWeight(); 
      System.out.println ("Number of sets: " + uf.getNumSets()); 
      System.out.println(); 
   } 
} 


import java.util.*;

import com.google.common.hash.Hashing;

public class BloomFilter {
	
	private BitSet bitArray;
	private int N; 
	private int K;
	private int falsePositive;
	
public BloomFilter(int size, int hash_count) {
	bitArray=new BitSet(size);
	this.N=size;
	this.K=hash_count;
	falsePositive=0;
	
}

public String toString() {
	StringBuilder string=new StringBuilder();
	for (int i=0; i<N;i++) {
		if (i<N-1) {
		if (bitArray.get(i)) {
			string.append("1,");
		}
		else
			string.append("0,");
	}
	
	if(i==N-1) {
		if (bitArray.get(i)) {
			string.append("1");
		}
		else
			string.append("0");
	}
	}
	return string.toString();
}

public void printBitsArray() {
	for(int i=0;i<N;i++) {
		if(bitArray.get(i)) {
			if (i==N-1)
			System.out.print("1");
			else System.out.print("1,");
		}
		
		else {
			if(i==N-1)
			System.out.print("0");
			else 	System.out.print("0,");
		}
	
	}
	System.out.println();
	
}
public void add(String element) {
         
	     for (int i = 1; i <= K; i++) {
	            int hash = Hashing.murmur3_32(i).hashBytes(element.getBytes()).asInt();
	            int index = Math.abs(hash) % N;
	            bitArray.set(index);
	        }
	     
	
}

public int hashCollisions(String password) {
	   int count = 0;
	  for (int i = 1; i <= K; i++) {
	        int hash = Hashing.murmur3_32(i).hashBytes(password.getBytes()).asInt();
	        int index = Math.abs(hash) % N;
	        if (bitArray.get(index)) count++;
	    }
	  return count;
	    
}

public boolean contain(String element) {
	PasswordApp psApp=new PasswordApp(this);
    for (int i = 1; i <= K; i++) {
        int hash = Hashing.murmur3_32(i).hashBytes(element.getBytes()).asInt();
        int index = Math.abs(hash) % N;
        if (!bitArray.get(index)) return false;
    }
    
    if(!psApp.weakPass.contains(element))
    	this.falsePositive++;
  
    return true;
}
 public int getFalsePositiveAmount() {
	 return falsePositive;
 }


}

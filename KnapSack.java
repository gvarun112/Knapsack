import java.io.*;
import java.util.Random;
public class KnapSack {

    private static int[] N;
    private static boolean output = false;
    public static void main(String[] args) throws IOException {
        
        long initialTime = System.currentTimeMillis();
        Random r = new Random();
        N = new int[50];
        
        for (int i=0;i<50;i++)
        {
            N[i] = r.nextInt(100);
        }
        
        Boolean x = knap(50,1000,1000);
        System.out.println("\nX="+x);
        long finalTime = System.currentTimeMillis();
        long timeTaken = finalTime - initialTime;
        System.out.println("\nTime taken = " + timeTaken);
        
    }
    private static Boolean knap(int X, int L1, int L2) {
        
        if(L1==0 && L2==0) { output=true; return output; }
        if(X==0) { return false; }
        if(L1<0 || L2<0) { return false; }
        if(output==false) {
            return (knap(X-1,L1-N[X-1],L2)||knap(X-1,L1,L2-N[X-1])||knap(X-1,L1,L2));
        
        }
        
        else return output;
    
    }
}  
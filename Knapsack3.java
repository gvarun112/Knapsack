
import java.io.IOException;
import java.util.Random;

public class Knapsack3 {
    private static int[] N;
    private static boolean output = false;
    private static boolean[][][] cacheValid;
    private static boolean[][][] cache;
    public static void main(String[] args) throws IOException {
        
        long initialTime = System.currentTimeMillis();
        Random r = new Random();
        N = new int[50];
        
        for (int i=0;i<50;i++)
        {
            N[i] = r.nextInt(100);
        }
        
        cache = new boolean[51][1001][1001];
        cacheValid = new boolean[51][1001][1001];
        Boolean x = knapMemo(50,1000,1000);
        System.out.println("\nX="+x);
        long finalTime = System.currentTimeMillis();
        long timeTaken = finalTime - initialTime;
        System.out.println("\nTime taken = " + timeTaken);
    }
    private static Boolean knapMemo(int X, int L1, int L2) {
        
        if(L1==0 && L2==0) { output=true; return output; }
        if(X==0) { return false; }
        if(L1<0 || L2<0) { return false; }
        
        if(cacheValid[X][L1][L2] != true)
        {
            Boolean abcd = (knapMemo(X-1,L1-N[X-1],L2)||knapMemo(X-1,L1,L2-N[X-1])||knapMemo(X-1,L1,L2));
            cacheValid[X][L1][L2]=true;
            cache[X][L1][L2]=abcd;
        }
        
        return cache[X][L1][L2];

    }
}
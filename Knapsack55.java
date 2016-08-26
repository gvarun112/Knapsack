
import java.util.Random;

public class Knapsack55 {
    
    private static int[] N;
    private static boolean[][][] cache;
    
	static boolean[][] cacheL1;
        static boolean[][]cacheL2;
        	
        public static void main(String[] args) {
            
        long initialTime = System.currentTimeMillis();
        Random r = new Random();
        N = new int[50];
        
        for (int i=0;i<50;i++)
        {
            N[i] = r.nextInt(100);
        }
        
        cache = new boolean[51][1001][1001];
        cacheL1 = new boolean[51][1001];
        cacheL2 = new boolean[51][1001];
        Boolean x = knapDP(50,1000,1000);
        System.out.println("\nX="+x);
        long finalTime = System.currentTimeMillis();
        long timeTaken = finalTime - initialTime;
        System.out.println("\nTime taken = " + timeTaken);
		
                knapDP(50,1000,1000);
	}
                
	public static boolean knapDP(int X,int L1,int L2)
	{
            for (int i = 0; i <= X; i++) {
                                        cache[i][0][0] =true;
					cacheL1[i][0] =true;
                                        cacheL2[i][0] =true;
				}
				for (int i = 1;  i <= L1; i++) {
                                    cache[0][i][0] =false;
					cacheL1[0][i] =false;
				}
				for (int i = 1; i <= L2; i++) {
					cache[0][0][i] =false;
                                        cacheL2[0][i] =false;
				}
				
		//Recusrion case
	   for (int i=1 ; i <= X; i++){
               for (int j=1; j<=L1 ; j++){
                   if(j-N[i-1]>=0){
				   
				   cacheL1[i][j] = cacheL1[i-1][j-N[i-1]] || cacheL1[i-1][j];
                   }
               }
               for (int j=1; j<=L2 ; j++){
                   if(j-N[i-1]>=0){
				   
				   cacheL2[i][j] = cacheL2[i-1][j-N[i-1]] || cacheL2[i-1][j];
                   }
               }	   
	   }
           
           for (int i=1 ; i <= X; i++){
               for (int j=1; j<=L1 ; j++){
                   for (int k=1; k<=L2 ; k++){
                        cache[i][j][k] = cacheL1[i][j] && cacheL2[i][k];
                   }
               }	   
	   }
	 
	   return cache[X][L1][L2];
		
	}
}
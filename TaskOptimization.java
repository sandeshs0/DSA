// Greedy Technique use garera
// Kun method use garera chai maximum tasks complete garna sakinxa. 

public class TaskOptimization {
    void maxTaskSelect(int s[], int f[]){
        // sort both arrays on the basis of finished time to ascending order 
        // Use comprator operator java or merge sort or quick sort

        int i=0;
        System.out.println("Selected Activity is +"+i);

        for(int j=1; j<s.length; j++){
            if(s[j]>=f[i]){
                i=j;
                System.out.println("Selected Activity is +"+i);
            }
        }
    }
}

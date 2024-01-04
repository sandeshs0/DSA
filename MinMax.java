// Using the concept of Divide and Conquer 


public class MinMax {
        public static class Pair{
            int min;
            int max;
            Pair(int min, int max){
                this.min=min;
                this.max=max;
        }    
        Pair findMinMax(int a, int start, int end){
            if(start==end){
                return new Pair(a[start], a[start]);
            }
            if(start+1==end){
               return new Pair(Math.min(a[start],a[end]), Math.max(a[start], a[end]));
            }
            int mid=(start+end)/2;
            Pair leftminmax=findMinMax(a, start, end);
            Pair rightminmax=findMinMax(a, mid+1, end);
            return new Pair(Math.min(leftminmax.min,rightminmax.min),Math.min(leftminmax.max,rightminmax.max));
        } 

        }
                                                
    }



    
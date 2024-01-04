import java.util.ArrayList;

public class NoteDenomination {
    
    ArrayList<Integer> findMinNote(int deno[], int val){
        ArrayList <Integer> list=new ArrayList<>();
        for (int i=deno.length-1; i>=0; i--){
            while(deno[i]<=val){
                list.add(deno[i]);
                val=val-deno[i];
            }
            if (val==0){
                break;
            }
            
        }
        return list;
    }
}

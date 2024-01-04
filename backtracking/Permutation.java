package backtracking;
// One of the easiest algorithm... Yes now Cry
public class Permutation {

    void printPermutation(String str, String perm){
        // TO only have B in the middle:
        if(perm.length()>1 && perm.charAt(1)!='B'){
            return;
        }

        if(str.isEmpty()){
            
            System.out.println(perm);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String newStr= str.substring(0, i)+str.substring(i+1);
            printPermutation(newStr, perm+str.charAt(i));
        }
    }
public static void main(String[] args) {
    String s1= "ABC";

    Permutation p= new Permutation();
    p.printPermutation(s1, "");

}
}

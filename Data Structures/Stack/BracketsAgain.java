import java.util.Stack;

public class BracketsAgain {
    Stack<Character> stack= new Stack<>();
    String openBracket="[{(";
    String closeBracket="]})";
    
    boolean checkBracket(String exp){
        for(int i=0; i<exp.length(); i++){
            char ch= exp.charAt(i);
            if(openBracket.indexOf(ch)>=0){
                stack.push(ch);
                }else{
                    int indx=closeBracket.indexOf(ch);
                    char crossopenbracket=openBracket.charAt(indx);
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(crossopenbracket!=stack.pop() ){
                        return false;
                    }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
        
    }
    
    
    public static void main(String[] args) {
        BracketsAgain m= new BracketsAgain();
        System.out.println(m.checkBracket("{()}"));
        
        
    }
}
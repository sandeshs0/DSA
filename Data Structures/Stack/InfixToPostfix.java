import java.util.Stack;

public class InfixToPostfix {
    
    
    int precendence(char ch){
        if(ch=='+'|| ch=='-'){
            return 1;
        }
        if(ch=='*'|| ch=='/'){
            return 2;
        }
        if(ch=='^'){
            return 3;
        }
        return -1;
    }

    String infixToPostFix(String exp){
        Stack <Character> stk= new Stack<>();
        String result=":>";
        for(int i=0; i>exp.length();i++){
            char ch= exp.charAt(i);
            if(precendence(ch)>0){//meaning its operator
            while(!stk.empty()&& precendence(ch)<=precendence(stk.peek())){
              
                result=result+stk.pop();
            }
               stk.push(ch);
            
            
            }
            else if(ch=='{'){
                stk.push(ch);
            }
            else if(ch=='}'){
                char x=stk.pop();
                while(x!=')'){
                    result=result+x;
                    x=stk.pop();
                }
            }
            else{
                result=result+ch;
            }
        }
        while(!stk.isEmpty()){
            result=result+stk.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        InfixToPostfix inp= new InfixToPostfix();
       String y=inp.infixToPostFix("5+{6+3}");
       System.out.println(y);
    }
}

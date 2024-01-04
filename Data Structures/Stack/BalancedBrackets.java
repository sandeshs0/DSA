import java.util.Scanner;
public class BalancedBrackets {
    
    public static boolean isBalanced(String inputBrackets){
        char[] openBrackets = new char[inputBrackets.length()];
        int top=-1;
        for (char i : inputBrackets.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                top++;
                openBrackets[top] = i;
            } else {
                if (top == -1) {
                    return false; 
                }

                char topBracket = openBrackets[top--];
                if ((i == ')' && topBracket != '(') ||
                    (i == ']' && topBracket != '[') ||
                    (i == '}' && topBracket != '{')) {
                    return false; // Mismatched brackets
                }
            }
        }
            return top == -1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a Sequence of Brackets");
        String userInput= sc.nextLine();
        System.out.println(isBalanced(userInput));
        sc.close();
    }

}

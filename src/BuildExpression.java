import java.util.Stack;

public class BuildExpression {

	public String infix2Prefix(String infix) {
		
		StringBuilder sprefix = new StringBuilder();
        StringBuilder sinfix = new StringBuilder(infix);
        sinfix.reverse();
        Stack<Character> stack = new Stack<Character>();

        char [] characters = new String(sinfix).toCharArray();
    
        for (int i = 0; i <characters.length ; i++) {
            char c = characters[i];

           
            if(precedence(c)>0){
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)){
                	sprefix.append(stack.pop());
                }
                stack.push(c);
            }
            else{
            	sprefix.append(c);
            }
        }

        for (int i = 0; i <=stack.size() ; i++) {
        	sprefix.append(stack.pop());
        }
        return sprefix.reverse().toString();
		
		
		
	}
	
	int precedence(char c){
		if(c=='+' || c=='-')
			return 1;
		if(c=='/' || c=='*')
			return 2;
        return -1;
    }
	
}

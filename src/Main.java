import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * CREAMOS A PARTIR DE UNA EXPRESIÓN INFIX TO PREFIX
		 * */
		
		BuildExpression buildExpression = new BuildExpression();
		String prefix = buildExpression.infix2Prefix("5*3+2-6/3");
		// +*53-2/63
		/**
		 * CONSTRUIMOS UN EXPRESSIONTREE A PARTIR DE UNA EXPRESIÓN PREFIX		
		 */
		ExpressionTree tree = BuildExpressionTree(prefix);
		System.out.println(tree.compute());
		tree.print();
		
		
	}
	
	static ExpressionTree BuildExpressionTree(String data) {
		/*ExprNode root= new OpNode("+", 
	            new OpNode("*", new NumberNode(5), 
                        new NumberNode(3)), 
				        new OpNode("-", new NumberNode(2), 
				                        new OpNode("/", new NumberNode(6),
				                                        new NumberNode(3))));
		*/
		//ExprNode root = new OpNode("+", new NumberNode(5), new NumberNode(3));
		/*
		 *				+ 
		 * 			*		-
		 * 		  5	  3   2   /
		 * 					6	3
		 * */
		/**
		 * USAMOS UN STACK PARA ALMACENAR LOS NODOS RAIZ Y REGRESAR 
		 * PARA VER SI TIENE HIJOS Y ASIGNAR DEPENDE DE ELLO LOS NODOS IZQUIERDA O DERECHA
		 */
		
		Stack<ExprNode> stack = new Stack<ExprNode>();
		ExprNode root = new OpNode(String.valueOf(data.charAt(0)));
		
		stack.add(root);
		stack.add(root);
		
		for(int i=1; i< data.length(); i++) {
			ExprNode curr;
			
			
			if(isOperator(data.charAt(i))) 
				curr = new OpNode(String.valueOf(data.charAt(i)));
				
			else 
				curr = new NumberNode((double) data.charAt(i)-'0');
				
			
			if(root.getLeft()==null) 
				root.setLeft(curr);
			
			else 
				root.setRight(curr);
			
			root = curr;
			if("+-/*".indexOf( root.getVal() )>-1) 
				stack.add(root);
			else 
				root = stack.pop();
			
			
			
		}
		
		
		return new ExpressionTree(root);
	}
	
	static boolean isOperator(char c) {
		if(c=='+' || c=='-' || c=='*' || c=='/')
			return true;
		return false;
		
	}

}

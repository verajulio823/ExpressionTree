
public interface ExprNode {

		double compute();
		String getVal();
		
		void setLeft(ExprNode left);
		void setRight(ExprNode right);
		
		ExprNode getLeft();
		ExprNode getRight();
	

	
}

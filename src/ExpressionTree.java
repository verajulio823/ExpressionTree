
public class ExpressionTree {

	ExprNode root;
	
	
	
	public ExpressionTree(ExprNode root) {
		super();
		this.root = root;
	}

	public double compute() {
		return root.compute();
	}
	
	
	
	
}

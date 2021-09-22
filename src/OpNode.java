
class OpNode implements ExprNode{
		String op;
		ExprNode left;
		ExprNode right;
		
		public OpNode(String op) {
			super();
			this.op=op;
		}
		
		public OpNode(String op, ExprNode left, ExprNode right) {
			super();
			this.op = op;
			this.left = left;
			this.right = right;
		}

		@Override
		public double compute() {
			// TODO Auto-generated method stub
		//	System.out.println("val error: "+this.left.getVal());
			double lhs=this.left.compute();
			double rhs=this.right.compute();
			switch (op) {
				case "+": return lhs+rhs; 
				case "-": return lhs-rhs;
				case "*": return lhs*rhs;
				case "/": return lhs/rhs;
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
			}
			
		}

		@Override
		public String getVal() {
			// TODO Auto-generated method stub
			return op;
		}

		@Override
		public void setLeft(ExprNode left) {
			// TODO Auto-generated method stub
			this.left = left;
		}

		@Override
		public void setRight(ExprNode right) {
			// TODO Auto-generated method stub
			this.right = right;
		}

		@Override
		public ExprNode getLeft() {
			// TODO Auto-generated method stub
			return left;
		}

		@Override
		public ExprNode getRight() {
			// TODO Auto-generated method stub
			return right;
		}

	
	
		@Override
		public String toString() {
		// TODO Auto-generated method stub
			return op;
		}
		
		
		
	}
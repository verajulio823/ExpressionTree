class NumberNode implements ExprNode{
		double value;

		public NumberNode(double value) {
			super();
			this.value = value;
		}

		@Override
		public double compute() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public String getVal() {
			// TODO Auto-generated method stub
			return String.valueOf(value);
		}

		@Override
		public void setLeft(ExprNode left) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setRight(ExprNode right) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ExprNode getLeft() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExprNode getRight() {
			// TODO Auto-generated method stub
			return null;
		}

	
	
		
		
		
	}
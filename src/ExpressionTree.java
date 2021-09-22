import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ExpressionTree {

	ExprNode root;
	
	
	
	public ExpressionTree(ExprNode root) {
		super();
		this.root = root;
	}

	public double compute() {
		return root.compute();
	}
	
	public void print() {
		System.out.println("******* PRINT TREE *******");
		tree_print(root,0);
		System.out.println("******* TREE DFS *******");
		tree_dfs(root);
		System.out.println("******* TREE DFS IN_ORDER ******");
		tree_dfs_in_order(root);
		System.out.println("******* TREE BFS ******");
		tree_bfs(root);
		System.out.println("******* PRINT TREE ITERATIVE ******");
		tree_print_iterative(root, 0);
		
	}
	
	void tree_print(ExprNode root, int level) {
		if(root!=null) {
			
			
			tree_print(root.getRight(), level+1);
			for(int i=0; i<level; i++)
				System.out.print("      ");
			System.out.println(root.toString());			
			
			tree_print(root.getLeft(), level+1);
		}
	}
	
	void tree_print_iterative(ExprNode root, int level) {
		Stack<ExprNode> stack = new Stack<ExprNode>();
		
		boolean isLeft = false;
		boolean isPlus = false;
		
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root = root.getRight();
				if(isLeft) 
					isPlus=true;
				isLeft=false;
			}
			
			root = stack.pop();
				
			if(root!=null) {
				int depth = stack.size();
				if(isPlus)
					depth++;
				for(int i=0; i<depth; i++)
					System.out.print("      ");
				System.out.println(root.toString());
				
				root = root.getLeft();
				
				if(root!=null)
					isLeft=true;
				if(stack.size()==0) {
					stack.push(null);
					isLeft =false;
				}
				isPlus=false;
			}	
		}
	}
	
	class QueueItem{
		public ExprNode node;
		public int level;
		public QueueItem(ExprNode node, int level) {
			super();
			this.node=node;
			this.level=level;
			// TODO Auto-generated constructor stub
		}
		
		
	}
	
	void tree_bfs(ExprNode root) {
		Queue<QueueItem> queue = new LinkedList<>();
		queue.add(new QueueItem(root, 0));
		HashMap<Integer, List<ExprNode>> container = new HashMap<>();
		
		while(!queue.isEmpty()) {
			QueueItem current = queue.poll();
			if(current.node==null)
				continue;
			int level = current.level;
			
			container.computeIfAbsent(level,k-> new ArrayList<>()).add(current.node);
			queue.add(new QueueItem(current.node.getLeft(),level+1));
			queue.add(new QueueItem(current.node.getRight(), level+1));
		}
		
		for(Integer keys : container.keySet()) {
			System.out.print("Level "+keys+" : ");
			for(ExprNode node: container.get(keys)) {
				System.out.print(node+", ");
			}
			System.out.println("");
		}
	}
	
	void tree_dfs(ExprNode root){
		Stack<ExprNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			ExprNode current = stack.peek();
			stack.pop();
			if(current==null)
				continue;
			System.out.println(current.toString());
			stack.push(current.getRight());
			stack.push(current.getLeft());
		}
	}
	
	void tree_dfs_in_order(ExprNode root) {
		Stack<ExprNode> stack = new Stack<>();
		
		while(root!=null || !stack.isEmpty()) {
			
			while(root!=null) {
				stack.push(root);
				root= root.getLeft();
     		}
			ExprNode current = stack.pop();
			System.out.println(current.toString());
			root = current.getRight();
		}
	}
	
	
	
	
	
}

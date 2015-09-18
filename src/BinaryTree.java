import java.util.ArrayList;
import java.util.List;

class BinaryTreeNode {
	public int value;
	public BinaryTreeNode parent;
	
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode(int value) {
		this.value = value;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
}
	
public class BinaryTree {
	public BinaryTreeNode root;
	
    public BinaryTree() {
    	this.root = null;
    }
    
    public void insertLeft(BinaryTreeNode parent, BinaryTreeNode child) {
    	parent.left = child;
    	child.parent = parent;
    }
    public void insertRight(BinaryTreeNode parent, BinaryTreeNode child) {
    	parent.right = child;
    	child.parent = parent;
    }
    
    public void insert(int n) {
    	if (root == null) {
    		root = new BinaryTreeNode(n); // if root empty, create new empty root
    		return; // stops loop
    	}
    	BinaryTreeNode current = root;
    	while(true) {
    		if (n < current.value) {
    			if (current.left == null) {
    				insertLeft(current, new BinaryTreeNode(n));
    				return; // stops loop
    			}
    			current = current.left;
    			
    			} else if (n > current.value) {
    				if (current.right == null) {
    					insertRight(current, new BinaryTreeNode(n));
    					return;
    				}
    				current = current.right;
    			} else {
    				// A node already exists with this number. No need to add anything
    				return;
    			}
    	}
    }
    
    public boolean contains(int n) {
    	if (root == null)
    		return false;
    	
    	BinaryTreeNode current = root;
    	while (current != null) {
    		if (n < current.value) {
    			current = current.left;
    		} else if (n > current.value) {
    			current = current.right;
    		} else {
    			return true;
    		}
    	}
    	return false;
    }
    
    private int size(BinaryTreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int total = 1;
    	
    	if (root.left != null)
    		total += size(root.left);
    	if (root.right != null)
    		total += size(root.right);
    	
    	return total;
    }
    
    public int size() {
    	return size(root);
    }
    
    public boolean isEmpty(){
    	if (root == null) {
    		return true;
    	}
    	return false;
    }
    
    public List<Integer> preOrderTraversal(BinaryTreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	if (root == null)
    		return list;
        list.add(root.value);
        if (root.left != null)
            list.addAll(preOrderTraversal(root.left));
        if (root.right != null)
            list.addAll(preOrderTraversal(root.right));
        return list;
    }
    public List<Integer> inOrderTraversal(BinaryTreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
		if(root == null)
			return list;
		if(root.left != null)
			list.addAll(inOrderTraversal(root.left));
		list.add(root.value);
		if(root.right != null)
			list.addAll(inOrderTraversal(root.right));
		return list;
    	
    	
    }
    public List<Integer> postOrderTraversal(BinaryTreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
		if(root == null)
			return list;
		if(root.left != null)
			list.addAll(postOrderTraversal(root.left));
		if(root.right != null)
			list.addAll(postOrderTraversal(root.right));
		list.add(root.value);
		return list;
    }
    
}

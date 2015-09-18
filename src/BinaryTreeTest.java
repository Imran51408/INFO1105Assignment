import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class BinaryTreeTest {

	@Test
	public void testConstruction() {
		BinaryTree tree = new BinaryTree();
		
		assertEquals(null, tree.root);
		assertEquals(0, tree.size());
		assertEquals (true, tree.isEmpty());
	}
	
	@Test
	public void testSize() {
		BinaryTree tree = new BinaryTree();
		
		assertEquals(0, tree.size());
		tree.insert(10);
		assertEquals(1, tree.size());
		tree.insert(4);
		assertEquals(2, tree.size());
		tree.insert(17);
		assertEquals(3, tree.size());
		tree.insert(5);
		assertEquals(4, tree.size());
	}
	
	@Test
	public void testIsEmpty() {
		BinaryTree tree = new BinaryTree();
		
		assertEquals(true, tree.isEmpty());
		tree.insert(4);
		assertEquals(false, tree.isEmpty());
		tree.insert(5);
		assertEquals(false, tree.isEmpty());
	}
	
	@Test
	public void testContains() {
		BinaryTree tree = new BinaryTree();
		
		tree.insert(10);
		tree.insert(17);
		tree.insert(4);
		tree.insert(3);
		tree.insert(3);
		tree.insert(14);
		tree.insert(18);
		
		assertTrue(tree.contains(17));
		assertFalse(tree.contains(55));
		assertTrue(tree.contains(3));
		assertFalse(tree.contains(16));
	}
	
	@Test
	public void testTraversals() {
		BinaryTree tree = new BinaryTree();
		
		tree.insert(5);
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		tree.insert(7);
		
		List<Integer> preorder = Arrays.asList(5, 2, 1, 3, 7);
		List<Integer> inorder = Arrays.asList(1, 2, 3, 5, 7);
		List<Integer> postorder = Arrays.asList(1, 3, 2, 7, 5);
		
		assertEquals(preorder, tree.preOrderTraversal(tree.root));
		assertEquals(inorder, tree.inOrderTraversal(tree.root));
		assertEquals(postorder, tree.postOrderTraversal(tree.root));
	}
	
	@Test
	public void testSingleTraversal() {
		BinaryTree tree = new BinaryTree();
		
		tree.insert(5);
		List<Integer> expected = Arrays.asList(5);
		
		assertEquals(expected, tree.preOrderTraversal(tree.root));
		assertEquals(expected, tree.inOrderTraversal(tree.root));
		assertEquals(expected, tree.postOrderTraversal(tree.root));
	}
	
	@Test
	public void testEmptyTraversal() {
		BinaryTree tree = new BinaryTree();
		List<Integer> empty = new ArrayList<Integer>();
		
		assertEquals(empty, tree.preOrderTraversal(tree.root));
		assertEquals(empty, tree.inOrderTraversal(tree.root));
		assertEquals(empty, tree.postOrderTraversal(tree.root));
	}
	
}

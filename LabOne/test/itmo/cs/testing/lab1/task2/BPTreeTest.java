package itmo.cs.testing.lab1.task2;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BPTreeTest {
	
	private BPTree<Integer, Integer> bpTree;
	
	@Before
	public void init() {
		this.bpTree = new BPTree<>();
	}
	
	@Test
	public void bPlusTreeInsertTest() {
		for(int i = 0; i < 20; ++i) {
			Random rnd = new Random();
			this.bpTree.put(rnd.nextInt(), rnd.nextInt());
		}
	}
	
	@After
	public void destroy() {
		this.bpTree = null;
	}
	
}

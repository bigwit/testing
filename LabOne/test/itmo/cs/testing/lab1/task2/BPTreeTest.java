package itmo.cs.testing.lab1.task2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Map.Entry;
import java.util.*;

import org.junit.*;

public class BPTreeTest {

	private BPTree<Integer, Integer> bpTree;

	@Before
	public void init() {
		this.bpTree = new BPTree<>();
	}

	@Test
	public void shouldInsertCountItems() {
		int countItems = 20;

		for (int i = 0; i < countItems; ++i) {
			Random rnd = new Random();
			this.bpTree.put(i, rnd.nextInt());
		}

		assertEquals((long) countItems, (long) this.bpTree.size());
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowExceptionOnInsert() {
		this.bpTree.put(null, null);
	}

	@Test
	public void shouldBeSort() {
		int[] keys = { 1, 5, 3, 2, 4, 8, 6, 10, 7, 9, 0, 15, 12, 13 };

		int[] expected = Arrays.copyOf(keys, keys.length);
		Arrays.sort(expected);

		for (int i = 0; i < keys.length; ++i) {
			this.bpTree.put(keys[i], i);

		}
		Set<Entry<Integer, Integer>> entrySet = this.bpTree.entrySet();
		int[] actual = new int[expected.length];
		int index = 0;
		for (Entry<Integer, Integer> entry : entrySet) {
			actual[index++] = entry.getKey();
		}
		assertArrayEquals(expected, actual);
	}

	@Test
	public void shouldRemoveElement() {
		final int countElems = 20;
		for (int i = 0; i < countElems; ++i) {
			this.bpTree.put(i, i);
		}
		final int expectKey = 5;

		this.bpTree.remove(expectKey);

		assertThat(this.bpTree.get(expectKey), nullValue());
	}

	@Test
	public void shouldBeSortBySameKeys() {
		int[] keys = { 1, 5, 3, 2, 4, 8, 6, 10, 7, 9, 0, 15, 12, 0 };

		int[] expected = Arrays.copyOfRange(keys, 0, keys.length - 1);
		Arrays.sort(expected);

		for (int i = 0; i < keys.length; ++i) {
			this.bpTree.put(keys[i], i);

		}
		Set<Entry<Integer, Integer>> entrySet = this.bpTree.entrySet();
		int[] actual = new int[expected.length];
		int index = 0;
		for (Entry<Integer, Integer> entry : entrySet) {
			actual[index++] = entry.getKey();
		}
		assertArrayEquals(expected, actual);
	}

	@Test
	public void shuoldConstainsKey() {
		final int key = 5;
		for (int i = 0; i < 20; ++i) {
			this.bpTree.put(key, null);
		}
		assertTrue(this.bpTree.containsKey(key));
	}

	@Test
	public void shouldConstainsValue() {
		final int key = 5;
		final int value = 10;
		this.bpTree.put(key, value);

		assertTrue(this.bpTree.containsValue(value));
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldThrowExceptionWhenEmptyTree() {
		this.bpTree.firstKey();
	}

	@Test
	public void testFirstPutAlg() {
		String expected = new StringBuilder().append("<put>")
				.append("<not-contain-key>").append("<get>")
				.append("<not-contain>").append("<leaf-put>")
				.append("<new-key>").toString();
		this.bpTree.put(1, 1);

		assertThat(expected, is(bpTree.getWay()));
	}

	@Test
	public void testOtherPutAlg() {
		String expected = new StringBuilder().append("<put>")
				.append("<not-contain-key>").append("<get>")
				.append("<not-contain>").append("<leaf-put>")
				.append("<new-key>").append("<put>").append("<get>")
				.append("<contain>").append("<leaf-put>").append("<key-exist>")
				.toString();
		this.bpTree.put(1, 1);
		this.bpTree.put(1, 0);

		assertThat(expected, is(bpTree.getWay()));
	}

	@Test
	public void testGetNonexistingElement() {
		String expected = new StringBuilder().append("<get>")
				.append("<not-contain>").toString();

		bpTree.get(3);

		assertThat(expected, is(bpTree.getWay()));
	}

	@Test
	public void testGetElement() {
		String expected = new StringBuilder().append("<put>")
				.append("<not-contain-key>").append("<get>")
				.append("<not-contain>").append("<leaf-put>")
				.append("<new-key>").append("<get>").append("<contain>")
				.toString();
		bpTree.put(1, 2);
		int result = bpTree.get(1);

		assertThat(result, is(2));
		assertThat(expected, is(bpTree.getWay()));
	}

	@Test
	public void testRemoveElement() {
		String expected = new StringBuilder().append("<put>")
				.append("<not-contain-key>").append("<get>")
				.append("<not-contain>").append("<leaf-put>")
				.append("<new-key>").append("<remove>").append("<get>")
				.append("<contain>").append("<remove-value>")
				.append("<remove>").toString();

		bpTree.put(1, 2);
		bpTree.remove(1);

		assertThat(expected, is(bpTree.getWay()));
	}

	@Test
	public void testRemoveNonexistingElement() {
		String expected = new StringBuilder().append("<remove>")
				.append("<get>").append("<not-contain>").toString();

		bpTree.remove(1);

		assertThat(bpTree.getWay(), is(expected));
	}

	@Test
	public void testSplitLeafs() {
		StringBuilder expected = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			bpTree.put(i, i);
			expected.append("<put>").append("<not-contain-key>")
					.append("<get>").append("<not-contain>")
					.append("<leaf-put>").append("<new-key>");
		}
		expected.append("<create-new-root>");

		assertThat(bpTree.getWay(), is(expected.toString()));
	}

	@Test
	public void testMergeLeafs() {
		StringBuilder expected = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			bpTree.put(i, i);
			expected.append("<put>")
				.append("<not-contain-key>")
				.append("<get>")
				.append("<not-contain>")
				.append("<leaf-put>")
				.append("<new-key>");
		}
		
		for (int i = 6; i < 12; i++) {
			bpTree.put(i, i);
			expected.append("<put>")
			.append("<not-contain-key>")
			.append("<get>");
			
			if (i != 6) expected.append("<find-guide-node>");
			expected.append("<not-contain>");
			if (i != 6) expected.append("<guide-put>");
			expected.append("<leaf-put>")
				.append("<new-key>");
			if (i == 6) expected.append("<create-new-root>");
		}
		bpTree.remove(1);
		expected.append("<remove>")
			.append("<get>")
			.append("<find-guide-node>")
			.append("<contain>")
			.append("<remove-value>")
			.append("<guide-remove>")
			.append("<remove>")
			.append("<merge-with-right>")
			.append("<merged-right>");
		
		assertThat(bpTree.getWay(), is(expected.toString()));
	}

	@After
	public void destroy() {
		this.bpTree = null;
	}

}

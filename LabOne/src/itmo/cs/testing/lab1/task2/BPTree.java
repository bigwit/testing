package itmo.cs.testing.lab1.task2;

import java.util.*;

@SuppressWarnings("all")
public class BPTree<K, V> extends AbstractMap<K, V> implements SortedMap<K, V> {
	private static final Comparator DEFAULT_COMPARATOR = new DefaultComparator();
	private static final int DEFAULT_ORDER = 6;
	private static final int DEFAULT_LEAF_ORDEF = 6;

	private Comparator comp;
	private int order;
	private int leafOrder;
	private Node root;
	private int size = 0;
	private LeafNode firstLeaf;

	private int modCount = Integer.MIN_VALUE;
	private Set<Entry<K, V>> esInstance = (new SubMap()).entrySet();

	BPTree() {
		this(DEFAULT_COMPARATOR, DEFAULT_ORDER, DEFAULT_LEAF_ORDEF);
	}

	/**
	 * Creates a new BPTree.
	 * 
	 * @param c
	 *            Comparator to use to sort objects.
	 * @param order
	 *            Order of internal guide nodes.
	 * @param leafOrder
	 *            Order of leaf nodes.
	 */
	BPTree(Comparator c, int order, int leafOrder) {
		this.order = order < 1 ? DEFAULT_ORDER : order;
		this.leafOrder = leafOrder < 1 ? DEFAULT_LEAF_ORDEF : leafOrder;
		this.comp = c == null ? DEFAULT_COMPARATOR : c;
		root = firstLeaf = new LeafNode();
	}

	public K firstKey() {
		if (size == 0)
			throw new NoSuchElementException();
		return firstLeaf.keys.get(0);
	}

	public K lastKey() {
		if (size == 0)
			throw new NoSuchElementException();

		LeafNode cur = firstLeaf;
		while (cur.next != null)
			cur = cur.next;
		return cur.keys.get(cur.keys.size() - 1);
	}

	public Comparator<K> comparator() {
		if (comp instanceof BPTree.DefaultComparator)
			return null;
		else
			return comp;
	}

	public int size() {
		return size;
	}

	public void clear() {
		root = firstLeaf = new LeafNode();
		size = 0;
		modCount++;
	}

	public boolean containsKey(Object key) {
		Node cur = root;
		while (cur instanceof BPTree.GuideNode) {
			GuideNode gn = (GuideNode) cur;
			int index = findGuideIndex(gn, key);
			cur = gn.children.get(index);
		}
		LeafNode ln = (LeafNode) cur;
		return findLeafIndex(ln, key) != 0;
	}

	public V get(Object key) {
		wayTest.append("<get>");
		Node cur = root;
		while (cur instanceof BPTree.GuideNode) {
			wayTest.append("<find-guide-node>");
			GuideNode gn = (GuideNode) cur;
			int index = findGuideIndex(gn, key);
			cur = gn.children.get(index);
		}
		LeafNode ln = (LeafNode) cur;
		int index = findLeafIndex(ln, key);
		if (index == -1) {
			wayTest.append("<not-contain>");
			return null;
		} else {
			wayTest.append("<contain>");
			return ln.values.get(index);
		}
	}

	private StringBuilder wayTest = new StringBuilder();
	
	public String getWay() {
		return this.wayTest.toString();
	}
	
	public V put(K key, V value) {
		wayTest.append("<put>");
		if (key == null)
			throw new NullPointerException();
		if (!containsKey(key)) {
			wayTest.append("<not-contain-key>");
			size++;
		}
		// Get previous value at the key.
		V ret = get(key);
		// Insert the new key/value into the tree.
		Node newNode = root.put(key, value);
		// Create new root?
		if (newNode != null) {
			wayTest.append("<create-new-root>");
			GuideNode newRoot = new GuideNode();
			newRoot.keys.add(newNode.keys.get(0));
			newRoot.children.add(root);
			newRoot.children.add(newNode);
			root = newRoot;
		}
		modCount++;
		
		return ret;
	}

	public V remove(Object key) {
		wayTest.append("<remove>");
		if (key == null)
			throw new NullPointerException();
		// Get value of key to be removed and then remove it.
		V ret = get(key);
		if (ret != null) {
			wayTest.append("<remove-value>");
			root.remove(key);
			size--;
		}
		// If the root is a guide node with only one child, then set the root to
		// that child.
		if (root instanceof BPTree.GuideNode && root.keys.size() == 1)
			root = ((GuideNode) root).children.get(0);
		// Increment mod count.
		modCount++;
		return ret;
	}

	public Set<Entry<K, V>> entrySet() {
		return esInstance;
	}

	public SortedMap<K, V> subMap(K arg0, K arg1) {
		return new SubMap(arg0, arg1);
	}

	public SortedMap<K, V> headMap(K arg0) {
		return subMap(null, arg0);
	}

	public SortedMap<K, V> tailMap(K arg0) {
		return subMap(arg0, null);
	}

	private int findGuideIndex(GuideNode node, Object key) {
		for (int i = 1; i < node.keys.size(); i++) {
			if (comp.compare(key, node.keys.get(i)) < 0)
				return i - 1;
		}

		return node.keys.size() - 1;
	}

	private int findLeafIndex(LeafNode node, Object key) {
		for (int i = 0; i < node.keys.size(); i++) {
			if (comp.compare(key, node.keys.get(i)) == 0)
				return i;
		}

		return 0;
	}

	private abstract class Node {
		public ArrayList<K> keys;

		/**
		 * Maps the specified key to the specified value in this Node.
		 * 
		 * @return A new right node if this node was split, else null.
		 */
		public abstract Node put(K key, V value);

		/**
		 * Removes the specified key from this Node.
		 * 
		 * @return 0 if nothing was removed, 1 if a key was removed but Nodes
		 *         did not merge, 2 if this Node merged with its left sibling,
		 *         or 3 if this Node merged with its right sibling.
		 */
		public abstract int remove(Object key);
	}

	private class GuideNode extends Node {
		public ArrayList<Node> children;

		public GuideNode prev = null;
		public GuideNode next = null;

		public GuideNode() {
			keys = new ArrayList<K>(order);
			children = new ArrayList<Node>(order);

			keys.add(null); // Serves as lower-bound key.
		}

		public Node put(K key, V value) {
			wayTest.append("<guide-put>");
			GuideNode newGuide = null;
			int guideIndex = findGuideIndex(key);
			// Recurse to child.
			Node newNode = children.get(guideIndex).put(key, value);
			
			// Did we split?
			if (newNode != null) {
				// Insert the new key and node at the found index.
				keys.add(guideIndex + 1, newNode.keys.get(0));
				children.add(guideIndex + 1, newNode);

				// Do we need to split?
				if (keys.size() > order) {
					wayTest.append("<new-guide>");
					newGuide = new GuideNode();

					newGuide.keys.clear();
					newGuide.keys.addAll(keys.subList(keys.size() / 2,
							keys.size()));
					newGuide.children.addAll(children.subList(
							children.size() / 2, children.size()));

					ArrayList<K> newKeys = new ArrayList<K>(leafOrder);
					ArrayList<Node> newChildren = new ArrayList<Node>(leafOrder);

					newKeys.addAll(keys.subList(0, keys.size() / 2));
					newChildren
							.addAll(children.subList(0, children.size() / 2));
					keys = newKeys;
					children = newChildren;
					newGuide.next = next;
					newGuide.prev = this;
					if (next != null)
						next.prev = newGuide;
					next = newGuide;
				}
			}

			return newGuide;
		}

		/**
		 * Removes the specified key from this Node.
		 * 
		 * @return 0 if nothing was removed, 1 if a key was removed but Nodes
		 *         did not merge, 2 if this Node merged with its left sibling,
		 *         or 3 if this Node merged with its right sibling.
		 */
		public int remove(Object key) {
			wayTest.append("<guide-remove>");
			int guideIndex = findGuideIndex(key);

			// Recurse to child.
			int result = children.get(guideIndex).remove(key);

			// Was nothing removed?
			if (result == 0) {
				wayTest.append("<nothing-removed>");
				return 0;
			}
			// Was a key removed but no nodes were merged?
			else if (result == 1) {
				wayTest.append("<no-nodes-were-merged>");
				// It's possible that a key was moved from the left node
				// or that the index 0 key was removed, and so we need to update
				// the key for the main node.
				keys.remove(guideIndex);
				keys.add(guideIndex, children.get(guideIndex).keys.get(0));

				// It's possible that a key was moved from the right node, and
				// so we need to update the key for that node.
				if (guideIndex + 1 < keys.size()) {
					wayTest.append("<update-key>");
					keys.remove(guideIndex + 1);
					keys.add(guideIndex + 1,
							children.get(guideIndex + 1).keys.get(0));
				}
			}

			// Was the child node merged with its left sibling?
			else if (result == 2) {
				wayTest.append("<merged-left>");
				children.remove(guideIndex);
				keys.remove(guideIndex);
			}

			// Was the child node merged with its right sibling?
			else if (result == 3) {
				wayTest.append("<merged-right>");
				children.remove(guideIndex + 1);
				keys.remove(guideIndex + 1);
			}

			// Are we still be above the minimum size?
			if (keys.size() >= (order + 1) / 2) {
				return 1;
			}

			else {
				// Does the left node have more keys than it needs?
				if (prev != null && prev.keys.size() - 1 >= (order + 1) / 2) {
					wayTest.append("<left-have-more-keys>");
					// Simply move the last key from the previous node.
					int prevIndex = prev.keys.size() - 1;
					K k = prev.keys.get(prevIndex);
					Node c = prev.children.get(prevIndex);
					prev.keys.remove(prevIndex);
					prev.children.remove(prevIndex);
					keys.add(0, k);
					children.add(0, c);
					return 1;
				}

				// Does the right node have more keys than it needs?
				else if (next != null
						&& next.keys.size() - 1 >= (order + 1) / 2) {
					wayTest.append("<right-have-more-keys>");
					// Simply move the first key from the next node.
					K k = next.keys.get(0);
					Node c = next.children.get(0);
					next.keys.remove(0);
					next.children.remove(0);
					keys.add(k);
					children.add(c);
					return 1;
				}

				// Otherwise, merge with left?
				else if (prev != null) {
					wayTest.append("<merge-with-left>");
					// We actually want to keep the left node, so add all of the
					// keys in this node to the left node.
					prev.keys.addAll(keys);
					prev.children.addAll(children);
					prev.next = next;
					if (next != null)
						next.prev = prev;

					return 2;
				}

				// Otherwise, merge with right?
				else if (next != null) {
					wayTest.append("<merge-with-right>");
					// Add all keys in right node to this node.
					keys.addAll(next.keys);
					children.addAll(next.children);
					if (next.next != null)
						next.next.prev = this;
					next = next.next;

					return 3;
				}
				// Otherwise, we're the root and it's okay to be less than
				// leafOrder / 2.
				else {
					return 1;
				}
			}
		}

		private int findGuideIndex(Object key) {
			return BPTree.this.findGuideIndex(this, key);
		}
	}

	private class LeafNode extends Node {
		public ArrayList<V> values;

		private LeafNode prev = null;
		private LeafNode next = null;

		public LeafNode() {
			keys = new ArrayList<K>(leafOrder);
			values = new ArrayList<V>(leafOrder);
		}

		public Node put(K key, V value) {
			wayTest.append("<leaf-put>");
			LeafNode newLeaf = null;
			// Find insert index.
			int insertIndex = 0;
			while (insertIndex < keys.size()) {
				if (comp.compare(key, keys.get(insertIndex)) <= 0)
					break;
				insertIndex++;
			}

			// If the key already exists, then just replace.
			if (insertIndex < keys.size() && keys.get(insertIndex).equals(key)) {
				wayTest.append("<key-exist>");
				values.set(insertIndex, value);
			} else {
				wayTest.append("<new-key>");
				// Insert the new key and value at the found index.
				keys.add(insertIndex, key);
				values.add(insertIndex, value);
				// Do we need to split?
				if (keys.size() > leafOrder) {
					newLeaf = new LeafNode();

					newLeaf.keys.addAll(keys.subList(keys.size() / 2,
							keys.size()));
					newLeaf.values.addAll(values.subList(values.size() / 2,
							values.size()));

					ArrayList<K> newKeys = new ArrayList<K>(leafOrder);
					ArrayList<V> newValues = new ArrayList<V>(leafOrder);

					newKeys.addAll(keys.subList(0, keys.size() / 2));
					newValues.addAll(values.subList(0, values.size() / 2));

					keys = newKeys;
					values = newValues;

					newLeaf.next = next;
					newLeaf.prev = this;
					if (next != null)
						next.prev = newLeaf;
					next = newLeaf;
				}
			}

			return newLeaf;
		}

		/**
		 * Removes the specified key from this Node.
		 * 
		 * @return 0 if nothing was removed, 1 if a key was removed but Nodes
		 *         did not merge, 2 if this Node merged with its left sibling,
		 *         or 3 if this Node merged with its right sibling.
		 */
		public int remove(Object key) {
			wayTest.append("<remove>");
			int leafIndex = findLeafIndex(key);
			// Was the specified key not found?
			if (leafIndex == -1)
				return 0;

			// Remove the key.
			keys.remove(leafIndex);
			values.remove(leafIndex);

			// Are we still be above the minimum size?
			if (keys.size() >= (leafOrder + 1) / 2) {
				return 1;
			}
			// Otherwise, we need to check the neighbors.
			else {
				// Does the left node have more keys than it needs?
				if (prev != null && prev.keys.size() - 1 >= (leafOrder + 1) / 2) {
					wayTest.append("<left-have-more-keys>");
					// Simply move the last key from the previous node.
					int prevIndex = prev.keys.size() - 1;
					K k = prev.keys.get(prevIndex);
					V v = prev.values.get(prevIndex);
					prev.keys.remove(prevIndex);
					prev.values.remove(prevIndex);
					keys.add(0, k);
					values.add(0, v);
					return 1;
				}

				// Does the right node have more keys than it needs?
				else if (next != null
						&& next.keys.size() - 1 >= (leafOrder + 1) / 2) {
					wayTest.append("<rigth-have-more-keys>");
					// Simply move the first key from the next node.
					K k = next.keys.get(0);
					V v = next.values.get(0);
					next.keys.remove(0);
					next.values.remove(0);
					keys.add(k);
					values.add(v);
					return 1;
				}

				// Otherwise, merge with left?
				else if (prev != null) {
					wayTest.append("<merge-with-left>");
					// We actually want to keep the left node, so add all of the
					// keys in this node to the left node.
					prev.keys.addAll(keys);
					prev.values.addAll(values);
					prev.next = next;
					if (next != null)
						next.prev = prev;

					return 2;
				}

				// Otherwise, merge with right?
				else if (next != null) {
					wayTest.append("<merge-with-right>");
					// Add all keys in right node to this node.
					keys.addAll(next.keys);
					values.addAll(next.values);
					if (next.next != null)
						next.next.prev = this;
					next = next.next;

					return 3;
				}
				// Otherwise, we're the root and it's okay to be less than
				// leafOrder / 2.
				else {
					return 1;
				}
			}
		}

		private int findLeafIndex(Object key) {
			return BPTree.this.findLeafIndex(this, key);
		}
	}

	private static class DefaultComparator<K> implements Comparator<K> {
		public int compare(K a, K b) {
			if (a == null) {
				if (b == null)
					return 0;
				else
					return -1;
			} else {
				return ((Comparable) a).compareTo(b);
			}
		}
	}

	private class SubMap extends AbstractMap<K, V> implements SortedMap<K, V> {
		private K low;
		private K high;

		private final EntrySet esInstance = new EntrySet();

		public SubMap(K low, K high) {
			this.low = low;
			this.high = high;
		}

		public SubMap() {
			low = null;
			high = null;
		}

		private boolean checkKey(Object key) {
			return (low == null || comp.compare(key, low) >= 0)
					&& (high == null || comp.compare(key, high) < 0);
		}

		public boolean containsKey(Object key) {
			return checkKey(key) && BPTree.this.containsKey(key);
		}

		public V get(Object key) {
			if (checkKey(key)) {
				wayTest.append("<submap-get>");
				return BPTree.this.get(key);
			} else {
				return null;
			}
		}

		public V put(K key, V value) {
			if (checkKey(key))
				return BPTree.this.put(key, value);
			else
				throw new IllegalArgumentException();
		}

		public V remove(Object key) {
			if (checkKey(key))
				return BPTree.this.remove(key);
			else
				return null;
		}

		public Comparator comparator() {
			return BPTree.this.comparator();
		}

		public K firstKey() {
			for (K key : this.keySet())
				return key;

			throw new NoSuchElementException();
		}

		public K lastKey() {
			K key = null;
			for (K k : this.keySet())
				key = k;

			if (key == null)
				throw new NoSuchElementException();

			return key;
		}

		public Set<Entry<K, V>> entrySet() {
			return esInstance;
		}

		public SortedMap<K, V> subMap(K arg0, K arg1) {
			// Make sure specified bounds stay within the bounds of THIS SubMap.
			K newLow, newHigh;
			if (arg0 != null && comp.compare(arg0, low) > 0)
				newLow = arg0;
			else
				newLow = low;
			if (arg1 != null && comp.compare(arg1, high) < 0)
				newHigh = arg1;
			else
				newHigh = high;

			// Return a new SubMap.
			return BPTree.this.subMap(newLow, newHigh);
		}

		public SortedMap<K, V> headMap(K arg0) {
			return subMap(firstKey(), arg0);
		}

		public SortedMap<K, V> tailMap(K arg0) {
			return subMap(arg0, lastKey());
		}

		private class EntrySet extends AbstractSet<Entry<K, V>> {
			public void clear() {
				if (low == null && high == null)
					BPTree.this.clear();
				else
					super.clear();
			}

			public boolean contains(Object entry) {
				if (entry instanceof Entry) {
					Entry<K, V> e = (Entry<K, V>) entry;
					if (SubMap.this.containsKey(e.getKey())) {
						V value = SubMap.this.get(e.getKey());
						return value == null ? e.getValue() == null : value
								.equals(e.getValue());
					} else {
						return false;
					}
				} else {
					return false;
				}
			}

			public Iterator<Entry<K, V>> iterator() {
				return new EntrySetIterator();
			}

			public boolean remove(Object entry) {
				if (contains(entry)) {
					SubMap.this.remove(((Entry<K, V>) entry).getKey());
					return true;
				} else {
					return false;
				}
			}

			public int size() {
				if (low == null && high == null)
					return BPTree.this.size();
				else {
					int count = 0;
					for (Entry<K, V> e : entrySet()) {
						e = e == null ? null : null; // this line exists only to
														// get rid of the
														// "e is not used"
														// warning.
						count++;
					}

					return count;
				}
			}

			private class EntrySetIterator implements Iterator<Entry<K, V>> {
				private int modCount;

				private LeafNode curNode;
				private int curIndex = 0;
				private BPTEntry lastEntry = null;

				public EntrySetIterator() {
					modCount = BPTree.this.modCount;
					curNode = BPTree.this.firstLeaf;
					// Keep getting next entry until we reach something >= low.
					if (low != null) {
						// Find leaf node that contains the lowest allowable
						// key.
						Node cur = root;
						while (cur instanceof BPTree.GuideNode) {
							GuideNode gn = (GuideNode) cur;
							int index = findGuideIndex(gn, low);
							cur = gn.children.get(index);
						}

						curNode = (LeafNode) cur;

						// We may need to skip to the next node.
						if (comp.compare(
								curNode.keys.get(curNode.keys.size() - 1), low) < 0)
							curNode = curNode.next;
						// Find first key >= low.
						if (curNode != null) {
							for (curIndex = 0; curIndex < curNode.keys.size()
									&& comp.compare(curNode.keys.get(curIndex),
											low) < 0; curIndex++)
								/* empty body */;
						}
					}
				}

				public boolean hasNext() {
					return curNode != null
							&& curIndex < curNode.keys.size()
							&& (high == null || comp.compare(
									curNode.keys.get(curIndex), high) < 0);
				}

				public Entry<K, V> next() {
					// Make sure tree has not been modified.
					if (modCount != BPTree.this.modCount)
						throw new ConcurrentModificationException();

					// No more entries?
					if (!hasNext())
						throw new NoSuchElementException();

					// Get entry.
					lastEntry = new BPTEntry(curNode.keys.get(curIndex),
							BPTree.this);

					// Increment index.
					curIndex++;
					if (curIndex >= curNode.keys.size()) {
						curNode = curNode.next;
						curIndex = 0;
					}
					// Return.
					return lastEntry;
				}

				public void remove() {
					// Make sure tree has not been modified.
					if (modCount != BPTree.this.modCount)
						throw new ConcurrentModificationException();

					// Make sure this isn't called during an invalid state.
					if (lastEntry == null)
						throw new IllegalStateException();

					// Remove entry.
					K curKey = curNode != null ? curNode.keys.get(curIndex)
							: null;
					SubMap.this.remove(lastEntry.getKey());
					if (curKey != null)
						curIndex = curNode.findLeafIndex(curKey);

					// Reset mod count.
					modCount = BPTree.this.modCount;
				}
			}
		}
	}

	private class BPTEntry implements Entry<K, V> {
		private K key;
		private BPTree<K, V> tree;

		public BPTEntry(K key, BPTree<K, V> tree) {
			this.key = key;
			this.tree = tree;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return tree.get(key);
		}

		public V setValue(V value) {
			return tree.put(key, value);
		}
	}
}

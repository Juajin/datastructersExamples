
public class AVLTree {
	private Node root;
	int sumOfDatas = 0;
	int sumsmaller = 0;

	public AVLTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}	




	private int height(Node t) {
		return t == null ? -1 : t.height;
	}

	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}
	public void insert(int data) {
		root = insert(data, root);
	}
	private Node insert(int x, Node t) {
		if (t == null)
			t = new Node(x);
		else if (x < t.data) {
			t.left = insert(x, t.left);
			if (height(t.left) - height(t.right) == 2)
				if (x < t.left.data)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
		} else if (x > t.data) {
			t.right = insert(x, t.right);
			if (height(t.right) - height(t.left) == 2)
				if (x > t.right.data)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		} else
			; // Duplicate; do nothing
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private Node rotateWithLeftChild(Node k2) {
		Node k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}

	private Node rotateWithRightChild(Node k1) {
		Node k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;
		return k2;
	}

	private Node doubleWithLeftChild(Node k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/**
	 *   * Double rotate binary tree node: first right child   * with its left
	 * child; then node k1 with new right child
	 */
	private Node doubleWithRightChild(Node k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	public int GetSumSmaller(int maxNumber) {
		sumsmaller=0;
		return GetSumSmaller(root, maxNumber);
	}

	private int GetSumSmaller(Node r, int maxNumber) {
		if (r == null)
			return 0;
		else {
			GetSumSmaller(r.left, maxNumber);
			if (r.data <= maxNumber) {
				sumsmaller += r.data;
			}
			GetSumSmaller(r.right, maxNumber);
			return sumsmaller;
		}
	}

	public int MaxData() {
		Node temp = root;
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.data;

	}

	public int MinData() {
		Node temp = root;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.data;

	}

	public void getSum() {
		getSum(root);
	}

	private void getSum(Node r) {
		if (r != null) {
			getSum(r.left);
			sumOfDatas += r.data;
			getSum(r.right);
		}
	}

	public void print() {
		print(root);
	}

	private void print(Node r) {
		if (r != null) {
			print(r.left);
			System.out.print(r.data + " ");
			print(r.right);
		}
	}

}

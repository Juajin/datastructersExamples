
public class AugmentedAVLTree {

	private AugmentedNode root;
	int sumOfDatas = 0;
	int sumsmaller = 0;

	public AugmentedAVLTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	private int height(AugmentedNode t) {
		return t == null ? -1 : t.height;
	}

	private int max(int leftHight, int rightHight) {
		return leftHight > rightHight ? leftHight : rightHight;
	}

	public void insert(int data) {
		root = insert(data, root);
		AugmentedNode n = search(data, null);
		SMALLERSUM(data, root);
		SmallerSum2(data, root, n);

	}

	public AugmentedNode search(int key, AugmentedNode temp) {
		if (temp == null) {
			temp = root;
		}

		while ((temp.left != null && key < (int) temp.data) || (temp.right != null && key > (int) temp.data)) {
			if (key < (int) temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}

		if (key == (int) temp.data) {
			return temp;
		}

		return null;

	}

	private AugmentedNode insert(int x, AugmentedNode t) {
		if (t == null)
			t = new AugmentedNode(x);

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
			;
		t.height = max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private AugmentedNode rotateWithLeftChild(AugmentedNode k2) {
		AugmentedNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(height(k2.left), height(k2.right)) + 1;
		k1.height = max(height(k1.left), k2.height) + 1;
		return k1;
	}

	private AugmentedNode rotateWithRightChild(AugmentedNode k1) {
		AugmentedNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(height(k1.left), height(k1.right)) + 1;
		k2.height = max(height(k2.right), k1.height) + 1;
		return k2;
	}

	private AugmentedNode doubleWithLeftChild(AugmentedNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private AugmentedNode doubleWithRightChild(AugmentedNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	public void newSumSmaller(int data, AugmentedNode n) {
		if (data < n.data && n.left != null) {
			newSumSmaller(data, n.left);

		}
		if (data < n.data) {
			n.sumOfSmaller += data;
		}
		if (data < n.data && n.right != null) {
			newSumSmaller(data, n.right);
		}
	}

	public int MaxData() {
		AugmentedNode temp = root;
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.data;

	}

	public int MinData() {
		AugmentedNode temp = root;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.data;

	}

	public void SmallerSum2(int key, AugmentedNode node,AugmentedNode nodeToUpdate)
	{
		if(node.right!=null)
		{
			SmallerSum2(key,node.right,nodeToUpdate);
		}
		if(key>(int)node.data)
		{
			nodeToUpdate.sumOfSmaller=nodeToUpdate.sumOfSmaller+(int)node.data;
		}
		if(node.right!=null)
		{
			SmallerSum2(key,node.right,nodeToUpdate);
		}
	}

	public void SMALLERSUM(int key, AugmentedNode node) {
		if (key < (int) node.data && node.right != null) {
			SMALLERSUM(key, node.right);
		}
		if (key < (int) node.data) {
			node.sumOfSmaller = node.sumOfSmaller + key;
		}
		if (key < (int) node.data && node.right != null) {
			SMALLERSUM(key, node.right);
		}

	}

	public void getSum() {
		getSum(root);
	}

	private void getSum(AugmentedNode r) {
		if (r != null) {
			getSum(r.left);
			sumOfDatas += r.data;
			getSum(r.right);
		}
	}

	public void print() {
		print(root);
	}

	private void print(AugmentedNode r) {
		if (r != null) {
			print(r.left);
			System.out.print(r.data + " ");
			print(r.right);
		}
	}

	public int GetSumSmaller(int a) {
		sumsmaller = 0;
		return GetSumSmaller(root, a);
	}

	private int GetSumSmaller(AugmentedNode r, int maxNumber) {
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

}

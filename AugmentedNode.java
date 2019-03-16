
public class AugmentedNode {

	AugmentedNode left;
	AugmentedNode right;
	int data;
	int height;
	int sumOfSmaller;

	AugmentedNode() {
		sumOfSmaller=0;
		left = null;
		right = null;
		data = 0;
		height = 0;

	}

	AugmentedNode(int a) {

		left = null;
		right = null;
		data = a;
		height = 0;

	}

}

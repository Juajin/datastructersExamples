package DS;

public class Sort {

	String strYour_name="Anýl Dursun";
	long Your_number= 2014510023;
	Sort() {

	}

	public void Our_sort(int[] array, int p, int q, int digit) {

		int p1 = p;

		int q1 = q;

		while (q > 0 && p < array.length - 1 && p <= q) {
			String leftArray = Integer.toBinaryString(array[p]);
			String rightArray = Integer.toBinaryString(array[q]);

			int size = leftArray.length();
			for (int i = 0; i < 32 - size; i++) {
				leftArray = "0" + leftArray;
			}
			size = rightArray.length();
			for (int i = 0; i < 32 - size; i++) {
				rightArray = "0" + rightArray;
			}

			if (leftArray.substring(32 - digit, 33 - digit).equalsIgnoreCase("1")

					&& rightArray.substring(32 - digit, 33 - digit).equalsIgnoreCase("1")) {

				q--;

			} else if (leftArray.substring(32 - digit, 33 - digit).equalsIgnoreCase("1")

					&& rightArray.substring(32 - digit, 33 - digit).equalsIgnoreCase("0")) {

				int temp = array[p];

				array[p] = array[q];

				array[q] = temp;

				p++;

				q--;

			} else if (leftArray.substring(32 - digit, 33 - digit).equalsIgnoreCase("0")

					&& rightArray.substring(32 - digit, 33 - digit).equalsIgnoreCase("0")) {

				p++;

			} else if (leftArray.substring(32 - digit, 33 - digit).equalsIgnoreCase("0")

					&& rightArray.substring(32 - digit, 33 - digit).equalsIgnoreCase("1")) {

				p++;

				q--;

			}

		}

		if (digit > 1) {

			Our_sort(array, p1, q, digit - 1);
			Our_sort(array, p, q1, digit - 1);

		}

	}

}

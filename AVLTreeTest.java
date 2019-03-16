import java.util.Random;
import java.util.Scanner;

public class AVLTreeTest {
	static long insertionTime;
	static long GetSumInsertionTime;

	public static void main(String[] args) {
		Random rnd = new Random();
		Scanner scan = new Scanner(System.in);
		/* Creating object of AVLTree */
		AVLTree avlt = new AVLTree();
		AugmentedAVLTree aavlt = new AugmentedAVLTree();
		long startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			avlt.insert(rnd.nextInt(2000));
		}
		long finishTime = System.nanoTime();
		insertionTime = finishTime - startTime;
		avlt.GetSumSmaller(1000);
		System.out.println();
		System.out.print("The time elapsed for the insertion of all items is   " + insertionTime + "   nanoseconds");
		System.out.println();
		System.out.print("The result of GETSUMSMALLER for the item with value 1000 is " + avlt.sumsmaller);
		System.out.println();
		System.out.print("The maximum value of all items is " + avlt.MaxData());
		System.out.println();
		System.out.print("The minimum value of all items is " + avlt.MinData());
		System.out.println();
		long startTime2 = System.nanoTime();
		avlt.getSum();
		long finishTime2 = System.nanoTime();
		GetSumInsertionTime = finishTime2 - startTime2;
		System.out.print("The summation of all items is " + avlt.sumOfDatas);
		System.out.println();
		System.out.print("The time elapsed for GETSUM is " + GetSumInsertionTime);

		System.out.println();

		System.out.println();
		System.out.println("----------------------AUGMENTED----------------------");

		long startTimeA = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			aavlt.insert(rnd.nextInt(2000));
		}
		long finishTimeA = System.nanoTime();
		long insertionTimeA = finishTimeA - startTimeA;
		aavlt.GetSumSmaller(1000);
		System.out.println();
		System.out.print("The time elapsed for the insertion of all items is   " + insertionTimeA + "   nanoseconds");
		System.out.println();
		System.out.print("The result of GETSUMSMALLER for the item with value 1000 is " + aavlt.sumsmaller);
		System.out.println();
		System.out.print("The maximum value of all items is " + aavlt.MaxData());
		System.out.println();
		System.out.print("The minimum value of all items is " + aavlt.MinData());
		System.out.println();
		long startTimeA2 = System.nanoTime();
		aavlt.getSum();
		long finishTimeA2 = System.nanoTime();
		long GetSumInsertionTimeA = finishTimeA2 - startTimeA2;
		System.out.print("The summation of all items is " + aavlt.sumOfDatas);
		System.out.println();
		System.out.print("The time elapsed for GETSUM is " + GetSumInsertionTimeA);
	}
}

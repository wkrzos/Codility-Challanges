public class Solution {

	public static void main(String[] args) {
		// Test case 1: Matrix with maximum sum already
		int[] matrix1 = {5, 6, 7, 2, 9, 8, 4, 3, 1};
		int[] result1 = solution(matrix1);
		System.out.println("Test Case 1:");
		displayMatrix(result1);
		
		// Test case 2: Matrix with varying row and column sums
		int[] matrix2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] result2 = solution(matrix2);
		System.out.println("Test Case 2:");
		displayMatrix(result2);
		
		// Test case 3: Matrix with equal row sums but different column sums
		int[] matrix3 = {1, 4, 7, 2, 5, 8, 3, 6, 9};
		int[] result3 = solution(matrix3);
		System.out.println("Test Case 3:");
		displayMatrix(result3);
		
		// Test case 4: Matrix with equal column sums but different row sums
		int[] matrix4 = {1, 2, 3, 6, 5, 4, 9, 8, 7};
		int[] result4 = solution(matrix4);
		System.out.println("Test Case 4:");
		displayMatrix(result4);
	}

	public static int[] solution(int[] T) {
		// Initialize the output array with the input matrix
		int[] outputArray = T;

		// Arrays to store the sum of rows and columns
		int[] rowSumArray = new int[3];
		int[] colSumArray = new int[3];

		// Initialize the maximum sum to a negative value
		int maxSum = -1;

		// Calculate row and column sums and find the maximum sum
		for (int i = 0; i < 3; i++) {
			rowSumArray[i] = 0;
			colSumArray[i] = 0;

			for (int j = 0; j < 3; j++) {
				// Calculate the sum of rows and columns
				rowSumArray[i] += T[j + 3*i];
				colSumArray[i] += T[3*j + i];
			}

			// Update the maximum sum
			maxSum = Math.max(maxSum, rowSumArray[i]);
			maxSum = Math.max(maxSum, colSumArray[i]);
		}

		// Adjust the matrix to make row and column sums equal to the maximum sum
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (rowSumArray[i] < maxSum && colSumArray[j] < maxSum) {
					// Calculate the difference needed to reach the maximum sum
					int difference = maxSum - Math.max(rowSumArray[i], colSumArray[j]);
					
					// Update the values in the output array, row sums, and column sums
					outputArray[3*i + j] += difference;
					rowSumArray[i] += difference;
					colSumArray[j] += difference;
				}
			}
		}
		
		// Return the modified output array
		return outputArray;
	}

	public static void displayMatrix(int[] matrix) {
		// Display a 3x3 matrix
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix[3 * i + j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

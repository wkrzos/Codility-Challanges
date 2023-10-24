public class Solution {

	public static void main(String[] args) {
		// Input matrix
		int[] matrix = {0, 2, 3, 4, 1, 1, 1, 3, 1};
		int[] result = solution(matrix);

		// Display the result
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
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
}

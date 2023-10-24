public class Solution {
    
    // Define the size of the English alphabet
    private static final int ALPHABET_SIZE = 26;

    // Main solution method that takes an array of strings as input
    public int solution(String[] T) {
        // Initialize the maximum occurrences to 1
        int maxOccurrences = 1;
        
        // Create a 3D array to store occurrences of character triplets
        int occurrences[][][] = new int[ALPHABET_SIZE][ALPHABET_SIZE][ALPHABET_SIZE];

        // Iterate through the input array of strings
        for (int i = 0; i < T.length; i++) {
            // Convert the current string into a character array
            char[] chars = T[i].toCharArray();

            // Normalize characters to be in the range [0, 25] (assuming lowercase English letters)
            chars[0] -= 'a';
            chars[1] -= 'a';
            chars[2] -= 'a';

            // Update the occurrences count for the character triplet
            occurrences[chars[0]][chars[1]][chars[2]]++;

            // If characters at positions 0 and 1 are different, update the occurrence count for other permutations
            if (chars[0] != chars[1]) {
                occurrences[chars[1]][chars[0]][chars[2]]++;
            }

            // If characters at positions 1 and 2 are different, update the occurrence count for other permutations
            if (chars[1] != chars[2]) {
                occurrences[chars[0]][chars[2]][chars[1]]++;
            }

            // Update the maximum occurrences value
            maxOccurrences = Math.max(maxOccurrences, occurrences[chars[0]][chars[1]][chars[2]]);
            maxOccurrences = Math.max(maxOccurrences, occurrences[chars[1]][chars[0]][chars[2]]);
            maxOccurrences = Math.max(maxOccurrences, occurrences[chars[0]][chars[2]][chars[1]]);
        }

        // Return the maximum occurrences found
        return maxOccurrences;
    }

    public static void main(String[] args) {
        // Test cases
        Solution solution = new Solution();
        String[] test1 = {"abc", "def", "ghi", "jkl"};
        String[] test2 = {"aaa", "bbb", "ccc"};
        String[] test3 = {"aba", "aba", "aaa", "aca"};

        int result1 = solution.solution(test1);
        int result2 = solution.solution(test2);
        int result3 = solution.solution(test3);

        System.out.println("Test Case 1: " + result1); // Should output 1
        System.out.println("Test Case 2: " + result2); // Should output 3
        System.out.println("Test Case 3: " + result3); // Should output 4
    }
}

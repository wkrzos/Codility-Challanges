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
            maxOccurrences = Math.max(maxOccurrences, occurrences[chars[1]][chars[0]][chars[2]);
            maxOccurrences = Math.max(maxOccurrences, occurrences[chars[0]][chars[2]][chars[1]);
        }

        // Return the maximum occurrences found
        return maxOccurrences;
    }
}

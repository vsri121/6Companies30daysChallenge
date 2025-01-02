class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        // Base case: if the string is too short to have any 10-letter-long sequences
        if (s.length() < 10) {
            return result;
        }
        
        // Map nucleotides to 2-bit integers
        Map<Character, Integer> nucleotideMap = new HashMap<>();
        nucleotideMap.put('A', 0);
        nucleotideMap.put('C', 1);
        nucleotideMap.put('G', 2);
        nucleotideMap.put('T', 3);

        // Set to track the sequences we've seen
        Set<String> seen = new HashSet<>();
        // Set to track repeated sequences
        Set<String> repeated = new HashSet<>();

        // The current 20-bit representation of a 10-letter sequence
        int currentValue = 0;

        for (int i = 0; i < s.length(); i++) {
            // Shift the current value by 2 bits to the left (make space for the next nucleotide)
            currentValue <<= 2;

            // Get the integer value of the current nucleotide
            currentValue |= nucleotideMap.get(s.charAt(i));

            // If we've processed at least 10 characters, check the sequence
            if (i >= 9) {
                // Extract the 10-letter sequence's integer representation
                if (seen.contains(s.substring(i - 9, i + 1))) {
                    // If the sequence is repeated, add it to the result list
                    repeated.add(s.substring(i - 9, i + 1));
                } else {
                    seen.add(s.substring(i - 9, i + 1));
                }
            }
        }

        // Add all repeated sequences to the result list
        result.addAll(repeated);
        return result;
    }

    
}

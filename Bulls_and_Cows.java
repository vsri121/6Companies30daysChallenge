class Solution {
    public String getHint(String secret, String guess) {
        
        
    int bulls = 0, cows = 0;
        HashMap<Character, Integer> secretMap = new HashMap<>();
        HashMap<Character, Integer> guessMap = new HashMap<>();

        // Step 1: Count bulls and populate hash maps for mismatched digits
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if (s == g) {
                bulls++;
            } else {
                secretMap.put(s, secretMap.getOrDefault(s, 0) + 1);
                guessMap.put(g, guessMap.getOrDefault(g, 0) + 1);
            }
        }

        // Step 2: Count cows
        for (char key : secretMap.keySet()) {
            if (guessMap.containsKey(key)) {
                cows += Math.min(secretMap.get(key), guessMap.get(key));
            }
        }

        // Step 3: Format and return the result
        return bulls + "A" + cows + "B";
    }
}

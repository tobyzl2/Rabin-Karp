class RabinKarp {
    //Source: https://www.coursera.org/lecture/algorithms-part2/rabin-karp-3KiqT

    /**
     * Returns the index of the text in which the pattern is found at O(n+m)
     * @param pattern the pattern that is searched for
     * @param text the text in which the pattern is searched for
     * @return index where pattern is found, -1 if pattern is not found
     * @throws IllegalArgumentException when pattern or text are both null or empty or when pattern is longer than text
     */
    static int indexOf(String pattern, String text) throws IllegalArgumentException {
        if (pattern == null || text == null) {
            throw new IllegalArgumentException("Invalid null argument.");
        } else if (pattern.equals("") || text.equals("")) {
            throw new IllegalArgumentException("Invalid empty String argument.");
        } else if (pattern.length() > text.length()) {
            throw new IllegalArgumentException("Pattern longer tan text.");
        }

        //Comparing hash values
        long patternHash = getHash(pattern);
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            String compareFragment = text.substring(i, pattern.length() + i);
            long compFragmentHash = getHash(compareFragment);
            //Comparing chars when hash matches
            if (compFragmentHash == patternHash) {
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) != compareFragment.charAt(j)) {
                        break;
                    } else if (j == pattern.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Determines modulo hash value of text using Horner's method.
     * @param text text to find hash for
     * @return hash value of text
     */
    private static long getHash(String text) {
        long hashValue = 0;
        final int PRIME = 193;
        final int RADIX = 10;
        for (int i = 0; i < text.length(); i++) {
            hashValue = (RADIX * (hashValue + text.charAt(i)) % PRIME);
        }
        return hashValue;
    }
}

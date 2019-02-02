public class RabinKarp {
    //Source: https://www.coursera.org/lecture/algorithms-part2/rabin-karp-3KiqT
    static int indexOf(String pattern, String text) throws IllegalArgumentException {
        if (pattern == null || text == null || pattern.length() > text.length()) {
            throw new IllegalArgumentException();
        }

        long patternHash = getHash(pattern);
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            String textFragment = text.substring(i, pattern.length() + i);
            long textFragmentHash = getHash(textFragment);
            if (textFragmentHash == patternHash) {
                for (int j = 0; j < text.length(); j++) {
                    if (text.charAt(j) != textFragment.charAt(j)) {
                        break;
                    }
                }
                return i;
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

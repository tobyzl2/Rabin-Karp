import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RabinKarpTest {
    public static final String WIKIPEDIA = "In computer science, the Rabin–Karp algorithm or Karp–Rabin algorithm is a string-searching algorithm created by Richard M. Karp and Michael O. Rabin (1987) that uses hashing to find any one of a set of pattern strings in a text. For text of length n and p patterns of combined length m, its average and best case running time is O(n+m) in space O(p), but its worst-case time is O(nm). In contrast, the Aho–Corasick string-matching algorithm has asymptotic worst-time complexity O(n+m) in space O(m). A practical application of the algorithm is detecting plagiarism. Given source material, the algorithm can rapidly search through a paper for instances of sentences from the source material, ignoring details such as case and punctuation. Because of the abundance of the sought strings, single-string searching algorithms are impractical.";
    @Test
    public void simpleWikipediaTest() {
        assertEquals(WIKIPEDIA.indexOf("science"), RabinKarp.indexOf("science", WIKIPEDIA));
    }

}

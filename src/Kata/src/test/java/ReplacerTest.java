import org.example.Replacer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class ReplacerTest {


    @ParameterizedTest
    @CsvSource({"a, z","b, e","c, e","d, e","e, d","f, i","g, i","h, i","i, h","j, o","k, o","l, o",
            "m, o","n, o","o, n","p, u","q, u","r, u","s, u","t, u","u, t","v, a","w, a","x, a","y, a","z, a", "+, ' '"})

    public void replacerTest(char c, char expectedChar){
        char replacedChar = Replacer.getTheNearest(c);
        assertEquals(replacedChar, expectedChar);

    }

}

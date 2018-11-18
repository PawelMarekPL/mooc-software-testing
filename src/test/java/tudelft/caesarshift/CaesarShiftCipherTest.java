package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {
    @ParameterizedTest(name = "{0}: ({1}, {2}) = {3}")
    @CsvSource({
            "'tooShort','',1,''",
            "'short','a',-1,'z'","'short','a',25,'z'","'short','a',51,'z'",
            "'short','b',-1,'a'","'short','c',26,'c'","'short','y',2,'a'",
            "'space',' ba',-1,' az'","'space','a c',26,'a c'","'space','yz ',2,'ab '",
            "'long','xyzab',3,'abcde'"

    })
    public void test(String partition, String message, int shift, String expectedResult) {
        String result = new CaesarShiftCipher().CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expectedResult, result);
    }

}

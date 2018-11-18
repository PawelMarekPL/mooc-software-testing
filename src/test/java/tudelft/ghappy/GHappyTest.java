package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    @ParameterizedTest(name = "{0}: ({1}) = {2}")
    @CsvSource({
            "'tooShort','',true","'tooShort','G',true","'tooShort','g',false",
            "'short','1g',false","'short','gg',true","'short','gG',false",
            "'longer','FGH',true","'longer','Rgg',true","'longer','ggG',true","'longer','g1G',false",
            "'long','g1xG',false","'long','Gg1xG',false","'long','1xGg',false"
    })
    public void test(String partition, String s, boolean expectedResult) {
        boolean result = new GHappy().gHappy(s);
        if (expectedResult)
            Assertions.assertTrue(result);
        else
            Assertions.assertFalse(result);
    }
}

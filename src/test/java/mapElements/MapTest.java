package mapElements;

import com.walker.mapElements.model.Map;
import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    @Test
    public void testCreateStringRepresentation() {
        String[][] representation = {
                { "#", "#", "#", "#" },
                { "*", "*", "*", "*" },
                { "@", "@", "@", "@" }
        };
        Map map = new Map(representation);

        String expected = "####" + System.lineSeparator()
                + "****" + System.lineSeparator()
                + "@@@@" + System.lineSeparator();

        String actual = map.toString();

        Assert.assertEquals(expected, actual);
    }
}

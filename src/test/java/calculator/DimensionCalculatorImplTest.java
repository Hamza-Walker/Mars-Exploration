package calculator;

import com.walker.calculators.service.DimensionCalculator;
import com.walker.calculators.service.DimensionCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class DimensionCalculatorImplTest {

    @Test
    public void testCalculateDimension() {
        DimensionCalculator dimensionCalculator = new DimensionCalculatorImpl();

        // Test case 1: desiredSize = 20, dimensionGrowth = 3
        int dimension1 = dimensionCalculator.calculateDimension(20, 3);
        Assert.assertEquals(8, dimension1);

        // Test case 2: desiredSize = 50, dimensionGrowth = 5
        int dimension2 = dimensionCalculator.calculateDimension(50, 5);
        Assert.assertEquals(9, dimension2);

        // Test case 3: desiredSize = 10, dimensionGrowth = 1
        int dimension3 = dimensionCalculator.calculateDimension(10, 1);
        Assert.assertEquals(5, dimension3);

        // Test case 4: desiredSize = 100, dimensionGrowth = 10
        int dimension4 = dimensionCalculator.calculateDimension(100, 10);
        Assert.assertEquals(11, dimension4);
    }
}

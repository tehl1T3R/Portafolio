package neuralnetwork;

import java.math.BigDecimal;

public class RoundDecimals {
    
    public double getRounded(double n, int p) {
        return roundDecimals(n, p);
    }
    
    private double roundDecimals(double number, int precision) {
        double d1 = 0;
        try {
            BigDecimal bd = new BigDecimal(number);
            bd = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
            d1 = bd.doubleValue();
        } catch (NumberFormatException e) {
        }
        return d1;
    }
    
}

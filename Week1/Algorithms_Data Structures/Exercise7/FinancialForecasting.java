public class FinancialForecasting {

    public static double forecastValue(double currentValue, double growthRate, int years) {
        if (years == 0) return currentValue;
        return forecastValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double currentValue = 100000;
        double growthRate = 0.08;
        int years = 5;

        double futureValue = forecastValue(currentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: ₹" + futureValue);
    }
}

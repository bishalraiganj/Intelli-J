public class MainForCarpetCostCalculator {
    public static void main(String[] args) {
        Floor floor = new Floor(4, 5);
        Carpet carpet = new Carpet(5);
        Calculator calculator = new Calculator(floor, carpet);
        System.out.println(calculator.getTotalCost());
    }
}

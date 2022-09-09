public class Salary extends Income{

    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (this.getIncome() <= 5000) {
            return 0;
        }
        return (this.getIncome() - 5000) * 0.2;
    }
}

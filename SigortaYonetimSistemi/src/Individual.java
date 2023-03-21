import java.util.ArrayList;

public class Individual extends Account{
    private double profit;

    public Individual(User user) {
        super(user);
        this.profit = 0.25;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}

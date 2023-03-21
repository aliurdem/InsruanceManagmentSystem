import java.util.ArrayList;

public class Enterprise extends Account{
    private double profit;

    public Enterprise(User user) {
        super(user);
        this.profit = 0.5;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}

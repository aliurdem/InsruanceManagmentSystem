import java.time.LocalDate;

public abstract class Insurance {
    private int id ;
    private String name;
    private double cost;
    private LocalDate startDate;
    private LocalDate endDate;

    public Insurance(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusYears(1);
    }
    public abstract double calculate(Account account);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

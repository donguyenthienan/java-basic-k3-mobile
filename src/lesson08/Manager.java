package lesson08;

public class Manager extends Employee{
    @Override
    protected double getSalary() {
        return 50000;
    }

    @Override
    protected double getSupportMoney() {
        return 3000;
    }
}

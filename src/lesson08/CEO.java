package lesson08;

public class CEO extends Employee{
    @Override
    protected double getSalary() {
        return 100000;
    }

    @Override
    protected double getSupportMoney() {
        return 1000;
    }
}

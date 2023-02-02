package salarioFun;

public class Employee {
    public String name;

    public double gross;

    public double tax;

    public double Netsalary(){
        return gross - tax;
    }

    public void IncreaseSalary(double percentage) {
        gross += gross * percentage/100;
    }

    public String toString() {
        return   name +  ", $" + String.format("%.2f", Netsalary());
    }

}

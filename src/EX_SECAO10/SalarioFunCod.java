package EX_SECAO10;

public class SalarioFunCod {
    private Integer id;
    private String name;
    private double salary;


    public SalarioFunCod(){

    }

    public SalarioFunCod(Integer id, String name, double salary){

    }
    public void AcressSalary(double percent){
        salary += salary * percent /100.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString(){
        return id + name + String.format("salary: %.2f", salary);
    }
}

package CompanyStructure;

public class Employee {
    private String name;
    private double baseSalary;
    private int employeeId;
    private Employee manager;
    private double bonus;
    //public String employeeStatus;


    public static int nextID=1;
    public Employee(String name, double baseSalary){
        this.name=name;
        this.baseSalary=baseSalary;
        this.employeeId=nextID++;
    }
    public double getBaseSalary(){
        return (this.baseSalary);
    }
    public String getName(){
        return (this.name);
    }
    public int getEmployeeId(){
        return (this.employeeId);
    }
    public Employee getManager() {
        return (this.manager);
    }
    public void setManager(Employee manager){
        this.manager=manager;
    }
    public boolean equals(Employee other){
        return (this.employeeId==other.employeeId);
    }
    public void setBonus(double bonus){
        this.bonus=bonus;
    }
    public double getBonus(){
        return this.bonus;
    }
    public String toString(){
        return ("\""+ this.employeeId+" "+ this.name+"\"");
    }
    public String employeeStatus(){
        return ("\""+ getEmployeeId() +" "+ getName());
    }
}

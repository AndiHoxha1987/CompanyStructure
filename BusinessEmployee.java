package CompanyStructure;

public class BusinessEmployee extends Employee {
    public double bonusBudget;
    public static int baseSalary = 50000;

    public BusinessEmployee (String name){
        super (name,baseSalary);
    }
    public void setBonusBudget(double bonusBudget){
        this.bonusBudget=bonusBudget;
    }
    public double getBonusBudget(){
        return this.bonusBudget;
    }
    public String employeeStatus(){
       return super.employeeStatus()+" with a budget of "+ getBonusBudget()+"\"";
    }
}

package CompanyStructure;

public class TechnicalEmployee extends Employee {
    public static int baseSalary=75000;
    public int checkInCount;
    public TechnicalEmployee(String name){
        super(name,baseSalary);
    }
    public TechnicalEmployee(String name, double salaryMultiply){
        super(name,baseSalary*salaryMultiply);
    }
    public void setCheckInCount(SoftwareEngineer e){
        this.checkInCount=e.getSuccessfulCheckIns();
    }

    public int getSuccessfulCheckIns() {
        return this.checkInCount;
    }

    public String employeeStatus(){
        return super.employeeStatus()+" has "+checkInCount +" successful check ins\"";
    }
}

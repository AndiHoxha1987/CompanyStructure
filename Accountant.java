package CompanyStructure;

import java.util.List;

public class Accountant extends BusinessEmployee {
    public TechnicalLead supportTeam;
    public double bonusBudget;
    public Accountant(String name){
        super(name);
        this.bonusBudget=0;

    }
    public void setTeamSupported(TechnicalLead supportManager){
        this.supportTeam=supportManager;//sets the supported team of this accountant to the passed in supported manager,
        // actually set by the addReport method of the BusinessLead
        List<Employee>supportReports= supportManager.getReport();//I stored the supported manager's reports here for ease  of access
        int supportedTeamSalary=budgetOfReports(supportReports);//I decided to add up the salaries in a different method down there
        int budgetAddition= supportedTeamSalary/10; //takes the added up number and divides it by 10 to get 10%
        this.bonusBudget=supportedTeamSalary+budgetAddition;
    }

    public int budgetOfReports(List<Employee>supportReports){
        int supportedTeamSalary=0;
        for(int i=0; i < supportReports.size(); i++){
            supportedTeamSalary += supportReports.get(i).getBaseSalary();
        }
        return supportedTeamSalary;
    }

    public TechnicalLead getTeamSupported(){
        return this.supportTeam;
    }
    public double getBonusBudget(){
        return this.bonusBudget;
    }

    public boolean approveBonus(double bonus){
        if(bonus<this.bonusBudget){
            return true;
        }else if(this.supportTeam==null){
            return false;
        }else {
            return false;
        }
    }
    public String employeeStatus(){
        return super.employeeStatus()+" with a budget of "+getBonusBudget()+" is supporting "+ this.supportTeam.getName()+"\"";
    }

}

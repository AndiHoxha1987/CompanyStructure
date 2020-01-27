package CompanyStructure;

import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee {
    public static double salaryMultiply=1.3;
    public List<Employee> report= new ArrayList<Employee>();

    public TechnicalLead (String name){
        super(name,salaryMultiply);
    }

    public boolean hasHeadCount(){
        if(this.report.size()<4){
            return true;
        }else return false;
    }

    public boolean addReport(SoftwareEngineer e){
    if(hasHeadCount()){
        report.add(e);
        e.setManager(this);
        return true;
    }else return false;
    }

    public List<Employee> getReport() {
        return this.report;
    }

    public boolean approveCheckIn(SoftwareEngineer e){
    if((this==e.getManager())&& (e.getCodeAccess())){
        return true;
    }else {return false; }
    }

    public boolean requestBonus(Employee e,double bonus){
    BusinessLead thisManager = ((BusinessLead) this.getManager());
    if(thisManager.approveBonus(this,bonus)){
        return true;
    }else return false;
    }

    public String getTeamStatus(){
        TechnicalLead currentManager = this;
        if(report.size() == 0){
            return this.employeeStatus() + " and no reports yet";
        }else {
            System.out.println(currentManager + ", " + getTeamList());
            return currentManager + ", " + getTeamList();
        }
    }
    public String getTeamList(){ //found it easier to put this string builder function down here
        String teamList = "";
        for(int i = 0; i < report.size(); i++){
            teamList += report.get(i).employeeStatus() + ", ";
        }
        return teamList;
    }
}

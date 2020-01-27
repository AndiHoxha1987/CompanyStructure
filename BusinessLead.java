package CompanyStructure;

import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee {
    public List<Employee> reports = new ArrayList<Employee>();
    public static int Multiply=2;
    public int headCount;
    public static double bonusBudget;

    public BusinessLead(String name){
        super(name);
        this.headCount=10;

    }

    public boolean hasHeadCount(){
    if(this.reports.size()<this.headCount){
        return true;
    }else return false;
    }

    public boolean addReport(Accountant e,TechnicalLead supportTeam){
    if(hasHeadCount()){
        reports.add(e);
        e.setManager(this);
        bonusBudget +=((e.getBaseSalary())*1.1);
        e.setTeamSupported(supportTeam);//this is how we update the Accountant to support the passed in TechnicalLead
        return true;
        }else return false;
    }

    public double getBonusBudget(){
        return bonusBudget;
    }
    public boolean requestBonus(Employee e, double bonus){
        if(bonus<bonusBudget){
            e.setBonus(bonus);
            return true;
        }else return false;
    }

    public boolean approveBonus(Employee e, double bonus){
        for(int i = 0; i < this.reports.size(); i++) {
            if ((((Accountant) reports.get(i)).getTeamSupported() == e.getManager())&&(((Accountant) reports.get(i)).getBonusBudget()<bonus)){
                e.setBonus(bonus);
                bonusBudget -= bonus;
                return true;}else return false;
        }return false;
    }
    public String getTeamStatus(){ //this code (along with getTeamList) was so similar to the TechnicalLead's code I probably should have moved it up one level or something but since they have different superclasses I'm not suer how that would have worked

        BusinessLead currentManager = this;
        if(reports.size() > 0){
            return this.employeeStatus() + " and no reports yet";
        }else{
            System.out.println(currentManager + ", " + getTeamList());
            return currentManager + ", " + getTeamList();
        }
    }

    public String getTeamList(){
        String teamList = "";
        for(int i = 0; i < reports.size(); i++){
            teamList += reports.get(i).employeeStatus() + ", ";
        }
        return teamList;
    }
}

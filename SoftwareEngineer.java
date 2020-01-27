package CompanyStructure;

public class SoftwareEngineer extends TechnicalEmployee {
       public boolean hasCodeAccess;

    public SoftwareEngineer(String name){
        super(name);
        this.checkInCount=0;
        this.hasCodeAccess= false;
    }
    public boolean getCodeAccess(){
        return this.hasCodeAccess;
    }
    public void setCodeAccess(boolean externalAccess){
        this.hasCodeAccess=externalAccess;
    }

    public int getSuccessfulCheckIns(){
        return this.checkInCount;
    }
    public boolean checkInCode(){
        TechnicalLead thisManager= ((TechnicalLead) this.getManager());
        if(thisManager.approveCheckIn(this)){
            checkInCount ++;
            return true;
        }else return false;
    }
}

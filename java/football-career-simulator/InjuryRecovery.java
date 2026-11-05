class Injury{
    private String injuryName;
    private String severity;
    private int recoveryDays;
    private boolean isRecovered;
    
    public Injury(String injuryName, String Severity, int recoveredDays, boolean isRecovered){
        this.injuryName = injuryName;
        this.severity = Severity;
        this.recoveryDays = recoveredDays;
        this.isRecovered = isRecovered; 
    }

    public void setRecoveryDays(int days){
        if (days < 0){
            throw new IllegalArgumentException("Recovery days cannot be negative: " + days);
        }
        if (days > 365){
            throw new IllegalArgumentException("Recovery days cannot exceed 365: " + days);
        }

        this.recoveryDays = days;
    }

    public void setSeverity(String severity){
        if (severity == "Minor" || severity == "Moderate" || severity == "Severe"){
            this.severity = severity;
        }else{
            throw new IllegalArgumentException("Injury severity can only be Moderate or Minor or Severe");
        }
    }

    public void recovery(int days){
        if (days < 0){
            throw new IllegalArgumentException("Recovery days cannot be negative: " + days);
        }
        if (this.recoveryDays > days){
            throw new IllegalArgumentException("The player's recovery days cant be more than the remaningrecovery period");
        }
        if (this.recoveryDays == 0 ){
            this.isRecovered = true;
        }
    }
    
}


public class InjuryRecovery{
    public static void main(String[] args) {
        
    }
}
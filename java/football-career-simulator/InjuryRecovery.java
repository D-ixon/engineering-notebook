
class Injury {
    private String injuryName;
    private String severity;
    private int recoveryDays;
    private boolean isRecovered;

    // Constructor
    public Injury(String injuryName, String severity, int recoveryDays) {
        this.injuryName = injuryName;

        // Reuse validation methods
        setSeverity(severity);
        setRecoveryDays(recoveryDays);
    }

    // Validate and set recovery days
    public void setRecoveryDays(int days) {
        if (days < 0) {
            throw new IllegalArgumentException(
                "Recovery days cannot be negative."
            );
        }

        if (days > 365) {
            throw new IllegalArgumentException(
                "Recovery days cannot exceed 365."
            );
        }

        this.recoveryDays = days;
        this.isRecovered = (days == 0);
    }

    // Validate and set injury severity
    public void setSeverity(String severity) {
        if ("Minor".equals(severity) ||
            "Moderate".equals(severity) ||
            "Severe".equals(severity)) {

            this.severity = severity;

        } else {
            throw new IllegalArgumentException(
                "Severity must be Minor, Moderate or Severe."
            );
        }
    }

    // Recovery operation
    public void recover(int days) throws IllegalArgumentException {

        if (this.isRecovered) {
            throw new IllegalArgumentException(
                "This player has already recovered."
            );
        }

        if (days <= 0) {
            throw new IllegalArgumentException(
                "Recovery days must be positive."
            );
        }

        if (days > this.recoveryDays) {
            throw new IllegalArgumentException(
                "Cannot recover more days than the remaining recovery period."
            );
        }

        this.recoveryDays -= days;

        if (this.recoveryDays == 0) {
            this.isRecovered = true;
        }
    }

    // Getters
    public String getInjuryName() {
        return this.injuryName;
    }

    public String getSeverity() {
        return this.severity;
    }

    public int getRecoveryDays() {
        return this.recoveryDays;
    }

    public boolean getIsRecovered() {
        return this.isRecovered;
    }

    // Display injury information
    public void displayInjuryInfo() {
        System.out.println("\nPlayer: " + getInjuryName());
        System.out.println("Injury Severity: " + getSeverity());
        System.out.println("Remaining Recovery Days: " + getRecoveryDays());
        System.out.println("Recovered: " + getIsRecovered());
    }
}

public class InjuryRecovery {
    public static void main(String[] args) {

        System.out.println("========= INJURY AND RECOVERY SYSTEM =========");

        // Create an injury requiring 20 days of recovery
        Injury player = new Injury("Felix", "State", 20);

        player.displayInjuryInfo();

        // First recovery operation: 8 days
        try {
            player.recover(8);
            System.out.println("\nSuccessfully recovered for 8 days.");
        } catch (IllegalArgumentException e) {
            System.out.println("Recovery error: " + e.getMessage());
        }

        player.displayInjuryInfo();

        // Second recovery operation: invalid 15 days
        try {
            player.recover(15);
            System.out.println("\nSuccessfully recovered for 15 days.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nRecovery error: " + e.getMessage());
        }

        player.displayInjuryInfo();

        // Third recovery operation: remaining 12 days
        try {
            player.recover(12);
            System.out.println("\nSuccessfully completed recovery.");
        } catch (IllegalArgumentException e) {
            System.out.println("Recovery error: " + e.getMessage());
        }

        player.displayInjuryInfo();
    }
}

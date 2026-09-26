class Microwave {
    private int timerSeconds = 0;

    public void setTimer(int seconds){
        this.timerSeconds = seconds;
    }

    public String cook(){
        return "Food is hot after cooking for " + this.timerSeconds + " seconds!";
    }
}

public class Main{
    public static void main(String[] args) {
        Microwave myMicrowave = new Microwave();

        myMicrowave.setTimer(60);

        String result = myMicrowave.cook();

        System.out.println(result);
    }
}
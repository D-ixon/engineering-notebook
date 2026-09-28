class stringtools {
    public static void announce(String strObj){
        System.out.println("The sting object contains" + strObj);
        System.out.println("Length of Object: " + strObj.length());
    }
}
public class caller {
    public static void main(String[] args) {
        
        String myName = new String("Manim");

        stringtools.announce(myName);
    }
}

class Calor{
    String name;
    int age;
    
    public Calor(String name, int age){
        setAge(age);
        setName(name);
    }

    public int setAge(int age){
        if (this.age > 0){
            this.age = age;
        }
        return age;
    }
    public void setName(String name){
        if ("Kofi".equals(this.name)){
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "{name='" + name + "', age=" + age + "}";
    }
}
public class Consta {
    
    public static void main(String[] args) {
        Calor Name1 = new Calor("Kofi", 5);

        System.out.println(Name1);

    }
}

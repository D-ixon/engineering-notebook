public class player {
    private final String name;
    private final int age;
    private final String position;
    private int skillLevel;

    public player(String name, int age, String position, int skillLevel) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void train() {
        // Increase skill level based on training
        skillLevel += 1; // Simple increment for demonstration
    }
}
public class Student {
    private int id;
    private String name;
    private int age;
    private int score;

    public Student(int id, String name, int age, int score){

        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;

    }

//    GETTERS

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getScore() { return score; }

//    Setter (for updating score)

    public void setScore(int score){
        this.score = score;
    }
}

package aydin.firebasedemo;

public class Person {
    private String name;
    private int age;
    private String phonenum;

    public Person(String name, int age, String phonenum) {
        this.name = name;
        this.age = age;
        this.phonenum = phonenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhonenum() {return phonenum;}

    public void setPhonenum(String phonenum) {this.phonenum = phonenum;}

}

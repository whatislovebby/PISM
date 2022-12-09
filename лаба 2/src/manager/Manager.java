package manager;
import java.util.Scanner;

public class Manager {

    private String name;
    private boolean abilities;
    private int age;

    public Manager() { // Дефолтный конструктор
        this.name = "Yulia";
        this.abilities = true;
        this.age = 18;
    }

    public Manager(String name, boolean abilities, int age) { //конструктор с полным набором параметров
        this.name = name;
        this.abilities = abilities;
        this.age = age;
    }

    public Manager(Manager o) { // создаине конструктора копирования
        this.name = o.name;
        this.abilities = o.abilities;
        this.age = o.age;
    }

    public String getName() {
        return name;
    }

    public boolean getAbilities() {
        return abilities;
    }

    public int getAge() {
        return age;
    }

    public static int AvarageAge(Manager[] manager) { //статический метод подсчёта среднего возраста менеджеров
        int summ = 0;
        for (int i = 0; i < 4; i++) {
            summ += manager[i].age;
        }
        return summ / 4;
    }

    public static int hasAbilities(Manager []manager){
        int goodMan = 0;
        for (int i = 0; i < 4; i++)
            if (manager[i].abilities == true)
                goodMan++;
        return goodMan;
    }

    public void print(int i) { //метод для вывода введенной информации
        System.out.println(i + 1 + ") Имя и Фамилия менеджера: " + this.getName() + "\n" + "Возраст менеджера: " + this.getAge());
        if (this.getAbilities()) {
            System.out.println("Менеджер " + this.getName() + " справляется со своими обязанностями\n");
        }
        if (!this.getAbilities()) {
            System.out.println("Менеджер " + this.getName() + " не справляется со своими обязанностями\n");
        }
    }
}

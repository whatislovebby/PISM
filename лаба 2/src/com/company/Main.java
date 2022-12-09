package com.company;
import manager.Manager;


public class Main {
    public static void main(String[] args) {

        Manager ArrayOfManagers[] = new Manager[4];


        System.out.println("\nИнформация о менеджерах:\n");
        ArrayOfManagers[0] = new Manager();
        ArrayOfManagers[1]=new Manager("Томильчик Владислав",false, 20);
        ArrayOfManagers[2]=new Manager("Моховиков Иван", true, 21);
        ArrayOfManagers[3]=new Manager(ArrayOfManagers[1]);

        for(int i = 0; i < 4; i++){
            ArrayOfManagers[i].print(i);
        }

        System.out.println("Средний возраст менеджеров: "+ Manager.AvarageAge(ArrayOfManagers));

        System.out.println("Количество менеджеров, справляющихся со своими обязанностями: "+ Manager.hasAbilities(ArrayOfManagers));
    }
    }

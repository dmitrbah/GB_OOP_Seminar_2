import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 5, false);
        Cat cat2 = new Cat("Мурка", 20, false);
        Cat cat3 = new Cat("Василек", 30, false);
        Cat cat4 = new Cat("Снежок", 10, false);
        Cat cat5 = new Cat("Черныш", 50, false);

        ArrayList<Cat> cats = new ArrayList<>();

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);   

        Plate plate = new Plate(100);

        for (int i = 0; i < cats.size(); i++) {
            if (plate.getFood() >= cats.get(i).getAppetite()) {
                cats.get(i).eat(plate);
                cats.get(i).setFullness(true);
                System.out.println("Котик " + cats.get(i).getName() + " покушал!");
            } else {
                System.out.println("Котик " + cats.get(i).getName() + " не покушал!");
                System.out.println("Добавить еды в миску?");
                System.out.println("Y - Да, N - Нет");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                if (answer.equals("Y")) {
                    System.out.println("Сколько корма добавить?");
                    int additionalFood = scanner.nextInt();
                    plate.increaseFood(additionalFood);
                }
                scanner.close();
                i--;
            }
        }
        plate.info();
    }
}

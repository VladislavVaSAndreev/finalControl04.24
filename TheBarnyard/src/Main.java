import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AnimalsList animalsList = new AnimalsList();
        while (true) {
            System.out.println("Введите  животное или команду LIST:");
            String input = new Scanner(System.in).nextLine();
            if (animalsList.isName(input)) {
                if (animalsList.getAnimalByName(input).size() != 0) {
                    System.out.println(animalsList.getAnimalByName(input));
                    continue;
                }
                System.out.println("Такого животного нет.\n" +
                        "Введите через пробел комманды для животного " + "\"" + input + "\":");
                String phoneInput = new Scanner(System.in).nextLine();
                if (animalsList.isCommand(phoneInput)) {
                    animalsList.addAnimal(phoneInput, input);
                    System.out.println("Животное сохранено!");
                    continue;
                }
            } else if (input.equals("LIST")) {
                for (String contacts : animalsList.getAllAnimals()) {
                    System.out.println(contacts);
                }
                continue;
            }
            System.out.println("Неверный формат ввода");
        }
    }
}

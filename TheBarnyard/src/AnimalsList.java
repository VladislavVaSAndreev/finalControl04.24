import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AnimalsList {
    Map<String, String> animalsList = new TreeMap<>();

    public void addAnimal(String command, String name) {
        if (isName(name) && isCommand(command)) {
            animalsList.put(command, name);
        } else {
            System.out.println("Неверный формат ввода");
        }
    }

    public Set<String> getAnimalByName(String name) {
        Set<String> animalByName = new TreeSet<>();
        for (String key : animalsList.keySet()) {
            if (name.equals(animalsList.get(key))) {
                animalByName.add(animalsList.get(key) + " - " + key);
            }
        }
        return animalByName;
    }

    public Set<String> getAllAnimals() {
        Map<String, String> mapForEqualsAnimals = new TreeMap<>();
        Set<String> allAnimals = new TreeSet<>();

        for (Map.Entry<String, String> entry : animalsList.entrySet()) {
            if (mapForEqualsAnimals.containsKey(entry.getValue())) {
                String animal = mapForEqualsAnimals.get(entry.getValue());
                mapForEqualsAnimals.put(entry.getValue(), animal.concat(", ").concat(entry.getKey()));
            } else {
                mapForEqualsAnimals.put(entry.getValue(), entry.getKey());
            }
        }
        for (String key : mapForEqualsAnimals.keySet()) {
            allAnimals.add(key + " - " + mapForEqualsAnimals.get(key));
        }
        return allAnimals;
    }

    public boolean isName(String name) {
        Boolean isName = false;
        String regex = "[а-яА-я]+\\s?[а-яА-я]+?";
        if (name.matches(regex)) {
            isName = true;
        }
        return isName;
    }

    public boolean isCommand(String command) {
        Boolean isCommand = false;
        String regex = "[а-яА-я]+\\s?[а-яА-я]+?";
        if (command.matches(regex)) {
            isCommand = true;
        }
        return isCommand;
    }
}


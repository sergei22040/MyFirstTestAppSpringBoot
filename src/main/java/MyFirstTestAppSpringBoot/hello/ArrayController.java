package MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class ArrayController {

    private ArrayList<String> myControllerList = null;

    private HashMap<Integer, String> myControllerMap = null;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(name = "s") String s) {
        if (myControllerList == null) {
            myControllerList = new ArrayList<>();
            return "Инициализирован пустой ArrayList. Значение '" + s + "' не добавлено, так как это первый вызов.";
        }

        myControllerList.add(s);
        return "Значение '" + s + "' успешно добавлено. Текущий список: " + myControllerList.toString();
    }

    @GetMapping("/show-array")
    public ArrayList<String> showArrayList() {

        return myControllerList;
    }
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(name = "s") String s) {

        if (myControllerMap == null) {
            myControllerMap = new HashMap<>();
            return "Инициализирован пустой HashMap. Значение не добавлено.";
        }

        int nextId = myControllerMap.size();
        myControllerMap.put(nextId, s);

        return "Значение '" + s + "' успешно добавлено в HashMap под ключом " + nextId + ".";
    }
    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap() {

        return myControllerMap;
    }
    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int arrayListSize = (myControllerList != null) ? myControllerList.size() : 0;

        int hashMapSize = (myControllerMap != null) ? myControllerMap.size() : 0;

        return "Количество элементов в ArrayList: " + arrayListSize + ", в HashMap: " + hashMapSize;
    }
}
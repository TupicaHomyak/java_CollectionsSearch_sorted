package practice;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        //метод генерации «красивых» автомобильных номеров generateCoolNumbers()

        List<String> coolNumbers = new ArrayList<>(); //формируется список номеров в переменной
        String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        //массив, содержащий допустимые буквы для номеров
        int regionCount = 199;//регион (от 01 до 199);
        int count = 0; //кол-во элементов в коллекции
        //несколько вложенных циклов, где каждый цикл отвечает за одну часть номера:
        for (String x : letters) {
            for (int n = 0; n <= 9; n++) {
                for (String y : letters) {
                    for (String z : letters) {
                       for (int region = 1; region <= regionCount; region++) {
                            String number = x + n + n + n + y + z + String.format("%02d", region);
                            coolNumbers.add(number); //сгенерированные номера добавляются в список
                            count++;//колич-во элементов в коллекции растет

                            if (count >= 2000001) { //цикл прерывается и метод возвращает список
                                return coolNumbers;
                            }
                       }
                    }
                }
            }
        }
        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        //прямым перебором по ArrayList,
        for (String item : list) {  //проходит по каждому элементу списка
            if (item.equals(number)) {
                return true;  //Если найдено совпадение
            }
        }
        return false;  //в противном случае
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        //бинарным поиском по сортированному ArrayLis для поиска номера number
        int low = 0;  //В начале метод определяет нижнюю
        int high = sortedList.size() - 1;  //и верхнюю границы для поиска.
        while (low <= high) {  //запускаем цикл
            int mid = high / 2;  //находим значение индекса среднего элемента
            String item = sortedList.get(mid);  // само значение среднего  элемента
            int comparison = item.compareTo(number);  //Сравнение значения среднего элемента с искомым номером
            if (comparison == 0) {  //Если найдено совпадение, возвращаем true
                return true;
            } else if (comparison < 0) {
                //Если значение среднего элемента меньше искомого номера,
                // сужаем границы поиска до верхней половины списка
                low = mid + 1;
            } else {
                // Если значение среднего элемента больше искомого номера,
                // сужаем границы поиска до нижней половины списка
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        //поиском в HashSet,
        return hashSet.contains(number); //contains() проверяет наличие элемента в множестве
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        //поиском в TreeSet.
        return treeSet.contains(number);  //contains() проверяет наличие элемента в множестве
    }
}

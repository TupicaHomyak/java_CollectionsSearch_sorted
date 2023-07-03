package practice;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //создается список coolNumbersList, содержащий сгенерированные "красивые" номера
        // с помощью метода generateCoolNumbers()
        List<String> coolNumbersList = CoolNumbers.generateCoolNumbers();
        List<String> sortedCoolNumbersList = new ArrayList<>(coolNumbersList);  //создается отсортированный список
        Collections.sort(sortedCoolNumbersList);
        HashSet<String> coolNumbersHashSet = new HashSet<>(coolNumbersList);  //хэш-множество
        TreeSet<String> coolNumbersTreeSet = new TreeSet<>(coolNumbersList);  //дерево

        // Поиск и измерение времени выполнения
        String numberToFind = "С333СС197";  // заданный номер
        long startTime, endTime, duration;  // переменные для замера времени выполнения

        // Поиск перебором
        startTime = System.nanoTime();
        boolean bruteForceResult = CoolNumbers.bruteForceSearchInList(coolNumbersList, numberToFind);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Поиск перебором: номер " + (bruteForceResult ? "найден" : "не найден") + ", поиск занял " + duration + "нс");

        // Бинарный поиск
        startTime = System.nanoTime();
        boolean binarySearchResult = CoolNumbers.binarySearchInList(sortedCoolNumbersList, numberToFind);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Бинарный поиск: номер " + (binarySearchResult ? "найден" : "не найден") + ", поиск занял " + duration + "нс");

        // Поиск в HashSet
        startTime = System.nanoTime();
        boolean hashSetSearchResult = CoolNumbers.searchInHashSet(coolNumbersHashSet, numberToFind);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Поиск в HashSet: номер " + (hashSetSearchResult ? "найден" : "не найден") + ", поиск занял " + duration + "нс");

        // Поиск в TreeSet
        startTime = System.nanoTime();
        boolean treeSetSearchResult = CoolNumbers.searchInTreeSet(coolNumbersTreeSet, numberToFind);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Поиск в TreeSet: номер " + (treeSetSearchResult ? "найден" : "не найден") + ", поиск занял " + duration + "нс");
    }

}

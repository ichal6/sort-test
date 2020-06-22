import java.io.IOException;
import java.util.List;

public class Main {
    private static InputManager inputManager = new InputManager();
    private static TypeSort typeSort;

    public static void main(String[] args) {
        String[] paths = FileOperation.searchFiles();
        String path = "src/main/resources/";
        path += chooseFile(paths);
        while(menu(path));
    }

    private static boolean menu(String path){
        System.out.println("1. Insertion sort\n2. Quick sort\n0.exit");
        int option = inputManager.getIntInput("Please provide number of option:");

        switch (option){
            case 0:
                return false;
            case 1:
                typeSort = TypeSort.INSERTSORT;
                testForInsertionSort(path);
                break;
            case 2:
                typeSort = TypeSort.QUICKSORT;
                testForQuickSort(path);
                break;
            default:
                System.out.println("You put incorrect option!");
        }
        return true;
    }

    private static String chooseFile(String[] paths){
        int count = 0;
        for(String fileName : paths) {
            System.out.println(count + ". " +fileName);
            count++;
        }
        int option = inputManager.getIntInput("Please provide number of option:");
        return paths[option];
    }

    private static void testForInsertionSort(String path){
        try{
            System.out.println("Time for simple array:");
            loadToArray(path, TypeList.SIMPLEARRAY);
            System.out.println("Time for ArrayList:");
            loadToArray(path, TypeList.ARRAYLIST);
            System.out.println("Time for LinkedList:");
            loadToArray(path, TypeList.LINKEDLIST);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void testForQuickSort(String path){
        try{
            System.out.println("Time for simple array:");
            loadToArray(path, TypeList.SIMPLEARRAY);
            System.out.println("Time for ArrayList:");
            loadToArray(path, TypeList.ARRAYLIST);
            System.out.println("Time for LinkedList:");
            loadToArray(path, TypeList.LINKEDLIST);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void loadToArray(String args, TypeList type) throws IOException{
        List<Integer> numbers;
        switch (type){
            case ARRAYLIST:
                numbers = readFromFileArrayList(args);
                runAlgorithm(args, numbers);
                break;
            case LINKEDLIST:
                numbers = readFromFileLinkedList(args);
                runAlgorithm(args, numbers);
                break;
            case SIMPLEARRAY:
                Integer[] numbersAsArray = readFromFileArray(args);
                runAlgorithmWithArray(args, numbersAsArray);
                break;
        }
    }

    private static List<Integer> readFromFileArrayList(String args) throws IOException{
        long timeRun = startTime();
        List<Integer> list = FileOperation.readFromFileAsArrayList(args);
        System.out.println(String.format("time of read from file: %.0f ms", stopTime(timeRun)));
        return list;
    }

    private static List<Integer> readFromFileLinkedList(String args) throws IOException{
        long timeRun = startTime();
        List<Integer> list = FileOperation.readFromFileAsLinkedList(args);
        System.out.println(String.format("time of read from file: %.0f ms", stopTime(timeRun)));
        return list;
    }

    private static Integer[] readFromFileArray(String args) throws IOException{
        long timeRun = startTime();
        Integer[] array = FileOperation.readFromFile(args);
        System.out.println(String.format("time of read from file: %.0f ms", stopTime(timeRun)));
        return array;
    }

    private static void runAlgorithm(String args, List<Integer> numbers) throws IOException{
        long timeRun = startTime();
        switch (typeSort){
            case INSERTSORT:
                numbers = SortAlgorithm.insertSort(numbers);
                break;
            case QUICKSORT:
                numbers = SortAlgorithm.quicksort(numbers,0, numbers.size() - 1);
                break;
        }

        System.out.println(String.format("time of sort: %.0f ms", stopTime(timeRun)));
        timeRun = startTime();
        String pathToSave = args.substring(0, args.length() - 4);
        pathToSave += "_ordered.txt";
        FileOperation.saveToFile(pathToSave, numbers);
        System.out.println(String.format("time of save to file: %.0f ms", stopTime(timeRun)));
    }

    private static void runAlgorithmWithArray(String args, Integer[] numbers) throws IOException{
        long timeRun = startTime();
        switch (typeSort){
            case INSERTSORT:
                numbers = SortAlgorithm.insertSort(numbers);
                break;
            case QUICKSORT:
                numbers = SortAlgorithm.quicksort(numbers, 0, numbers.length - 1);
                break;
        }
        System.out.println(String.format("time of sort: %.0f ms", stopTime(timeRun)));
        timeRun = startTime();
        String pathToSave = args.substring(0, args.length() - 4);
        pathToSave += "_ordered.txt";
        FileOperation.saveToFile(pathToSave, numbers);
        System.out.println(String.format("time of save to file: %.0f ms", stopTime(timeRun)));
    }

    private static long startTime(){
        return System.nanoTime();
    }

    private static Double stopTime(long startTime){
        long endTime = System.nanoTime();
        Double start = Double.valueOf(startTime);
        Double end = Double.valueOf(endTime);
        return (end - start)/1000000.0;
    }
}

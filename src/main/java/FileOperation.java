import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileOperation {
    public static boolean checkFile(String path){
        File file = new File(path);
        return file.exists();
    }

    public static String[] searchFiles(){
        String path = "src/main/resources";

        File f = new File(path);

        return f.list();
    }

    public static Integer[] readFromFile(String filename) throws IOException {
        List<Integer> contentFromFile = new ArrayList<>();

        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));

        while (br.ready()){
            contentFromFile.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        return contentFromFile.toArray(new Integer[0]);
    }

    public static ArrayList<Integer> readFromFileAsArrayList(String filename) throws IOException {
        ArrayList<Integer> contentFromFile = new ArrayList<>();

        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));

        while (br.ready()){
            contentFromFile.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        return contentFromFile;
    }

    public static LinkedList<Integer> readFromFileAsLinkedList(String filename) throws IOException {
        LinkedList<Integer> contentFromFile = new LinkedList<>();

        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));

        while (br.ready()){
            contentFromFile.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        return contentFromFile;
    }

    public static void saveToFile(String filename, Integer[] numbers) throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for(Integer number: numbers)
                writer.write(String.format("%d\n", number));

            writer.close();

    }

    public static void saveToFile(String filename, List<Integer> numbers) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for(Integer number: numbers)
            writer.write(String.format("%d\n", number));

        writer.close();

    }
}

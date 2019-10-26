import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("unsorteddict.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("sortededdict.txt"));

        LinkedList<String> dictionary = new LinkedList<String>();
        String line;
        String tempLine = "";
        int index = 0;


        while ((line = br.readLine()) != null) {
            dictionary.add(line);
            if (index > 1) {
                int test = line.compareToIgnoreCase(tempLine);
                if (test < 0) {
                    dictionary.remove(line);
                    dictionary.add(dictionary.indexOf(tempLine), line);
                    System.out.println(dictionary);
                }
                else {
                    tempLine = line;
                }
            }
            else if (index == 1){
                int test = line.compareToIgnoreCase(tempLine);
                if (test < 0) {
                    dictionary.remove(line);
                    dictionary.addFirst(line);
                    System.out.println(dictionary);
                }
            }
            else{
                tempLine = line;
            }
            bw.write(line);
            bw.newLine();
            index++;
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class UserArgumentClass {

    public static void userArguments(LinkedList<Node> dictionary){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter from 0 to 10 commands separated by a space:");
        String userInput = scan.nextLine();
        scan.close();
        String[] individualUserInput = userInput.split(" ");
        if (individualUserInput.length > 10){
            System.out.println("Invalid number of commands! Ending program...");
        }

        else{
            for (int i = 0; i < individualUserInput.length ; i++){

                try {
                    long timeElapsedInFileComparison = System.currentTimeMillis();
                    if (Integer.parseInt(individualUserInput [i]) == -1) {
                        BufferedReader readSortByProgramFile = new BufferedReader(new FileReader("/Users/vhoyospoyato/PairProg/Sortedbyprogram.txt"));
                        BufferedReader readSortedDictTestFile = new BufferedReader(new FileReader("/Users/vhoyospoyato/PairProg/sortedDictTest.txt"));

                        String eachLineSortedByProgramFile = readSortByProgramFile.readLine();
                        String eachLineSortedDictTestFile = readSortedDictTestFile.readLine();

                        boolean areEqual = true;
                        int indexPositionOfLineByNumber = 1;

                        while (eachLineSortedByProgramFile != null || eachLineSortedDictTestFile != null) {
                            if (eachLineSortedByProgramFile == null || eachLineSortedDictTestFile == null) {
                                areEqual = false;
                                break;
                            } else if (!eachLineSortedByProgramFile.equalsIgnoreCase(eachLineSortedDictTestFile)) {
                                areEqual = false;
                                break;
                            }

                            eachLineSortedByProgramFile = readSortByProgramFile.readLine();
                            eachLineSortedDictTestFile = readSortedDictTestFile.readLine();
                            indexPositionOfLineByNumber++;
                        }

                        if (areEqual) {
                            System.out.println("Two files have same content.");
                        } else {
                            System.out.println("Two files have different content. They differ at line " + indexPositionOfLineByNumber);
                            System.out.println("Sortedbyprogram has " + eachLineSortedByProgramFile + " and sortedDictTest has " + eachLineSortedDictTestFile + " at line " + indexPositionOfLineByNumber);
                        }

                        readSortByProgramFile.close();

                        readSortedDictTestFile.close();
                    } else {

                        System.out.println(dictionary.get(Integer.parseInt(individualUserInput[i])).data);
                    }
                    System.out.print("Compare time taken: ");
                    System.out.print(System.currentTimeMillis() - timeElapsedInFileComparison);
                    System.out.println(" milliseconds.");
                }

                catch (Exception e){
                    for (int j = 0; j < dictionary.size(); j++){
                        if (individualUserInput[i].compareToIgnoreCase(dictionary.get(j).data) == 0){
                            System.out.println(j+1);
                            break;
                        }
                        if (j == dictionary.size() - 1){
                            System.out.println(-1);
                        }
                    }
                }
            }
        }


    }

}

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


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
                    System.out.print(System.currentTimeMillis() - timeElapsedInFileComparison);   //Prints total sorting time
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


    public static void main(String[] args) throws IOException {
        long timeElapsedForDictSorting = System.currentTimeMillis();                            //Timer starts.
        File fileToBeSorted = new File("unsortedDictTest.txt");
        BufferedReader unsortedFileReader = new BufferedReader(new FileReader(fileToBeSorted));
        BufferedWriter sortedFileWriter = new BufferedWriter(new FileWriter("Sortedbyprogram.txt"));

        LinkedList<Node> dictionary = new LinkedList<Node>();
        Node head = null;
        String eachLineUnsortedDictTest;

        while ((eachLineUnsortedDictTest = unsortedFileReader.readLine()) != null) {
            if (dictionary.isEmpty()) {
                head = new Node(eachLineUnsortedDictTest);
                dictionary.add(head);
            }
            else {
                head = dictionary.getFirst();
                if (head.next == null) {
                    if (head.data.compareToIgnoreCase(eachLineUnsortedDictTest) > 0) {
                        Node temp = head;
                        head = new Node(eachLineUnsortedDictTest);
                        head.next = temp;
                        dictionary.addFirst(head);
                    }
                    else {
                        Node temp = new Node(eachLineUnsortedDictTest);
                        head.next = temp;
                        dictionary.add(temp);
                    }
                }
                else {
                    Node current = head;
                    int index = 0;
                    while (current.next != null){
                        if (current.data.compareToIgnoreCase(eachLineUnsortedDictTest) > 0) {
                            Node temp = new Node(eachLineUnsortedDictTest);
                            temp.next = current;
                            if (index > 0){
                                dictionary.get(index - 1).next = temp;
                            }
                            dictionary.add(index, temp);
                            break;
                        }
                        else{
                            current = current.next;
                            if (current.next == null){
                                Node temp = new Node(eachLineUnsortedDictTest);
                                if (current.data.compareToIgnoreCase(eachLineUnsortedDictTest) > 0){
                                    temp.next = current;
                                    dictionary.get(index).next = temp;
                                    dictionary.add(index + 1, temp);
                                }
                                else{
                                    dictionary.getLast().next = temp;
                                    dictionary.addLast(temp);
                                }
                                break;
                            }
                            index ++;
                        }
                    }
                }
            }
        }
        System.out.print("Time taken: ");
        System.out.print(System.currentTimeMillis() - timeElapsedForDictSorting);   //Prints total sorting time
        System.out.println(" milliseconds.");

        unsortedFileReader.close();

        for (int i = 0; i < dictionary.size(); i++) {
            sortedFileWriter.write(dictionary.get(i).data);
            sortedFileWriter.newLine();
        }

        sortedFileWriter.close();

        performance();

        userArguments(dictionary);                              //Execute method for user to enter arguments
    }

    public static void performance() throws IOException {

        long time = 0;

        for (int i = 0; i < 10; i++) {

            long start = System.currentTimeMillis();


                    BufferedReader reader1 = new BufferedReader(new FileReader("/Users/vhoyospoyato/PairProg/Sortedbyprogram.txt"));
                    BufferedReader reader2 = new BufferedReader(new FileReader("/Users/vhoyospoyato/PairProg/sortedDictTest.txt"));

                    String line1 = reader1.readLine();
                    String line2 = reader2.readLine();

                    boolean areEqual = true;
                    int lineNum = 1;

                    while (line1 != null || line2 != null) {
                        if (line1 == null || line2 == null) {
                            areEqual = false;
                            break;
                        } else if (!line1.equalsIgnoreCase(line2)) {
                            areEqual = false;
                            break;
                        }

                        line1 = reader1.readLine();
                        line2 = reader2.readLine();
                        lineNum++;
                    }

                    if (areEqual) {
                        System.out.println("Two files have same content.");
                    } else {
                        System.out.println("Two files have different content. They differ at line " + lineNum);
                        System.out.println("Sortedbyprogram has " + line1 + " and sortedDictTest has " + line2 + " at line " + lineNum);
                    }

                    reader1.close();

                    reader2.close();



            long end = System.currentTimeMillis();
            long test = end - start;
            time = time + test;
            }


        System.out.println("Average time: " + (time/10));

    }
}


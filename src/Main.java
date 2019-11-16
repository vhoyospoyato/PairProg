import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    public static void userArguments(LinkedList<Node> dictionary){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter from 0 to 10 commands separated by a space:");
        String argument = scan.nextLine();
        scan.close();
        String[] commands = argument.split(" ");
        if (commands.length > 10){
            System.out.println("Invalid number of commands! Ending program...");
        }

        else{
            for (int i = 0; i < commands.length ; i++){

                try {
                    long compare = System.currentTimeMillis();
                    if (Integer.parseInt(commands [i]) == -1) {
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
                    } else {

                        System.out.println(dictionary.get(Integer.parseInt(commands[i])).data);
                    }
                    System.out.print("Compare time taken: ");
                    System.out.print(System.currentTimeMillis() - compare);   //Prints total sorting time
                    System.out.println(" milliseconds.");
                }

                catch (Exception e){
                    for (int j = 0; j < dictionary.size(); j++){
                        if (commands[i].compareToIgnoreCase(dictionary.get(j).data) == 0){
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
        long startElapsedSeconds = System.currentTimeMillis();                            //Timer starts.
        File fileToBeProcessed = new File("unsortedDictTest.txt");
        BufferedReader fileToBeRead = new BufferedReader(new FileReader(fileToBeProcessed));
        BufferedWriter fileToBeWritten = new BufferedWriter(new FileWriter("Sortedbyprogram.txt"));

        LinkedList<Node> dictionary = new LinkedList<Node>();
        Node head = null;
        String line;

        while ((line = br.readLine()) != null) {
            if (dictionary.isEmpty()) {
                head = new Node(line);
                dictionary.add(head);
            }
            else {
                head = dictionary.getFirst();
                if (head.next == null) {
                    if (head.data.compareToIgnoreCase(line) > 0) {
                        Node temp = head;
                        head = new Node(line);
                        head.next = temp;
                        dictionary.addFirst(head);
                    }
                    else {
                        Node temp = new Node(line);
                        head.next = temp;
                        dictionary.add(temp);
                    }
                }
                else {
                    Node current = head;
                    int index = 0;
                    while (current.next != null){
                        if (current.data.compareToIgnoreCase(line) > 0) {
                            Node temp = new Node(line);
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
                                Node temp = new Node(line);
                                if (current.data.compareToIgnoreCase(line) > 0){
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
        System.out.print(System.currentTimeMillis() - startElapsedSeconds);   //Prints total sorting time
        System.out.println(" milliseconds.");

        fileToBeRead.close();

        for (int i = 0; i < dictionary.size(); i++) {
            fileToBeWritten.write(dictionary.get(i).data);
            fileToBeWritten.newLine();
        }

        fileToBeWritten.close();

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


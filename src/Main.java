import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    // Arguments: User inputs 0 to 10 args to retrieve information from sorted dictionary.
    public static void userArguments(LinkedList<Node> dictionary){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter from 0 to 10 commands separated by a space:");
        String argument = scan.nextLine();
        scan.close();
        String[] commands = argument.split(" ");
        long argTime = System.currentTimeMillis();
        if (commands.length > 10){
            System.out.println("Invalid number of commands! Ending program...");
        }
        else{
            for (int i = 0; i < commands.length ; i++){
                try{
                    System.out.println(dictionary.get(Integer.parseInt(commands[i])).data);
                }
                catch (Exception e){
                    for (int j = 0; j < dictionary.size(); j++){
                        if (commands[i].compareToIgnoreCase(dictionary.get(j).data) == 0){
                            System.out.println(j);
                            break;
                        }
                        if (j == dictionary.size() - 1){
                            System.out.println(-1);
                        }
                    }
                }
            }
        }
        System.out.print("Arguments time taken: ");
        System.out.print(System.currentTimeMillis() - argTime);   //Prints total sorting time
        System.out.println(" milliseconds.");
    }


    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();                                            //Timer starts.
        File file = new File("unsortedDictTest.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("sortededdict.txt"));

        LinkedList<Node> dictionary = new LinkedList<Node>();
        Node head = null;
        String line;

        while ((line = br.readLine()) != null) {
            long addDic = System.currentTimeMillis();
            if (dictionary.isEmpty()) {
                head = new Node(line);
                dictionary.add(head);                           //First node inserted in dictionary
                System.out.print("First node add time taken: ");
                System.out.print(System.currentTimeMillis() - addDic);   //Prints total sorting time
                System.out.println(" milliseconds.");
            }

            else {
                long addSecond = System.currentTimeMillis();
                head = dictionary.getFirst();
                if (head.next == null) {                        //Checks if there is a second value in dictionary
                    if (head.data.compareToIgnoreCase(line) > 0) {
                        Node temp = head;
                        head = new Node(line);
                        head.next = temp;
                        dictionary.addFirst(head);              //Enters new node as first and pushes other to second
                    }
                    else {
                        Node temp = new Node(line);
                        head.next = temp;
                        dictionary.add(temp);                   //Enters new node as second
                    }
                    System.out.print("Second node add time taken: ");
                    System.out.print(System.currentTimeMillis() - addSecond);   //Prints total sorting time
                    System.out.println(" milliseconds.");
                }

                else {
                    Node current = head;
                    int index = 0;
                    while (current.next != null){
                        if (current.data.compareToIgnoreCase(line) > 0) { //Check if word comes before in alphabet
                            Node temp = new Node(line);
                            temp.next = current;
                            if (index > 0){                               //For every value, except first
                                dictionary.get(index - 1).next = temp;
                            }
                            dictionary.add(index, temp);                  //Add node to correct alphabetical position
                            break;
                        }
                        else{
                            current = current.next;             //If words comes later in the alphabet move to next node
                            if (current.next == null){
                                Node temp = new Node(line);
                                dictionary.getLast().next = temp;
                                dictionary.addLast(temp);       //Add node in last position
                                break;
                            }
                            index ++;
                        }
                    }

                }

            }
        }

        System.out.print("Rest nodes added time taken: ");
        System.out.print(System.currentTimeMillis() - start);   //Prints total sorting time
        System.out.println(" milliseconds.");

        br.close();

        for (int i = 0; i < dictionary.size(); i++) {
            bw.write(dictionary.get(i).data);
            bw.newLine();
        }
        bw.close();

        performance();

        userArguments(dictionary);                              //Execute method for user to enter arguments
    }

    public static void performance() throws IOException {

        long time = 0;

        for (int i = 0; i < 10; i++) {

            long start = System.currentTimeMillis();                                            //Timer starts.
            File file = new File("unsortedDictTest.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter("sortededdict.txt"));

            LinkedList<Node> dictionary = new LinkedList<Node>();
            Node head = null;
            String line;

            while ((line = br.readLine()) != null) {
                if (dictionary.isEmpty()) {
                    head = new Node(line);
                    dictionary.add(head);                           //First node inserted in dictionary
                }

                else {
                    head = dictionary.getFirst();
                    if (head.next == null) {                        //Checks if there is a second value in dictionary
                        if (head.data.compareToIgnoreCase(line) > 0) {
                            Node temp = head;
                            head = new Node(line);
                            head.next = temp;
                            dictionary.addFirst(head);              //Enters new node as first and pushes other to second
                        }
                        else {
                            Node temp = new Node(line);
                            head.next = temp;
                            dictionary.add(temp);                   //Enters new node as second
                        }
                    }

                    else {
                        Node current = head;
                        int index = 0;
                        while (current.next != null){
                            if (current.data.compareToIgnoreCase(line) > 0) { //Check if word comes before in alphabet
                                Node temp = new Node(line);
                                temp.next = current;
                                if (index > 0){                               //For every value, except first
                                    dictionary.get(index - 1).next = temp;
                                }
                                dictionary.add(index, temp);                  //Add node to correct alphabetical position
                                break;
                            }
                            else{
                                current = current.next;             //If words comes later in the alphabet move to next node
                                if (current.next == null){
                                    Node temp = new Node(line);
                                    dictionary.getLast().next = temp;
                                    dictionary.addLast(temp);       //Add node in last position
                                    break;
                                }
                                index ++;
                            }
                        }

                    }

                }

            }
            long end = System.currentTimeMillis();
            long test = end - start;
            time = time + test;
        }

        System.out.println("Average time: " + (time/10));

    }
}

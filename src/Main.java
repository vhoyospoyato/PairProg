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
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        File file = new File("unsorteddict.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("sortededdict.txt"));

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
                                dictionary.getLast().next = temp;
                                dictionary.addLast(temp);
                                break;
                            }
                            index ++;
                        }
                    }
                }
            }
        }
        br.close();

        for (int i = 0; i < dictionary.size(); i++) {
            bw.write(dictionary.get(i).data);
            bw.newLine();
        }

        bw.close();
        System.out.print("Time taken: ");
        System.out.print(System.currentTimeMillis() - start);
        System.out.println(" milliseconds.");
        userArguments(dictionary);
    }
}

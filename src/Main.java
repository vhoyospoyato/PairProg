import java.io.*;
import java.util.LinkedList;


public class Main {

    public static void main(String[] args) throws IOException {
        long timeElapsedForDictSorting = System.currentTimeMillis();
        File fileToBeSorted = new File("unsortedDictTest.txt");
        BufferedReader unsortedFileReader = new BufferedReader(new FileReader(fileToBeSorted));
        BufferedWriter sortedFileWriter = new BufferedWriter(new FileWriter("Sortedbyprogram.txt"));

        LinkedList<Node> dictionary = new LinkedList<Node>();
        Node head = null;
        String eachLineUnsortedDictTest;

        while ((eachLineUnsortedDictTest = unsortedFileReader.readLine()) != null) {
            if (dictionary.isEmpty()) {
                dictionary = addFirstNodeToDictionary(head,eachLineUnsortedDictTest, dictionary );
            }
            else {
                head = dictionary.getFirst();
                if (head.next == null) {
                    if (head.data.compareToIgnoreCase(eachLineUnsortedDictTest) > 0) {
                        dictionary = addSecondNodeAsFirstToDictionary(head, eachLineUnsortedDictTest, dictionary);
                    }
                    else {
                        dictionary = addSecondNodeAsLastToDictionary(head, eachLineUnsortedDictTest, dictionary);
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
        System.out.print(System.currentTimeMillis() - timeElapsedForDictSorting);
        System.out.println(" milliseconds.");

        unsortedFileReader.close();

        for (int i = 0; i < dictionary.size(); i++) {
            sortedFileWriter.write(dictionary.get(i).data);
            sortedFileWriter.newLine();
        }

        sortedFileWriter.close();

        TestingClass.performanceTestingForProgram();

        UserArgumentClass.userArguments(dictionary);
    }

    public static LinkedList<Node> addFirstNodeToDictionary(Node head, String eachLineUnsortedDictTest, LinkedList<Node> dictionary){
        head = new Node(eachLineUnsortedDictTest);
        dictionary.add(head);
        return dictionary;
    }

    public static LinkedList<Node> addSecondNodeAsFirstToDictionary(Node head, String eachLineUnsortedDictTest, LinkedList<Node> dictionary){
        Node temp = head;
        head = new Node(eachLineUnsortedDictTest);
        head.next = temp;
        dictionary.addFirst(head);
        return dictionary;
    }

    public static LinkedList<Node> addSecondNodeAsLastToDictionary(Node head, String eachLineUnsortedDictTest, LinkedList<Node> dictionary){
        Node temp = new Node(eachLineUnsortedDictTest);
        head.next = temp;
        dictionary.add(temp);
        return dictionary;
    }

}


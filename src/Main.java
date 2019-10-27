import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
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
        for (int i = 0; i < dictionary.size(); i++) {
            bw.write(dictionary.get(i).data);
            bw.newLine();
        }
    }
}

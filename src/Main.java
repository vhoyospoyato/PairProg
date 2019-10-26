import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("unsorteddict.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("sortededdict.txt"));

        LinkedList<Node> dictionary = new LinkedList<Node>();
        String line;
        String tempLine = "";
        Node head = null;

        while ((line = br.readLine()) != null) {
            if (head == null)
            {
                head = new Node(line);
                dictionary.add(head);
                start = false;
            }
            else{
                Node current = head;
                Node previous;
                    while(current.next != null){
                        if (current.data.compareToIgnoreCase(head.data) < 0){
                            head.next = current;
                            previous = current;
                        }
                        current = current.next;
                    }
            }
            bw.write(line);
            bw.newLine();
        }
        System.out.println(dictionary.get(0).data);
    }
}

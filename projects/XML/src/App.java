import java.io.File;
import java.util.Scanner;

public class App {

    private static Queue queue1;
    private static Queue queue2;

    public static void main(String[] args) throws Exception {
        
        File absolute = new File("");
        String absolutePath = absolute.getAbsolutePath();
        String fullPath = absolutePath + "\\input.xml";
        Scanner file = new Scanner(new File(fullPath));
        queue1 = new Queue();
        queue2 = new Queue();
        boolean tags = true;
        
        while (file.hasNextLine()) {
            String line = file.nextLine();
            
            for (int pos = 0; pos < line.length(); pos++) {

                if (line.charAt(pos) == '<') {
                    pos++;
                    String tag = "";

                    while (line.charAt(pos) != '>') {
                        tag += line.charAt(pos);
                        pos++;
                    }

                    if (tag.startsWith("/")) {

                        String closingTag = tag.substring(1);

                        if (queue1.peek() == null) {
                            tags = false;
                        } else if (queue1.peek().equals(closingTag)) {
                            queue1.dequeue();
                        } else {
                            tags = false;
                        }

                    } else {
                        add(tag);
                    }
                }
            }

            if (tags != true) {
                break;
            }
        }

        if(queue1.peek() != null || tags != true) {
            System.out.println("The file isnt correct");
        } else {
            System.out.println("The file is correct closed!");
        }
    }

    public static void add(String tag) {
        if (queue1.peek() == null) {
            queue1.enqueue(tag);
        } else {
           
            while(queue1.peek() != null) {
                String top = queue1.peek();
                queue2.enqueue(top);
                queue1.dequeue();
            }
           
            queue1.enqueue(tag);

            while(queue2.peek() != null) {
                String top = queue2.peek();
                queue1.enqueue(top);
                queue2.dequeue();
            }
        }
    }

}

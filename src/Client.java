
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try (Socket client = new Socket("127.0.0.1", 8080)) {

                System.err.println("MENU");
                System.err.println("1 - add Pages");
                System.err.println("2 - Show Pages");
                System.err.println("4 - Delete Pages");
                System.err.println("3 - Exit the phonebook");

                int operation = scanner.nextInt();

                PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                writer.write(operation + "\n");
                writer.flush();

                if (operation == 2) {

                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.err.println(line);
                    }

                    reader.close();
                } else if (operation == 4) {

                    System.out.println("Enter delete index");
                    int delete = scanner.nextInt();
                    writer.write(delete + "\n");
                }

                writer.close();
            }
        }
    }
}

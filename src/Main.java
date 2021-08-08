import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            Calculate.calc(line);
        }
    }
}

package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).equals("exit")) {
            try {
                Calculate.calc(line);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

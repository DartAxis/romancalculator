import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {
    public static void calc(String line) throws Exception {
        line = line.toUpperCase();
        boolean isArabic = match(line, "^\\d{1,2}[\\s+,\\s-,\\s/,\\s*]\\d{1,2}$");
        boolean isRoman = match(line, "^[VIX]{1,4}[\\s+,\\s-,\\s/,\\s*][VIX]{1,4}$");
        if (!isArabic && !isRoman) {
            throw new Exception("Неверный формат входных данных");
        }
        String[] numbers = line.split("\\W");
        String operation =getOperation(line);
        Integer result = 0;
        if (isArabic) {
            if(Integer.parseInt(numbers[0]) < 11 && Integer.parseInt(numbers[1]) < 11){
                result = calculate(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), operation);
                System.out.println(line + "=" + result);
            }else {
                throw new Exception("Неверные входные параметры!!!Введены слишком большие числа");
            }
        }
        if (isRoman) {
            if(Converter.fromRomanToArabic(numbers[0]) < 11 && Converter.fromRomanToArabic(numbers[1]) < 11){
                result = calculate(Converter.fromRomanToArabic(numbers[0]), Converter.fromRomanToArabic(numbers[1]), operation);
            }else {
                throw new Exception("Неверные входные параметры!!!Введены слишком большие числа");
            }
            if (result > 1) {
                System.out.println(line + "=" + Converter.fromArabicToRoman(result));
            } else {
                throw new Exception("Результат вычисления в римских числах не может быть меньше 1");
            }
        }
    }

    private static Boolean match(String line, String mask) {
        Pattern pattern = Pattern.compile(mask);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    private static Integer calculate(Integer operand1, Integer operand2, String operation) {
        switch (operation) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
        }
        return 0;
    }

    private static String getOperation(String line){
        Pattern pattern = Pattern.compile("\\b[\\s+,\\s-,\\s/,\\s*]");
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return line.substring(matcher.start(), matcher.end());
    }
}

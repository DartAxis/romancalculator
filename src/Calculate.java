import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {
    public static void calc(String line) throws Exception {
        //вставляем проверку на арбские или римские цифры
        line=line.toUpperCase();
        Boolean isArabic = match(line,"^\\d{1,2}[\\s+,\\s-,\\s/,\\s*]\\d{1,2}$");
        Boolean isRoman = match(line,"^[VIX]{1,4}[\\s+,\\s-,\\s/,\\s*][VIX]{1,4}$");
        if(!isArabic&&!isRoman){
            throw new Exception("Неверный формат входных данных");
        }
        String[] numbers = line.split("\\W");
        Integer result=0;

        if(isArabic){
            if(line.contains("+")){
                result=Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]);
            }
            if(line.contains("-")){
                result=Integer.parseInt(numbers[0])-Integer.parseInt(numbers[1]);
            }
            if(line.contains("*")){
                result=Integer.parseInt(numbers[0])*Integer.parseInt(numbers[1]);
            }
            if(line.contains("/")){
                result=Integer.parseInt(numbers[0])/Integer.parseInt(numbers[1]);
            }
            System.out.println(line+"="+result);
        }

        if(isRoman){
            if(line.contains("+")){
                result=Converter.fromRomanToArabic(numbers[0])+Converter.fromRomanToArabic(numbers[1]);
            }
            if(line.contains("-")){
                result=Converter.fromRomanToArabic(numbers[0])-Converter.fromRomanToArabic(numbers[1]);
            }
            if(line.contains("*")){
                result=Converter.fromRomanToArabic(numbers[0])*Converter.fromRomanToArabic(numbers[1]);
            }
            if(line.contains("/")){
                result=Converter.fromRomanToArabic(numbers[0])/Converter.fromRomanToArabic(numbers[1]);
            }
            if(result>1) {
                System.out.println(line + "=" + Converter.fromArabicToRoman(result));
            } else {
                throw new Exception("Результат вычисления в римских числах не может быть меньше 1");
            }
        }

    }

    private static Boolean match(String line, String mask){
        Pattern pattern = Pattern.compile(mask);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}

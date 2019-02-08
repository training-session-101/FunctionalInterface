package chaining;

import java.util.function.Function;

public class UtilityFunction {

    private static String addHeader(String text){
        return " Hello "+text;
    }

    private static String addFooter(String text){
        return text+" Regards Iftekhar ";
    }

    private static String checkSpelling(String text){
        return text.contains("lamba")? text.replace("lamba","Lambda") : text;
    }

    public static void main(String[] args) {
        String s="lamba data";
        Function<String,String> header = UtilityFunction::addHeader;
        Function<String,String> spellingChecker = header.andThen(UtilityFunction::checkSpelling);
        Function<String,String> addFooter = spellingChecker.andThen(UtilityFunction::addFooter);

        System.out.println(addFooter.apply(s));


    }



}

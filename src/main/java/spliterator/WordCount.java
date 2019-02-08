package spliterator;

public class WordCount {
    public static void main(String[] args) {
        String s="My name  is khan ";
        System.out.println(new WordCount().wordsCount(s));
    }

    int wordsCount(String s){
         boolean whiteSpace=false;
         int counter=0;
        for(char c:s.toCharArray()){
            if(Character.isWhitespace(c)){
                whiteSpace=true;
            }
            else{
                if(whiteSpace)
                    counter++;
                whiteSpace=false;
            }
        }
        return counter;
    }
}

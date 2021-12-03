public class Day2 {

    static Integer horizontal = 0;
    static Integer depth = 0;
    static Integer aim = 0;

    public static void main1(String[] args) {
        for(String step : args){
            if(step.contains("forward")) horizontal += Integer.valueOf(step.substring(step.length()-1));
            else if(step.contains("down")) depth += Integer.valueOf(step.substring(step.length()-1));
            else if(step.contains("up")) depth -= Integer.valueOf(step.substring(step.length()-1));
        }
        System.out.println(horizontal*depth);
    }

    public static void main(String[] args) {
        for(String step : args){

            Integer actualNumber = Integer.valueOf(step.substring(step.length()-1));

            if(step.contains("forward")) {horizontal += actualNumber; depth += aim*actualNumber; }
            else if(step.contains("down")) {aim += actualNumber; }
            else if(step.contains("up")) {aim -= actualNumber;}
        }
        System.out.println(horizontal*depth);
    }
}

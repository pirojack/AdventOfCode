import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3_2 {

    static int index=0;

    public static void main(String[] args) {
        String oxygen = Rating("oxygen",args);
        index = 0;
        String CO2 = Rating("notOxygen",args);

        Integer oxygenRate = Integer.parseInt(oxygen,2);
        Integer co2Rate = Integer.parseInt(CO2,2);

        System.out.println(oxygenRate*co2Rate);

    }

    static String Rating(String type,String[] args) {

        List<String> listOfRemainingBits = new ArrayList<>(Arrays.asList(args));
        List<String> copyOfListOfRemainingBits = new ArrayList<>();

        String lookingFor1or2;

        while (listOfRemainingBits.size()>1) {

            lookingFor1or2 = isOneOrNullMostCommon(type,listOfRemainingBits);
            for(String bits : listOfRemainingBits){
                if(!bits.substring(index,index+1).equals(lookingFor1or2)){
                    copyOfListOfRemainingBits.add(bits);
                }
            }

            listOfRemainingBits.removeAll(copyOfListOfRemainingBits);
            copyOfListOfRemainingBits.clear();
            index++;
        }
        return listOfRemainingBits.get(0);
    }

    static String isOneOrNullMostCommon(String type,List<String> listOfBits){
        int ones = 0;
        for(String bites : listOfBits){
            if(bites.charAt(index) == '1') ones++;
        }
        if(type.equals("oxygen")) return (listOfBits.size()-ones)<=ones ? "1" : "0";
        else return (listOfBits.size()-ones)<=ones ? "0" : "1";

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3_1 {

    static StringBuilder _1sBits = new StringBuilder();
    static StringBuilder _2sBits = new StringBuilder();
    static StringBuilder _3sBits = new StringBuilder();
    static StringBuilder _4sBits = new StringBuilder();
    static StringBuilder _5sBits = new StringBuilder();
    static StringBuilder _6sBits = new StringBuilder();
    static StringBuilder _7sBits = new StringBuilder();
    static StringBuilder _8sBits = new StringBuilder();
    static StringBuilder _9sBits = new StringBuilder();
    static StringBuilder _10sBits = new StringBuilder();
    static StringBuilder _11sBits = new StringBuilder();
    static StringBuilder _12sBits = new StringBuilder();

    static StringBuilder SBgammaRate = new StringBuilder();
    static StringBuilder SBepsilonRate = new StringBuilder();

    static List<StringBuilder> ListFromBits = new ArrayList<>(Arrays.asList(_1sBits, _2sBits, _3sBits, _4sBits, _5sBits, _6sBits, _7sBits,
            _8sBits, _9sBits, _10sBits, _11sBits, _12sBits));

    static int halfOfArgs;

    public static void main(String[] args) {
        halfOfArgs = args.length/2;
        for( String binary : args ){
            _1sBits.append(binary.charAt(0));
            _2sBits.append(binary.charAt(1));
            _3sBits.append(binary.charAt(2));
            _4sBits.append(binary.charAt(3));
            _5sBits.append(binary.charAt(4));
            _6sBits.append(binary.charAt(5));
            _7sBits.append(binary.charAt(6));
            _8sBits.append(binary.charAt(7));
            _9sBits.append(binary.charAt(8));
            _10sBits.append(binary.charAt(9));
            _11sBits.append(binary.charAt(10));
            _12sBits.append(binary.charAt(11));
        }
        for(StringBuilder Bits : ListFromBits){
            appendToGammaEpsilon(Bits);
        }

        int gammaRate = Integer.parseInt(SBgammaRate.toString(),2);
        int epsilonRate = Integer.parseInt(SBepsilonRate.toString(),2);

        System.out.println(gammaRate * epsilonRate);

    }

    static void appendToGammaEpsilon(StringBuilder bits){
        if ( halfOfArgs < bits.chars().filter(ch -> ch == '0').count()) {
            SBgammaRate.append("0");
            SBepsilonRate.append("1");
        } else {
            SBgammaRate.append("1");
            SBepsilonRate.append("0");
        }
    }

}

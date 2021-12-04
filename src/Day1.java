import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static Integer solution (List<Integer> listWithSums) {
        int measurement = 0;
        for (int i = 1; i < listWithSums.size();i++ ) {
            Integer next = listWithSums.get(i);
            Integer previous = listWithSums.get(i-1);
            if(next.compareTo(previous) > 0) measurement++;
        }
        return measurement;
    }

    public static void main(String[] args) {
        List<Integer> listWithSums = new ArrayList<>();
        Integer sum = 0;
        int window = 0;
        int slidingWindow =0;

        for (int i = 0; i < args.length; i++) {
            if(window!=3) {
                sum += Integer.parseInt(args[i]);
                window++;
                if(i==args.length-1) listWithSums.add(sum);
            } else {
                listWithSums.add(sum);
                sum=0;
                i = i-3;
                window=0;
                slidingWindow++;
            }
            if(slidingWindow==4) {
                slidingWindow=0;
            }
        }
        System.out.println(listWithSums);
        System.out.println(solution(listWithSums));

    }
}
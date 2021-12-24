import java.io.File;
import java.util.*;

public class Day9 {

    Integer count = 0;

    List<ArrayList<Integer>> matrix = new ArrayList<>();
    Integer riskLevel = 0;

    Map<Location,Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        Day9 d9 = new Day9();

        d9.readInput();
        //d9.countLowPoints();

        System.out.println(d9.riskLevel);

    }

    void readInput() throws Exception {

        File file = new File("src\\Day9_input.txt");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            ArrayList<Integer> line = new ArrayList<>();
            for (char c : scanner.next().toCharArray()) {
                line.add(Integer.parseInt(String.valueOf(c)));
            }
            matrix.add(line);
        }

        scanner.close();
    }

    static class Location{
        Integer x,y;

        public Location(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return Objects.equals(x, location.x) && Objects.equals(y, location.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Day4_1 {

    static HashMap<Integer,BingoBoard> Boards = new HashMap<>();
    static List<Integer> calledNumbers = new ArrayList<>();
    static Integer finalCallNumber = 0;

    static void parseInput() throws Exception {

        File file = new File("src\\Day4_1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        boolean isFirstLine=true;
        String[] inputCalledNumbers;

        List<String> board = new ArrayList<>();
        int rowCount = 0;
        Integer boardCount=0;

        while ((st = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                for (String number : inputCalledNumbers = st.split(",")) {
                    calledNumbers.add(Integer.valueOf(number));
                }
                continue;
            }


            if(!st.equals("")){
                rowCount++;
                String[] arrayBoardRow = st.split(" ");
                board.addAll(Arrays.asList(arrayBoardRow));
            }

            if(rowCount==5){
                boardCount++;
                BingoBoard bb = new BingoBoard();
                while(board.contains("")){
                    board.remove("");
                }
                bb.makeBoard(board);
                Boards.put(boardCount,bb);
                board.clear();
                rowCount=0;
            }
        }
    }

    static void markGrid(BingoBoard board,Integer calledNumber){
        for(int i=0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(board.board.get(i).get(j).number.equals(calledNumber)) {
                    board.board.get(i).get(j).Mark();
                }
            }
        }
    }

    static boolean isBingoVertical(BingoBoard board){

        for(int i=0;i<5;i++){
            Integer countMarks = 0;
            for(int j = 0;j<5;j++){
                if(board.board.get(i).get(j).isItMarked) {
                    countMarks++;
                }
            }
            if(countMarks.equals(5)) return true;
        }
        return false;
    }

    static boolean isBingoHorizontal(BingoBoard board){

        for(int i=0;i<5;i++){
            Integer countMarks = 0;
            for(int j = 0;j<5;j++){
                if(board.board.get(j).get(i).isItMarked) {
                    countMarks++;
                }
            }
            if(countMarks.equals(5)) return true;
        }
        return false;
    }

    static Integer markAndCheck(){
        for(Integer number : calledNumbers){
            for (HashMap.Entry<Integer,BingoBoard> board : Boards.entrySet()){

                markGrid(board.getValue(),number);

                if(isBingoVertical(board.getValue()) || isBingoHorizontal(board.getValue())) {
                    finalCallNumber = number;
                    return board.getKey();
                }
            }
        }
        return null;
    }

    static Integer scoreCalculating(Integer key){
        Integer sum = 0;
        for(int i=0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(!Boards.get(key).board.get(j).get(i).isItMarked) {
                    sum += Boards.get(key).board.get(j).get(i).number;
                }
            }
        }
        return sum*finalCallNumber;
    }

    public static void main(String[] args) throws Exception {
        parseInput();

        //marking and check for bingo and get the key for bingoboard
        Integer key = markAndCheck();

        System.out.println(" Final Score:" + scoreCalculating(key));
    }
}

class BingoBoard {

    List<List<Grid>> board = new ArrayList<>();

    void makeBoard(List<String> boardLines){

        for(int i=0;i<5;i++){
            List<Grid> column = new ArrayList<>();
            int l = i;
            for(int j=0;j<5;j++){
                column.add(new Grid(Integer.valueOf(boardLines.get(l))));
                l += 5;
            }
            board.add(column);
        }

    }

}

class Grid {
    Integer number;

    boolean isItMarked = false;

    public void Mark() {
        this.isItMarked = true;
    }




    Grid(Integer number){
        this.number = number;
    }

}

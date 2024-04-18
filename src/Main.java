import java.util.*;

public class Main {
    private static int ROW = 3;
    private static int COL = 3;

    private static String[][] board= new String [ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        boolean done = false;
        boolean gameOver = false;
        boolean finshMove = false;
        String playerMove = "x";
        int rowMove = 0;
        int colMove = 0;


        do{
            ClearBoard();


            do{
                display();
                //start of game


                do{
                    //player move
                    rowMove = safeInput.getRangedInt(in, "whats your Row? ", 1,3);
                    colMove = safeInput.getRangedInt(in, "whats your Col? ", 1,3);
                    rowMove --;
                    colMove --;

                    finshMove = validMove(rowMove, colMove);

                }while(!finshMove);
                //player move on the board
                board[rowMove][colMove] = playerMove;


                //checking for win or tie
                gameOver = isWin(playerMove);
                //flipping player
                if (playerMove.equals("x")){
                    playerMove = "o";

                }
                else {
                    playerMove = "x";
                }



            }while(!gameOver);
            //do you want to play again?
            done = safeInput.getYNConfirm(in,"do you want to play again?");


        }while(done);





    }
//showing the board
    private static  void ClearBoard() {

        for(int row=0; row < ROW; row++) {

            for (int col =0; col < COL; col++) {

                board[row][col] = "-";

            }
        }



    }
    // displaying the lines of the board
    private static void display() {

        for (int row = 0; row < ROW; row++) {
            System.out.print("| ");

            for (int col = 0; col<COL; col++) {

                System.out.print(board[row][col] + " | ");

            }
            System.out.println();

        }
    }

    private static boolean validMove(int row, int col){

        boolean validMove = false;

        if(board[row][col].equals("-")){

            validMove = true;
        }
        else {
            System.out.println("space already taken");
        }
        return validMove;
    }


    private static boolean isRowWin(String playerMove){
        boolean rowWin = false;

        for(int i = 0; i < ROW; i ++){

            if(board[i][0].equals(playerMove) && board[i][1].equals(playerMove) && board[i][2].equals(playerMove)){

                rowWin = true;

            }

        }
        return rowWin;
}


 private static boolean isColWin(String playerMove){

     boolean colWin = false;

     for(int i = 0; i < COL; i ++){

         if(board[0][i].equals(playerMove) && board[1][i].equals(playerMove) && board[2][i].equals(playerMove)){

             colWin = true;

         }

     }
     return colWin;

 }

 private static boolean digWin(String playerMove){
        boolean digWin = false;

         if (board[0][0].equals(playerMove) && board[1][1].equals(playerMove) && board[2][2].equals(playerMove)){

             digWin = true;
         }
        else if (board[0][2].equals(playerMove) && board[1][1].equals(playerMove) && board[2][0].equals(playerMove)){

            digWin = true;
        }

    return digWin;
 }

 private static boolean isWin(String playerMove){
        boolean win = false;
     //checking for win row
        if(isRowWin(playerMove)){
            win = true;
            System.out.println("Player "+playerMove+" has won!");
        }
        //checking for win column
        else if (isColWin(playerMove)){
            win = true;
            System.out.println("Player "+playerMove+" has won!");
        }
        //checking for win dig
        else if (digWin(playerMove)){
            win = true;
            System.out.println("Player "+playerMove+" has won!");
        }
        //checking for tie
        else if (isTie()){
            win = true;
            System.out.println("Tie game!");
        }

        return win;
 }

    private static boolean isTie(){

        boolean tie = true;

        for(int i = 0; i < COL; i ++){

            if(board[0][i].equals("-") || board[1][i].equals("-") || board[2][i].equals("-")){

                tie = false;

            }
            else if(board[0][i].equals("-") || board[1][i].equals("-") || board[2][i].equals("-")){

                tie = false;

            }
            //else if for diag
            else if(board[0][0].equals("-") || board[1][1].equals("-") || board[2][2].equals("-")){

                tie = false;

            }
            //else if for diag
            else if(board[0][2].equals("-") || board[1][1].equals("-") || board[2][0].equals("-")){

                tie = false;

            }
        }
        return tie;

    }


    }


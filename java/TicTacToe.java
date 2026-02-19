import java.util.Scanner;

public class TicTacToe {

    static char[] board = {
        '1','2','3',
        '4','5','6',
        '7','8','9'
    };

    static char currentPlayer = 'X';

    // Display the board
    static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---|---|---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---|---|---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    // Check winner
    static boolean checkWin() {
        int[][] winPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, // rows
            {0,3,6}, {1,4,7}, {2,5,8}, // columns
            {0,4,8}, {2,4,6}           // diagonals
        };

        for (int[] pos : winPositions) {
            if (board[pos[0]] == currentPlayer &&
                board[pos[1]] == currentPlayer &&
                board[pos[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Check draw
    static boolean isDraw() {
        for (char c : board) {
            if (c != 'X' && c != 'O')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter slot (1-9): ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > 9 || 
                board[choice - 1] == 'X' || board[choice - 1] == 'O') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[choice - 1] = currentPlayer;

            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("Game is a draw!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}

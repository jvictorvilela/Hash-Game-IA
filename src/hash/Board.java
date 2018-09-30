package hash;

/**
 *
 * @author victor
 */
public class Board {
    final short PLAYED_X = 1;
    final short PLAYED_O = 2;
    
    private short[][] board;
    
    public Board() {
        board = new short[3][3];
        for (short aux[] : board) { // inicializando tabuleiro
            for (int i = 0; i < aux.length; i++) {
                aux[i] = 0;
            }
        }
    }
    
    public Board(short[][] matrix) {
        board = matrix;
    }
    
    public boolean play(int i, int j, short player) {
        if (i >= 1 && i <= 3
                && j >= 1 && j <= 3
                && board[i - 1][j - 1] == 0) {
            board[i - 1][j - 1] = player;
            return true;
        } else {
            return false;
        }
    }
    
    // verifica se o jogo já acabou
    // retorna:
    // 0 = jogo ainda não acabou
    // 1 = X ganhou
    // 2 = O ganhou
    // -1 = empate
    public short check() { 
        
        // checando linhas
        if (board[0][0] == board[0][1] && board[0][0] == board[0][2]) { // primeira linha
            return board[0][0];
        }
        if (board[1][0] == board[1][1] && board[1][0] == board[1][2]) { // primeira linha
            return board[1][0];
        }
        if (board[2][0] == board[2][1] && board[2][0] == board[2][2]) { // primeira linha
            return board[2][0];
        }
        
        // checando colunas
        if (board[0][0] == board[1][0] && board[0][0] == board[2][0]) { // primeira linha
            return board[0][0];
        }
        if (board[0][1] == board[1][1] && board[0][1] == board[2][1]) { // primeira linha
            return board[0][1];
        }
        if (board[0][2] == board[1][2] && board[0][2] == board[2][2]) { // primeira linha
            return board[0][2];
        }
        
        // checando diagonais
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) { // primeira linha
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) { // primeira linha
            return board[0][2];
        }

        // verificando possível empate
        for (short aux[] : board) {
            for (int i = 0; i < aux.length; i++) {
                if (aux[i] == 0) {
                    return 0; // jogo não acabou
                }
            }
        }
        
        return -1; // empate
    }
    
    public String getSymbol(Short number) {
        if (number == PLAYED_X) {
            return "X";
        }
        if (number == PLAYED_O) {
            return "O";
        }
        return " ";
    }
    
    public void printBoard() {
        System.out.println("");
        System.out.println(" "+getSymbol(board[0][0])+" | "+getSymbol(board[0][1])+" | "+getSymbol(board[0][2])+" ");
        System.out.println("-----------");
        System.out.println(" "+getSymbol(board[1][0])+" | "+getSymbol(board[1][1])+" | "+getSymbol(board[1][2])+" ");
        System.out.println("-----------");
        System.out.println(" "+getSymbol(board[2][0])+" | "+getSymbol(board[2][1])+" | "+getSymbol(board[2][2])+" ");
        System.out.println("");
    }
    
    public short[][] getMatrix() {
        return board;
    }
    
    public short[][] copyMatrix() {
        short[][] newBoard = new short[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }
    
    public void replaceBoard(Board board) {
        this.board = board.getMatrix();
    }
    
    
}

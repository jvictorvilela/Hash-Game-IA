package hash;

/**
 *
 * @author victor
 */
public abstract class Player {
    final short X = 1;
    final short O = 2;
    protected String name;
    protected short symbol;
    
    public Player(String name, short symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    
    public abstract void play(Board board);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getSymbol() {
        return symbol;
    }

    public void setSymbol(short symbol) {
        this.symbol = symbol;
    }
    
    public String getSymbolName() {
        if (symbol == X) {
            return "X";
        } else {
            return "O";
        }
    }
}

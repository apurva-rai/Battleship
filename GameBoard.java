import java.awt.Point;

public class GameBoard{
    private int boardSize;
    private int[][] board;
    private Ship[] ships;

    /*** BOARD VARIABLES ***
        0 = EMPTY SPACE
        1 = EMPTY MISS
        2 = SHIP
        3 = SHIP HIT
        4 = SUNK SHIP ?
     ***                 ***/

    public GameBoard(int boardSize){
        this.boardSize = boardSize;
        this.ships = ships;
        board = new int[boardSize][boardSize];
    }

    public boolean addShip(Ship newShip){
        Point[] newShipCords = newShip.getShipCords();

        for(Point newShipCords : newShipCord){
            for(Ship ship : ships){
                if(ship.contains(newShipCord))
                    return false;
            }
        }
        return true;
    }

    public String fire(int x, int y){
        if(x >= boardSize || y >= boardSize || x < 0 || y < 0)
            return "Error: out of board bounds";

        if(board[x][y] == 0){
            board[x][y] = 1;
            return "Miss";
        }
        else if(board[x][y] == 1){
            for(Ship ship : ships){
                if(ship.contains(x,y)){
                    ship.hit(x,y);
                    return "Hit";
                }
            }
            return "HIT!";
        }
        return "Error";
    }

    public int[][] getBoard(){
        return board;
    }

    public boolean gameOver(){
        boolean gameOver = true;
        for(Ship ship :ships){
            if(!ship.sunk()){
                gameOver = false;
                break;
            }
            return gameOver;
        }
    }
}

import java.util.ArrayList;

/**
 * This is a comment!
 *
 * @class: BattleShipGame
 * @description: BattleShipGame
 * @author: Xincheng Huang - xinchenh
 * @create: 01-21-2019 23:21
 **/
public class BattleShipGame {


    /*
    x x . .
    . . x .
    x . x .
    x . x .


    o o . .
    . . o .
    o . x .
    o . o .

    . . . .
    . . . .
    . . x .
    . . . .  3
    



     */

    //船身击中一发受伤，全部击中沉没， board是船的图，x代表船体，.代表海面，共三艘船，target是攻击的目标
    public int ship(char[][] board, ArrayList<target> targets) {
        if (board == null || targets == null || targets.size() == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < targets.size(); i++) {
            int x = targets.get(i).x;
            int y = targets.get(i).y;
            if (board[x][y] != 'x')
                continue;

            board[x][y] = 'o';
        }

        return 1;
    }


    public static void main(String[] args) {
        char[][] board = {{'x', 'x', '.', 'x'}, {'.', '.', 'x', '.'}, {'x', '.', 'x', '.'}, {'x', '.', 'x', '.'}};
    }
}


class target {
    //攻击点的横坐标和纵坐标
    int x;
    int y;

    public target(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
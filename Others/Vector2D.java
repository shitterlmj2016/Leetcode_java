/**
 * This is a comment!
 *
 * @class: Vector2D
 * @description: 251. Flatten 2D Vector
 * @author: Xincheng Huang - xinchenh
 * @create: 03-04-2019 19:23
 **/
public class Vector2D {
    int[][] v;
    int row = 0;
    int col = 0;

    public Vector2D(int[][] v) {
        this.v = v;
    }

    public int next() {
        while (v[row] == null || v[row].length == 0)
            row++;
        int res = v[row][col];
        col++;
        if (col >= v[row].length) {
            col = 0;
            row++;
        }
        return res;
    }

    public boolean hasNext() {
        while (row < v.length && (v[row] == null || v[row].length == 0))
            row++;
        if (row < v.length && col < v[row].length)
            return true;
        return false;
    }


}

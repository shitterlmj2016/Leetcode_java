/**
 * 顺时针旋转90度
 * 旋转可以通过反转实现
 *
 * @class: RotateImage
 * @description: 48. Rotate Image
 * @author: Xincheng Huang - xinchenh
 * @create: 01-17-2019 19:02
 **/

/*
    1 2 3
    4 5 6
    7 8 9

 对角线

    1 4 7
    2 5 6
    3 6 9

4-5-6

    7 4 1
    6 5 2
    9 6 3



 */

//key : j = i

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = i; j <matrix.length ; j++) { //这里必须从i开始，如果从j开始会再换一遍，等于没换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length/2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }


    }


}

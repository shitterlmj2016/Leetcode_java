//302. Smallest Rectangle Enclosing Black Pixels
public class SmallestRectangleEnclosingBlackPixels {


    /*
      0 0 1 0
      0 1 1 0
      0 0 1 0

      x = 1, y = 2
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0)
            return 0;
        int left = searchLeft(image, 0, y, true);
        int right = searchRight(image, y, image[0].length - 1, true);
        int top = searchLeft(image, 0, x, false);
        int bottom = searchRight(image, x, image.length - 1, false);

        return (right - left + 1) * (bottom - top + 1);

    }

    private int searchLeft(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                right = mid;
            } else left = mid;
        }

        if (hasBlack(image, left, isHor)) {
            return left;
        }
        return right;
    }

    private int searchRight(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                left = mid;
            } else right = mid;
        }

        if (hasBlack(image, right, isHor)) {
            return right;
        }
        return left;
    }


    private boolean hasBlack(char[][] image, int x, boolean isHor) {
        if (isHor) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1') return true;
            }
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1') return true;
            }
        }
        return false;
    }

}

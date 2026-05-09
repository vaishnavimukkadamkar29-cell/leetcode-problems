import java.util.*;
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int l = 0; l < layers; l++) {

            int top = l;
            int left = l;
            int bottom = m - 1 - l;
            int right = n - 1 - l;

            List<Integer> list = new ArrayList<>();

            // extract layer
            for (int j = left; j <= right; j++)
                list.add(grid[top][j]);

            for (int i = top + 1; i <= bottom; i++)
                list.add(grid[i][right]);

            for (int j = right - 1; j >= left; j--)
                list.add(grid[bottom][j]);

            for (int i = bottom - 1; i > top; i--)
                list.add(grid[i][left]);

            int len = list.size();
            int rot = k % len;

            // rotate using reversal method
            if (rot != 0) {
                reverse(list, 0, rot - 1);
                reverse(list, rot, len - 1);
                reverse(list, 0, len - 1);
            }

            // put back
            int idx = 0;

            for (int j = left; j <= right; j++)
                grid[top][j] = list.get(idx++);

            for (int i = top + 1; i <= bottom; i++)
                grid[i][right] = list.get(idx++);

            for (int j = right - 1; j >= left; j--)
                grid[bottom][j] = list.get(idx++);

            for (int i = bottom - 1; i > top; i--)
                grid[i][left] = list.get(idx++);
        }

        return grid;
    }

    private void reverse(List<Integer> list, int i, int j) {
        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }
}
package leetcode;

/**
 * ��ͼ����
 * @Author: Zyl
 * @Date: 2020/2/3 23:21
 */
public class MapAnalysis {
    /**
     * step1:��ͼ��Ϊ����½�صĵ����Ϊ0��������ĵ����ΪINT_MAX
     * step2:�����Ͻǿ�ʼDP
     * step3:�����½ǿ�ʼDP(ͬʱ��¼���ֵ)
     * */
    public static int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        System.out.println("=======Step0=========");
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

        // Step 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = Integer.MAX_VALUE;
                    count++;
                }
                else{
                    grid[i][j] = 0;
                }
            }
        }

        System.out.println("=======Step1=========");
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == Integer.MAX_VALUE){
                    System.out.print(" MAX_VALUE ");
                }else{
                    System.out.print(anInt);
                }
            }
            System.out.println();
        }

        // ����Ƿ�ȫ½�ػ�ȫ����
        if(count == rows*cols || count == 0){
            return -1;
        }

        // Step 2
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    if (i > 0 && grid[i - 1][j] < grid[i][j] - 1){
                        grid[i][j] = grid[i - 1][j] + 1;
                    }
                    if (j > 0 && grid[i][j - 1] < grid[i][j] - 1){
                        grid[i][j] = grid[i][j - 1] + 1;
                    }
                }
            }
        }

        System.out.println("=======Step2=========");
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

        // Step 3
        int max = 0;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (grid[i][j] > 0) {
                    if (i < rows - 1 && grid[i + 1][j] < grid[i][j] - 1) {
                        grid[i][j] = grid[i + 1][j] + 1;
                    }
                    if (j < cols - 1 && grid[i][j + 1] < grid[i][j] - 1) {
                        grid[i][j] = grid[i][j + 1] + 1;
                    }
                }
                if (grid[i][j] > max)
                    max = grid[i][j];
            }
        }

        System.out.println("=======Step3=========");
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(maxDistance(grid));
    }
}

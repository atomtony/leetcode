import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ch47 {

    static class Similarity {
        int uId1;
        int uId2;
        double dist;

        public Similarity(int uId1, int uId2, double dist) {
            this.uId1 = uId1;
            this.uId2 = uId2;
            this.dist = dist;
        }

    }

    public static void main(String[] args) {
        // 基于相似用户做推荐
        {

            int[][] data = new int[][]{
                    {5, 3, 3, 0, -1, 2, 5, 4, 1, -1},
                    {4, 5, 2, 1, 0, 3, 2, 0, 1, 1},
                    {1, 0, 5, 5, -1, 5, 0, 0, 0, 2},
                    {3, 0, 0, 3, 0, 2, 0, 4, -1, -1},
                    {0, 0, 0, -1, 5, -1, 5, 0, 4, 1},
            };

            // 计算 欧几里得距离
            List<Similarity> similarities = new ArrayList<>();
            for (int i = 0; i < data.length - 1; i++) {

                int[] dataRow1 = data[i];

                // 遍历后续的行
                for (int j = i + 1; j < data.length; j++) {
                    int[] dataRow2 = data[j];

                    double dist = 0;
                    for (int k = 0; k < dataRow1.length; k++) {
                        dist += dataRow1[k] * dataRow2[k];
                    }
                    // 欧几里得距离
                    dist = Math.sqrt(dist);

                    similarities.add(new Similarity(i, j, dist));
                }
            }

            // 排序 欧几里得距离
            Collections.sort(similarities, (similarity, t1) -> {
                if (similarity.dist - t1.dist > 0) {
                    return 1;
                } else if (similarity.dist - t1.dist < 0) {
                    return -1;
                } else {
                    return 0;
                }
            });

            // 输出用户之间的相似度，前3个
            for (int i = 0; i < 3; i++) {
                Similarity similarity = similarities.get(i);
                System.out.println("用户<" + similarity.uId1 + "> 与 用户<" + similarity.uId2 + "> 相似度：" + similarity.dist);
            }


        }

    }
}

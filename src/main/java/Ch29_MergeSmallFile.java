import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

public class Ch29_MergeSmallFile {

    public static void writeFile(String path, List<String> lines) throws IOException {
        FileUtils.writeLines(new File(path), lines);
    }

    // 自建堆
    public static void buildHeap(Line[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    private static void heapify(Line[] a, int n, int i) {//自上往下堆化
        while (true) {
            int maxPos = i;

            // 左节点大于当前节点
            if (i * 2 <= n && a[i].value.compareTo(a[i * 2].value) > 0) {
                maxPos = i * 2;
            }

            // 右节点大于左节点或者当前节点
            if (i * 2 + 1 <= n && a[maxPos].value.compareTo(a[i * 2 + 1].value) > 0) {
                maxPos = i * 2 + 1;
            }

            // 当前节点最大
            if (maxPos == i) {
                break;
            }

            // 交换当前节点和较大的那个子节点
            swap(a, i, maxPos);

            // 记录较大那个子节点为当前节点
            i = maxPos;
        }
    }

    private static <T> void swap(T[] a, int index1, int index2) {
        T tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    static class Line {
        int fileIndex;
        String value;

        @Override
        public String toString() {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {

        int fileCount = 10;
        //生成小文件
        {
            Random random = new Random(10000);
            // 生成10个小文件
            for (int i = 1; i <= fileCount; i++) {
                // 每个文件10行内容
                List<String> lines = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    String line = StringUtils.leftPad(String.valueOf(random.nextInt(10000)), 5, "0");
                    lines.add(line);
                }
                // 排序，生成有序的
                Collections.sort(lines);
                // 写入小文件
                writeFile(String.format("%d.txt", i), lines);
            }
        }

        //合并小文件
        {
            // 空出堆第一个位置，下标从1开始
            Line[] array = new Line[fileCount + 1];
            ArrayList<BufferedReader> readers = new ArrayList<>();
            for (int i = 1; i <= fileCount; i++) {
                BufferedReader reader = new BufferedReader(new FileReader(String.format("%d.txt", i)));
                readers.add(reader);
            }

            // 读取小文件第一行
            for (int i = 0; i < fileCount; i++) {
                Line line = new Line();
                line.fileIndex = i;
                line.value = readers.get(i).readLine();
                array[i + 1] = line;
            }

            BufferedWriter maxWriter = new BufferedWriter(new FileWriter("max.txt"));

            while (true) {

                if (fileCount == 0) {
                    break;
                }

                System.out.println(Arrays.toString(array));
                // 自建元素，这里可以改进，改成小堆顶元素，写入文件，后续再用插入方法
                buildHeap(array, fileCount);

                // 自建后属于小顶堆,写最小元素到大文件中
                maxWriter.write(array[1].value);
                maxWriter.write("\n");
                BufferedReader reader = readers.get(array[1].fileIndex);

                try {
                    String line = reader.readLine();
                    if (line == null) {
                        throw new Exception("eof");
                    }
                    Line tmpLine = new Line();
                    tmpLine.value = line;
                    tmpLine.fileIndex = array[1].fileIndex;
                    array[1] = tmpLine;
                } catch (Exception e) {
                    // 将最后一个元素移动到第一个
                    array[1] = array[fileCount];
                    array[fileCount] = null;
                    //异常后说明文件读到了末尾，文件数减少1
                    fileCount--;
                }
            }

            // 书写文件
            maxWriter.flush();
            maxWriter.close();
        }
    }
}

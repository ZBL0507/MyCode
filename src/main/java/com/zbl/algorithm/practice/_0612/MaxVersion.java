package com.zbl.algorithm.practice._0612;

/**
 * 获取最大的版本号，输入多个版本号，输出最大的版本号
 * 版本号格式：x.y.z 例如：1.2.3   345.5463.576567
 *
 * @author zbl
 * @version 1.0
 * @since 2022/6/12 13:44
 */
public class MaxVersion {
    public static void main(String[] args) {
        String[][] arr = {
                {"1.2.3", "1.2.4", "1.4.5"},
                {"0.0.1", "0.0.22"}
        };

        for (String[] e : arr) {
            System.out.println(getMaxVersion(e));
        }

    }

    public static int myCompare(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }
        return a.compareTo(b);
    }

    public static String getMaxVersion(String[] version) {
        String[] e1 = version[0].split("\\.");
        String maxX = e1[0];
        String maxY = e1[1];
        String maxZ = e1[2];

        for (int i = 1; i < version.length; i++) {
            String[] cur = version[i].split("\\.");
            String x = cur[0];
            String y = cur[1];
            String z = cur[2];

            if (myCompare(maxX, x) < 0) {
                maxX = x;
                maxY = y;
                maxZ = z;
                continue;
            }

            if (myCompare(maxX, x) == 0) {
                if (maxY.compareTo(y) < 0) {
                    maxY = y;
                    maxZ = z;
                    continue;
                }
                if (myCompare(maxY, y) == 0) {
                    if (myCompare(maxZ, z) < 0) {
                        maxZ = z;
                    }
                }
            }
        }

        return maxX + "." + maxY + "." + maxZ;
    }
}

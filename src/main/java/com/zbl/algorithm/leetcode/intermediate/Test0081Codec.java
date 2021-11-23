package com.zbl.algorithm.leetcode.intermediate;

import com.zbl.ds.structure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 10^4] 内
 * -1000 <= Node.val <= 1000
 *
 * @author zbl
 * @version 1.0
 * @since 2021/11/23 17:26
 */
@SuppressWarnings("unused")
public class Test0081Codec {

    // Encodes a tree to a single string.
    private static String serialize(TreeNode root) {
        if (root == null)
            return null;
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private static void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#").append(",");
            return;
        } else
            builder.append(root.val).append(",");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    private static TreeNode deserialize(String data) {
        if (data == null)
            return null;

        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserialize(nodes);
    }

    private static TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        TreeNode root;
        if (!"#".equals(first))
            root = new TreeNode(Integer.parseInt(first));
        else
            return null;

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        String serializeStr = serialize(root);
        TreeNode treeNode = deserialize(serializeStr);

    }
}

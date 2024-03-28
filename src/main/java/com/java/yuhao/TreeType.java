package com.java.yuhao;

import com.java.yuhao.entity.TreeNode;

public class TreeType {

    public int maxDepth(TreeNode root) {
        // 递归终止
        if (root == null) {
            return 0;
        }
        // dfs，先递归左子结点，再递归右子结点，最后求出每一子树的深度的最大值
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

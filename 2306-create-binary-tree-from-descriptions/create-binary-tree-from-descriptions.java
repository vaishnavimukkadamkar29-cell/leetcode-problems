
 import java.util.*;

// LeetCode's built-in TreeNode class definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store value -> TreeNode mapping to track existing nodes
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        // Set to store all child values
        Set<Integer> children = new HashSet<>();

        // Step 1: Build the tree relationships
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            // Get or create parent node
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            TreeNode parent = nodeMap.get(parentVal);

            // Get or create child node
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode child = nodeMap.get(childVal);

            // Link parent and child based on direction
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            // Track that this node has a parent
            children.add(childVal);
        }

        // Step 2: Identify the root node (The parent node that never appears as a child)
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            if (!children.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }

        return null;
    }
}

//time complexity - O(n) where n is the number of tree nodes

//space complexity - O(n/2) the que will have maximum nodes at the last level of a complete tree
import java.util.*;
public class LevelOrderTraversal {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    List<List<Integer>> sol = new ArrayList<>();
    private List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            int len = que.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                TreeNode temp = que.poll();
                li.add(temp.data);
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
            }
            sol.add(li);
        }
        return sol;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        /*
                3
               /  \
            9       20
                   /  \
                 15    7
         */

        LevelOrderTraversal tree = new LevelOrderTraversal();
        System.out.println(tree.levelOrder(root));
    }
}

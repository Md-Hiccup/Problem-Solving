package hackerrank.ds;

import java.util.Scanner;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    public static int getHeight(Node root) {
        if (root.left == null || root.right == null) {
            return 0;
        } else {
            int leftHeight = 0;
            Node travNode = root.left;
            while (travNode != null) {
                travNode = travNode.left;
                leftHeight += 1;
            }
            int rightHeight = 0;
            travNode = root.right;
            while (travNode != null) {
                travNode = travNode.right;
                rightHeight += 1;
            }
            return Math.max(leftHeight, rightHeight);
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}
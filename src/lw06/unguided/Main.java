package lw06.unguided;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumber.txt"));

        BinarySearchTree bst = new BinarySearchTree();
        String[] numbers = sc.nextLine().split(" ");
        for (String number : numbers) {
            bst.insert(Integer.parseInt(number));
        }

        int target = sc.nextInt();
        sc.close();
        System.out.print("Preorder  :");
        System.out.print(" ");
        bst.preOrder();
        System.out.print("\nInorder   :");
        System.out.print(" ");
        bst.inOrder();
        System.out.print("\nPostorder :");
        System.out.print(" ");
        bst.postOrder();
        System.out.print("\nSearching for " + target + ": " + bst.search(target));
        System.out.print("\nMinimum value: " + bst.findMin());
        System.out.print("\nMaximum value: " + bst.findMax());


    }
}
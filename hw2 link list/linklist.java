// 1. Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs/ (Links to an external site.)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode newHead = second;
        ListNode next = null;
        first.next = null;
        while(first != null && second != null){
            next = second.next;
            second.next = first;
            if(next == null){
                first.next = next;
                first = first.next;
            }else{
                first.next = next.next == null ? next : next.next;                
                second = next.next;
                first = next;
            }
        }
        return newHead;
    }
}

//2. Delete a node in link list https://leetcode.com/problems/delete-node-in-a-linked-list/ (Links to an external site.) 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

//3. Even Odd Link List https://leetcode.com/problems/odd-even-linked-list/ (Links to an external site.) 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
         if(head == null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

//4. Split Link list in parts https://leetcode.com/problems/split-linked-list-in-parts/ (Links to an external site.)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode current = root;
        int size = 0; 
        while(current != null){
            size++;
            current = current.next;
        }
        ListNode[] result = new ListNode[k];
        int arrSize = size / k;
        int off = size % k;
        current = root;
        for(int i = 0; i < k; i++){
            ListNode node = current;
            int extra = i < off ? 1 : 0;
            for(int j = 0; j < arrSize + extra - 1; j++){
               if(current != null){
                   current = current.next;
               }
            }
            if(node != null){
                ListNode temp = current;
                current = current.next;
                temp.next = null;
            }
            result[i] = node;
        }
        return result;        
    }
}

//5. Insert in Circular link list https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/ (Links to an external site.) 

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node toInsert = new Node(insertVal);
        if (head == null) {
            toInsert.next = toInsert;
            return toInsert;
        }
        Node node = head;
        while (node.next != head) {
            if (node.val <= node.next.val) {
                //  found place to insert between two nodes
                if (node.val <= toInsert.val && toInsert.val <= node.next.val) {
                    break;
                }
            } else if (node.val < toInsert.val || toInsert.val < node.next.val) {
                break;
            }
            node = node.next;
        }
        toInsert.next = node.next;
        node.next = toInsert;
        return head;
    }
}
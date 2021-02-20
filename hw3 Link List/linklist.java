// 1. Merge in between links https://leetcode.com/problems/merge-in-between-linked-lists/

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        int index = 0;
        ListNode start = null;
        ListNode end = null;
        // traverse until bth node
        while(cur != null && index < b){
            if(index == a - 1){
                start = cur;
            }
            cur = cur.next;
            index++;
        }
        end = cur;
        ListNode ptr2 = list2;
        start.next = ptr2;
        while(ptr2.next != null){
            ptr2 = ptr2.next;
        }
        ptr2.next = end.next;
        return list1;
    }
}


// 2. Swap Nodes in link list https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null;
        ListNode second = null;
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            length++;
            if(second != null){
                second = second.next;
            }
            if(length == k){
                first = cur;
                second = head;
            }
            cur = cur.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    
    }
}


// 3. Remove link list element https://leetcode.com/problems/remove-linked-list-elements/ (Links to an external site.) 

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}


// 4. Delete n nodes after m nodes https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/

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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        int num = 0;
        while(cur != null){
            num++;
            if(num == m){
                ListNode end = cur.next;
                int skip = 0;
                while(end != null && skip < n){
                    end = end.next;
                    skip++;
                }
                cur.next = end;
                num = 0;
            }
            cur = cur.next;
        }
        return head;
    }
}


// 5. Design and implement a Double Link list 

/*Create a class for Node which has next and prev pointers

Create class for double link list  and add functions for Add to tail, Add to head, size, print list functions to the class.*/

/* see file 

Node.java 

DoubleLinkList.java     */

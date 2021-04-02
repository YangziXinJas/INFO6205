import java.util.HashSet;
import java.util.Set;

public class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public boolean areConverging(ListNode n1, ListNode n2){
        // egde case: either of the linked list is empty
        if(n1 == null || n2 == null){
            return false;
        }
        Set<ListNode> s = new HashSet<>();
        ListNode listPointer = n1;
        while(listPointer != null){
            s.add(listPointer);
            listPointer = listPointer.next;
        }
        listPointer = n2;
        while(listPointer != null){
            if(s.contains(listPointer)){
                return true;
            }
            listPointer = listPointer.next;
        }
        return false;
    }
}
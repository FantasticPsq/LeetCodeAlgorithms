public class CycleList {
    public boolean hasCycle(ListNode head) {
        ListNode node = head;
        while (head != null && node != null && node.next != null) {
            head = head.next;
            node = node.next.next;
            if (node != null && head != null && head.val == node.val) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new CycleList().hasCycle(new ListNode(1)));;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}



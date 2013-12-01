public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        } 
        ListNode small = null;
        ListNode smallpoint = null;
        ListNode large = null;
        ListNode largepoint = null;
        while (head!=null) {
            if (head.val < x) {
                if (small == null) {
                    small = head;
                    smallpoint = small;
                } else {
                    smallpoint.next = head;
                    smallpoint = smallpoint.next;
                }
                head = head.next;
                smallpoint.next = null;
            } else {
                if (large == null) {
                    large = head;
                    largepoint = large;
                } else {
                    largepoint.next = head;
                    largepoint = largepoint.next;
                }
                head = head.next;
                largepoint.next = null;
            }
        }
        if (small == null) {
            return large;
        } 
        smallpoint.next = large;
        return small;
    }
}

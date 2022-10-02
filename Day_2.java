//------------------------------- Detect Cycle in LL -----------------------------------------
import java.util.* ;
import java.io.*; 

public class DetectCycleLL {
    
    public static boolean detectCycle(Node<Integer> head) {
        if(head == null || head.next == null) {
            return false;
        }
        
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}

//--------------------------------- Palindrome in LL ----------------------------------
class PalindromeLL {
    public ListNode reverseLL(ListNode head) {
       if(head == null || head.next == null) {
           return head;
       }    
        
       ListNode prev = null;
       ListNode curr = head;
       ListNode frwd = null;
        
       while(curr != null) {
           frwd = curr.next;
           curr.next = prev;
           prev = curr;
           curr = frwd;
       }
       return prev;
    }
    
    public ListNode middleLL(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        
        ListNode middle = middleLL(head);
        ListNode nhead = middle.next;
        middle.next = null;
        
        ListNode c1 = head;
        ListNode c2 = reverseLL(nhead);
        boolean flag = true;
        
        while(c1 != null && c2 != null) {
            if(c1.val != c2.val) {
                flag = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        
        middle.next = reverseLL(nhead);
        return flag;
    }
}

//-------------------------------------- Intersection of LL ----------------------------------
public class IntersectionLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode c1 = headA;
        ListNode c2 = headB;
        
        while(c1 != c2) {
            if(c1 != null) {
                c1 = c1.next;
            } else {
                c1 = headB;
            }
            
            if(c2 != null) {
                c2 = c2.next;
            } else {
                c2 = headA;
            }
        }
        
        return c1;
    }
}

//--------------------  Starting point of loop in LL ----------------------------
public class CycleDetect2 
{
    public static Node firstNode(Node head) 
    {
        if(head == null || head.next == null) {
            return null;
        }
        
        Node slow = head;
        Node fast = head;
        
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                break;
            }
        }
        
        if(slow != fast) {
            return null;
        }
      
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
 }
}

//------------------------------ Flatten Linked List --------------------------------------
public class FlattenLL {
    public static Node mergeTwoSortedLL(Node l1, Node l2) {
        Node temp = new Node(0);
        Node res = temp;
        
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                temp.child = l1;
                temp = temp.child;
                l1 = l1.child;
            }
            else{
                temp.child = l2;
                temp = temp.child;
                l2 = l2.child;
            }
        }
        
        temp.child = l1 == null ? l2 : l1;
        return res.child;
    }
    
	public static Node flattenLinkedList(Node start) {
        if(start == null || start.next == null) {
            return start;
        }
        
        start.next = flattenLinkedList(start.next);
        start = mergeTwoSortedLL(start, start.next);
        return start;
	}
}

//--------------------------------- Reorder LL ------------------------------------------
class ReorderLL {
    public ListNode reverseLL(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode frwd = null;
        
        while(curr != null) {
            frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }
        return prev;
    }
    
    public ListNode middleLL(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public void reorderList(ListNode head) {
        ListNode middle = middleLL(head);
        ListNode nhead = middle.next;
        middle.next = null;
        
        ListNode c1 = head;
        ListNode c2 = reverseLL(nhead);
        ListNode f1 = null;
        ListNode f2 = null;
        
        while(c1 != null && c2 != null) {
            f1 = c1.next;
            f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
    }
}

//------------------------ Reverse a LL in group of size k --------------------------------------
class ReverseGroupSizekLL {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode frwd = dummy;
        
        ListNode temp = head;
        int counter = 0;
        
        while(temp != null) {
            counter++;
            temp = temp.next;
        }
        
        while(counter >= k) {
            curr = prev.next;
            frwd = curr.next;
            
            for(int i = 0; i < k - 1; i++) {
                curr.next = frwd.next;
                frwd.next = prev.next;
                prev.next = frwd;
                frwd = curr.next;
            }
            
            counter = counter - k;
            prev = curr;
        }
        return dummy.next;
    }
}

//------------------------ Reverse a LL in group of size k Variant --------------------------------------
public class VariantTReverseLLInGroupSizeOfK {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        if(head == null || n == 0) {
            return head;
        }
        
        Node dummy = new Node(0);
        dummy.next = head;
        
        Node prev = dummy;
        Node curr = dummy;
        Node frwd = dummy;
        
        Node temp = head;
        int counter = 0;
        
        while(temp != null) {
            counter++;
            temp = temp.next;
        }
        
        int j = 0;
           while(counter > 0 && j < n) {
                curr = prev.next;
                frwd = curr.next;
                
               int x = 0;
                if(b[j] <= counter) {
                    x = b[j];
                } else {
                    x = counter;
                }
               
               if(x == 0) {
                   j++;
                   continue;
               }
                
                for(int i = 0; i < x - 1; i++) {
                    curr.next = frwd.next;
                    frwd.next = prev.next;
                    prev.next = frwd;
                    frwd = curr.next;
                }
                
                counter = counter - b[j];
                prev = curr;
                j++;
            }
        return dummy.next;
	}
}



//------------------------------------- Kadane's Algorithm -----------------------------------
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;


public class Kadanes {
	
	public static long maxSubarraySum(int[] arr, int n) {
	    long maxSum = 0;
        long individualValue = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(individualValue >= 0) {
                individualValue += arr[i];
            } else {
                individualValue = arr[i];
            }
            maxSum = Math.max(maxSum, individualValue);
        }
        
        return maxSum;
	}
}


//------------------------------------- Sort012 / Dutch Flag Algorithm -------------------------
public class DutchFlag 
{
    public static void sort012(int[] arr)
    {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while(mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else if(arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    
    public static void swap(int[] arr, int low, int high) {
          int temp = arr[low];
          arr[low] = arr[high];
          arr[high] =temp;
    }
}

//------------------------------------- Stock buy and Sell ----------------------------------------
public class StockSellAndBuy{
    public static int maximumProfit(ArrayList<Integer> prices){
        int minimumPrice = Integer.MAX_VALUE;
        int maximumProfit = 0;
        
        for(int i = 0; i < prices.size(); i++) {
            if(maximumProfit < prices.get(i) - minimumPrice) {
                maximumProfit = prices.get(i) - minimumPrice;
            } else {
                minimumPrice = Math.min(minimumPrice, prices.get(i));           
            }
        }
        return maximumProfit;
    }
}

//---------------------------------- Set Matrix to zeroes ------------------------------------------
public class SetMatrixToZero {
    public static void setZeros(int matrix[][]) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean col0 = false;
        
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == 0) {
                col0 = true;
            }
            
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = row - 1; i >= 0; i--) {
            for(int j = col - 1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            
            if(col0 == true) {
                matrix[i][0] = 0;
            }
        }
    }

}

//----------------------------- Pascal Triangle --------------------------------------------------
public class PascalTriangle {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> result = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> previousRow = null;
        ArrayList<Long> newRow = null;
        
        for(int i = 0; i < n; i++) {
            newRow = new ArrayList<Long>();
            
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    newRow.add(Long.valueOf(1));
                } else {
                    newRow.add(previousRow.get(j - 1) + previousRow.get(j));
                }
            }
            previousRow = newRow;
            result.add(newRow);
        }
        return result;
	}
}

//------------------------- Next Permutation --------------------------------------------------------
public class NextPermutation 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
        if(permutation.size() <= 1) {
            return permutation;
        }
        
        int i = permutation.size() - 2;
        while(i >= 0 && permutation.get(i) >= permutation.get(i + 1)) {
            i--;
        }
        
        if(i >= 0) {
            int j = permutation.size() - 1;
            while(permutation.get(j) <= permutation.get(i)) {
                j--;
            }
            swap(permutation, i, j);
        }
        reverse(permutation, i + 1, permutation.size() - 1);
        return permutation;
	}
    
    public static void swap(ArrayList<Integer> per, Integer low, Integer high) {
        Integer temp = per.get(low);
        per.set(low, per.get(high));
        per.set(high, temp);
    }
    
    public static void reverse(ArrayList<Integer> per, Integer low, Integer high) {
       while(low <= high) {
           swap(per, low, high);
           low++;
           high--;
       }
    }
}

//--------------------------------- Reverse LinkedList ----------------------------------------

public class ReverseLL 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        if(head == null || head.next == null) {
            return head;
        } 
        
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> frwd = null;
        
        while(curr != null) {
            frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }
        
        return prev;
    }
}

//------------------------------ Middle LinkedList -------------------------------------------

public class MiddleLL {
    public static Node findMiddle(Node head) 
    {
        Node slow = head;
        Node fast = head;
        
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}

//------------------------------ Merge Two Sorted LinkedList --------------------------------

public class MergeSortLL {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		if(first == null || second == null) {
            if(first == null) {
                return second;
            } else {
                return first;
            }
        }
        
        LinkedListNode<Integer> dummy = new LinkedListNode(0);
        LinkedListNode<Integer> prev = dummy;
        LinkedListNode<Integer> c1 = first;
        LinkedListNode<Integer> c2 = second;
        
        while(c1 != null && c2 != null) {
            if(c1.data <= c2.data) {
                prev.next = c1;
                prev = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                prev = c2;
                c2 = c2.next;
            }
        }
        
        prev.next = c1 == null ? c2 : c1;
        return dummy.next;
	}
}

//--------------------------------- Delete Node in a linkedList -----------------------------
public class DeleteNodeLL {
	public static void deleteNode(LinkedListNode<Integer> node) {
         node.data = node.next.data;
         node.next = node.next.next;
    }
}

//------------------------------- Remove nth node from back of the LL -----------------------------------
public class RemoveNthLL {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
        if(head == null || K == 0) {
            return head;
        }
        
		LinkedListNode<Integer> dummy = new LinkedListNode(0);
        LinkedListNode<Integer> prev = dummy;
        LinkedListNode<Integer> slow = dummy;
        LinkedListNode<Integer> fast = dummy;
        dummy.next = head;
        for(int i = 1; i <= K; i++) {
            fast = fast.next;
        }
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
	}
}

//------------------------------ Add Two number as LL ------------------------------------------------------
public class AddTwoLL {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        if(head1 == null || head2 == null) {
            if(head1 == null) {
                return head2;
            } else {
                return head1;
            }
        }
        
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode temp = dummy;
        LinkedListNode c1 = head1;
        LinkedListNode c2 = head2;
        int carry = 0;
        
        while(c1 != null || c2 != null || carry > 0) {
            int sum = 0;
            if(c1 != null) {
                sum = sum + c1.data;
                c1 = c1.next;
            }
            
            if(c2 != null) {
                sum = sum + c2.data;
                c2 = c2.next;
            }
            
            sum = sum + carry;
            carry = sum / 10;
            temp.next = new LinkedListNode(sum % 10);
            temp = temp.next;
        }
        
        return dummy.next;
    }
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistsort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author evanb
 */
public class LinkedListUtil {
     /*
    Sort linked list using mergesort
    */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode secondHalf = findMiddleNode(head).next;
        ListNode firstHalf = getSubList(head, secondHalf);
        
        return mergeLists(sortList(firstHalf), sortList(secondHalf));
    }
    
    
    /*
    Assumption: LinkedLists a and b are already in sorted order
    Assumption: LinkedLists a and b contain an equal number of nodes
    Assumption: LinkedLists a and b are not null
    Output: The head of the sorted linked list
    */
    public static ListNode mergeLists(ListNode a, ListNode b) {
        
        /*
        Initialize merged list with dummy node
        This dummy node is removed at the end
        */
        ListNode mergedHead = new ListNode(0);
        
        ListNode mergedIter = mergedHead;
        
        /*
        Merge the lists
        */
        while (a != null && b != null) {
            if (a.val < b.val) {
                mergedIter.next = a;
                a = a.next;
            } else {
                mergedIter.next = b;
                b = b.next;
            }
            mergedIter = mergedIter.next;
        }
        
        
        /*
        Add the last remaining node
        */
        if (a == null) {
            mergedIter.next = b;
        } else {
            mergedIter.next = a;
        }
        
        /*
        Remove the head (dummy node)
        */
        mergedIter = mergedHead;
        mergedHead = mergedHead.next;
        mergedIter = null;
        
        return mergedHead;
    }
    
    /*
    Given a starting node, return the middle node
    ex. if you give it the head node, it will return the middle node
    ex. if you give it the middle node, it will give the node in between the middle and the tail
    */
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = (fast.next).next;
        }

        return slow;
    }
    
    /*
    Input:  ListNode front is the starting position of the sublist
            ListNode back is the delimeter of where to slice the list
    Assumption: ListNode back is a node in ListNode front
    Output: A linked list that is starts with front and ends with back
    */
    public static ListNode getSubList(ListNode front, ListNode back) {
        
        if (front == null || front == back) {
            return front;
        }
        
        ListNode sublist = new ListNode(front.val);
        ListNode sublistIter = sublist;
        front = front.next;
        
        while (front != back) {
            sublistIter.next = new ListNode(front.val);
            front = front.next;
            sublistIter = sublistIter.next;
        }
        
        return sublist;
    }
    
    /*
    Purpose: Make it easier to make a large linked list for testing
    Input: A list of integers
    Output: Linked list of ListNodes
    */
    public static ListNode listToLinkedList(List<Integer> list) {
        
        if (list == null) {
            return null;
        }
        
        ListNode head = new ListNode(list.get(0));
        
        ListNode iter = head;
        
        for (int i = 1; i < list.size(); i++) {
            iter.next = new ListNode(list.get(i));
            iter = iter.next;
        }
        
        return head;
    }
    
    /*
    Input: Linked list of ListNodes
    Output: List of integers
    */
    public static List<Integer> linkedListToList(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        List<Integer> arr = new ArrayList<>();
        
        ListNode iter = head;
        
        while (iter != null) {
            arr.add(iter.val);
            iter = iter.next;
        }
        
        return arr;
    }

    public static void printListNodes(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        
        System.out.println();
    }
}

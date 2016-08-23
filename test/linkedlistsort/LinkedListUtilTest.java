/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author evanb
 */
public class LinkedListUtilTest {

    public LinkedListUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    

    /**
     * Test of sortList method, of class LinkedListUtil.
     */
    @Test
    public void testSortList() {
        System.out.println("sortList");

        /*
        Generate long list of random integers
         */
        Random rand = new Random();
        int max = 1000;
        int min = -1000;
        int arrayLength = 20000000;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arrayLength; i++) {
            list.add(rand.nextInt((max - min) + 1) + min);
        }
        ListNode linkedList = LinkedListUtil.listToLinkedList(list);

        List<Integer> result = LinkedListUtil.linkedListToList(LinkedListUtil.sortList(linkedList));
        Collections.sort(list);

        //System.out.println(result);

        assertEquals(list, result);
    }

    /**
     * Test of mergeLists method, of class LinkedListUtil.
     */
    @Test
    public void testMergeLists() {
        System.out.println("mergeLists");
        ListNode a = LinkedListUtil.listToLinkedList(Arrays.asList(0, 1, 5, 6, 6, 7));
        ListNode b = LinkedListUtil.listToLinkedList(Arrays.asList(8, 10, 10, 12, 15, 17));
        List<Integer> expResult = Arrays.asList(0, 1, 5, 6, 6, 7, 8, 10, 10, 12, 15, 17);
        List<Integer> result = LinkedListUtil.linkedListToList(LinkedListUtil.mergeLists(a, b));
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of findMiddleNode method, of class LinkedListUtil.
     */
    @Test
    public void testFindMiddleNode() {
        System.out.println("findMiddleNode");

        List<Integer> list = Arrays.asList(1, 0, 6, 10, 12, 15, 6, 7, 8, 5, 10, 17);
        ListNode head = LinkedListUtil.listToLinkedList(list);

        List<Integer> expResult = Arrays.asList(15, 6, 7, 8, 5, 10, 17);

        List<Integer> result = LinkedListUtil.linkedListToList(LinkedListUtil.findMiddleNode(head));

        System.out.println(result);

        assertEquals(expResult, result);
    }

    /**
     * Test of getSubList method, of class LinkedListUtil.
     */
    @Test
    public void testGetSubList() {
        System.out.println("getSubList");

        List<Integer> list = Arrays.asList(1, 0, 6, 10, 12, 15, 6, 7, 8, 5, 10, 17);

        ListNode head = LinkedListUtil.listToLinkedList(list);

        ListNode iter = head;

        int i = 0;

        int frontIndex = 2;
        int backIndex = 9;

        ListNode front = null;
        ListNode back = null;

        while (iter != null) {
            if (i == frontIndex) {
                front = iter;
            }
            if (i == backIndex) {
                back = iter;
            }
            iter = iter.next;
            i++;
        }

        List<Integer> result = LinkedListUtil.linkedListToList(LinkedListUtil.getSubList(front, back));

        List<Integer> expResult = list.subList(frontIndex, backIndex);

        System.out.println(result);

        assertEquals(expResult, result);
    }

    /**
     * Test of linkedListToList method, of class LinkedListUtil.
     */
    @Test
    public void testLinkedListToList() {
        System.out.println("linkedListToList");

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(12);
        ListNode node6 = new ListNode(15);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(7);
        ListNode node9 = new ListNode(8);
        ListNode node10 = new ListNode(5);
        ListNode node11 = new ListNode(10);
        ListNode node12 = new ListNode(17);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = null;

        List<Integer> expResult = Arrays.asList(1, 0, 6, 10, 12, 15, 6, 7, 8, 5, 10, 17);
        List<Integer> result = LinkedListUtil.linkedListToList(head);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of listToLinkedList method, of class LinkedListUtil.
     */
    @Test
    public void testListToLinkedList() {
        System.out.println("listToLinkedList");

        List<Integer> list = Arrays.asList(1, 0, 6, 10, 12, 15, 6, 7, 8, 5, 10, 17);

        ListNode result = LinkedListUtil.listToLinkedList(list);

        ListNode iter = result;
        List<Integer> listTest = new ArrayList<>();
        int i = 0;

        while (iter != null) {
            listTest.add(iter.val);
            i++;
            iter = iter.next;
        }

        System.out.println(listTest);

        Assert.assertEquals(listTest, list);
    }

}

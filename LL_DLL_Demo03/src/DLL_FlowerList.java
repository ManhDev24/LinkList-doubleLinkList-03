/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NC
 */
public class DLL_FlowerList {

    DLL_Node head;
    DLL_Node tail;

    public DLL_FlowerList() {
        head = tail = null;
    }

    public boolean Empty() {
        return head == null;
    }

   public boolean addFirst(Flower f) {
    DLL_Node newNode = new DLL_Node(f);
    if (this.Empty()) {
        head = tail = newNode;
    } else {
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }
    return true;
}

    public boolean addFirst(String name, String original, int price) {
        Flower f = new Flower(name, original, price);
        return addFirst(f);
    }

    public boolean addLast(Flower f) {
    DLL_Node newNode = new DLL_Node(f);
    if (this.Empty()) {
        head = tail = newNode;
    } else {
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
    }
    return true;
}


    public boolean addLast(String name, String original, int price) {
        Flower f = new Flower(name, original, price);
        return addLast(f);
    }

    public boolean addBefore(DLL_Node p, Flower f) {
        if (this.Empty() || p == head) {
            return addFirst(f);
        } else {
            DLL_Node newNode = new DLL_Node(f);
            DLL_Node before = p.previous;
            // before <---> newNode<--->p
            before.next = newNode;
            newNode.next = p;
            p.previous = newNode;
            newNode.previous = before;
        }
        return true;
    }

    public boolean addAfter(DLL_Node p, Flower f) {
        if (this.Empty() || p == tail) {
            return addLast(f);
        } else {
            DLL_Node newNode = new DLL_Node(f);
            DLL_Node after = p.next;
            // p<--> newNode <--> after
            p.next = newNode;
            newNode.next = after;
            after.previous = newNode;
            newNode.previous = p;
        }
        return true;
    }

    public DLL_Node search(String flowerName) {
        if (this.Empty()) {
            return null;
        }
        Flower f = new Flower(flowerName);
        DLL_Node p = head;
        while (p != null) {
            if (p.flower.equals(f)) {
                return p;
            } else {
                p = p.next;
            }
        }
        return null;
    }

    public DLL_Node removeFirst() {
        if (this.Empty()) {
            return null;
        }
        DLL_Node result = head;
        if (head == tail) {
            head = tail = null;
        } else {
            DLL_Node newHead = head.next;
            newHead.previous = null;
            head = newHead;
        }
        return result;
    }

//    public DLL_Node removeLast() {
//        if (this.Empty()) {
//            return null;
//        }
//        DLL_Node result = tail;
//        if (head == tail) {
//            head = tail = null;
//        } else {
//            DLL_Node newTail = tail.previous;
//            newTail.next = null;
//            tail = newTail;
//        }
//        
//        return result;
//    }
    public DLL_Node removeLast() {
        if (this.Empty()) {
            return null;
        }

        DLL_Node result = tail;

        if (head == tail) {
            head = tail = null;
        } else {
            DLL_Node newTail = tail.previous;
            newTail.next = null;
            tail = newTail;
        }

        return result;
    }

    private DLL_Node remove(DLL_Node p) {
        if (this.Empty() || p == null) {
            return null;
        }

        DLL_Node before = p.previous;
        DLL_Node after = p.next;

        if (before != null) {
            before.next = after;
        } else {
            // If p is the head, update the head
            head = after;
        }

        if (after != null) {
            after.previous = before;
        } else {
            // If p is the tail, update the tail
            tail = before;
        }

        return p;
    }

    public Flower remove(String flowerName) {
        DLL_Node p = this.search(flowerName);
        if (p != null) {
            DLL_Node removedNode = remove(p);
            return (removedNode != null) ? removedNode.flower : null;
        } else {
            System.out.println("Flower not found: " + flowerName);
            return null;
        }
    }

    public void printAll() {
        if (this.Empty()) {
            System.out.println("Emty List");
        } else {
            for (DLL_Node p = head; p != null; p = p.next) {
                System.out.println(p.flower);
            }
        }
    }

    public void printAll_reverse() {
        if (this.Empty()) {
            System.out.println("Empty List");
        } else {
            for (DLL_Node p = tail; p != null; p = p.previous) {
                System.out.println(p.flower);
            }
        }
    }

    public void printAll_org(String original) {
        if (this.Empty()) {
            System.out.println("Emty List");
        } else {
            for (DLL_Node p = head; p != null; p = p.next) {
                if (p.flower.original.equals(original)) {
                    System.out.println(p.flower);
                }
            }
        }
    }

}

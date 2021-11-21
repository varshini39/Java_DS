package LinkedList;

public class LinkedList {
    public static void main(String[] args) {
        // Write your code here:
        LinkedList sports = new LinkedList();
        sports.addToHead("Cricket");
        sports.addToHead("Chess");
        sports.addToTail("Football");
        sports.addToTail("Hockey");
        sports.addToTail("Basket Ball");
        sports.addToTail("Tennis");
        sports.addToTail("Shuttle");
        sports.addToTail("Badminton");
        sports.addToTail("Volley Ball");
        sports.printList();
        sports.removeHead();
        sports.printList();
        String value = sports.removeNode("Shuttle");
        System.out.println("Node removed: " + value);
        sports.printList();
    }

    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(String data) {
        Node tail = this.head;
        if (tail == null) {
            this.head = new Node(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node(data));
        }
    }

    public String removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNextNode();
        return removedHead.data;
    }

    public String removeNode(String dataToBeRemoved) {
        Node currentNode = this.head;
        Node prevNode = null;
        while (currentNode != null) {
            if (currentNode.data == dataToBeRemoved) {
                if (prevNode == null) {
                    return this.removeHead();
                } else {
                    prevNode.setNextNode(currentNode.getNextNode());
                    return currentNode.data;
                }
            } else {
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
        }
        return null;
    }

    public static void swapNodes(LinkedList list, String data1, String data2) {
        System.out.println("Swapping " + data1 + " with " + data2);

        Node node1Prev = null;
        Node node2Prev = null;
        Node node1 = list.head;
        Node node2 = list.head;

        if (data1.equals(data2)) {
            System.out.println("Elements are the same - no swap to be made");
            return;
        }

        while (node1 != null) {
            if (node1.data == data1) {
                break;
            }
            node1Prev = node1;
            node1 = node1.getNextNode();
        }

        while (node2 != null) {
            if (node2.data == data2) {
                break;
            }
            node2Prev = node2;
            node2 = node2.getNextNode();
        }

        if (node1 == null || node2 == null) {
            System.out.println("Swap not possible - one or more element is not in the list");
            return;
        }

        if (node1Prev == null) {
            list.head = node2;
        } else {
            node1Prev.setNextNode(node2);
        }

        if (node2Prev == null) {
            list.head = node1;
        } else {
            node2Prev.setNextNode(node1);
        }

        Node temp = node1.getNextNode();
        node1.setNextNode(node2.getNextNode());
        node2.setNextNode(temp);
    }

    public static Node nthLastNode(LinkedList list, int n) {
        Node currentNode = null;
        Node tailPointer = list.head;
        int count = 0;
        while (tailPointer != null) {
            tailPointer = tailPointer.getNextNode();
            if (count >= n) {
                if (currentNode == null) {
                    currentNode = list.head;
                }
                currentNode = currentNode.getNextNode();
            }
            count++;
        }
        return currentNode;
    }

    public static Node findMiddle(LinkedList linkedList) {
        Node fast = linkedList.head;
        Node slow = linkedList.head;
        while (fast != null) {
            fast = fast.getNextNode();
            if (fast != null) {
                fast = fast.getNextNode();
                slow = slow.getNextNode();
            }
        }
        return slow;
    }

    public String printList() {
        String output = "<head> ";
        Node currentNode = this.head;
        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        System.out.println(output);
        return output;
    }
}

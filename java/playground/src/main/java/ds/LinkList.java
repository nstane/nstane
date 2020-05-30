package ds;

import java.util.Objects;

class LinkList<T> {
    private Node<T> head;
    private class Node<T> {
        private Node next;
        private T data;

        private Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        if (Objects.isNull(head)) {
            head = new Node(data);
        } else {
            Node current = head;

            while (Objects.nonNull(current.next)) {
                current = current.next;
            }

            current.next = new Node(data);
        }
    }

    public void remove(T t) {
        if(Objects.isNull(head)) {
            return ;
        }
        if (head.data.equals(t)) {
            head = null;
        }

        Node current = head;

        while (Objects.nonNull(current.next)) {
            if(current.next.data.equals(t)) {
                Node tmp = current.next.next;
                current.next = null;
                current.next = tmp;
                break;
            }
            current = current.next;
        }
    }
}


class Main {
    public static void main(String[] args) {
        LinkList<String> stringLinkList = new LinkList<>();
        stringLinkList.add("hello");
        stringLinkList.add("narender");
        stringLinkList.add("how");
        stringLinkList.add("are");
        stringLinkList.add("you");

        System.out.println(stringLinkList);

        stringLinkList.remove("narender");

        stringLinkList.remove("are");

        stringLinkList.remove("you");


        System.out.println(stringLinkList);
    }
}



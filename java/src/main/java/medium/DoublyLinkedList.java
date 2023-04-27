package medium;

public class DoublyLinkedList<T> {

    private Element<T> head;
    private Element<T> tail;

    void unshift(T value) {
        if (head == null) {
            head = new Element<T>(value, null, null);
            tail = head;
        } else {
            Element<T> newHead = new Element<T>(value, null, head);
            head.prev = newHead;
            head = newHead;
        }
    }

    T shift() {
        T result = head.value;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return result;
    }

    void push(T value) {
        if (tail == null) {
            tail = new Element<T>(value, null, null);
            head = tail;
        } else {
            Element<T> newTail = new Element<T>(value, tail, null);
            tail.next = newTail;
            tail = newTail;
        }
    }

    T pop() {
        T result = tail.value;
        if (tail.prev == null) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return result;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;
        Element(T inputValue, Element<T> inputPrev, Element<T> inputNext) {
            value = inputValue;
            prev = inputPrev;
            next = inputNext;
        }
    }
}

package Moje_slozka.OOP.adts;

public class StringQueue {

    QueueLink first, last;

    void enqueue(String toAdd) {
        QueueLink link = new QueueLink();
        link.data = toAdd;

        if (isEmpty()) {
            first = link;
        } else {
            last.next = link;
        }
        last = link;

    }

    String dequeue() {
        if (isEmpty()){
            return null;
        }

        String toReturn = first.data;
        first = first.next;
        return toReturn;
    }

    String peek() {
        if (isEmpty()) {
            return null;
        }
        else {
            return first.data;
        }
    }

    int getSize() {
        int sizeCounter = 1;
        QueueLink helper = first;

        if (isEmpty()) {
            return 0;
        }
        while (helper.next != null) {
            sizeCounter++;
            helper = helper.next;
        }
        return sizeCounter;
    }

    boolean isEmpty() {
        return first == null;
    }

}

class QueueLink {
    String data;
    QueueLink next;
}

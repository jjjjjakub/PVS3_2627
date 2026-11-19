package Moje_slozka.OOP.adts;

public class StringStack {
    String[] data;
    int freeIndex;

    StringStack() {
        data = new String[5];
        freeIndex = 0;
    }

    void push(String toAdd) {
        data[freeIndex] = toAdd;
        freeIndex++;
    }

    String pop() {
        freeIndex--;
        return data[freeIndex];
    }

    String peak() {
        return data[freeIndex-1];
    }

    public static void main(String[] args) {
        StringStack test = new StringStack();
        test.push("Test");
        test.push("world");
        System.out.println(test.pop());
        test.push("example");
        System.out.println(test.peak());
        System.out.println(test.pop());

    }


}

package Moje_slozka.OOP.adts;

public class StringStack implements MyStack{
    String[] data;
    int freeIndex;
    private static final int BASE_SIZE = 16;

    private void expandArray() {
        String[] newPole = new String[(int) (data.length * 1.5)];

        for (int i = 0; i < data.length; i++) {
            newPole[i] = data[i];
        }
        data = newPole;
    }

    StringStack() {
        data = new String[BASE_SIZE];
        freeIndex = 0;
    }
    @Override
    public void push(String toAdd) {
        if (freeIndex == data.length) {
            expandArray();
        }
        data[freeIndex] = toAdd;
        freeIndex++;

    }

    @Override
    public String pop() {
        if (freeIndex > 0) {
            freeIndex--;
            return data[freeIndex];
        }
        else return null;
    }

    @Override
    public String peak() {
        if (freeIndex == 0) {
            return null;
        }
        return data[freeIndex-1];
    }

    @Override
    public boolean isEmpty() {

        return (freeIndex == 0);

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

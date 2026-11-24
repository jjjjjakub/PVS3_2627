package Moje_slozka.OOP.adts;

public class LinkStack implements MyStack{
    MyLink data;
    @Override
    public void push(String item) {
        data.setCurrent(item);
        data.setNext(new MyLink(""));
    }

    @Override
    public String pop() {
        return "";
    }

    @Override
    public String peak() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}

class MyLink {
    String current;
    MyLink next;

    public MyLink(String current) {
        this.current = current;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public MyLink getNext() {
        return next;
    }

    public void setNext(MyLink next) {
        this.next = next;
    }
}

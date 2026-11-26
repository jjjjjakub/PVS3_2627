package Moje_slozka.OOP.adts;

public class QueuePractice {
    public static void main(String[] args) {
        StringQueue queue = new StringQueue();
        queue.enqueue("Test");
        queue.enqueue("Dalsi");
        queue.enqueue("Slovo");

        System.out.println(queue.peek());
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Another");
        System.out.println(queue.peek());
        System.out.println(queue.getSize());

        //ruská ruleta

        StringQueue roulette = new StringQueue();

        queue.enqueue("Bob");
        queue.enqueue("Derek");
        queue.enqueue("Václav");
        queue.enqueue("Horvát");
        queue.enqueue("Marshal Malinovsky");
        queue.enqueue("ClovekuvLidoborec");
        String onTurn;
        while (queue.getSize() > 1) {
            onTurn = roulette.dequeue();
            if (Math.random() > 0.16) {
                roulette.enqueue(onTurn);
            }
        }


    }
}

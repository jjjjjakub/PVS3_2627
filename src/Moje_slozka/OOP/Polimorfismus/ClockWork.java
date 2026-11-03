package Moje_slozka.OOP.Polimorfismus;

public class ClockWork {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch(0);
        watch.setStart();
        watch.addMiliseconds(5000);
        watch.setStop();
        watch.addMiliseconds(7000);
        watch.displayTime();
    }
}

class DigitalClock implements TimeSupport{
    int year, month, day, hour, minute, second;

    public DigitalClock(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public void displayTime() {
        System.out.println("Today is: " + day + ". " + "Hour: " + hour +":"+ minute +":"+ second);
    }
}

class StopWatch implements TimeSupport{
    long miliseconds;

    long start;

    long stop;

    void setStart() {
        start = miliseconds;
    }

    void addMiliseconds(long toAdd) {
        miliseconds += toAdd;
    }

    void setStop() {
        stop = miliseconds;
    }

    public StopWatch(long miliseconds) {
        this.miliseconds = miliseconds;
    }

    @Override
    public void displayTime() {
        long duration = stop - start;
        double seconds = duration / 1000.0;

        int minutes = (int) (seconds / 60);

        double s = seconds % 60.0;

        System.out.println(minutes + ". " + seconds + ".");
    }
}

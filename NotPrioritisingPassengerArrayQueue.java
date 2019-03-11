package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Category;
import dk.cphbusiness.airport.template.Clock;
import dk.cphbusiness.airport.template.Passenger;
import dk.cphbusiness.airport.template.PassengerConsumer;
import dk.cphbusiness.airport.template.PassengerProducer;
import dk.cphbusiness.airport.template.Plane;
import dk.cphbusiness.airport.template.Time;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * An implementation of a queue using a fixed, non-expandable array whose
 * capacity is set in its constructor.
 *
 * @author mbeg
 *
 */
public class NotPrioritisingPassengerArrayQueue implements PriorityQueue<Passenger> {

    private static Clock clock;
    private final Passenger[] items;
    private int size = 0;
    private int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added
    private static PassengerProducer producer;
    private static PassengerConsumer consumer;

    public NotPrioritisingPassengerArrayQueue(int capacity) {
        //items = (T[])new Object[capacity];
        items = new Passenger[capacity];
    }

    public void enqueue(Passenger item) {
        if (size == items.length) {
            throw new IllegalStateException("Cannot add to full queue");
        }
        System.out.println("tail is: " + tail);
        items[tail] = item;

        tail = (tail + 1) % items.length;

        size++;
    }

    public Passenger dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        Passenger item = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        size--;
        return item;
    }

    public Passenger peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        return items[head];
    }

    public int size() {
        return size;
    }

    @Override
    public void insertionSort() {

        clock = new Clock(producer, consumer, new Time(05, 00, 00));
        ArrayList<Passenger> passengerList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            passengerList.add(getRandomPassenger());
        }
        System.out.println("before sort:\n\n");
        for (int i = 0; i < passengerList.size(); i++) {
            System.out.println(passengerList.get(i).getCategory());
        }
        for (int i = 0; i < passengerList.size(); i++) {
            if (i + 1 >= passengerList.size()) {
                break;
            }

            if (getPriority(passengerList.get(i).getCategory()) > getPriority(passengerList.get(i + 1).getCategory())) {
                Passenger move = passengerList.get(i);
                Passenger compareWithRest = passengerList.get(i + 1);
                passengerList.set(i, compareWithRest);
                passengerList.set(i + 1, move);
                for (int j = i - 1; j >= 0; j--) {
                    if (getPriority(compareWithRest.getCategory()) > getPriority(passengerList.get(j).getCategory())) {
                        break;
                    }
                    if (getPriority(compareWithRest.getCategory()) < getPriority(passengerList.get(j).getCategory())) {
                        Passenger holder = passengerList.get(j);
                        passengerList.set(j, compareWithRest);
                        passengerList.set(j + 1, holder);
                    }
                }
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("after sort:\n\n");
        for (int i = 0; i < passengerList.size(); i++) {
            System.out.println(passengerList.get(i).getCategory());
        }

    }

    static Passenger getRandomPassenger() {
        Time now = clock.getTime();
        ArrayList<Category> c = new ArrayList<>();
        c.add(Category.BusinessClass);
        c.add(Category.Disabled);
        c.add(Category.Family);
        c.add(Category.LateToFlight);
        c.add(Category.Monkey);
        Random r = new Random();
        Passenger passenger = new Passenger(0, now, c.get(r.nextInt(c.size())), new Plane(new Time(2, 00, 00)));
        return passenger;
    }

    @Override
    public int getPriority(Category category) {
        if (category == Category.Monkey) {
            return 5;
        }
        if (category == Category.Family) {
            return 4;
        }
        if (category == Category.BusinessClass) {
            return 3;
        }
        if (category == Category.Disabled) {
            return 2;
        }
        if (category == Category.LateToFlight) {
            return 1;
        }
        return 0;
    }

}

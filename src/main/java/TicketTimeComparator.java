import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        if (t1.getFligtTime() < t2.getFligtTime()) {
            return -1;
        } else if (t1.getFligtTime() > t2.getFligtTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}
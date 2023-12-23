import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket(
            "Москва",
            "Хельсинги",
            200,
            12,
            24

    );
    Ticket ticket2 = new Ticket(
            "Санкт-Петербург",
            "Берлин",
            300,
            13,
            23

    );
    Ticket ticket3 = new Ticket(
            "Санкт-Петербург",
            "Берлин",
            400,
            3,
            4

    );
    Ticket ticket4 = new Ticket(
            "Санкт-Петербург",
            "Берлин",
            100,
            2,
            5

    );

    @Test
    public void compareToTest() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
        expected = 1;
        actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);

        expected = 1;
        actual = ticket3.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchTest() {
        AviaSouls tikets = new AviaSouls();
        tikets.add(ticket1);
        tikets.add(ticket2);
        tikets.add(ticket3);
        tikets.add(ticket4);

        Ticket[] expected = {ticket4, ticket2, ticket3};
        Ticket[] actual = tikets.search("Санкт-Петербург", "Берлин");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ticketTimeComparatorTest() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        int expected = 1;
        int actual = comparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
        expected = -1;
        actual = comparator.compare(ticket2, ticket1);

        Assertions.assertEquals(expected, actual);

        expected = -1;
        actual = comparator.compare(ticket3, ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchAndSortByTest() {
        AviaSouls tikets = new AviaSouls();
        tikets.add(ticket1);
        tikets.add(ticket2);
        tikets.add(ticket3);
        tikets.add(ticket4);
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket3, ticket4, ticket2};
        Ticket[] actual = tikets.searchAndSortBy("Санкт-Петербург", "Берлин", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

}

// Custom Exception
class NoSeatsAvailableException extends Exception {
    public NoSeatsAvailableException(String message) {
        super(message);
    }
}

// Flight Class
class Flight {
    private String flightName;
    private int availableSeats;

    public Flight(String flightName, int availableSeats) {
        this.flightName = flightName;
        this.availableSeats = availableSeats;
    }

    public void bookSeat(int seats) throws NoSeatsAvailableException {

        if (seats > availableSeats) {
            throw new NoSeatsAvailableException(
                "Not enough seats available! Only " + availableSeats + " seats left."
            );
        }

        availableSeats -= seats;
        System.out.println(seats + " seat(s) booked successfully on " + flightName);
        System.out.println("Remaining seats: " + availableSeats);
    }
}

// Main Class
public class FlightBookingSystem {
    public static void main(String[] args) {

        Flight flight = new Flight("Indigo 6E123", 5);

        try {
            flight.bookSeat(3);  // Successful
            flight.bookSeat(4);  // Will throw exception
        } 
        catch (NoSeatsAvailableException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
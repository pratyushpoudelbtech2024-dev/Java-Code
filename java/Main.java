// Custom Exception Class
class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String message) {
        super(message);
    }
}

// Movie Class
class Movie {
    private String movieName;
    private int availableSeats;

    // Constructor
    public Movie(String movieName, int availableSeats) {
        this.movieName = movieName;
        this.availableSeats = availableSeats;
    }

    // Method to book tickets
    public void bookTicket(int seats) throws SeatNotAvailableException {
        if (seats > availableSeats) {
            throw new SeatNotAvailableException(
                "Seats not available! Only " + availableSeats + " seats left."
            );
        }

        availableSeats -= seats;
        System.out.println(seats + " seat(s) booked successfully for " + movieName);
        System.out.println("Remaining seats: " + availableSeats);
    }
}

// Main Clas
public class Main {
    public static void main(String[] args) {

        Movie movie = new Movie("Avengers", 5);

        try {
            movie.bookTicket(3);  // Successful booking
            movie.bookTicket(4);  // This will throw exception
        } 
        catch (SeatNotAvailableException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
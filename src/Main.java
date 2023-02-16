import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var airports = new LinkedList<Airport>();
        airports.add(new Airport(1, "Бориспіль"));
        airports.add(new Airport(2, "Charles de Gaulle"));
        airports.add(new Airport(3, "Schiphol"));
        airports.add(new Airport(4, "El Prat"));
        var airplanes = new ArrayList<Airplane>();
        airplanes.add(new Airplane(10, LocalDate.of(2000, 5, 25)));
        airplanes.add(new Airplane(20, LocalDate.of(2002, 10, 25)));
        airplanes.add(new Airplane(30, LocalDate.of(1989, 12, 30)));
        var flights = new ArrayList<Flight>();
        flights.add(new Flight(100, 10, 1, 2, LocalDate.of(2020, 5, 25), 150));
        flights.add(new Flight(200, 10, 1, 3, LocalDate.of(2020, 6, 25), 100));
        flights.add(new Flight(300, 10, 2, 1, LocalDate.of(2020, 5, 26), 95));
        flights.add(new Flight(400, 20, 1, 3, LocalDate.of(2020, 8, 26), 155));
        flights.add(new Flight(500, 20, 3, 1, LocalDate.of(2020, 8, 27), 132));
        var query = flights.
                stream().
                filter(e -> e.date.isAfter(LocalDate.of(2020, 1, 1)) && e.date.isBefore(LocalDate.of(2020, 12, 31)))
                .map(Flight::getFromAirportId)
                .map(id -> new Info(id, airports.
                        stream().
                        filter(e -> e.getAirportId() == id).
                        map(Airport::getName).
                        findFirst().
                        orElse("nothing"),
                        (int) flights.
                                stream().
                                map(elem -> elem.FromAirportId).
                                filter(elem -> elem == id).
                                count())).
                sorted(Comparator.comparingInt(Info::getFlightCount).reversed()).
                distinct().
                collect(Collectors.toCollection(ArrayList::new));
        for (var i : query) {
            System.out.println(i.AirportId + " " + i.AirportName + " " + i.FlightCount);
        }
    }
}
     class Info
    {
       int AirportId;
       String AirportName;
       int  FlightCount;
       public Info(int AirportId, String AirportName, int FlightCount)
       {
           this.AirportId = AirportId;
           this.AirportName = AirportName;
           this.FlightCount = FlightCount;
       }

        public int getAirportId() {
            return AirportId;
        }

        public int getFlightCount() {
            return FlightCount;
        }
        @Override
        public int hashCode()
        {
            return Objects.hash(AirportId, AirportName, FlightCount);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return this.AirportId== info.AirportId;
        }
    }

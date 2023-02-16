import java.time.LocalDate;

public class Flight
{
    public int FlightId;
    public int AirplaneId;
    public int FromAirportId;
    public int ToAirportId;
    public LocalDate date;
    public int PassengerCount;
    public Flight(int FlightId, int AirplaneId, int FromAirportId, int ToAirportId, LocalDate date, int PassengerCount)
    {
        this.FlightId = FlightId;
        this.AirplaneId = AirplaneId;
        this.FromAirportId = FromAirportId;
        this.ToAirportId = ToAirportId;
        this.date = date;
        this.PassengerCount = PassengerCount;
    }

    public int getFromAirportId() {
        return FromAirportId;
    }
}

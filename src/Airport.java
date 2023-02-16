public class Airport
{
    public int AirportId;
    public String Name;
    public Airport(int AirportId, String name)
    {
        this.AirportId = AirportId;
        this.Name = name;

    }
    public int getAirportId ()
    {
        return AirportId;
    }
    public String getName()
    {
        return Name;
    }
}

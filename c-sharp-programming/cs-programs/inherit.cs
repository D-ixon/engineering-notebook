public class Car
{
    public string Brand { get; set; }
    public void Drive() => Console.WriteLine("Driving...");

}

public class SportsCar : Car
{
    public void Turbo() => Console.WriteLine("Turbo boost!...");
    
}
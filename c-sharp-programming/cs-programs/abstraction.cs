public abstract class Vechile
{
    public abstract void StartEngine();
}

public class Car : Vechile
{
    public override void StartEngine()
    {
        Console.WriteLine("Turning the key and starting the engine...");
    }
}
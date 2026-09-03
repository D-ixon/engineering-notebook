public class Car
{
    private int _speed;

    public int Speed
    {
        get { return _speed;}
        set

        {
            if (value >= 0)
            _speed = value;
        }
    }
}
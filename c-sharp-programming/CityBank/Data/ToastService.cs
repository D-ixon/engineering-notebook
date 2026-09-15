namespace CityBank.Data;

public class ToastService
{
    public event Action<string, string>? OnShow;

    public void ShowToast(string message, string cssClass = "bg-success")
    {
        OnShow?.Invoke(message, cssClass);
    }
}
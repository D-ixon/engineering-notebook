using Enterprise.Data.Enums;

namespace Enterprise.Data.Models;

public class TelemetryReading
{
    public string Id { get; set; } = Guid.NewGuid().ToString("N")[..8];
    public string ContainerId { get; set; } = string.Empty;
    public DateTime Timestamp { get; set; } = DateTime.UtcNow;
    
    public double TemperatureCelsius { get; set; }
    public double HumidityPercentage { get; set; }
    public double Latitude { get; set; }
    public double Longitude { get; set; }
    public bool ShockDetected { get; set; }
    
    public AlarmLevel Alarm { get; set; } = AlarmLevel.Normal;
}
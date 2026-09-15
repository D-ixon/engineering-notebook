using Enterprise.Data.Enums;
using Enterprise.Data.Models;
using System.Collections.Concurrent;

namespace Enterprise.Services;

public interface ITelemetrySimulatorService
{
    event Action<TelemetryReading>? OnTelemetryReceived;
    List<TelemetryReading> GetRecentReadings(string? containerId = null);
}

public class TelemetrySimulatorService : ITelemetrySimulatorService
{
    public event Action<TelemetryReading>? OnTelemetryReceived;
    private readonly ConcurrentQueue<TelemetryReading> _readingHistory = new();
    private readonly Timer _timer;

    public TelemetrySimulatorService()
    {
        // Broadcast telemetry every 3 seconds
        _timer = new Timer(GenerateTelemetry, null, TimeSpan.Zero, TimeSpan.FromSeconds(3));
    }

    private void GenerateTelemetry(object? state)
    {
        var containers = new[] { "C101", "C102", "C103", "C104", "C105" };
        var selectedId = containers[Random.Shared.Next(containers.Length)];

        // Generate baseline readings with random drift
        double temp = Math.Round(3.5 + (Random.Shared.NextDouble() * 3.0 - 1.5), 2);
        double humidity = Math.Round(60.0 + (Random.Shared.NextDouble() * 10.0 - 5.0), 1);
        bool shock = Random.Shared.Next(0, 20) == 1; // 5% chance of impact shock

        var reading = new TelemetryReading
        {
            ContainerId = selectedId,
            Timestamp = DateTime.UtcNow,
            TemperatureCelsius = temp,
            HumidityPercentage = humidity,
            Latitude = Math.Round(5.6037 + (Random.Shared.NextDouble() * 0.1 - 0.05), 4),
            Longitude = Math.Round(-0.1870 + (Random.Shared.NextDouble() * 0.1 - 0.05), 4),
            ShockDetected = shock,
            Alarm = shock ? AlarmLevel.Critical : (temp > 5.5 ? AlarmLevel.Warning : AlarmLevel.Normal)
        };

        _readingHistory.Enqueue(reading);

        // Keep rolling buffer capped at 50 readings
        while (_readingHistory.Count > 50)
        {
            _readingHistory.TryDequeue(out _);
        }

        OnTelemetryReceived?.Invoke(reading);
    }

    public List<TelemetryReading> GetRecentReadings(string? containerId = null)
    {
        var list = _readingHistory.ToList();
        if (!string.IsNullOrWhiteSpace(containerId))
        {
            return list.Where(r => r.ContainerId == containerId).OrderByDescending(r => r.Timestamp).ToList();
        }
        return list.OrderByDescending(r => r.Timestamp).ToList();
    }
}
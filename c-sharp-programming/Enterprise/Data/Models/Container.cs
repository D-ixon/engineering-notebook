using System.ComponentModel.DataAnnotations;
using Enterprise.Data.Enums;

namespace Enterprise.Data.Models;

public class Container
{
    public string Id { get; set; } = Guid.NewGuid().ToString("N")[..8].ToUpper();

    [Required(ErrorMessage = "Container Code is required (e.g., MSKU-904123-8)")]
    [RegularExpression(@"^[A-Z]{4}-\d{6}-\d$", ErrorMessage = "Format must match standard ISO code (e.g., MSKU-904123-8)")]
    public string ContainerNumber { get; set; } = string.Empty;

    public ContainerType Type { get; set; } = ContainerType.Reefer;

    public ContainerStatus Status { get; set; } = ContainerStatus.Available;

    [Range(1000, 50000, ErrorMessage = "Max Payload must be between 1,000 kg and 50,000 kg")]
    public double MaxPayloadKg { get; set; } = 28000;

    public string AssignedSensorId { get; set; } = string.Empty;

    public DateTime LastServiced { get; set; } = DateTime.UtcNow.AddMonths(-2);

    // Operational threshold configuration for Reefer containers
    public double TargetTempCelsius { get; set; } = 4.0;
    public double TempToleranceRange { get; set; } = 2.0;
}
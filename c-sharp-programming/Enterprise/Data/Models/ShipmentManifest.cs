using System.ComponentModel.DataAnnotations;
using Enterprise.Data.Enums;

namespace Enterprise.Data.Models;

public class ShipmentManifest
{
    [Key]
    public string ManifestId { get; set; } = Guid.NewGuid().ToString("N")[..8].ToUpper();
    
    public string ManifestNumber { get; set; } = string.Empty;
    public string OriginHub { get; set; } = string.Empty;
    public string DestinationHub { get; set; } = string.Empty;
    public string Carrier { get; set; } = string.Empty;
    public DateTime DepartureTime { get; set; }
    public DateTime EstimatedArrival { get; set; }
    
    public List<string> ContainerIds { get; set; } = new();
}
namespace Enterprise.Data.Enums;

public enum ContainerType
{
    Reefer,        // Temperature-controlled (Refrigerated)
    DryStorage,    // Standard dry cargo
    FlatRack,      // Heavy/Oversized load
    OpenTop        // Top-loading tall cargo
}

public enum ContainerStatus
{
    Available,     // Ready at hub/port
    InTransit,     // On active shipment manifest
    PortHold,      // Customs clearance or inspection hold
    Maintenance,   // Servicing or repair
    Decommissioned // End of operational lifecycle
}

public enum AlarmLevel
{
    Normal,        // All sensor metrics within operational threshold
    Warning,       // Minor temperature/humidity drift
    Critical       // Severe temperature excursion or impact/shock detected
}
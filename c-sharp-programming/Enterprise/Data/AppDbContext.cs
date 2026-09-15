using Enterprise.Data.Enums;
using Enterprise.Data.Models;
using Microsoft.EntityFrameworkCore;

namespace Enterprise.Data;

public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

    public DbSet<Container> Containers => Set<Container>();
    public DbSet<ShipmentManifest> Manifests => Set<ShipmentManifest>();

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        base.OnModelCreating(modelBuilder);

        // Serialization converter for SQLite to store List<string> ContainerIds as a comma-separated string
        modelBuilder.Entity<ShipmentManifest>()
            .Property(m => m.ContainerIds)
            .HasConversion(
                v => string.Join(',', v),
                v => v.Split(',', StringSplitOptions.RemoveEmptyEntries).ToList()
            );

        // Initial Seed Data
        modelBuilder.Entity<Container>().HasData(
            new Container { Id = "C101", ContainerNumber = "MSKU-904123-8", Type = ContainerType.Reefer, Status = ContainerStatus.InTransit, MaxPayloadKg = 28000, TargetTempCelsius = 4.0, AssignedSensorId = "IOT-8821" },
            new Container { Id = "C102", ContainerNumber = "HAPG-441092-1", Type = ContainerType.DryStorage, Status = ContainerStatus.Available, MaxPayloadKg = 30400, TargetTempCelsius = 20.0, AssignedSensorId = "IOT-3319" },
            new Container { Id = "C103", ContainerNumber = "CMAU-110294-5", Type = ContainerType.FlatRack, Status = ContainerStatus.PortHold, MaxPayloadKg = 45000, TargetTempCelsius = 15.0, AssignedSensorId = "IOT-9904" },
            new Container { Id = "C104", ContainerNumber = "EVER-772910-3", Type = ContainerType.Reefer, Status = ContainerStatus.InTransit, MaxPayloadKg = 26500, TargetTempCelsius = -18.0, AssignedSensorId = "IOT-5512" }
        );
    }
}
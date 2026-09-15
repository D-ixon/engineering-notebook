using Enterprise.Data;
using Enterprise.Data.Models;
using Microsoft.EntityFrameworkCore;

namespace Enterprise.Services;

public interface IManifestService
{
    Task<List<ShipmentManifest>> GetManifestsAsync();
    Task<ShipmentManifest?> GetManifestByIdAsync(string id);
    Task<ShipmentManifest> CreateManifestAsync(ShipmentManifest manifest);
    Task<bool> UpdateManifestAsync(ShipmentManifest manifest);
    Task<bool> DeleteManifestAsync(string id);
}

public class ManifestService : IManifestService
{
    private readonly IDbContextFactory<AppDbContext> _dbFactory;

    public ManifestService(IDbContextFactory<AppDbContext> dbFactory)
    {
        _dbFactory = dbFactory;
    }

    public async Task<List<ShipmentManifest>> GetManifestsAsync()
    {
        await using var context = await _dbFactory.CreateDbContextAsync();
        return await context.Manifests.OrderByDescending(m => m.DepartureTime).ToListAsync();
    }

    public async Task<ShipmentManifest?> GetManifestByIdAsync(string id)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();
        return await context.Manifests.FindAsync(id);
    }

    public async Task<ShipmentManifest> CreateManifestAsync(ShipmentManifest manifest)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();

        if (string.IsNullOrWhiteSpace(manifest.ManifestId))
        {
            manifest.ManifestId = Guid.NewGuid().ToString("N")[..8].ToUpper();
        }

        if (string.IsNullOrWhiteSpace(manifest.ManifestNumber))
        {
            manifest.ManifestNumber = $"MNF-2026-{Random.Shared.Next(1000, 9999)}";
        }

        context.Manifests.Add(manifest);
        await context.SaveChangesAsync();
        return manifest;
    }

    public async Task<bool> UpdateManifestAsync(ShipmentManifest manifest)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();
        context.Manifests.Update(manifest);
        return await context.SaveChangesAsync() > 0;
    }

    public async Task<bool> DeleteManifestAsync(string id)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();
        var manifest = await context.Manifests.FindAsync(id);
        if (manifest == null) return false;

        context.Manifests.Remove(manifest);
        return await context.SaveChangesAsync() > 0;
    }
}
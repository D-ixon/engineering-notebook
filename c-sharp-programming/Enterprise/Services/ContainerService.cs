using Enterprise.Data;
using Enterprise.Data.Enums;
using Enterprise.Data.Models;
using Microsoft.EntityFrameworkCore;

namespace Enterprise.Services;

public interface IContainerService
{
    Task<List<Container>> GetContainersAsync(string? searchTerm = null, ContainerStatus? statusFilter = null);
    Task<Container?> GetContainerByIdAsync(string id);
    Task<Container> CreateContainerAsync(Container container);
    Task<bool> UpdateContainerAsync(Container container);
    Task<bool> DeleteContainerAsync(string id);
}

public class ContainerService : IContainerService
{
    private readonly IDbContextFactory<AppDbContext> _dbFactory;

    public ContainerService(IDbContextFactory<AppDbContext> dbFactory)
    {
        _dbFactory = dbFactory;
    }

    public async Task<List<Container>> GetContainersAsync(string? searchTerm = null, ContainerStatus? statusFilter = null)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();
        var query = context.Containers.AsQueryable();

        if (!string.IsNullOrWhiteSpace(searchTerm))
        {
            query = query.Where(c => 
                c.ContainerNumber.Contains(searchTerm) || 
                c.AssignedSensorId.Contains(searchTerm));
        }

        if (statusFilter.HasValue)
        {
            query = query.Where(c => c.Status == statusFilter.Value);
        }

        return await query.OrderByDescending(c => c.LastServiced).ToListAsync();
    }

    public async Task<Container?> GetContainerByIdAsync(string id)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();
        return await context.Containers.FindAsync(id);
    }

    public async Task<Container> CreateContainerAsync(Container container)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();

        if (string.IsNullOrWhiteSpace(container.Id))
        {
            container.Id = Guid.NewGuid().ToString("N")[..8].ToUpper();
        }

        if (string.IsNullOrWhiteSpace(container.AssignedSensorId))
        {
            container.AssignedSensorId = $"IOT-{Random.Shared.Next(1000, 9999)}";
        }

        context.Containers.Add(container);
        await context.SaveChangesAsync();
        return container;
    }

    public async Task<bool> UpdateContainerAsync(Container container)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();
        context.Containers.Update(container);
        return await context.SaveChangesAsync() > 0;
    }

    public async Task<bool> DeleteContainerAsync(string id)
    {
        await using var context = await _dbFactory.CreateDbContextAsync();
        var container = await context.Containers.FindAsync(id);
        if (container == null) return false;

        context.Containers.Remove(container);
        return await context.SaveChangesAsync() > 0;
    }
}
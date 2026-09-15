using Microsoft.EntityFrameworkCore;

namespace CityBank.Data;

public class CityBankDbContext : DbContext
{
    public CityBankDbContext(DbContextOptions<CityBankDbContext> options) 
        : base(options) 
    { 
    }

    public DbSet<Account> Accounts => Set<Account>();
    public DbSet<Transaction> Transactions => Set<Transaction>();

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        base.OnModelCreating(modelBuilder);

        var seedDate = new DateTime(2026, 1, 1, 0, 0, 0, DateTimeKind.Utc);

        modelBuilder.Entity<Account>().HasData(
            new Account { Id = 1, AccountNumber = "10012345678", AccountHolder = "John Doe", AccountType = "Checking", Balance = 5420.50m, IsActive = true, CreatedAt = seedDate },
            new Account { Id = 2, AccountNumber = "20098765432", AccountHolder = "Jane Smith", AccountType = "Savings", Balance = 12850.00m, IsActive = true, CreatedAt = seedDate },
            new Account { Id = 3, AccountNumber = "30011223344", AccountHolder = "Apex Dynamics LLC", AccountType = "Business", Balance = 48900.75m, IsActive = true, CreatedAt = seedDate }
        );
    }
}
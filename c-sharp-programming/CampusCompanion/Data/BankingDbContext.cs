using Microsoft.EntityFrameworkCore;
using CampusCompanion.Models;

namespace CampusCompanion.Data;

public class BankingDbContext : DbContext
{
public BankingDbContext(DbContextOptions<BankingDbContext> options)
: base(options)
{
}

public DbSet<BankAccount> BankAccounts { get; set; }

}

using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CityBank.Data;

public enum TransactionType
{
    Deposit,
    Withdrawal,
    Transfer
}

public class Transaction
{
    [Key]
    public int Id { get; set; }

    public int AccountId { get; set; }
    
    [ForeignKey("AccountId")]
    public Account? Account { get; set; }

    public int? DestinationAccountId { get; set; }

    [Required]
    public TransactionType Type { get; set; }

    [Column(TypeName = "decimal(18, 2)")]
    [Range(0.01, 1_000_000, ErrorMessage = "Amount must be greater than 0.")]
    public decimal Amount { get; set; }

    public string Description { get; set; } = string.Empty;

    public DateTime Timestamp { get; set; } = DateTime.UtcNow;
}
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CityBank.Data;

public class Account
{
    [Key]
    public int Id { get; set; }

    [Required(ErrorMessage = "Account Number is required.")]
    [StringLength(12, MinimumLength = 10, ErrorMessage = "Account Number must be between 10 and 12 digits.")]
    public string AccountNumber { get; set; } = string.Empty;

    [Required(ErrorMessage = "Account Holder Name is required.")]
    [StringLength(100, ErrorMessage = "Account Holder Name cannot exceed 100 characters.")]
    public string AccountHolder { get; set; } = string.Empty;

    [Required]
    public string AccountType { get; set; } = "Checking"; // Checking, Savings, Business

    [Column(TypeName = "decimal(18, 2)")]
    [Range(0, 1_000_000_000, ErrorMessage = "Balance must be non-negative.")]
    public decimal Balance { get; set; }

    public bool IsActive { get; set; } = true;

    public DateTime CreatedAt { get; set; } = DateTime.UtcNow;
}
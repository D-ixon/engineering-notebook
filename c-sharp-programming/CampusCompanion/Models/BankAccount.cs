using System.ComponentModel.DataAnnotations;

namespace CampusCompanion.Models;

public class BankAccount
{
public int Id { get; set; }


[Required(ErrorMessage = "Account number is required.")]
public string AccountNumber { get; set; } = string.Empty;

[Required(ErrorMessage = "Account holder name is required.")]
public string AccountHolderName { get; set; } = string.Empty;

[Required(ErrorMessage = "Please select an account type.")]
public string AccountType { get; set; } = string.Empty;

[Range(0, 100000000, ErrorMessage = "Balance must be between GH₵0 and GH₵100,000,000.")]
public decimal Balance { get; set; }


}

using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace CityBank.Migrations
{
    /// <inheritdoc />
    public partial class InitialCityBankCreate : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Accounts",
                columns: table => new
                {
                    Id = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    AccountNumber = table.Column<string>(type: "TEXT", maxLength: 12, nullable: false),
                    AccountHolder = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    AccountType = table.Column<string>(type: "TEXT", nullable: false),
                    Balance = table.Column<decimal>(type: "decimal(18, 2)", nullable: false),
                    IsActive = table.Column<bool>(type: "INTEGER", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "TEXT", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Accounts", x => x.Id);
                });

            migrationBuilder.InsertData(
                table: "Accounts",
                columns: new[] { "Id", "AccountHolder", "AccountNumber", "AccountType", "Balance", "CreatedAt", "IsActive" },
                values: new object[,]
                {
                    { 1, "John Doe", "10012345678", "Checking", 5420.50m, new DateTime(2026, 1, 1, 0, 0, 0, 0, DateTimeKind.Utc), true },
                    { 2, "Jane Smith", "20098765432", "Savings", 12850.00m, new DateTime(2026, 1, 1, 0, 0, 0, 0, DateTimeKind.Utc), true },
                    { 3, "Apex Dynamics LLC", "30011223344", "Business", 48900.75m, new DateTime(2026, 1, 1, 0, 0, 0, 0, DateTimeKind.Utc), true }
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Accounts");
        }
    }
}

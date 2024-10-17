package exercise3;
public abstract class Mortgage implements MortgageConstants {
  private String mortgageNumber;
  private String customerName;
  private double mortgageAmount;
  protected double interestRate;
  private int term;

  public Mortgage(String mortgageNumber, String customerName, double amount, double interestRate, int term) {
    if (amount > MAX_MORTGAGE_AMOUNT) {
      System.out.println("Amount exceeds maximum mortgage limit. Setting amount to " + MAX_MORTGAGE_AMOUNT);
      this.mortgageAmount = MAX_MORTGAGE_AMOUNT;
    } else {
      this.mortgageAmount = amount;
    }

    this.mortgageNumber = mortgageNumber;
    this.customerName = customerName;
    this.interestRate = interestRate;

    if (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) {
      System.out.println("Invalid term. Setting to short-term (1 year).");
      this.term = SHORT_TERM;
    } else {
      this.term = term;
    }
  }

  public abstract void setInterestRate(double primeRate);

  public String getMortgageInfo() {
    return "Mortgage Number: " + mortgageNumber +
        "\nCustomer Name: " + customerName +
        "\nAmount: $" + mortgageAmount +
        "\nInterest Rate: " + interestRate + "%" +
        "\nTerm: " + term + " years" +
        "\nTotal Owed: $" + (mortgageAmount + mortgageAmount * (interestRate / 100) * term);
  }
}

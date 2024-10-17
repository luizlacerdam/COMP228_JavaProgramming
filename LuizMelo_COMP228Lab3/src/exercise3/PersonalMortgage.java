package exercise3;

public class PersonalMortgage extends Mortgage {

  public PersonalMortgage(String mortgageNumber, String customerName, double amount, double primeRate, int term) {
    super(mortgageNumber, customerName, amount, primeRate, term);
    setInterestRate(primeRate);
  }

  @Override
  public void setInterestRate(double primeRate) {
    double personalRate = primeRate + 2.0;
    super.interestRate = personalRate;
  }
}


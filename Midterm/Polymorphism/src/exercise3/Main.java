package exercise3;

public class Main {
  public static void main(String[] args) {
    Payable contractor = new Contractor("John", 10, 40);
    Payable employee = new Employee("Jane", 5000);
    Payable freelancer = new Freelancer(10, 100);

    System.out.println(contractor.pay());
    System.out.println(employee.pay());
    System.out.println(freelancer.pay());
  }

}

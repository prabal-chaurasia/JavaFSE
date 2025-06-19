package Eleventh;

interface CustomerRepository {
    String findCustomerById(String customerId);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String customerId) {
        return "Customer[ID=" + customerId + ", Name=Prabal Chaurasia]";
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerDetails(String customerId) {
        String customer = repository.findCustomerById(customerId);
        System.out.println("Fetched: " + customer);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.getCustomerDetails("C102");
    }
}

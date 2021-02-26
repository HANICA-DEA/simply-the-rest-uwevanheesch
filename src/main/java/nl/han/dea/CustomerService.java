package nl.han.dea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {

    // deployment

    private static CustomerService customerService = new CustomerService();

    private Map<Integer, CustomerDTO> customers = new HashMap<>();

    private CustomerService() {
        addCustomer(new CustomerDTO(1, "Uwe van Heesch"));
        addCustomer(new CustomerDTO(2, "Peter Pan"));

    }

    public void addCustomer(CustomerDTO customerDTO) {
        customers.put(customerDTO.getId(), customerDTO);
    }

    public static CustomerService getInstance() {
        return customerService;
    }

    public CustomerDTO getCustomer(Integer id) {
        return customers.get(id);
    }

    public void deleteCustomer(CustomerDTO customerDTO) {
        customers.remove(customerDTO.getId());
    }

    public void deleteCustomer(Integer customerId) {
        customers.remove(customerId);
    }


    public void updateCustomer(CustomerDTO customerDTO) {
        if (customers.get(customerDTO.getId()) == null) {
            throw new IllegalArgumentException("Customer does not exist");
        } else {
            customers.put(customerDTO.getId(), customerDTO);
        }
    }

    public List<CustomerDTO> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

}

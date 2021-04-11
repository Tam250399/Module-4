package Tam.service.customerService;

import Tam.model.Customer;
import Tam.model.Product;
import Tam.service.IGeneralSevice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralSevice<Customer> {
    Iterable<Customer> findAllByProduct(Product product);
    Page<Customer>findAll(Pageable pageable);
    Page<Customer>findAllByNameContaining(String name,Pageable pageable);

}

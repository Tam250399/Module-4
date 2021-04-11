package Tam.repository.customerRepository;

import Tam.model.Customer;
import Tam.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends PagingAndSortingRepository<Customer,Long>{
    Iterable<Customer>findAllByProduct(Product product);
    Page<Customer>findAllByNameContaining(String name, Pageable pageable);
}

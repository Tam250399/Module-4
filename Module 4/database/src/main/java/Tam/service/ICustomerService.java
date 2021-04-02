package Tam.service;

import Tam.model.Customer;
import Tam.model.Provinces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer>{
    Iterable<Customer> findAllByProvince(Provinces province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}

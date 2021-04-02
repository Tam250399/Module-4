package Tam.repository;

import Tam.model.Customer;
import Tam.model.Provinces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository <Customer,Long> {
    Iterable<Customer> findAllByProvince(Provinces province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}

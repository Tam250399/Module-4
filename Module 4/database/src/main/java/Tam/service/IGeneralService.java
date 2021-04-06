package Tam.service;

import Tam.model.Customer;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    Customer save(T t) throws DuplicateEmailException;

    void remove(Long id);

}

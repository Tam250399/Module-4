package Tam.service;

import Tam.model.Customer;

import java.util.List;
import java.util.Optional;

public interface IGeneralSevice<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    T save (T t);
    void remove(Long id);
}

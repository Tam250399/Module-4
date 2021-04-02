package Tam.service;

import Tam.model.Provinces;

import java.util.Optional;


public interface ProvinceService {
    Iterable<Provinces> findAll();

    Provinces findById(Long id);

    void save(Provinces province);

    void remove(Long id);
}

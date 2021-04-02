package Tam.service;

import Tam.model.Provinces;
import Tam.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {


    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Provinces> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Provinces findById(Long id) {
        return provinceRepository.findById(id).get();
    }

    @Override
    public void save(Provinces province) {
provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
     provinceRepository.deleteById(id);
    }
}

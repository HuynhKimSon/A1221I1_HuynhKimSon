package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.House;
import vn.codegym.repository.IHouseRepository;
import vn.codegym.service.IHouseService;

import java.util.List;

@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private IHouseRepository houseRepository;

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public House findById(Long id) {
        return houseRepository.findById(id).orElse(new House());
    }
}

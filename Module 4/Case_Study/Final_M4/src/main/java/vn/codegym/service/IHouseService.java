package vn.codegym.service;

import vn.codegym.model.House;

import java.util.List;

public interface IHouseService {
    List<House> findAll();

    House findById(Long id);
}

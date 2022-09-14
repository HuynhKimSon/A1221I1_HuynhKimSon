package vn.codegym.service;


import vn.codegym.dto.ContractDto;
import vn.codegym.dto.response.ResultContractRes;
import vn.codegym.model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    Contract findById(Long id);

    ResultContractRes save(ContractDto contractDto);

    void delete(Long id);
}

package vn.codegym.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.ContractDto;
import vn.codegym.dto.response.ResultContractRes;
import vn.codegym.model.Contract;
import vn.codegym.model.House;
import vn.codegym.repository.IContractRepository;
import vn.codegym.repository.IHouseRepository;
import vn.codegym.service.IContractService;
import vn.codegym.type.StatusType;

import java.util.HashMap;
import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IHouseRepository houseRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long id) {
        return null;
    }

    @Override
    public ResultContractRes save(ContractDto contractDto) {
        ResultContractRes resultContractRes = new ResultContractRes();
        HashMap<String, String> listError = checkContract(contractDto);
        if (listError.size() > 0) {
            resultContractRes.setCode(StatusType.FAIL.value());
            resultContractRes.setErrors(listError);
            return resultContractRes;
        }

        // Convert contractDto into contract
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        House house = new House();
        house.setIdHouse(Long.parseLong((contractDto.getHouse())));
        contract.setHouse(house);
        

        // Save
        contractRepository.save(contract);

        // Set result
        resultContractRes.setCode(StatusType.SUCCESS.value());
        resultContractRes.setContracts(contractRepository.findAll());
        return resultContractRes;
    }

    @Override
    public void delete(Long id) {
        contractRepository.deleteById(id);
    }

    private HashMap<String, String> checkContract(ContractDto contractDto) {
        HashMap<String, String> errors = new HashMap<>();

        return errors;
    }
}

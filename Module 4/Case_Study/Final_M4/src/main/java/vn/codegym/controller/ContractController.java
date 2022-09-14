package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.ContractDto;
import vn.codegym.dto.response.ResultContractRes;
import vn.codegym.model.Contract;
import vn.codegym.model.House;
import vn.codegym.service.IContractService;
import vn.codegym.service.IHouseService;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    private String prefix = "contract";

    @Autowired
    private IContractService contractService;

    @Autowired
    private IHouseService houseService;

    @GetMapping()
    public String processContract() {
        return prefix + "/contract";
    }

    @PostMapping("/list")
    public ResponseEntity<List<Contract>> getList() {
        List<Contract> list = contractService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/houseType")
    public ResponseEntity<List<House>> getCustomerType() {
        List<House> list = houseService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResultContractRes> createCustomer(@RequestBody ContractDto contractDto) {
        ResultContractRes result = contractService.save(contractDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<List<Contract>> remove(@RequestParam("id") Long id) {
        contractService.delete(id);
        List<Contract> list = contractService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

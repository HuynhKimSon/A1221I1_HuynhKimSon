package vn.codegym.dto.response;

import vn.codegym.model.Contract;

import java.util.HashMap;
import java.util.List;

public class ResultContractRes {
    private Integer code;
    private HashMap<String, String> errors;
    private List<Contract> contracts;

    public ResultContractRes() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

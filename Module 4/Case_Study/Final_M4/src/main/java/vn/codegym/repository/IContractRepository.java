package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Contract;

public interface IContractRepository extends JpaRepository<Contract,Long> {
}

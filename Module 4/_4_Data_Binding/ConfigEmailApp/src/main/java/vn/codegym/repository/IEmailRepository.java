package vn.codegym.repository;

import vn.codegym.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();

    void save(Email email);
}

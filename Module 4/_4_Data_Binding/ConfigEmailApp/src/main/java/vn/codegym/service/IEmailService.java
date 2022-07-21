package vn.codegym.service;

import vn.codegym.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();

    void save(Email email);
}

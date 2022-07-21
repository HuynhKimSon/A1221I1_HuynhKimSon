package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Email;
import vn.codegym.repository.IEmailRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepositoryImpl implements IEmailRepository {

    private static List<Email> emailList;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1, "English", 5, false, "SONHK1"));
        emailList.add(new Email(2, "Vietnamese", 25, true, "SONHK2"));
        emailList.add(new Email(3, "Japanese", 15, false, "SONHK3"));
        emailList.add(new Email(4, "Chinese", 10, false, "SONHK4"));
        emailList.add(new Email(5, "Japanese", 5, false, "SONHK5"));
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public void save(Email email) {
        emailList.add(email);
    }
}

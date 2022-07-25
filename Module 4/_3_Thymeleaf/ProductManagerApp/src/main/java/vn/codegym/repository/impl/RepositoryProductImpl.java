package vn.codegym.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;
import vn.codegym.repository.IRepositoryProduct;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RepositoryProductImpl implements IRepositoryProduct {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager
                .createQuery("SELECT s FROM Product as s", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {

    }
}

package vn.codegym.repository.impl;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Song;
import vn.codegym.repository.IMusicRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepositoryImpl implements IMusicRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = (TypedQuery<Song>) entityManager.createNativeQuery("SELECT * FROM song", Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        entityManager.persist(song);
    }
}

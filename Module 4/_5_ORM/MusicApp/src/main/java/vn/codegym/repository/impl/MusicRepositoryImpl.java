package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Music;
import vn.codegym.repository.IMusicRepository;

import java.util.List;

@Repository
public class MusicRepositoryImpl implements IMusicRepository {

    @Override
    public List<Music> findAll() {
        return null;
    }

    @Override
    public void save(Music music) {

    }
}

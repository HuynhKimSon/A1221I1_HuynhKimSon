package vn.codegym.repository;

import vn.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music);
}

package vn.codegym.repository;

import vn.codegym.model.Song;

import java.util.List;

public interface IMusicRepository {
    List<Song> findAll();

    void save(Song song);
}

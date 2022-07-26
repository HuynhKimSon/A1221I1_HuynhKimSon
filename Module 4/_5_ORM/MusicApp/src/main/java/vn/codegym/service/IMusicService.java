package vn.codegym.service;

import vn.codegym.model.Song;

import java.util.List;

public interface IMusicService {
    List<Song> findAll();

    void save(Song song);
}

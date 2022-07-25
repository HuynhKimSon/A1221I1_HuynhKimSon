package vn.codegym.service;

import vn.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);
}

package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Music;
import vn.codegym.repository.IMusicRepository;
import vn.codegym.service.IMusicService;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {

    }
}

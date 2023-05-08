package service.impl;

import controllers.DirectorDTO;
import controllers.DirectorRequest;
import service.DirectorService;

import java.util.List;

public class DirectorServiceImpl implements DirectorService {
    @Override
    public List<DirectorDTO> findAllDirectors() {
        return null;
    }

    @Override
    public DirectorDTO findDirectorById(Long directorId) {
        return null;
    }

    @Override
    public Long createDirector(DirectorRequest directorRequest) {
        return null;
    }

    @Override
    public DirectorDTO updateDirector(Long directorId, DirectorRequest directorRequest) {
        return null;
    }

    @Override
    public boolean deleteDirector(Long directorId) {
        return false;
    }
}

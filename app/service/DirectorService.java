package service;

import controllers.DirectorDTO;
import controllers.DirectorRequest;

import java.util.List;

public interface DirectorService {

    List<DirectorDTO> findAllDirectors();
    DirectorDTO findDirectorById(Long directorId);
    Long createDirector(DirectorRequest directorRequest);
    DirectorDTO updateDirector(Long directorId, DirectorRequest directorRequest);
    boolean deleteDirector(Long directorId);
}

package controllers;

import service.DirectorService;

public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }


    public DirectorDTO getDirectorById(Long id){
        return directorService.findDirectorById(id);
    }
}

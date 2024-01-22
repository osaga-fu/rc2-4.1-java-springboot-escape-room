package org.factoriaf5.backend.controllers;

public class MovieResponse {
    
    private String title;
    private Long id;

    public MovieResponse(Long id, String title){
        this.id = id;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public Long getId(){
        return id;
    }
}

package org.factoriaf5.backend.controllers;

public class MovieResponse {
    
    private String title;
    private Long id;

    public MovieResponse(String title, Long id){
        this.title = title;
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public Long getId(){
        return this.id;
    }
}

package org.factoriaf5.backend.controllers;

public class MovieRequest {
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String whichMovie() {
        return "La película es " + this.title;
    }
}
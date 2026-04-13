package com.marsapp.marsapp.news;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "x_link", columnDefinition = "TEXT")
    private String xLink;

    @Column(name = "youtube_link", columnDefinition = "TEXT")
    private String youtubeLink;

    @Column(name = "instagram_link", columnDefinition = "TEXT")
    private String instagramLink;

    public Author() {}

    public Author(String name) {this.name = name;}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getxLink() {
        return xLink;
    }
    public void setxLink(String xLink) {
        this.xLink = xLink;
    }
    public String getYoutubeLink() {
        return youtubeLink;
    }
    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
    public String getInstagramLink() {
        return instagramLink;
    }
    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }
    
}

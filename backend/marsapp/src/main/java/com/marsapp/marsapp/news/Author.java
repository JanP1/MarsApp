package com.marsapp.marsapp.news;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Author {

    @Column
    private String name;

    @Column(name = "x_link", columnDefinition = "TEXT")
    private String xLink;

    @Column(name = "youtube_link", columnDefinition = "TEXT")
    private String youtubeLink;

    @Column(name = "instagram_link", columnDefinition = "TEXT")
    private String instagramLink;

    public Author() {}

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

package com.testing.demo.Model.Request;

import org.springframework.data.annotation.Id;

public class DownloadCategory {
    @Id
    private String id;
    private String downloadHeader;
    private String downloadDescription;
    private String type;
    private String link;

    /**
     * Type of the download category will have the link to the, files.
     * Types of files will be research papers, templates...
     *
     * **/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDownloadHeader() {
        return downloadHeader;
    }

    public void setDownloadHeader(String downloadHeader) {
        this.downloadHeader = downloadHeader;
    }

    public String getDownloadDescription() {
        return downloadDescription;
    }

    public void setDownloadDescription(String downloadDescription) {
        this.downloadDescription = downloadDescription;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package org.kuroneko.starpivot.entity.file;

import java.io.Serializable;

public class FileDetail implements Serializable {
    private String path;
    private String content;

    public FileDetail(String path, String content) {
        this.path = path;
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

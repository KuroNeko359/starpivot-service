package org.kuroneko.starpivot.entity;


import org.apache.hadoop.fs.FileStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSystemRoot {
    List<FileSystemItem> items = new ArrayList<>();

    public void putItems(FileSystemItem children) {
        this.items.add(children);
    }

    public List<FileSystemItem> getItems() {
        return new ArrayList<>(items);
    }
}

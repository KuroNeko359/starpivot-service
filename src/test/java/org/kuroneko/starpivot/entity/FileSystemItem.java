package org.kuroneko.starpivot.entity;

import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileSystemItem extends LocatedFileStatus {
    List<FileSystemItem> children = new ArrayList<>();

    public FileSystemItem() {
        super();
    }

    public FileSystemItem(LocatedFileStatus locatedFileStatus) {
        super(locatedFileStatus,locatedFileStatus.getBlockLocations());
        this.children = new ArrayList<>();
    }

    public void addChildren(FileSystemItem children) {
        this.children.add(children);
    }

    @Override
    public String toString() {
        return "FileSystemItem{" +
                "data=" + super.toString() +
                ",children=" + children +
                '}';
    }
}
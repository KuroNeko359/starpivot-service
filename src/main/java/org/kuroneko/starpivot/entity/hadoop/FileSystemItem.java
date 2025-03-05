package org.kuroneko.starpivot.entity.hadoop;

import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.LocatedFileStatus;

import java.util.ArrayList;
import java.util.List;

public class FileSystemItem extends LocatedFileStatus {
    List<FileSystemItem> children = new ArrayList<>();

    public FileSystemItem() {
        super();
    }

    public FileSystemItem(LocatedFileStatus locatedFileStatus) {
        super(locatedFileStatus,locatedFileStatus.getBlockLocations());
        this.children = new ArrayList<>();
    }

    public List<FileSystemItem> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "FileSystemItem{" +
                "data=" + super.toString() +
                ",children=" + children +
                '}';
    }

}
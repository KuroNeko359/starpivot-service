package org.kuroneko.starpivot.entity.hadoop;

import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class File implements Serializable {
    private String name;
    private String url;
    private String path;
    private long length;
    private Boolean isDir;
    private short blockReplication;
    private long blockSize;
    private long modificationTime;
    private long accessTime;
    private String permission;
    private String owner;
    private String group;
    private Path symlink;
    private BlockLocation[] locations;

    public File() {
    }

    public File(Path url, long length, Boolean isDir, short blockReplication,
                long blockSize, long modificationTime, long accessTime,
                FsPermission permission, String owner, String group,
                Path symlink, BlockLocation[] locations)
            throws URISyntaxException {
        this.name = url.getName();
        this.url = url.toString();
        this.path = new URI(this.url).getPath();
        this.length = length;
        this.isDir = isDir;
        this.blockReplication = blockReplication;
        this.blockSize = blockSize;
        this.modificationTime = modificationTime;
        this.accessTime = accessTime;
        this.permission = permission.toString();
        this.owner = owner;
        this.group = group;
        this.symlink = symlink;
        this.locations = locations;
    }

    public  File(FileSystemItem fileSystemItem) throws IOException, URISyntaxException {
        this(
                fileSystemItem.getPath(),
                fileSystemItem.getLen(),
                fileSystemItem.isDirectory(),
                fileSystemItem.getReplication(),
                fileSystemItem.getBlockSize(),
                fileSystemItem.getModificationTime(),
                fileSystemItem.getAccessTime(),
                fileSystemItem.getPermission(),
                fileSystemItem.getOwner(),
                fileSystemItem.getGroup(),
                new Path("/"),//TODO 暂时未完善
                fileSystemItem.getBlockLocations()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public Boolean getDir() {
        return isDir;
    }

    public void setDir(Boolean dir) {
        isDir = dir;
    }

    public short getBlockReplication() {
        return blockReplication;
    }

    public void setBlockReplication(short blockReplication) {
        this.blockReplication = blockReplication;
    }

    public long getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(long blockSize) {
        this.blockSize = blockSize;
    }

    public long getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(long modificationTime) {
        this.modificationTime = modificationTime;
    }

    public long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(long accessTime) {
        this.accessTime = accessTime;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Path getSymlink() {
        return symlink;
    }

    public void setSymlink(Path symlink) {
        this.symlink = symlink;
    }

    public BlockLocation[] getLocations() {
        return locations;
    }

    public void setLocations(BlockLocation[] locations) {
        this.locations = locations;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

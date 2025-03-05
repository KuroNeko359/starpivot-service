package org.kuroneko.starpivot.entity.file;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class File implements Serializable {
    private String path;
    private boolean isDirectory;
    private long length;
    private int replication;
    private long blocksize;
    private long modificationTime;
    private long accessTime;
    private String owner;
    private String group;
    private String permission;
    private boolean isSymlink;
    private boolean hasAcl;
    private boolean isEncrypted;
    private boolean isErasureCoded;
    private List<File> children;

    public File() {
        this.children = new ArrayList<>();
    }

    public File(String path, boolean isDirectory, long length, int replication, long blocksize, long modificationTime, long accessTime, String owner, String group, String permission, boolean isSymlink, boolean hasAcl, boolean isEncrypted, boolean isErasureCoded) {
        this.path = path;
        this.isDirectory = isDirectory;
        this.length = length;
        this.replication = replication;
        this.blocksize = blocksize;
        this.modificationTime = modificationTime;
        this.accessTime = accessTime;
        this.owner = owner;
        this.group = group;
        this.permission = permission;
        this.isSymlink = isSymlink;
        this.hasAcl = hasAcl;
        this.isEncrypted = isEncrypted;
        this.isErasureCoded = isErasureCoded;
        this.children = new ArrayList<>();
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public int getReplication() {
        return replication;
    }

    public void setReplication(int replication) {
        this.replication = replication;
    }

    public long getBlocksize() {
        return blocksize;
    }

    public void setBlocksize(long blocksize) {
        this.blocksize = blocksize;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean isSymlink() {
        return isSymlink;
    }

    public void setSymlink(boolean symlink) {
        isSymlink = symlink;
    }

    public boolean isHasAcl() {
        return hasAcl;
    }

    public void setHasAcl(boolean hasAcl) {
        this.hasAcl = hasAcl;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }

    public boolean isErasureCoded() {
        return isErasureCoded;
    }

    public void setErasureCoded(boolean erasureCoded) {
        isErasureCoded = erasureCoded;
    }

    public List<File> getChildren() {
        return children;
    }

    public void setChildren(List<File> children) {
        this.children = children;
    }

    public void addFile(File file) throws URISyntaxException {
        String path = new URI(file.path).getPath();

        String[] parts = path.split("/");
        File current = this;
        for (String part : parts) {
            if (!part.isEmpty()) {
                File child = current.children.stream()
                        .filter(f -> f.getPath().equals(part))
                        .findFirst()
                        .orElse(null);
                if (child == null) {
                    child = new File(part, true, 0, 0, 0, 0, 0, "", "", "", false, false, false, false);
                    current.children.add(child);
                }
                current = child;
            }
        }
        current.isDirectory = file.isDirectory;
        current.length = file.length;
        current.replication = file.replication;
        current.blocksize = file.blocksize;
        current.modificationTime = file.modificationTime;
        current.accessTime = file.accessTime;
        current.owner = file.owner;
        current.group = file.group;
        current.permission = file.permission;
        current.isSymlink = file.isSymlink;
        current.hasAcl = file.hasAcl;
        current.isEncrypted = file.isEncrypted;
        current.isErasureCoded = file.isErasureCoded;
    }

    @Override
    public String toString() {
        return "File{" +
                "path='" + path + '\'' +
                ", isDirectory=" + isDirectory +
                ", length=" + length +
                ", replication=" + replication +
                ", blocksize=" + blocksize +
                ", modificationTime=" + modificationTime +
                ", accessTime=" + accessTime +
                ", owner='" + owner + '\'' +
                ", group='" + group + '\'' +
                ", permission='" + permission + '\'' +
                ", isSymlink=" + isSymlink +
                ", hasAcl=" + hasAcl +
                ", isEncrypted=" + isEncrypted +
                ", isErasureCoded=" + isErasureCoded +
                ", children=" + children +
                '}';
    }
}
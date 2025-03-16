package org.kuroneko.starpivot.entity.hadoop;

import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;

import java.io.Serializable;

/**
 *
 */
public class File extends LocatedFileStatus implements Serializable {
    private String permissionString;
    private String name;
    private String pathInHdfs;
    /**
     * 构造器
     * @param stat 一个文件的LocateFileStatus
     */
    public File(LocatedFileStatus stat) {
        super(stat.getLen(), stat.isDirectory(), stat.getReplication(),
                stat.getBlockSize(), stat.getModificationTime(),
                stat.getAccessTime(), stat.getPermission(),
                stat.getOwner(), stat.getGroup(), new Path("/"), stat.getPath(),
                stat.hasAcl(), stat.isEncrypted(), stat.isErasureCoded(), stat.getBlockLocations());
        permissionString = getPermission().toString();
        name = getPath().getName();
        pathInHdfs = getPath().toUri().getPath();
    }

    public String getPermissionString() {
        return permissionString;
    }

    public void setPermissionString(String permissionString) {
        this.permissionString = permissionString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathInHdfs() {
        return pathInHdfs;
    }

    public void setPathInHdfs(String pathInHdfs) {
        this.pathInHdfs = pathInHdfs;
    }
}

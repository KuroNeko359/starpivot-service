package org.kuroneko.starpivot.entity.file;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * 表示文件系统中的文件或目录的实体类
 * 实现了Serializable接口以支持序列化
 */
public class File implements Serializable {
    // 文件或目录的路径
    private String path;
    // 是否为目录的标志
    private boolean isDirectory;
    // 文件大小（字节数）
    private long length;
    // 文件副本数
    private int replication;
    // 数据块大小
    private long blocksize;
    // 最后修改时间（时间戳）
    private long modificationTime;
    // 最后访问时间（时间戳）
    private long accessTime;
    // 文件所有者
    private String owner;
    // 文件所属组
    private String group;
    // 文件权限字符串（如"rwxr-xr-x"）
    private String permission;
    // 是否为符号链接的标志
    private boolean isSymlink;
    // 是否具有访问控制列表（ACL）的标志
    private boolean hasAcl;
    // 是否加密的标志
    private boolean isEncrypted;
    // 是否使用纠删码存储的标志
    private boolean isErasureCoded;
    // 子文件/目录列表
    private List<File> children;

    /**
     * 默认构造函数
     * 初始化空的子文件列表
     */
    public File() {
        this.children = new ArrayList<>();
    }

    /**
     * 带所有参数的构造函数
     *
     * @param path             文件路径
     * @param isDirectory      是否为目录
     * @param length           文件大小
     * @param replication      副本数
     * @param blocksize        块大小
     * @param modificationTime 修改时间
     * @param accessTime       访问时间
     * @param owner            所有者
     * @param group            所属组
     * @param permission       权限
     * @param isSymlink        是否符号链接
     * @param hasAcl           是否有ACL
     * @param isEncrypted      是否加密
     * @param isErasureCoded   是否纠删码存储
     */
    public File(String path, boolean isDirectory, long length, int replication, long blocksize,
                long modificationTime, long accessTime, String owner, String group, String permission,
                boolean isSymlink, boolean hasAcl, boolean isEncrypted, boolean isErasureCoded) {
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

    // 以下是所有字段的getter和setter方法
    // 每个方法的作用通过名称自解释，这里仅列出方法签名

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
        this.isDirectory = directory;
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
        this.isSymlink = symlink;
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
        this.isEncrypted = encrypted;
    }

    public boolean isErasureCoded() {
        return isErasureCoded;
    }

    public void setErasureCoded(boolean erasureCoded) {
        this.isErasureCoded = erasureCoded;
    }

    public List<File> getChildren() {
        return children;
    }

    public void setChildren(List<File> children) {
        this.children = children;
    }

    /**
     * 将文件添加到文件树结构中
     *
     * @param file 要添加的文件对象
     * @throws URISyntaxException 如果路径格式不正确
     */
    public void addFile(File file) throws URISyntaxException {
        // 将路径转换为URI并获取路径部分
        String path = new URI(file.path).getPath();
        // 按"/"分割路径
        String[] parts = path.split("/");
        File current = this;

        // 遍历路径的每个部分
        for (String part : parts) {
            if (!part.isEmpty()) {
                // 在子节点中查找是否已存在该路径部分
                File child = current.children.stream()
                        .filter(f -> f.getPath().equals(part))
                        .findFirst()
                        .orElse(null);
                // 如果不存在则创建新节点
                if (child == null) {
                    child = new File(part, true, 0, 0, 0, 0, 0, "", "", "",
                            false, false, false, false);
                    current.children.add(child);
                }
                current = child;
            }
        }
        // 更新最终节点的属性
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

    /**
     * 返回文件对象的字符串表示形式
     *
     * @return 包含所有属性的字符串
     */
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
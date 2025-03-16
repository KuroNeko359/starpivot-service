package org.kuroneko.starpivot.entity.hadoop;

import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Arrays;

/**
 * 表示 Hadoop 文件系统中文件或目录的实体类。
 * 用于为前端返回序列化数据。
 * 该类封装了文件的基本属性（如路径、大小、权限等）以及与 Hadoop 文件系统相关的元数据（如块位置、复制因子等）。
 * 实现 {@link Serializable} 接口，支持对象的序列化和反序列化，适用于分布式系统中的数据传输或存储。
 */
@Deprecated
public class HadoopFile implements Serializable {

    /** 文件或目录的名称，通常为路径中的最后一部分。 */
    private String name;

    /** 文件或目录的完整 URL 字符串表示，例如 "hdfs://namenode:9000/path/to/file"。 */
    private String url;

    /** 文件或目录在文件系统中的路径部分，不包含协议和主机信息，例如 "/path/to/file"。 */
    private String path;

    /** 文件的长度（字节数），对于目录通常为 0。 */
    private long length;

    /** 指示该对象是否为目录的标志，true 表示目录，false 表示文件。 */
    private Boolean isDir;

    /** 文件的块复制因子，表示数据在集群中的副本数量。 */
    private short blockReplication;

    /** 文件的块大小（字节数），表示单个数据块的大小。 */
    private long blockSize;

    /** 文件或目录的最后修改时间（毫秒时间戳）。 */
    private long modificationTime;

    /** 文件或目录的最后访问时间（毫秒时间戳）。 */
    private long accessTime;

    /** 文件或目录的权限字符串，例如 "rwxr-xr-x"。 */
    private String permission;

    /** 文件或目录的所有者名称。 */
    private String owner;

    /** 文件或目录所属的用户组名称。 */
    private String group;

    /** 文件的符号链接路径，如果不是符号链接则为 null。 */
    private Path symlink;

    /** 文件的块位置数组，包含每个数据块在集群中的存储位置信息。 */
    private BlockLocation[] locations;

    //使用静态代码块 注册hdfs这个protocol

    /**
     * 默认构造方法，用于创建空的 {@code File} 对象。
     * 所有字段将保持默认值（null 或 0），适用于需要后续设置属性的场景。
     */
    public HadoopFile() {

    }

    /**
     * 根据提供的参数构造一个 {@code File} 对象。
     * 该构造方法从 Hadoop 文件系统的元数据中提取信息，用于初始化文件或目录的属性。
     *
     * @param url 文件或目录的路径对象 ({@link Path})。
     * @param length 文件的长度（字节数）。
     * @param isDir 是否为目录的标志。
     * @param blockReplication 文件的块复制因子。
     * @param blockSize 文件的块大小（字节数）。
     * @param modificationTime 最后修改时间（毫秒）。
     * @param accessTime 最后访问时间（毫秒）。
     * @param permission 文件权限对象 ({@link FsPermission})。
     * @param owner 文件所有者名称。
     * @param group 文件所属组名称。
     * @param symlink 符号链接路径，若无则为 null。
     * @param locations 文件的块位置数组。
     * @throws URISyntaxException 如果提供的 URL 无法解析为有效的 URI，则抛出此异常。
     */
    public HadoopFile(Path url, long length, Boolean isDir, short blockReplication,
                      long blockSize, long modificationTime, long accessTime,
                      FsPermission permission, String owner, String group,
                      Path symlink, BlockLocation[] locations) throws URISyntaxException, UnsupportedEncodingException, MalformedURLException {
        this.name = url.getName();
        this.url = url.toString();
        this.path = new URL(this.url).getPath();
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

    /**
     * 根据 {@code FileSystemItem} 对象构造一个 {@code File} 对象。
     * 该构造方法将文件系统项的属性映射到当前类的字段，适用于从 Hadoop 文件系统状态转换数据。
     *
     * @param fileSystemItem 文件系统项对象，包含文件或目录的元数据。
     * @throws IOException 如果获取块位置或其他文件系统操作失败，则抛出此异常。
     * @throws URISyntaxException 如果 URL 解析失败，则抛出此异常。
     */
    @Deprecated
    public HadoopFile(FileSystemItem fileSystemItem) throws IOException, URISyntaxException {
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
                new Path("/"), // TODO: 符号链接功能待完善
                fileSystemItem.getBlockLocations()
        );
    }

    public HadoopFile(LocatedFileStatus fileStatus) throws URISyntaxException, UnsupportedEncodingException, MalformedURLException {
        this(
                fileStatus.getPath(),
                fileStatus.getLen(),
                fileStatus.isDirectory(),
                fileStatus.getReplication(),
                fileStatus.getBlockSize(),
                fileStatus.getModificationTime(),
                fileStatus.getAccessTime(),
                fileStatus.getPermission(),
                fileStatus.getOwner(),
                fileStatus.getGroup(),
                new Path("/"),// TODO: 符号链接功能待完善
                fileStatus.getBlockLocations()
        );
    }

    /**
     * 获取文件或目录的名称。
     *
     * @return 文件名称字符串，如果未设置则可能为 null。
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文件或目录的名称。
     *
     * @param name 要设置的文件名称。
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取文件或目录的完整 URL。
     *
     * @return URL 字符串，如果未设置则可能为 null。
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文件或目录的完整 URL。
     *
     * @param url 要设置的 URL 字符串。
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取文件或目录的路径部分。
     *
     * @return 路径字符串，例如 "/path/to/file"，如果未设置则可能为 null。
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件或目录的路径部分。
     *
     * @param path 要设置的路径字符串。
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取文件长度。
     *
     * @return 文件长度（字节数），对于目录通常为 0。
     */
    public long getLength() {
        return length;
    }

    /**
     * 设置文件长度。
     *
     * @param length 要设置的文件长度（字节数）。
     */
    public void setLength(long length) {
        this.length = length;
    }

    /**
     * 获取是否为目录的标志。
     *
     * @return true 表示目录，false 表示文件，如果未设置则可能为 null。
     */
    public Boolean getDir() {
        return isDir;
    }

    /**
     * 设置是否为目录的标志。
     *
     * @param dir true 表示目录，false 表示文件。
     */
    public void setDir(Boolean dir) {
        isDir = dir;
    }

    /**
     * 获取文件的块复制因子。
     *
     * @return 复制因子值。
     */
    public short getBlockReplication() {
        return blockReplication;
    }

    /**
     * 设置文件的块复制因子。
     *
     * @param blockReplication 要设置的复制因子值。
     */
    public void setBlockReplication(short blockReplication) {
        this.blockReplication = blockReplication;
    }

    /**
     * 获取文件的块大小。
     *
     * @return 块大小（字节数）。
     */
    public long getBlockSize() {
        return blockSize;
    }

    /**
     * 设置文件的块大小。
     *
     * @param blockSize 要设置的块大小（字节数）。
     */
    public void setBlockSize(long blockSize) {
        this.blockSize = blockSize;
    }

    /**
     * 获取文件的最后修改时间。
     *
     * @return 修改时间（毫秒时间戳）。
     */
    public long getModificationTime() {
        return modificationTime;
    }

    /**
     * 设置文件的最后修改时间。
     *
     * @param modificationTime 要设置的修改时间（毫秒）。
     */
    public void setModificationTime(long modificationTime) {
        this.modificationTime = modificationTime;
    }

    /**
     * 获取文件的最后访问时间。
     *
     * @return 访问时间（毫秒时间戳）。
     */
    public long getAccessTime() {
        return accessTime;
    }

    /**
     * 设置文件的最后访问时间。
     *
     * @param accessTime 要设置的访问时间（毫秒）。
     */
    public void setAccessTime(long accessTime) {
        this.accessTime = accessTime;
    }

    /**
     * 获取文件或目录的权限字符串。
     *
     * @return 权限字符串，例如 "rwxr-xr-x"，如果未设置则可能为 null。
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置文件或目录的权限字符串。
     *
     * @param permission 要设置的权限字符串。
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取文件或目录的所有者名称。
     *
     * @return 所有者名称，如果未设置则可能为 null。
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 设置文件或目录的所有者名称。
     *
     * @param owner 要设置的所有者名称。
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 获取文件或目录所属的用户组名称。
     *
     * @return 用户组名称，如果未设置则可能为 null。
     */
    public String getGroup() {
        return group;
    }

    /**
     * 设置文件或目录所属的用户组名称。
     *
     * @param group 要设置的用户组名称。
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 获取文件的符号链接路径。
     *
     * @return 符号链接的 {@link Path} 对象，如果无符号链接则为 null。
     */
    public Path getSymlink() {
        return symlink;
    }

    /**
     * 设置文件的符号链接路径。
     *
     * @param symlink 要设置的符号链接路径。
     */
    public void setSymlink(Path symlink) {
        this.symlink = symlink;
    }

    /**
     * 获取文件的块位置数组。
     *
     * @return 块位置数组 ({@link BlockLocation[]})，如果未设置则可能为 null。
     */
    public BlockLocation[] getLocations() {
        return locations;
    }

    /**
     * 设置文件的块位置数组。
     *
     * @param locations 要设置的块位置数组。
     */
    public void setLocations(BlockLocation[] locations) {
        this.locations = locations;
    }

    /**
     * 为URL编码，防止出现非法字符
     * @param url 待编码的URL
     * @return  编码后的url
     * @throws UnsupportedEncodingException 如果不支持编码 则抛出该异常
     */
    public String encodeURL(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url,"UTF-8");
    }
    /**
     * 为URL解码
     * @param url 待解码的URL
     * @return  解码后的url
     * @throws UnsupportedEncodingException 如果不支持编码 则抛出该异常
     */
    public String decodeURL(String url) throws UnsupportedEncodingException {
        return URLDecoder.decode(url,"UTF-8");
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", length=" + length +
                ", isDir=" + isDir +
                ", blockReplication=" + blockReplication +
                ", blockSize=" + blockSize +
                ", modificationTime=" + modificationTime +
                ", accessTime=" + accessTime +
                ", permission='" + permission + '\'' +
                ", owner='" + owner + '\'' +
                ", group='" + group + '\'' +
                ", symlink=" + symlink +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }
}
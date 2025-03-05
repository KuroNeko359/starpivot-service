package org.kuroneko.starpivot.entity.file;

import java.io.Serializable;

/**
 * 表示文件详细信息的实体类，用于封装文件路径和内容的属性。
 * 该类实现了 {@link Serializable} 接口，支持对象的序列化和反序列化，
 * 适用于文件数据在系统间传输或持久化存储的场景。
 */
public class FileDetail implements Serializable {

    /**
     * 文件的完整路径，使用字符串表示。
     * 该字段存储文件的物理或逻辑路径，例如 "/usr/local/file.txt"。
     */
    private String path;

    /**
     * 文件的内容，使用字符串表示。
     * 该字段存储文件的主要数据，通常为文本内容，但也可以根据应用场景扩展为其他格式的表示。
     */
    private String content;

    /**
     * 构造一个新的 {@code FileDetail} 对象，初始化文件路径和内容。
     *
     * @param path 文件路径，不能为空，建议使用规范化的文件路径格式。
     * @param content 文件内容，可以为空字符串，但建议根据业务需求明确其含义。
     */
    public FileDetail(String path, String content) {
        this.path = path;
        this.content = content;
    }

    /**
     * 获取文件的路径。
     *
     * @return 文件路径字符串，如果未设置则可能返回 null。
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件的路径。
     *
     * @param path 要设置的文件路径，建议在设置前进行路径有效性校验。
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取文件的内容。
     *
     * @return 文件内容字符串，如果未设置则可能返回 null。
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文件的内容。
     *
     * @param content 要设置的文件内容，可以为空字符串但不建议为 null。
     */
    public void setContent(String content) {
        this.content = content;
    }
}
package org.kuroneko.starpivot.entity.hadoop;

import org.apache.hadoop.fs.LocatedFileStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示 Hadoop 文件系统中文件或目录的扩展实体类，继承自 {@link LocatedFileStatus}。
 * 该类在 Hadoop 原生文件状态的基础上增加了子文件或子目录的列表，用于表示文件系统的层次结构。
 * 适用于需要递归展示文件系统内容或构建文件树结构的场景。
 */
@Deprecated
public class FileSystemItem extends LocatedFileStatus {

    /**
     * 子文件或子目录的列表，用于表示当前文件系统项的层次结构。
     * 默认初始化为空的 {@link ArrayList}，支持动态添加子项。
     */
    private List<FileSystemItem> children = new ArrayList<>();

    /**
     * 默认构造方法，创建空的 {@code FileSystemItem} 对象。
     * 调用父类 {@link LocatedFileStatus} 的默认构造方法，并初始化子项列表为空。
     */
    public FileSystemItem() {
        super();
    }

    /**
     * 根据给定的 {@link LocatedFileStatus} 对象构造一个 {@code FileSystemItem} 对象。
     * 该构造方法将父类的文件状态和块位置信息复制到当前实例，并初始化子项列表为空。
     *
     * @param locatedFileStatus Hadoop 文件状态对象，包含文件的基本元数据和块位置信息。
     */
    public FileSystemItem(LocatedFileStatus locatedFileStatus) {
        super(locatedFileStatus, locatedFileStatus.getBlockLocations());
        this.children = new ArrayList<>();
    }

    /**
     * 获取当前文件系统项的子文件或子目录列表。
     *
     * @return 子项列表 ({@link List<FileSystemItem>})，如果没有子项则返回空列表。
     */
    public List<FileSystemItem> getChildren() {
        return children;
    }

    /**
     * 返回当前文件系统项的字符串表示形式。
     * 该方法重写了父类的 {@code toString()} 方法，包含父类信息和子项列表的描述。
     *
     * @return 字符串表示，格式为 "FileSystemItem{data=父类信息,children=子项列表}"。
     */
    @Override
    public String toString() {
        return "FileSystemItem{" +
                "data=" + super.toString() +
                ",children=" + children +
                '}';
    }
}
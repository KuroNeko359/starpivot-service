package org.kuroneko.starpivot.entity.memory;
/**
 * 抽象内存类，用于表示内存的使用情况。
 * 该类提供了内存使用量、空闲内存量和总内存量的基本信息，
 * 作为其他具体内存实现类的基类，强制子类遵循特定的内存信息表示方式。
 */
public abstract class AbstractMemory {
    /**
     * 已使用的内存量，单位为字节。
     * 该值在对象创建后不可修改，确保内存使用信息的一致性。
     */
    public final long usedMemory;

    /**
     * 空闲的内存量，单位为字节。
     * 该值在对象创建后不可修改，确保内存空闲信息的一致性。
     */
    public final long freeMemory;

    /**
     * 总的内存量，单位为字节。
     * 该值由已使用内存量和空闲内存量相加得到，在对象创建后不可修改。
     */
    public final long totalMemory;

    /**
     * 构造函数，用于初始化内存使用信息。
     *
     * @param usedMemory 已使用的内存量，单位为字节。该值必须是非负的。
     * @param freeMemory 空闲的内存量，单位为字节。该值必须是非负的。
     * @throws IllegalArgumentException 如果传入的 usedMemory 或 freeMemory 为负数。
     */
    protected AbstractMemory(long usedMemory, long freeMemory) {
        // 检查传入的参数是否合法
        if (usedMemory < 0 || freeMemory < 0) {
            throw new IllegalArgumentException("Used memory and free memory must be non-negative.");
        }
        this.usedMemory = usedMemory;
        this.freeMemory = freeMemory;
        this.totalMemory = usedMemory + freeMemory;
    }
}
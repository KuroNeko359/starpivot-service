package org.kuroneko.starpivot.entity.memory;

/**
 * JVMMemory 类用于表示 Java 虚拟机（JVM）的内存使用情况。
 * 它继承自 AbstractMemory 抽象类，继承了内存使用量、空闲内存量和总内存量的基本信息，
 * 专门针对 JVM 内存场景进行封装，使得在系统中可以方便地获取和管理 JVM 的内存状态。
 *
 * <p>通过该类，可以创建表示 JVM 内存使用情况的对象，其内存信息在对象创建时进行初始化，
 * 并且这些信息在对象创建后保持不变，确保数据的一致性和稳定性。</p>
 */
public class JVMMemory extends AbstractMemory {

    /**
     * 构造函数，用于初始化 JVM 内存使用信息。
     * 该构造函数会调用父类 AbstractMemory 的构造函数，将传入的已使用内存量和空闲内存量传递给父类进行初始化。
     *
     * @param usedMemory 已使用的 JVM 内存量，单位为字节。该值必须是非负的。
     * @param freeMemory 空闲的 JVM 内存量，单位为字节。该值必须是非负的。
     * @throws IllegalArgumentException 如果传入的 usedMemory 或 freeMemory 为负数。
     * @see AbstractMemory#AbstractMemory(long, long)
     */
    public JVMMemory(long usedMemory, long freeMemory) {
        // 调用父类的构造函数来初始化内存信息
        super(usedMemory, freeMemory);
    }
}
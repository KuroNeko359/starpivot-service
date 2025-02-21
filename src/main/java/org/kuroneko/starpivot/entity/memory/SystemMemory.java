package org.kuroneko.starpivot.entity.memory;

/**
 * SystemMemory 类用于表示系统层面的内存使用情况。
 * 它继承自 AbstractMemory 抽象类，借助父类的特性，对系统内存的使用量、空闲量以及总量进行管理。
 * 该类主要是为了在应用程序中方便获取和操作系统内存的相关信息，为系统资源监控和管理提供支持。
 *
 * <p>此类的实例化对象包含了系统内存的静态信息，这些信息在对象创建时被确定，并且后续不会改变，
 * 以保证数据的一致性和稳定性，便于在不同模块间进行可靠的数据传递和处理。</p>
 */
public class SystemMemory extends AbstractMemory {

    /**
     * 构造函数，用于初始化系统内存的使用信息。
     * 此构造函数会调用父类 AbstractMemory 的构造函数，将传入的已使用内存量和空闲内存量传递给父类进行初始化。
     *
     * @param usedMemory 系统中已使用的内存量，单位为字节。该值必须是非负的，因为内存使用量不可能为负数。
     * @param freeMemory 系统中当前空闲的内存量，单位为字节。该值同样必须是非负的，空闲内存量也不能为负数。
     * @throws IllegalArgumentException 如果传入的 usedMemory 或 freeMemory 为负数，会抛出此异常，以保证输入数据的合法性。
     * @see AbstractMemory#AbstractMemory(long, long)
     */
    public SystemMemory(long usedMemory, long freeMemory) {
        // 调用父类构造函数完成内存信息的初始化
        super(usedMemory, freeMemory);
    }

}
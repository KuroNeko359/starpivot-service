package org.kuroneko.starpivot.monitor;

import com.sun.management.OperatingSystemMXBean;
import org.kuroneko.starpivot.entity.memory.JVMMemory;
import org.kuroneko.starpivot.entity.memory.MemoryInfoDTO;
import org.kuroneko.starpivot.entity.memory.SystemMemory;

import java.lang.management.ManagementFactory;

/**
 * 一个用于监控和获取操作系统和 Java 虚拟机 (JVM) 内存使用情况的工具类。
 * 该类提供了获取内存统计信息的方法，例如空闲内存、总内存和 JVM 内存，单位可以是字节、千字节 (KB) 或兆字节 (MB)。
 * <p>
 * 该类使用 `OperatingSystemMXBean` 来收集系统内存的信息，并使用 `Runtime` 对象来收集 JVM 内存使用情况。
 * <p>
 * 内存大小可以以下列格式获取：
 * - **字节**：原始内存大小，单位为字节。
 * - **千字节 (KB)**：内存大小转换为千字节。
 * - **兆字节 (MB)**：内存大小转换为兆字节。
 * <p>
 * 内存值来源于以下内容：
 * 1. 操作系统的总内存和空闲内存。
 * 2. JVM 的总内存和空闲内存。
 * <p>
 * 示例用法：
 * - `getFreeMemoryInMb()` 返回操作系统的空闲内存，单位为兆字节。
 * - `getTotalMemoryOfJvmInKb()` 返回分配给 JVM 的总内存，单位为千字节。
 *
 * @since 1.0
 */
public class MemoryMonitor {

    /**
     * 用于获取系统级内存数据的 OperatingSystemMXBean 实例。
     */
    private static final OperatingSystemMXBean operatingSystemMXBean =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    /**
     * 用于获取与 JVM 相关的内存数据的 Runtime 实例。
     */
    private static final Runtime runtime = Runtime.getRuntime();


    public MemoryInfoDTO getMemory() {
        return new MemoryInfoDTO(
                new JVMMemory(getUsedMemoryOfJvm(), getFreeMemoryOfJvm()),
                new SystemMemory(getUsedMemory(), getFreeMemory())
        );
    }

    /**
     * 获取操作系统的空闲内存，单位为字节。
     *
     * @return 空闲内存，单位为字节。
     */
    private long getFreeMemory() {
        return operatingSystemMXBean.getFreePhysicalMemorySize();
    }

    /**
     * 获取操作系统的总内存，单位为字节。
     *
     * @return 总内存，单位为字节。
     */
    private long getTotalMemory() {
        return operatingSystemMXBean.getTotalPhysicalMemorySize();
    }

    /**
     * 获取操作系统的已用内存，单位为字节。
     *
     * @return 已用内存，单位为字节。
     */
    private long getUsedMemory() {
        return operatingSystemMXBean.getTotalPhysicalMemorySize() - operatingSystemMXBean.getFreePhysicalMemorySize();
    }

    /**
     * 获取 JVM 的空闲内存，单位为字节。
     *
     * @return JVM 的空闲内存，单位为字节。
     */
    private long getFreeMemoryOfJvm() {
        return runtime.freeMemory();
    }


    /**
     * 获取 JVM 的总内存，单位为字节。
     *
     * @return JVM 的总内存，单位为字节。
     */
    private long getTotalMemoryOfJvm() {
        return runtime.totalMemory();
    }

    /**
     * 获取 JVM 的已用内存，单位为字节。
     *
     * @return JVM 的已用内存，单位为字节。
     */
    private long getUsedMemoryOfJvm() {
        return runtime.totalMemory() - runtime.freeMemory();
    }
}

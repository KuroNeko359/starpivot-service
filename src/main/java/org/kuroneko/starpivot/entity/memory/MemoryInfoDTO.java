package org.kuroneko.starpivot.entity.memory;

/**
 * MemoryInfoDTO 是一个用于封装 JVM 内存和系统内存信息的数据传输对象（DTO）。
 * 在项目中，它主要负责在不同层（如数据访问层、业务逻辑层、表示层）之间传输 JVM 和系统的内存使用情况数据，
 * 以避免在层与层之间直接传递复杂的内存对象，提高数据传输的效率和安全性，同时也增强了代码的可维护性和可扩展性。
 */
public class MemoryInfoDTO {
    private final JVMMemory jvmMemory;
    private final SystemMemory systemMemory;

    /**
     * 构造一个新的 MemoryInfoDTO 实例。
     *
     * @param jvmMemory   JVM 内存信息
     * @param systemMemory 系统内存信息
     * @throws IllegalArgumentException 如果 jvmMemory 或 systemMemory 为 null。
     */
    public MemoryInfoDTO(JVMMemory jvmMemory, SystemMemory systemMemory) {
        if (jvmMemory == null || systemMemory == null) {
            throw new IllegalArgumentException("Both jvmMemory and systemMemory must not be null.");
        }
        this.jvmMemory = jvmMemory;
        this.systemMemory = systemMemory;
    }

    /**
     * 获取 JVM 内存信息。
     *
     * @return JVM 内存信息
     */
    public JVMMemory getJvmMemory() {
        return jvmMemory;
    }

    /**
     * 获取系统内存信息。
     *
     * @return 系统内存信息
     */
    public SystemMemory getSystemMemory() {
        return systemMemory;
    }
}

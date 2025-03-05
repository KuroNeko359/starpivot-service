package org.kuroneko.starpivot.monitor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 内存管理类，用于计算和获取已使用、剩余和总内存的信息。
 * 该类支持以字节（Bytes）、千字节（KB）和兆字节（MB）为单位的内存计算。
 */
@Deprecated
public class MemoryUtils {

    /**
     * 1 KB = 1024 Bytes
     */
    private static final BigDecimal KB = new BigDecimal(1024);
    /**
     * 1 MB = 1024 * 1024 Bytes
     */
    private static final BigDecimal MB = new BigDecimal(1024 * 1024);

    /**
     * 已使用的内存（单位：字节）
     */
    private BigDecimal used;
    /**
     * 总内存（单位：字节）
     */
    private BigDecimal total;

    /**
     * 构造方法，初始化内存使用情况。
     *
     * @param used  已使用的内存（单位：字节）
     * @param total 总内存（单位：字节）
     */
    public MemoryUtils(BigDecimal used, BigDecimal total) {
        this.used = used;
        this.total = total;
    }

    /**
     * 获取已使用的内存（单位：字节）。
     *
     * @return 已使用的内存值，单位为 Bytes。
     */
    public BigDecimal getUsedMemory() {
        return formatDecimal(this.used);
    }

    /**
     * 获取总内存（单位：字节）。
     *
     * @return 总内存值，单位为 Bytes。
     */
    public BigDecimal getTotalMemory() {
        return formatDecimal(this.total);
    }

    /**
     * 获取剩余内存（单位：字节）。
     *
     * @return 剩余内存值，单位为 Bytes。
     */
    public BigDecimal getFreeMemory() {
        return formatDecimal(this.total.subtract(this.used));
    }

    /**
     * 获取剩余内存（单位：KB）。
     *
     * @return 剩余内存值，单位为 KB。
     */
    public BigDecimal getFreeMemoryInKB() {
        return formatDecimal(getFreeMemory().divide(KB, RoundingMode.HALF_UP));
    }

    /**
     * 获取剩余内存（单位：MB）。
     *
     * @return 剩余内存值，单位为 MB。
     */
    public BigDecimal getFreeMemoryInMB() {
        return formatDecimal(getFreeMemory().divide(MB, RoundingMode.HALF_UP));
    }

    /**
     * 获取已使用的内存（单位：KB）。
     *
     * @return 已使用的内存值，单位为 KB。
     */
    public BigDecimal getUsedMemoryInKB() {
        return formatDecimal(this.used.divide(KB, RoundingMode.HALF_UP));
    }

    /**
     * 获取已使用的内存（单位：MB）。
     *
     * @return 已使用的内存值，单位为 MB。
     */
    public BigDecimal getUsedMemoryInMB() {
        return formatDecimal(this.used.divide(MB, RoundingMode.HALF_UP));
    }

    /**
     * 获取总内存（单位：KB）。
     *
     * @return 总内存值，单位为 KB。
     */
    public BigDecimal getTotalMemoryInKB() {
        return formatDecimal(this.total.divide(KB, RoundingMode.HALF_UP));
    }

    /**
     * 获取总内存（单位：MB）。
     *
     * @return 总内存值，单位为 MB。
     */
    public BigDecimal getTotalMemoryInMB() {
        return formatDecimal(this.total.divide(MB, RoundingMode.HALF_UP));
    }

    /**
     * 统一格式化小数，保留两位小数。
     *
     * @param number 需要格式化的数值。
     * @return 格式化后保留两位小数的 BigDecimal 值。
     */
    private BigDecimal formatDecimal(BigDecimal number) {
        return number.setScale(2, RoundingMode.HALF_UP);
    }
}

package org.kuroneko.starpivot.entity.hadoop;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * DataNodeInfo 表示多个数据节点的信息。
 * 每个数据节点由一个唯一的键（例如 "hadoop102:9866"）标识，并包含详细信息。
 */
public class DataNodeInfo {

    private final Map<String, NodeInfo> nodes = new HashMap<>();

    /**
     * 获取节点的映射。
     *
     * @return 节点的映射。
     */
    public Map<String, NodeInfo> getNodes() {
        return nodes;
    }

    /**
     * 设置节点的映射。
     *
     * @param name 节点的名称。
     * @param node 节点的内容。
     */
    @JsonAnySetter
    public void setNode(String name, NodeInfo node) {
        nodes.put(name, node);
    }

    /**
     * NodeInfo 表示单个数据节点的详细信息。
     */
    public static class NodeInfo {
        @JsonProperty("infoAddr")
        private String infoAddr;

        @JsonProperty("infoSecureAddr")
        private String infoSecureAddr;

        @JsonProperty("xferaddr")
        private String xferaddr;

        @JsonProperty("lastContact")
        private int lastContact;

        @JsonProperty("usedSpace")
        private long usedSpace;

        @JsonProperty("adminState")
        private String adminState;

        @JsonProperty("nonDfsUsedSpace")
        private long nonDfsUsedSpace;

        @JsonProperty("capacity")
        private long capacity;

        @JsonProperty("numBlocks")
        private int numBlocks;

        @JsonProperty("version")
        private String version;

        @JsonProperty("used")
        private long used;

        @JsonProperty("remaining")
        private long remaining;

        @JsonProperty("blockScheduled")
        private int blockScheduled;

        @JsonProperty("blockPoolUsed")
        private long blockPoolUsed;

        @JsonProperty("blockPoolUsedPercent")
        private double blockPoolUsedPercent;

        @JsonProperty("volfails")
        private int volfails;

        @JsonProperty("lastBlockReport")
        private int lastBlockReport;

        // Getters 和 Setters

        /**
         * 获取信息地址。
         *
         * @return 信息地址。
         */
        public String getInfoAddr() {
            return infoAddr;
        }

        /**
         * 设置信息地址。
         *
         * @param infoAddr 信息地址。
         */
        public void setInfoAddr(String infoAddr) {
            this.infoAddr = infoAddr;
        }

        /**
         * 获取安全信息地址。
         *
         * @return 安全信息地址。
         */
        public String getInfoSecureAddr() {
            return infoSecureAddr;
        }

        /**
         * 设置安全信息地址。
         *
         * @param infoSecureAddr 安全信息地址。
         */
        public void setInfoSecureAddr(String infoSecureAddr) {
            this.infoSecureAddr = infoSecureAddr;
        }

        /**
         * 获取传输地址。
         *
         * @return 传输地址。
         */
        public String getXferaddr() {
            return xferaddr;
        }

        /**
         * 设置传输地址。
         *
         * @param xferaddr 传输地址。
         */
        public void setXferaddr(String xferaddr) {
            this.xferaddr = xferaddr;
        }

        /**
         * 获取最后联系时间。
         *
         * @return 最后联系时间。
         */
        public int getLastContact() {
            return lastContact;
        }

        /**
         * 设置最后联系时间。
         *
         * @param lastContact 最后联系时间。
         */
        public void setLastContact(int lastContact) {
            this.lastContact = lastContact;
        }

        /**
         * 获取已使用空间。
         *
         * @return 已使用空间。
         */
        public long getUsedSpace() {
            return usedSpace;
        }

        /**
         * 设置已使用空间。
         *
         * @param usedSpace 已使用空间。
         */
        public void setUsedSpace(long usedSpace) {
            this.usedSpace = usedSpace;
        }

        /**
         * 获取管理状态。
         *
         * @return 管理状态。
         */
        public String getAdminState() {
            return adminState;
        }

        /**
         * 设置管理状态。
         *
         * @param adminState 管理状态。
         */
        public void setAdminState(String adminState) {
            this.adminState = adminState;
        }

        /**
         * 获取非DFS使用空间。
         *
         * @return 非DFS使用空间。
         */
        public long getNonDfsUsedSpace() {
            return nonDfsUsedSpace;
        }

        /**
         * 设置非DFS使用空间。
         *
         * @param nonDfsUsedSpace 非DFS使用空间。
         */
        public void setNonDfsUsedSpace(long nonDfsUsedSpace) {
            this.nonDfsUsedSpace = nonDfsUsedSpace;
        }

        /**
         * 获取总容量。
         *
         * @return 总容量。
         */
        public long getCapacity() {
            return capacity;
        }

        /**
         * 设置总容量。
         *
         * @param capacity 总容量。
         */
        public void setCapacity(long capacity) {
            this.capacity = capacity;
        }

        /**
         * 获取块数。
         *
         * @return 块数。
         */
        public int getNumBlocks() {
            return numBlocks;
        }

        /**
         * 设置块数。
         *
         * @param numBlocks 块数。
         */
        public void setNumBlocks(int numBlocks) {
            this.numBlocks = numBlocks;
        }

        /**
         * 获取版本。
         *
         * @return 版本。
         */
        public String getVersion() {
            return version;
        }

        /**
         * 设置版本。
         *
         * @param version 版本。
         */
        public void setVersion(String version) {
            this.version = version;
        }

        /**
         * 获取已使用空间。
         *
         * @return 已使用空间。
         */
        public long getUsed() {
            return used;
        }

        /**
         * 设置已使用空间。
         *
         * @param used 已使用空间。
         */
        public void setUsed(long used) {
            this.used = used;
        }

        /**
         * 获取剩余空间。
         *
         * @return 剩余空间。
         */
        public long getRemaining() {
            return remaining;
        }

        /**
         * 设置剩余空间。
         *
         * @param remaining 剩余空间。
         */
        public void setRemaining(long remaining) {
            this.remaining = remaining;
        }

        /**
         * 获取计划块数。
         *
         * @return 计划块数。
         */
        public int getBlockScheduled() {
            return blockScheduled;
        }

        /**
         * 设置计划块数。
         *
         * @param blockScheduled 计划块数。
         */
        public void setBlockScheduled(int blockScheduled) {
            this.blockScheduled = blockScheduled;
        }

        /**
         * 获取块池已使用空间。
         *
         * @return 块池已使用空间。
         */
        public long getBlockPoolUsed() {
            return blockPoolUsed;
        }

        /**
         * 设置块池已使用空间。
         *
         * @param blockPoolUsed 块池已使用空间。
         */
        public void setBlockPoolUsed(long blockPoolUsed) {
            this.blockPoolUsed = blockPoolUsed;
        }

        /**
         * 获取块池已使用百分比。
         *
         * @return 块池已使用百分比。
         */
        public double getBlockPoolUsedPercent() {
            return blockPoolUsedPercent;
        }

        /**
         * 设置块池已使用百分比。
         *
         * @param blockPoolUsedPercent 块池已使用百分比。
         */
        public void setBlockPoolUsedPercent(double blockPoolUsedPercent) {
            this.blockPoolUsedPercent = blockPoolUsedPercent;
        }

        /**
         * 获取卷故障数。
         *
         * @return 卷故障数。
         */
        public int getVolfails() {
            return volfails;
        }

        /**
         * 设置卷故障数。
         *
         * @param volfails 卷故障数。
         */
        public void setVolfails(int volfails) {
            this.volfails = volfails;
        }

        /**
         * 获取最后块报告时间。
         *
         * @return 最后块报告时间。
         */
        public int getLastBlockReport() {
            return lastBlockReport;
        }

        /**
         * 设置最后块报告时间。
         *
         * @param lastBlockReport 最后块报告时间。
         */
        public void setLastBlockReport(int lastBlockReport) {
            this.lastBlockReport = lastBlockReport;
        }

        @Override
        public String toString() {
            return "NodeInfo {" +
                    "infoAddr='" + infoAddr + '\'' +
                    ", infoSecureAddr='" + infoSecureAddr + '\'' +
                    ", xferaddr='" + xferaddr + '\'' +
                    ", lastContact=" + lastContact +
                    ", usedSpace=" + usedSpace +
                    ", adminState='" + adminState + '\'' +
                    ", nonDfsUsedSpace=" + nonDfsUsedSpace +
                    ", capacity=" + capacity +
                    ", numBlocks=" + numBlocks +
                    ", version='" + version + '\'' +
                    ", used=" + used +
                    ", remaining=" + remaining +
                    ", blockScheduled=" + blockScheduled +
                    ", blockPoolUsed=" + blockPoolUsed +
                    ", blockPoolUsedPercent=" + blockPoolUsedPercent +
                    ", volfails=" + volfails +
                    ", lastBlockReport=" + lastBlockReport +
                    '}';
        }
    }
}

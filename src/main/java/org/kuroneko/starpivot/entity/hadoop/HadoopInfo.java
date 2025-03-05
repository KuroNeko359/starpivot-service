package org.kuroneko.starpivot.entity.hadoop;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 表示Hadoop集群信息的实体类
 * 用于封装从Hadoop JMX接口获取的集群状态和统计信息
 */
public class HadoopInfo {
    // 使用Jackson注解映射JSON字段"beans"到该属性
    @JsonProperty("beans")
    private List<Bean> beans;

    /**
     * 获取Hadoop集群的Bean列表
     * 每个Bean包含特定的集群信息
     *
     * @return Bean对象列表
     */
    public List<Bean> getBeans() {
        return beans;
    }

    /**
     * 设置Hadoop集群的Bean列表
     *
     * @param beans 要设置的Bean对象列表
     */
    public void setBeans(List<Bean> beans) {
        this.beans = beans;
    }

    /**
     * 表示Hadoop集群的单个信息单元（Bean）
     * 包含集群的详细状态和统计信息
     */
    public static class Bean {
        // Bean的名称，通常是JMX的MBean名称
        @JsonProperty("name")
        private String name;

        // Bean的模型类型，描述其数据结构
        @JsonProperty("modelerType")
        private String modelerType;

        // 集群总存储容量（字节）
        @JsonProperty("Total")
        private long total;

        // 是否完成升级最终化
        @JsonProperty("UpgradeFinalized")
        private boolean upgradeFinalized;

        // 数据块池ID
        @JsonProperty("BlockPoolId")
        private String blockPoolId;

        // 集群唯一标识符
        @JsonProperty("ClusterId")
        private String clusterId;

        // 高优先级低冗余复制块数量
        @JsonProperty("HighestPriorityLowRedundancyReplicatedBlocks")
        private int highestPriorityLowRedundancyReplicatedBlocks;

        // 高优先级低冗余纠删码块数量
        @JsonProperty("HighestPriorityLowRedundancyECBlocks")
        private int highestPriorityLowRedundancyECBlocks;

        // Hadoop版本号
        @JsonProperty("Version")
        private String version;

        // 已使用存储空间（字节）
        @JsonProperty("Used")
        private long used;

        // 可用存储空间（字节）
        @JsonProperty("Free")
        private long free;

        // 提供的存储容量（字节）
        @JsonProperty("ProvidedCapacity")
        private long providedCapacity;

        // 安全模式状态
        @JsonProperty("Safemode")
        private String safemode;

        // 非DFS使用的空间（字节）
        @JsonProperty("NonDfsUsedSpace")
        private long nonDfsUsedSpace;

        // 已使用空间百分比
        @JsonProperty("PercentUsed")
        private double percentUsed;

        // 数据块池已使用空间（字节）
        @JsonProperty("BlockPoolUsedSpace")
        private long blockPoolUsedSpace;

        // 数据块池使用百分比
        @JsonProperty("PercentBlockPoolUsed")
        private double percentBlockPoolUsed;

        // 剩余空间百分比
        @JsonProperty("PercentRemaining")
        private double percentRemaining;

        // 缓存总容量（字节）
        @JsonProperty("CacheCapacity")
        private long cacheCapacity;

        // 已使用缓存空间（字节）
        @JsonProperty("CacheUsed")
        private long cacheUsed;

        // 数据块总数
        @JsonProperty("TotalBlocks")
        private int totalBlocks;

        // 丢失的数据块数量
        @JsonProperty("NumberOfMissingBlocks")
        private int numberOfMissingBlocks;

        // 复制因子为1的丢失块数量
        @JsonProperty("NumberOfMissingBlocksWithReplicationFactorOne")
        private int numberOfMissingBlocksWithReplicationFactorOne;

        // 活动节点信息（JSON字符串）
        @JsonProperty("LiveNodes")
        private String liveNodes;

        // 死亡节点信息（JSON字符串）
        @JsonProperty("DeadNodes")
        private String deadNodes;

        // 退役节点信息（JSON字符串）
        @JsonProperty("DecomNodes")
        private String decomNodes;

        // 进入维护模式的节点信息（JSON字符串）
        @JsonProperty("EnteringMaintenanceNodes")
        private String enteringMaintenanceNodes;

        // 名称目录状态信息（JSON字符串）
        @JsonProperty("NameDirStatuses")
        private String nameDirStatuses;

        // 节点使用情况信息（JSON字符串）
        @JsonProperty("NodeUsage")
        private String nodeUsage;

        // 名称日志状态信息（JSON字符串）
        @JsonProperty("NameJournalStatus")
        private String nameJournalStatus;

        // 日志事务信息（JSON字符串）
        @JsonProperty("JournalTransactionInfo")
        private String journalTransactionInfo;

        // NameNode启动时间（毫秒）
        @JsonProperty("NnStartedTimeInMillis")
        private long nnStartedTimeInMillis;

        // 编译信息
        @JsonProperty("CompileInfo")
        private String compileInfo;

        // 损坏文件列表（JSON字符串）
        @JsonProperty("CorruptFiles")
        private String corruptFiles;

        // 可快照目录数量
        @JsonProperty("NumberOfSnapshottableDirs")
        private int numberOfSnapshottableDirs;

        // 不同版本数量
        @JsonProperty("DistinctVersionCount")
        private int distinctVersionCount;

        // 不同版本列表
        @JsonProperty("DistinctVersions")
        private List<DistinctVersion> distinctVersions;

        // 软件版本号
        @JsonProperty("SoftwareVersion")
        private String softwareVersion;

        // 名称目录大小信息（JSON字符串）
        @JsonProperty("NameDirSize")
        private String nameDirSize;

        // 滚动升级状态
        @JsonProperty("RollingUpgradeStatus")
        private Object rollingUpgradeStatus;

        // 当前线程数
        @JsonProperty("Threads")
        private int threads;

        /**
         * 表示Hadoop集群的特定版本信息
         */
        public static class DistinctVersion {
            // 版本键（通常是版本号）
            private String key;
            // 该版本的计数
            private int value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        // Getter和Setter方法
        // 每个方法的作用通过字段注释已明确，这里仅保留签名

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getModelerType() {
            return modelerType;
        }

        public void setModelerType(String modelerType) {
            this.modelerType = modelerType;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public boolean isUpgradeFinalized() {
            return upgradeFinalized;
        }

        public void setUpgradeFinalized(boolean upgradeFinalized) {
            this.upgradeFinalized = upgradeFinalized;
        }

        public String getBlockPoolId() {
            return blockPoolId;
        }

        public void setBlockPoolId(String blockPoolId) {
            this.blockPoolId = blockPoolId;
        }

        public String getClusterId() {
            return clusterId;
        }

        public void setClusterId(String clusterId) {
            this.clusterId = clusterId;
        }

        public int getHighestPriorityLowRedundancyReplicatedBlocks() {
            return highestPriorityLowRedundancyReplicatedBlocks;
        }

        public void setHighestPriorityLowRedundancyReplicatedBlocks(int highestPriorityLowRedundancyReplicatedBlocks) {
            this.highestPriorityLowRedundancyReplicatedBlocks = highestPriorityLowRedundancyReplicatedBlocks;
        }

        public int getHighestPriorityLowRedundancyECBlocks() {
            return highestPriorityLowRedundancyECBlocks;
        }

        public void setHighestPriorityLowRedundancyECBlocks(int highestPriorityLowRedundancyECBlocks) {
            this.highestPriorityLowRedundancyECBlocks = highestPriorityLowRedundancyECBlocks;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public long getUsed() {
            return used;
        }

        public void setUsed(long used) {
            this.used = used;
        }

        public long getFree() {
            return free;
        }

        public void setFree(long free) {
            this.free = free;
        }

        public long getProvidedCapacity() {
            return providedCapacity;
        }

        public void setProvidedCapacity(long providedCapacity) {
            this.providedCapacity = providedCapacity;
        }

        public String getSafemode() {
            return safemode;
        }

        public void setSafemode(String safemode) {
            this.safemode = safemode;
        }

        public long getNonDfsUsedSpace() {
            return nonDfsUsedSpace;
        }

        public void setNonDfsUsedSpace(long nonDfsUsedSpace) {
            this.nonDfsUsedSpace = nonDfsUsedSpace;
        }

        public double getPercentUsed() {
            return percentUsed;
        }

        public void setPercentUsed(double percentUsed) {
            this.percentUsed = percentUsed;
        }

        public long getBlockPoolUsedSpace() {
            return blockPoolUsedSpace;
        }

        public void setBlockPoolUsedSpace(long blockPoolUsedSpace) {
            this.blockPoolUsedSpace = blockPoolUsedSpace;
        }

        public double getPercentBlockPoolUsed() {
            return percentBlockPoolUsed;
        }

        public void setPercentBlockPoolUsed(double percentBlockPoolUsed) {
            this.percentBlockPoolUsed = percentBlockPoolUsed;
        }

        public double getPercentRemaining() {
            return percentRemaining;
        }

        public void setPercentRemaining(double percentRemaining) {
            this.percentRemaining = percentRemaining;
        }

        public long getCacheCapacity() {
            return cacheCapacity;
        }

        public void setCacheCapacity(long cacheCapacity) {
            this.cacheCapacity = cacheCapacity;
        }

        public long getCacheUsed() {
            return cacheUsed;
        }

        public void setCacheUsed(long cacheUsed) {
            this.cacheUsed = cacheUsed;
        }

        public int getTotalBlocks() {
            return totalBlocks;
        }

        public void setTotalBlocks(int totalBlocks) {
            this.totalBlocks = totalBlocks;
        }

        public int getNumberOfMissingBlocks() {
            return numberOfMissingBlocks;
        }

        public void setNumberOfMissingBlocks(int numberOfMissingBlocks) {
            this.numberOfMissingBlocks = numberOfMissingBlocks;
        }

        public int getNumberOfMissingBlocksWithReplicationFactorOne() {
            return numberOfMissingBlocksWithReplicationFactorOne;
        }

        public void setNumberOfMissingBlocksWithReplicationFactorOne(int numberOfMissingBlocksWithReplicationFactorOne) {
            this.numberOfMissingBlocksWithReplicationFactorOne = numberOfMissingBlocksWithReplicationFactorOne;
        }

        public String getLiveNodes() {
            return liveNodes;
        }

        public void setLiveNodes(String liveNodes) {
            this.liveNodes = liveNodes;
        }

        public String getDeadNodes() {
            return deadNodes;
        }

        public void setDeadNodes(String deadNodes) {
            this.deadNodes = deadNodes;
        }

        public String getDecomNodes() {
            return decomNodes;
        }

        public void setDecomNodes(String decomNodes) {
            this.decomNodes = decomNodes;
        }

        public String getEnteringMaintenanceNodes() {
            return enteringMaintenanceNodes;
        }

        public void setEnteringMaintenanceNodes(String enteringMaintenanceNodes) {
            this.enteringMaintenanceNodes = enteringMaintenanceNodes;
        }

        public String getNameDirStatuses() {
            return nameDirStatuses;
        }

        public void setNameDirStatuses(String nameDirStatuses) {
            this.nameDirStatuses = nameDirStatuses;
        }

        public String getNodeUsage() {
            return nodeUsage;
        }

        public void setNodeUsage(String nodeUsage) {
            this.nodeUsage = nodeUsage;
        }

        public String getNameJournalStatus() {
            return nameJournalStatus;
        }

        public void setNameJournalStatus(String nameJournalStatus) {
            this.nameJournalStatus = nameJournalStatus;
        }

        public String getJournalTransactionInfo() {
            return journalTransactionInfo;
        }

        public void setJournalTransactionInfo(String journalTransactionInfo) {
            this.journalTransactionInfo = journalTransactionInfo;
        }

        public long getNnStartedTimeInMillis() {
            return nnStartedTimeInMillis;
        }

        public void setNnStartedTimeInMillis(long nnStartedTimeInMillis) {
            this.nnStartedTimeInMillis = nnStartedTimeInMillis;
        }

        public String getCompileInfo() {
            return compileInfo;
        }

        public void setCompileInfo(String compileInfo) {
            this.compileInfo = compileInfo;
        }

        public String getCorruptFiles() {
            return corruptFiles;
        }

        public void setCorruptFiles(String corruptFiles) {
            this.corruptFiles = corruptFiles;
        }

        public int getNumberOfSnapshottableDirs() {
            return numberOfSnapshottableDirs;
        }

        public void setNumberOfSnapshottableDirs(int numberOfSnapshottableDirs) {
            this.numberOfSnapshottableDirs = numberOfSnapshottableDirs;
        }

        public int getDistinctVersionCount() {
            return distinctVersionCount;
        }

        public void setDistinctVersionCount(int distinctVersionCount) {
            this.distinctVersionCount = distinctVersionCount;
        }

        public List<DistinctVersion> getDistinctVersions() {
            return distinctVersions;
        }

        public void setDistinctVersions(List<DistinctVersion> distinctVersions) {
            this.distinctVersions = distinctVersions;
        }

        public String getSoftwareVersion() {
            return softwareVersion;
        }

        public void setSoftwareVersion(String softwareVersion) {
            this.softwareVersion = softwareVersion;
        }

        public String getNameDirSize() {
            return nameDirSize;
        }

        public void setNameDirSize(String nameDirSize) {
            this.nameDirSize = nameDirSize;
        }

        public Object getRollingUpgradeStatus() {
            return rollingUpgradeStatus;
        }

        public void setRollingUpgradeStatus(Object rollingUpgradeStatus) {
            this.rollingUpgradeStatus = rollingUpgradeStatus;
        }

        public int getThreads() {
            return threads;
        }

        public void setThreads(int threads) {
            this.threads = threads;
        }

        /**
         * 返回Bean对象的字符串表示形式
         * 包含所有属性值的详细描述
         *
         * @return Bean的字符串表示
         */
        @Override
        public String toString() {
            return "Bean{" +
                    "name='" + name + '\'' +
                    ", modelerType='" + modelerType + '\'' +
                    ", total=" + total +
                    ", upgradeFinalized=" + upgradeFinalized +
                    ", blockPoolId='" + blockPoolId + '\'' +
                    ", clusterId='" + clusterId + '\'' +
                    ", highestPriorityLowRedundancyReplicatedBlocks=" + highestPriorityLowRedundancyReplicatedBlocks +
                    ", highestPriorityLowRedundancyECBlocks=" + highestPriorityLowRedundancyECBlocks +
                    ", version='" + version + '\'' +
                    ", used=" + used +
                    ", free=" + free +
                    ", providedCapacity=" + providedCapacity +
                    ", safemode='" + safemode + '\'' +
                    ", nonDfsUsedSpace=" + nonDfsUsedSpace +
                    ", percentUsed=" + percentUsed +
                    ", blockPoolUsedSpace=" + blockPoolUsedSpace +
                    ", percentBlockPoolUsed=" + percentBlockPoolUsed +
                    ", percentRemaining=" + percentRemaining +
                    ", cacheCapacity=" + cacheCapacity +
                    ", cacheUsed=" + cacheUsed +
                    ", totalBlocks=" + totalBlocks +
                    ", numberOfMissingBlocks=" + numberOfMissingBlocks +
                    ", numberOfMissingBlocksWithReplicationFactorOne=" + numberOfMissingBlocksWithReplicationFactorOne +
                    ", liveNodes='" + liveNodes + '\'' +
                    ", deadNodes='" + deadNodes + '\'' +
                    ", decomNodes='" + decomNodes + '\'' +
                    ", enteringMaintenanceNodes='" + enteringMaintenanceNodes + '\'' +
                    ", nameDirStatuses='" + nameDirStatuses + '\'' +
                    ", nodeUsage='" + nodeUsage + '\'' +
                    ", nameJournalStatus='" + nameJournalStatus + '\'' +
                    ", journalTransactionInfo='" + journalTransactionInfo + '\'' +
                    ", nnStartedTimeInMillis=" + nnStartedTimeInMillis +
                    ", compileInfo='" + compileInfo + '\'' +
                    ", corruptFiles='" + corruptFiles + '\'' +
                    ", numberOfSnapshottableDirs=" + numberOfSnapshottableDirs +
                    ", distinctVersionCount=" + distinctVersionCount +
                    ", distinctVersions=" + distinctVersions +
                    ", softwareVersion='" + softwareVersion + '\'' +
                    ", nameDirSize='" + nameDirSize + '\'' +
                    ", rollingUpgradeStatus=" + rollingUpgradeStatus +
                    ", threads=" + threads +
                    '}';
        }
    }

    /**
     * 返回HadoopInfo对象的字符串表示形式
     *
     * @return 包含beans列表的字符串表示
     */
    @Override
    public String toString() {
        return "HadoopInfo{" +
                "beans=" + beans.toString() +
                '}';
    }
}
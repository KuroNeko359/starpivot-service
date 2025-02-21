package org.kuroneko.starpivot.entity.hadoop;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents the information of a Hadoop cluster.
 */
public class HadoopInfo {
    @JsonProperty("beans")
    private List<Bean> beans;

    /**
     * Gets the list of beans.
     *
     * @return the list of beans
     */
    public List<Bean> getBeans() {
        return beans;
    }

    /**
     * Sets the list of beans.
     *
     * @param beans the list of beans
     */
    public void setBeans(List<Bean> beans) {
        this.beans = beans;
    }

    /**
     * Represents a bean containing detailed information about the Hadoop cluster.
     */
    public static class Bean {
        @JsonProperty("name")
        private String name;

        @JsonProperty("modelerType")
        private String modelerType;

        @JsonProperty("Total")
        private long total;

        @JsonProperty("UpgradeFinalized")
        private boolean upgradeFinalized;

        @JsonProperty("BlockPoolId")
        private String blockPoolId;

        @JsonProperty("ClusterId")
        private String clusterId;

        @JsonProperty("HighestPriorityLowRedundancyReplicatedBlocks")
        private int highestPriorityLowRedundancyReplicatedBlocks;

        @JsonProperty("HighestPriorityLowRedundancyECBlocks")
        private int highestPriorityLowRedundancyECBlocks;

        @JsonProperty("Version")
        private String version;

        @JsonProperty("Used")
        private long used;

        @JsonProperty("Free")
        private long free;

        @JsonProperty("ProvidedCapacity")
        private long providedCapacity;

        @JsonProperty("Safemode")
        private String safemode;

        @JsonProperty("NonDfsUsedSpace")
        private long nonDfsUsedSpace;

        @JsonProperty("PercentUsed")
        private double percentUsed;

        @JsonProperty("BlockPoolUsedSpace")
        private long blockPoolUsedSpace;

        @JsonProperty("PercentBlockPoolUsed")
        private double percentBlockPoolUsed;

        @JsonProperty("PercentRemaining")
        private double percentRemaining;

        @JsonProperty("CacheCapacity")
        private long cacheCapacity;

        @JsonProperty("CacheUsed")
        private long cacheUsed;

        @JsonProperty("TotalBlocks")
        private int totalBlocks;

        @JsonProperty("NumberOfMissingBlocks")
        private int numberOfMissingBlocks;

        @JsonProperty("NumberOfMissingBlocksWithReplicationFactorOne")
        private int numberOfMissingBlocksWithReplicationFactorOne;

        @JsonProperty("LiveNodes")
        private String liveNodes;

        @JsonProperty("DeadNodes")
        private String deadNodes;

        @JsonProperty("DecomNodes")
        private String decomNodes;

        @JsonProperty("EnteringMaintenanceNodes")
        private String enteringMaintenanceNodes;

        @JsonProperty("NameDirStatuses")
        private String nameDirStatuses;

        @JsonProperty("NodeUsage")
        private String nodeUsage;

        @JsonProperty("NameJournalStatus")
        private String nameJournalStatus;

        @JsonProperty("JournalTransactionInfo")
        private String journalTransactionInfo;

        @JsonProperty("NnStartedTimeInMillis")
        private long nnStartedTimeInMillis;

        @JsonProperty("CompileInfo")
        private String compileInfo;

        @JsonProperty("CorruptFiles")
        private String corruptFiles;

        @JsonProperty("NumberOfSnapshottableDirs")
        private int numberOfSnapshottableDirs;

        @JsonProperty("DistinctVersionCount")
        private int distinctVersionCount;

        @JsonProperty("DistinctVersions")
        private List<DistinctVersion> distinctVersions;

        @JsonProperty("SoftwareVersion")
        private String softwareVersion;

        @JsonProperty("NameDirSize")
        private String nameDirSize;

        @JsonProperty("RollingUpgradeStatus")
        private Object rollingUpgradeStatus;

        @JsonProperty("Threads")
        private int threads;

        // Getters and Setters for all fields
        // ...

        /**
         * Represents a distinct version of the Hadoop cluster.
         */
        public static class DistinctVersion {
            private String key;
            private int value;

            /**
             * Gets the key of the distinct version.
             *
             * @return the key of the distinct version
             */
            public String getKey() {
                return key;
            }

            /**
             * Sets the key of the distinct version.
             *
             * @param key the key of the distinct version
             */
            public void setKey(String key) {
                this.key = key;
            }

            /**
             * Gets the value of the distinct version.
             *
             * @return the value of the distinct version
             */
            public int getValue() {
                return value;
            }

            /**
             * Sets the value of the distinct version.
             *
             * @param value the value of the distinct version
             */
            public void setValue(int value) {
                this.value = value;
            }
        }

        // Getters and setters for Bean class fields

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

    @Override
    public String toString() {
        return "HadoopInfo{" +
                "beans=" + beans.toString() +
                '}';
    }
}

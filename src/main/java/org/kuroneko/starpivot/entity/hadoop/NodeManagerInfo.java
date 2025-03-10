package org.kuroneko.starpivot.entity.hadoop;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 表示Hadoop NodeManager信息的实体类
 * 用于封装YARN集群中NodeManager的状态和资源使用情况
 */
public class NodeManagerInfo {
    // 使用Jackson注解映射JSON字段"nodes"到该属性
    @JsonProperty("nodes")
    public Nodes nodes;

    /**
     * 获取节点信息对象
     *
     * @return 包含节点列表的Nodes对象
     */
    public Nodes getNodes() {
        return nodes;
    }

    /**
     * 设置节点信息对象
     *
     * @param nodes 包含节点列表的Nodes对象
     */
    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    /**
     * 表示NodeManager的节点集合
     * 包含多个节点的详细信息
     */
    public static class Nodes {
        // 使用Jackson注解映射JSON字段"node"到该属性
        @JsonProperty("node")
        public List<NodeInfo> nodeList;

        /**
         * 获取节点信息列表
         *
         * @return NodeInfo对象列表
         */
        public List<NodeInfo> getNodeList() {
            return nodeList;
        }

        /**
         * 设置节点信息列表
         *
         * @param nodeList NodeInfo对象列表
         */
        public void setNodeList(List<NodeInfo> nodeList) {
            this.nodeList = nodeList;
        }

        /**
         * 表示单个NodeManager节点的信息
         * 包含节点状态、资源使用情况等详细信息
         */
        public static class NodeInfo {
            // 节点的机架位置
            @JsonProperty("rack")
            public String rack;

            // 节点状态（如RUNNING, DECOMMISSIONED等）
            @JsonProperty("state")
            public String state;

            // 节点主机名
            @JsonProperty("nodeHostName")
            public String nodeHostName;

            // 节点的HTTP访问地址
            @JsonProperty("nodeHTTPAddress")
            public String nodeHTTPAddress;

            // 最后健康更新时间（毫秒时间戳）
            @JsonProperty("lastHealthUpdate")
            public long lastHealthUpdate;

            // 节点运行的软件版本
            @JsonProperty("version")
            public String version;

            // 健康报告描述
            @JsonProperty("healthReport")
            public String healthReport;

            // 当前运行的容器数量
            @JsonProperty("numContainers")
            public int numContainers;

            // 已使用内存（MB）
            @JsonProperty("usedMemoryMB")
            public long usedMemoryMB;

            // 可用内存（MB）
            @JsonProperty("availMemoryMB")
            public long availMemoryMB;

            // 已使用虚拟核心数
            @JsonProperty("usedVirtualCores")
            public long usedVirtualCores;

            // 可用虚拟核心数
            @JsonProperty("availableVirtualCores")
            public long availableVirtualCores;

            // 运行中的机会容器数量
            @JsonProperty("numRunningOpportContainers")
            public int numRunningOpportContainers;

            // 机会容器使用的内存（GB）
            @JsonProperty("usedMemoryOpportGB")
            public long usedMemoryOpportGB;

            // 机会容器使用的虚拟核心数
            @JsonProperty("usedVirtualCoresOpport")
            public long usedVirtualCoresOpport;

            // 排队中的容器数量
            @JsonProperty("numQueuedContainers")
            public int numQueuedContainers;

            // 资源利用率信息
            @JsonProperty("resourceUtilization")
            public ResourceUtilization resourceUtilization;

            // 已使用资源信息
            @JsonProperty("usedResource")
            public Resource usedResource;

            // 可用资源信息
            @JsonProperty("availableResource")
            public Resource availableResource;

            // Getter和Setter方法
            public String getRack() {
                return rack;
            }

            public void setRack(String rack) {
                this.rack = rack;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getNodeHostName() {
                return nodeHostName;
            }

            public void setNodeHostName(String nodeHostName) {
                this.nodeHostName = nodeHostName;
            }

            public String getNodeHTTPAddress() {
                return nodeHTTPAddress;
            }

            public void setNodeHTTPAddress(String nodeHTTPAddress) {
                this.nodeHTTPAddress = nodeHTTPAddress;
            }

            public long getLastHealthUpdate() {
                return lastHealthUpdate;
            }

            public void setLastHealthUpdate(long lastHealthUpdate) {
                this.lastHealthUpdate = lastHealthUpdate;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getHealthReport() {
                return healthReport;
            }

            public void setHealthReport(String healthReport) {
                this.healthReport = healthReport;
            }

            public int getNumContainers() {
                return numContainers;
            }

            public void setNumContainers(int numContainers) {
                this.numContainers = numContainers;
            }

            public long getUsedMemoryMB() {
                return usedMemoryMB;
            }

            public void setUsedMemoryMB(long usedMemoryMB) {
                this.usedMemoryMB = usedMemoryMB;
            }

            public long getAvailMemoryMB() {
                return availMemoryMB;
            }

            public void setAvailMemoryMB(long availMemoryMB) {
                this.availMemoryMB = availMemoryMB;
            }

            public long getUsedVirtualCores() {
                return usedVirtualCores;
            }

            public void setUsedVirtualCores(long usedVirtualCores) {
                this.usedVirtualCores = usedVirtualCores;
            }

            public long getAvailableVirtualCores() {
                return availableVirtualCores;
            }

            public void setAvailableVirtualCores(long availableVirtualCores) {
                this.availableVirtualCores = availableVirtualCores;
            }

            public int getNumRunningOpportContainers() {
                return numRunningOpportContainers;
            }

            public void setNumRunningOpportContainers(int numRunningOpportContainers) {
                this.numRunningOpportContainers = numRunningOpportContainers;
            }

            public long getUsedMemoryOpportGB() {
                return usedMemoryOpportGB;
            }

            public void setUsedMemoryOpportGB(long usedMemoryOpportGB) {
                this.usedMemoryOpportGB = usedMemoryOpportGB;
            }

            public long getUsedVirtualCoresOpport() {
                return usedVirtualCoresOpport;
            }

            public void setUsedVirtualCoresOpport(long usedVirtualCoresOpport) {
                this.usedVirtualCoresOpport = usedVirtualCoresOpport;
            }

            public int getNumQueuedContainers() {
                return numQueuedContainers;
            }

            public void setNumQueuedContainers(int numQueuedContainers) {
                this.numQueuedContainers = numQueuedContainers;
            }

            public ResourceUtilization getResourceUtilization() {
                return resourceUtilization;
            }

            public void setResourceUtilization(ResourceUtilization resourceUtilization) {
                this.resourceUtilization = resourceUtilization;
            }

            public Resource getUsedResource() {
                return usedResource;
            }

            public void setUsedResource(Resource usedResource) {
                this.usedResource = usedResource;
            }

            public Resource getAvailableResource() {
                return availableResource;
            }

            public void setAvailableResource(Resource availableResource) {
                this.availableResource = availableResource;
            }

            /**
             * 表示节点的资源利用率详细信息
             */
            public static class ResourceUtilization {
                // 节点物理内存使用量（MB）
                @JsonProperty("nodePhysicalMemoryMB")
                public long nodePhysicalMemoryMB;

                // 节点虚拟内存使用量（MB）
                @JsonProperty("nodeVirtualMemoryMB")
                public long nodeVirtualMemoryMB;

                // 节点CPU使用率（百分比）
                @JsonProperty("nodeCPUUsage")
                public double nodeCPUUsage;

                // 容器聚合物理内存使用量（MB）
                @JsonProperty("aggregatedContainersPhysicalMemoryMB")
                public long aggregatedContainersPhysicalMemoryMB;

                // 容器聚合虚拟内存使用量（MB）
                @JsonProperty("aggregatedContainersVirtualMemoryMB")
                public long aggregatedContainersVirtualMemoryMB;

                // 容器CPU使用率（百分比）
                @JsonProperty("containersCPUUsage")
                public double containersCPUUsage;

                public long getNodePhysicalMemoryMB() {
                    return nodePhysicalMemoryMB;
                }

                public void setNodePhysicalMemoryMB(long nodePhysicalMemoryMB) {
                    this.nodePhysicalMemoryMB = nodePhysicalMemoryMB;
                }

                public long getNodeVirtualMemoryMB() {
                    return nodeVirtualMemoryMB;
                }

                public void setNodeVirtualMemoryMB(long nodeVirtualMemoryMB) {
                    this.nodeVirtualMemoryMB = nodeVirtualMemoryMB;
                }

                public double getNodeCPUUsage() {
                    return nodeCPUUsage;
                }

                public void setNodeCPUUsage(double nodeCPUUsage) {
                    this.nodeCPUUsage = nodeCPUUsage;
                }

                public long getAggregatedContainersPhysicalMemoryMB() {
                    return aggregatedContainersPhysicalMemoryMB;
                }

                public void setAggregatedContainersPhysicalMemoryMB(long aggregatedContainersPhysicalMemoryMB) {
                    this.aggregatedContainersPhysicalMemoryMB = aggregatedContainersPhysicalMemoryMB;
                }

                public long getAggregatedContainersVirtualMemoryMB() {
                    return aggregatedContainersVirtualMemoryMB;
                }

                public void setAggregatedContainersVirtualMemoryMB(long aggregatedContainersVirtualMemoryMB) {
                    this.aggregatedContainersVirtualMemoryMB = aggregatedContainersVirtualMemoryMB;
                }

                public double getContainersCPUUsage() {
                    return containersCPUUsage;
                }

                public void setContainersCPUUsage(double containersCPUUsage) {
                    this.containersCPUUsage = containersCPUUsage;
                }
            }

            /**
             * 表示资源信息（已使用或可用）
             */
            public static class Resource {
                // 内存量（单位由上下文决定）
                @JsonProperty("memory")
                public long memory;

                // 虚拟核心数
                @JsonProperty("vCores")
                public long vCores;

                // 附加资源信息
                @JsonProperty("resourceInformations")
                public ResourceInformations resourceInformations;

                public long getMemory() {
                    return memory;
                }

                public void setMemory(long memory) {
                    this.memory = memory;
                }

                public long getvCores() {
                    return vCores;
                }

                public void setvCores(long vCores) {
                    this.vCores = vCores;
                }

                public ResourceInformations getResourceInformations() {
                    return resourceInformations;
                }

                public void setResourceInformations(ResourceInformations resourceInformations) {
                    this.resourceInformations = resourceInformations;
                }

                /**
                 * 表示资源信息的集合
                 */
                public static class ResourceInformations {
                    // 资源信息列表
                    @JsonProperty("resourceInformation")
                    public List<ResourceInformation> resourceInformation;

                    public List<ResourceInformation> getResourceInformation() {
                        return resourceInformation;
                    }

                    public void setResourceInformation(List<ResourceInformation> resourceInformation) {
                        this.resourceInformation = resourceInformation;
                    }

                    /**
                     * 表示单个资源条目
                     */
                    public static class ResourceInformation {
                        // 最大分配量
                        @JsonProperty("maximumAllocation")
                        public long maximumAllocation;

                        // 最小分配量
                        @JsonProperty("minimumAllocation")
                        public long minimumAllocation;

                        // 资源名称
                        @JsonProperty("name")
                        public String name;

                        // 资源类型
                        @JsonProperty("resourceType")
                        public String resourceType;

                        // 单位
                        @JsonProperty("units")
                        public String units;

                        // 当前值
                        @JsonProperty("value")
                        public long value;

                        public long getMaximumAllocation() {
                            return maximumAllocation;
                        }

                        public void setMaximumAllocation(long maximumAllocation) {
                            this.maximumAllocation = maximumAllocation;
                        }

                        public long getMinimumAllocation() {
                            return minimumAllocation;
                        }

                        public void setMinimumAllocation(long minimumAllocation) {
                            this.minimumAllocation = minimumAllocation;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getResourceType() {
                            return resourceType;
                        }

                        public void setResourceType(String resourceType) {
                            this.resourceType = resourceType;
                        }

                        public String getUnits() {
                            return units;
                        }

                        public void setUnits(String units) {
                            this.units = units;
                        }

                        public long getValue() {
                            return value;
                        }

                        public void setValue(long value) {
                            this.value = value;
                        }
                    }
                }
            }
        }
    }
}
package org.kuroneko.starpivot.entity.hadoop;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public class NodeManagerInfo {
    @JsonProperty("nodes")
    public Nodes nodes;

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public static class Nodes {
        @JsonProperty("node")
        public List<NodeInfo> nodeList;

        public List<NodeInfo> getNodeList() {
            return nodeList;
        }

        public void setNodeList(List<NodeInfo> nodeList) {
            this.nodeList = nodeList;
        }

        public static class NodeInfo {
            @JsonProperty("rack")
            public String rack;

            @JsonProperty("state")
            public String state;

            @JsonProperty("nodeHostName")
            public String nodeHostName;

            @JsonProperty("nodeHTTPAddress")
            public String nodeHTTPAddress;

            @JsonProperty("lastHealthUpdate")
            public long lastHealthUpdate;

            @JsonProperty("version")
            public String version;

            @JsonProperty("healthReport")
            public String healthReport;

            @JsonProperty("numContainers")
            public int numContainers;

            @JsonProperty("usedMemoryMB")
            public long usedMemoryMB;

            @JsonProperty("availMemoryMB")
            public long availMemoryMB;

            @JsonProperty("usedVirtualCores")
            public long usedVirtualCores;

            @JsonProperty("availableVirtualCores")
            public long availableVirtualCores;

            @JsonProperty("numRunningOpportContainers")
            public int numRunningOpportContainers;

            @JsonProperty("usedMemoryOpportGB")
            public long usedMemoryOpportGB;

            @JsonProperty("usedVirtualCoresOpport")
            public long usedVirtualCoresOpport;

            @JsonProperty("numQueuedContainers")
            public int numQueuedContainers;

//            @JsonProperty("allocationTags")
//            public AllocationTags allocationTags;

            @JsonProperty("resourceUtilization")
            public ResourceUtilization resourceUtilization;

            @JsonProperty("usedResource")
            public Resource usedResource;

            @JsonProperty("availableResource")
            public Resource availableResource;

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

//            public AllocationTags getAllocationTags() {
//                return allocationTags;
//            }
//
//            public void setAllocationTags(AllocationTags allocationTags) {
//                this.allocationTags = allocationTags;
//            }

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

//            public static class AllocationTags {
//                //Allocation Tags
//            }

            public static class ResourceUtilization {
                @JsonProperty("nodePhysicalMemoryMB")
                public long nodePhysicalMemoryMB;

                @JsonProperty("nodeVirtualMemoryMB")
                public long nodeVirtualMemoryMB;

                @JsonProperty("nodeCPUUsage")
                public double nodeCPUUsage;

                @JsonProperty("aggregatedContainersPhysicalMemoryMB")
                public long aggregatedContainersPhysicalMemoryMB;

                @JsonProperty("aggregatedContainersVirtualMemoryMB")
                public long aggregatedContainersVirtualMemoryMB;

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

            public static class Resource {
                @JsonProperty("memory")
                public long memory;

                @JsonProperty("vCores")
                public long vCores;

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

                public static class ResourceInformations {
                    @JsonProperty("resourceInformation")
                    public List<ResourceInformation> resourceInformation;

                    public List<ResourceInformation> getResourceInformation() {
                        return resourceInformation;
                    }

                    public void setResourceInformation(List<ResourceInformation> resourceInformation) {
                        this.resourceInformation = resourceInformation;
                    }

                    public static class ResourceInformation {
                        @JsonProperty("maximumAllocation")
                        public long maximumAllocation;

                        @JsonProperty("minimumAllocation")
                        public long minimumAllocation;

                        @JsonProperty("name")
                        public String name;

                        @JsonProperty("resourceType")
                        public String resourceType;

                        @JsonProperty("units")
                        public String units;

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

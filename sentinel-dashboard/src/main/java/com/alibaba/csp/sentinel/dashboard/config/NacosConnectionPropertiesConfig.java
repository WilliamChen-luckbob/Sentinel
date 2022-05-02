package com.alibaba.csp.sentinel.dashboard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Objects;

/**
 * 用于配置Nacos的连接相关数据
 *
 * @author william
 * @description
 * @Date: 2022-04-15 14:43
 */
@ConfigurationProperties(prefix = "sentinel.nacos")
public class NacosConnectionPropertiesConfig {
    private String serverAddr;
    private String dataId;
    private String groupId;
    private String namespace;
    private String username;
    private String password;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NacosConnectionPropertiesConfig{" +
            "serverAddr='" + serverAddr + '\'' +
            ", dataId='" + dataId + '\'' +
            ", groupId='" + groupId + '\'' +
            ", namespace='" + namespace + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NacosConnectionPropertiesConfig)) {
            return false;
        }
        NacosConnectionPropertiesConfig that = (NacosConnectionPropertiesConfig) o;
        return Objects.equals(getServerAddr(), that.getServerAddr()) &&
            Objects.equals(getDataId(), that.getDataId()) &&
            Objects.equals(getGroupId(), that.getGroupId()) &&
            Objects.equals(getNamespace(), that.getNamespace()) &&
            Objects.equals(getUsername(), that.getUsername()) &&
            Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServerAddr(), getDataId(), getGroupId(), getNamespace(), getUsername(), getPassword());
    }
}

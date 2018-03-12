
package com.madcoders.chatterjeekaustav.programexecutor.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProgramResponse {

    @SerializedName("output")
    @Expose
    private String output;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("memory")
    @Expose
    private String memory;
    @SerializedName("cpuTime")
    @Expose
    private String cpuTime;

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public ProgramResponse withOutput(String output) {
        this.output = output;
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public ProgramResponse withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public ProgramResponse withMemory(String memory) {
        this.memory = memory;
        return this;
    }

    public String getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(String cpuTime) {
        this.cpuTime = cpuTime;
    }

    public ProgramResponse withCpuTime(String cpuTime) {
        this.cpuTime = cpuTime;
        return this;
    }

}

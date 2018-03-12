
package com.madcoders.chatterjeekaustav.programexecutor.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProgramRequest {

    @SerializedName("script")
    @Expose
    private String script;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("versionIndex")
    @Expose
    private String versionIndex;
    @SerializedName("clientId")
    @Expose
    private String clientId;
    @SerializedName("clientSecret")
    @Expose
    private String clientSecret;

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public ProgramRequest withScript(String script) {
        this.script = script;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ProgramRequest withLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getVersionIndex() {
        return versionIndex;
    }

    public void setVersionIndex(String versionIndex) {
        this.versionIndex = versionIndex;
    }

    public ProgramRequest withVersionIndex(String versionIndex) {
        this.versionIndex = versionIndex;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ProgramRequest withClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public ProgramRequest withClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

}

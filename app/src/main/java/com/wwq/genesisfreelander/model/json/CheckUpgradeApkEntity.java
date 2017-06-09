package com.wwq.genesisfreelander.model.json;

/**
 * Created by wwq on 2017/3/29.
 */

public class CheckUpgradeApkEntity {

    /**
     * versionName : 3.0
     * versionCode : 3
     * description : jlkasjd
     * downloadUrl : http://124.165.205.15:8080/application/android/paopaoshansong.apk
     */

    private String versionName;
    private int versionCode;
    private String description;
    private String downloadUrl;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}

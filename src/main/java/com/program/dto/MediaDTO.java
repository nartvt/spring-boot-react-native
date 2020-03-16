package com.program.dto;

import java.sql.Timestamp;

import com.program.entity.BaseObject;

public class MediaDTO implements BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = -7096972201612416399L;

    private Long mediaId;

    private String mediaName;

    private Long mediaSize;

    private String mediaPath;

    private Timestamp updateTime;

    private byte[] data;

    public MediaDTO() {
    }

    public MediaDTO(String mediaName, Long mediaSize, String mediaPath, Timestamp updateTime) {
        this.mediaName = mediaName;
        this.mediaSize = mediaSize;
        this.mediaPath = mediaPath;
        this.updateTime = updateTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mediaId == null) ? 0 : mediaId.hashCode());
        result = prime * result + ((mediaName == null) ? 0 : mediaName.hashCode());
        result = prime * result + ((mediaPath == null) ? 0 : mediaPath.hashCode());
        result = prime * result + ((mediaSize == null) ? 0 : mediaSize.hashCode());
        result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MediaDTO other = (MediaDTO) obj;
        if (mediaId == null) {
            if (other.mediaId != null)
                return false;
        } else if (!mediaId.equals(other.mediaId))
            return false;
        if (mediaName == null) {
            if (other.mediaName != null)
                return false;
        } else if (!mediaName.equals(other.mediaName))
            return false;
        if (mediaPath == null) {
            if (other.mediaPath != null)
                return false;
        } else if (!mediaPath.equals(other.mediaPath))
            return false;
        if (mediaSize == null) {
            if (other.mediaSize != null)
                return false;
        } else if (!mediaSize.equals(other.mediaSize))
            return false;
        if (updateTime == null) {
            if (other.updateTime != null)
                return false;
        } else if (!updateTime.equals(other.updateTime))
            return false;
        return true;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public Long getMediaSize() {
        return mediaSize;
    }

    public void setMediaSize(Long mediaSize) {
        this.mediaSize = mediaSize;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MediaDTO [mediaId=" + mediaId + ", mediaName=" + mediaName + ", mediaPath=" + mediaPath + ", mediaSize="
                + mediaSize + ", updateTime=" + updateTime + "]";
    }

}
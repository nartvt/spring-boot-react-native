package com.program.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "Media")
@Table(name = "Media", schema = "Fileprogress")
public class MediaEntity implements BaseObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mediaId")
    private Long mediaId;

    @Column(name = "mediaName" )
    private String mediaName;

    @Column(name = "mediaSize")
    private Long mediaSize;

    @Column(name = "mediaPath")
    private String mediaPath;

    @Column(name = "updateTime")
    private Timestamp updateTime;

    @Transient
    private byte[] data;

    public MediaEntity(String mediaName, Long mediaSize, String mediaPath, Timestamp updateTime) {
        this.mediaName = mediaName;
        this.mediaSize = mediaSize;
        this.mediaPath = mediaPath;
        this.updateTime = updateTime;
    }

    public MediaEntity() {
    }

    public Long getMediaId() {
        return mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public Long getMediaSize() {
        return mediaSize;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
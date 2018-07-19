package com.cxd.xiaonuan.dto;

import java.io.Serializable;

public class Page implements Serializable {

    private int page;
    private int pageSize;
    private Long courseSeqId;
    private Long lessonSeqId;
    private Long userSeqId;
    private String title;
    private long toUserSeqId;
    private long fromUserSeqId;
    private Long seqId;

    private int start;

    public int getPage() {
        return page;
    }

    public Page setPage(int page) {
        this.page = page;

        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Page setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Page setTitle(String title) {
        this.title = title;
        return this;
    }

    public Long getCourseSeqId() {
        return courseSeqId;
    }

    public Page setCourseSeqId(Long courseSeqId) {
        this.courseSeqId = courseSeqId;
        return this;
    }

    public Long getUserSeqId() {
        return userSeqId;
    }

    public Page setUserSeqId(Long userSeqId) {
        this.userSeqId = userSeqId;
        return this;
    }

    public int getStart() {
        return (this.page-1)*this.pageSize;
    }

    public Page setStart(int start) {
        this.start = start;
        return this;
    }

    public Long getLessonSeqId() {
        return lessonSeqId;
    }

    public Page setLessonSeqId(Long lessonSeqId) {
        this.lessonSeqId = lessonSeqId;
        return this;
    }

    public long getToUserSeqId() {
        return toUserSeqId;
    }

    public Page setToUserSeqId(long toUserSeqId) {
        this.toUserSeqId = toUserSeqId;
        return this;
    }

    public long getFromUserSeqId() {
        return fromUserSeqId;
    }

    public Page setFromUserSeqId(long fromUserSeqId) {
        this.fromUserSeqId = fromUserSeqId;
        return this;
    }

    public Long getSeqId() {
        return seqId;
    }

    public Page setSeqId(Long seqId) {
        this.seqId = seqId;
        return this;
    }
}

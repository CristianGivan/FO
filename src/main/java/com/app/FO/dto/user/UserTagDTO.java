package com.app.FO.dto.user;

public class UserTagDTO {

    private Long useTagId;
    private String Tag;
    private String createdDate;

    @Override
    public String toString() {
        return "UserTagDTO{" +
                "useTagId=" + useTagId +
                ", Tag='" + Tag + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

    public UserTagDTO(Long useTagId, String tag, String createdDate) {
        this.useTagId = useTagId;
        Tag = tag;
        this.createdDate = createdDate;
    }

    public Long getUseTagId() {
        return useTagId;
    }

    public void setUseTagId(Long useTagId) {
        this.useTagId = useTagId;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}

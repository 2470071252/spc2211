package cn.tedu.spring.entity;

import java.time.LocalDateTime;

public class AwardLog {
    private Integer id;
    private Integer awardId;
    private Integer point;
    private String description;
    private LocalDateTime grantDate;

    public AwardLog() {
    }

    public AwardLog(Integer id, Integer awardId, Integer point, String description, LocalDateTime grantDate) {
        this.id = id;
        this.awardId = awardId;
        this.point = point;
        this.description = description;
        this.grantDate = grantDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAwardId() {
        return awardId;
    }

    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(LocalDateTime grantDate) {
        this.grantDate = grantDate;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "AwardLog{" +
                "id=" + id +
                ", awardId=" + awardId +
                ", point=" + point +
                ", description='" + description + '\'' +
                ", grantDate=" + grantDate +
                '}';
    }
}

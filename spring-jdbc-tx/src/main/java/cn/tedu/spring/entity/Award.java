package cn.tedu.spring.entity;

public class Award {
    private Integer id;
    private Integer userId;
    private Integer point;

    public Award() {
    }

    public Award(Integer id, Integer userId, Integer point) {
        this.id = id;
        this.userId = userId;
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Award{" +
                "id=" + id +
                ", userId=" + userId +
                ", point=" + point +
                '}';
    }
}

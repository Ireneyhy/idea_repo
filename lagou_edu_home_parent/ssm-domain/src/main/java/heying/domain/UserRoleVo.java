package heying.domain;

import java.util.List;

public class UserRoleVo {

    private int userId;
    private List<Integer> roleIdList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }

    @Override
    public String toString() {
        return "UserRoleVo{" +
                "userId=" + userId +
                ", roleIdList=" + roleIdList +
                '}';
    }
}

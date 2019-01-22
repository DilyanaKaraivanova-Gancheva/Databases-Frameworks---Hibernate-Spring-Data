package app.dto.view;

import com.google.gson.annotations.Expose;

import java.util.Set;
import java.util.TreeSet;

public class UsersProductsView {
    @Expose
    private int usersCount;

    @Expose
    private Set<UserNameAgeView> users;

    public UsersProductsView() {
        this.users = new TreeSet<>();
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public Set<UserNameAgeView> getUsers() {
        return users;
    }

    public void setUsers(Set<UserNameAgeView> users) {
        this.users = users;
    }
}

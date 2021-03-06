package app.login;


import app.entities.User;
import org.springframework.security.core.authority.AuthorityUtils;


public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getName(), user.getHash(), AuthorityUtils.createAuthorityList("USER"));
        this.user = user;
    }

    public CurrentUser(org.springframework.security.core.userdetails.User user, User userEntity) {
        super(user.getUsername(), userEntity.getHash(), user.getAuthorities());
        this.user = userEntity;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }
}

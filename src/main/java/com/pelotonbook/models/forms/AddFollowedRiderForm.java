package com.pelotonbook.models.forms;

import com.pelotonbook.models.Rider;
import com.pelotonbook.models.User;

/**
 * Created by Kevin on 4/17/2017.
 */
public class AddFollowedRiderForm {

    private User user;

    private Iterable<Rider> riders;

    private int userId;

    private int riderId;

    // constructors
    public AddFollowedRiderForm(User user, Iterable<Rider> riders) {
        this.user = user;
        this.riders = riders;
    }

    public AddFollowedRiderForm() { }

    // getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Iterable<Rider> getRiders() {
        return riders;
    }

    public void setRiders(Iterable<Rider> riders) {
        this.riders = riders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }
}

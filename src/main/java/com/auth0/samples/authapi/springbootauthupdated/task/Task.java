package com.auth0.samples.authapi.springbootauthupdated.task;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.auth0.samples.authapi.springbootauthupdated.user.ApplicationUser;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    
    @OneToMany(mappedBy="task")
	private List<ApplicationUser> projects = new ArrayList<ApplicationUser>();

    protected Task() { }

    public Task(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
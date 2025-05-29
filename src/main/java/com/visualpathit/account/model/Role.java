package com.visualpathit.account.model;

<<<<<<< HEAD
import jakarta.persistence.*;

=======
import javax.persistence.*;
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import java.util.Set;
/**{@author imrant} !*/
@Entity
@Table(name = "role")
public class Role {
	/** the id field !*/
    private Long id;
    /** the name field !*/
    private String name;
    /** the user field !*/
    private Set<User> users;
    /** {@inheritDoc}} !*/
    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
    @GeneratedValue(strategy = GenerationType.AUTO)
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
    /**
     * {@link Role#id}
     !*/
    public Long getId() {
        return id;
    }
    /** {@inheritDoc}} !*/
    public  void setId(final Long id) {
        this.id = id;
    }
    /**
     * {@link Role#name}
     !*/
    public String getName() {
        return name;
    }
    /** {@inheritDoc}} !*/
    public  void setName(final String name) {
        this.name = name;
    }
    /**
     * {@inheritDoc}} 
     !*/
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles",cascade = CascadeType.ALL)
    /**
     * {@link Role#id}
     !*/
    public Set <User> getUsers() {
        return users;
    }
    /**
     * {@inheritDoc}} 
     !*/
    public final void setUsers(Set<User> users) {
        this.users = users;
    }
}

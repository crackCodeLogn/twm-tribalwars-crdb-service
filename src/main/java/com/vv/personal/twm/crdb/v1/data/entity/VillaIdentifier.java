package com.vv.personal.twm.crdb.v1.data.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author Vivek
 * @since 16/01/22
 */
@Embeddable
public class VillaIdentifier implements Serializable {

    @Column(name = "world")
    private String world;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

    @Column(name = "cre_ts")
    private Instant createdTimestamp;

    public VillaIdentifier() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("world", world)
                .append("x", x)
                .append("y", y)
                .append("createdTimestamp", createdTimestamp)
                .toString();
    }

    public String getWorld() {
        return world;
    }

    public VillaIdentifier setWorld(String world) {
        this.world = world;
        return this;
    }

    public int getX() {
        return x;
    }

    public VillaIdentifier setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public VillaIdentifier setY(int y) {
        this.y = y;
        return this;
    }

    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }

    public VillaIdentifier setCreatedTimestamp(Instant createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
        return this;
    }
}
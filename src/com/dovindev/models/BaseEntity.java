package com.dovindev.models;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static int lastId;

    public BaseEntity(){
        this.id = ++lastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity base = (BaseEntity) o;
        return Objects.equals(id, base.id);
    }
}

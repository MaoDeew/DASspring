package com.das.dasspring.model.usuarios;

public abstract class Adapter {
    abstract public String getUser();
    abstract public String getPassword();
    abstract public void setUser(String user);
    abstract public void setPassword(String password);
    abstract public boolean autLogin(String user, String password);
}

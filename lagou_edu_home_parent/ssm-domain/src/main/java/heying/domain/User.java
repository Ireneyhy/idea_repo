package heying.domain;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private String portrait;
    private String phone;
    private String password;
    private String reg_ip;
    private int account_non_expired;
    private int credentials_non_expired;
    private int account_non_locked;
    private String status;
    private int is_del;
    private Date create_time;
    private Date update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReg_ip() {
        return reg_ip;
    }

    public void setReg_ip(String reg_ip) {
        this.reg_ip = reg_ip;
    }

    public int getAccount_non_expired() {
        return account_non_expired;
    }

    public void setAccount_non_expired(int account_non_expired) {
        this.account_non_expired = account_non_expired;
    }

    public int getCredentials_non_expired() {
        return credentials_non_expired;
    }

    public void setCredentials_non_expired(int credentials_non_expired) {
        this.credentials_non_expired = credentials_non_expired;
    }

    public int getAccount_non_locked() {
        return account_non_locked;
    }

    public void setAccount_non_locked(int account_non_locked) {
        this.account_non_locked = account_non_locked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIs_del() {
        return is_del;
    }

    public void setIs_del(int is_del) {
        this.is_del = is_del;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}

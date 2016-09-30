package com.conan.conantch.model.entities;

import java.util.List;

/**
 * 登录接口
 * Created by conan on 16/9/29.
 */
public class LoginEntity {

    /**
     * ret : 0
     * msg :
     * uid : 1000********1341268
     * username : lcq***
     * password : 96e79218965eb72c92**************
     * realname : 刘*强
     * email : null
     * telephone : 159****0681
     * sex : 0
     * identitytype : 2
     * is_audit : 1
     * is_active : 1
     * is_init : 1
     * origin : 1
     * certificate : 0
     * create_time : 1452860313
     * update_time : 1452860313
     * status : 0
     * group : [{"title":"学校管理员","type":"0","group_id":"2"},{"title":"校长","type":"0","group_id":"11"}]
     * access_token : 558f86e48***************1930ccd0
     * expires_in : 86400
     * scope : null
     * refresh_token : aa328d03***************63471396e
     */

    private int ret;
    private String msg;
    private String uid;
    private String username;
    private String password;
    private String realname;
    private Object email;
    private String telephone;
    private String sex;
    private String identitytype;
    private String is_audit;
    private String is_active;
    private String is_init;
    private String origin;
    private String certificate;
    private String create_time;
    private String update_time;
    private String status;
    private String access_token;
    private int expires_in;
    private Object scope;
    private String refresh_token;
    /**
     * title : 学校管理员
     * type : 0
     * group_id : 2
     */

    private List<GroupBean> group;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentitytype() {
        return identitytype;
    }

    public void setIdentitytype(String identitytype) {
        this.identitytype = identitytype;
    }

    public String getIs_audit() {
        return is_audit;
    }

    public void setIs_audit(String is_audit) {
        this.is_audit = is_audit;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getIs_init() {
        return is_init;
    }

    public void setIs_init(String is_init) {
        this.is_init = is_init;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public Object getScope() {
        return scope;
    }

    public void setScope(Object scope) {
        this.scope = scope;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public List<GroupBean> getGroup() {
        return group;
    }

    public void setGroup(List<GroupBean> group) {
        this.group = group;
    }

    public static class GroupBean {
        private String title;
        private String type;
        private String group_id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }
    }
}

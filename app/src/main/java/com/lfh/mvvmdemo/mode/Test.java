package com.lfh.mvvmdemo.mode;

import java.util.List;


public class Test {


    private Integer code;
    private String msg;
    private DataBean data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<UsersordersBean> usersorders;

        public List<UsersordersBean> getUsersorders() {
            return usersorders;
        }

        public void setUsersorders(List<UsersordersBean> usersorders) {
            this.usersorders = usersorders;
        }

        public static class UsersordersBean {
            private String _id;
            private UsersIdBean users_id;
            private CoursepricesIdBean courseprices_id;
            private AddressesIdBean addresses_id;
            private String state;
            private Object express;
            private String payamount;
            private String ordertime;
            private String paymethod;
            private Integer __v;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public UsersIdBean getUsers_id() {
                return users_id;
            }

            public void setUsers_id(UsersIdBean users_id) {
                this.users_id = users_id;
            }

            public CoursepricesIdBean getCourseprices_id() {
                return courseprices_id;
            }

            public void setCourseprices_id(CoursepricesIdBean courseprices_id) {
                this.courseprices_id = courseprices_id;
            }

            public AddressesIdBean getAddresses_id() {
                return addresses_id;
            }

            public void setAddresses_id(AddressesIdBean addresses_id) {
                this.addresses_id = addresses_id;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public Object getExpress() {
                return express;
            }

            public void setExpress(Object express) {
                this.express = express;
            }

            public String getPayamount() {
                return payamount;
            }

            public void setPayamount(String payamount) {
                this.payamount = payamount;
            }

            public String getOrdertime() {
                return ordertime;
            }

            public void setOrdertime(String ordertime) {
                this.ordertime = ordertime;
            }

            public String getPaymethod() {
                return paymethod;
            }

            public void setPaymethod(String paymethod) {
                this.paymethod = paymethod;
            }

            public Integer get__v() {
                return __v;
            }

            public void set__v(Integer __v) {
                this.__v = __v;
            }

            public static class UsersIdBean {
                private String _id;
                private String username;
                private String nickname;
                private String password;
                private String phonenumber;
                private String headimg;
                private String level;
                private String createdAt;
                private String updatedAt;
                private Integer __v;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getPhonenumber() {
                    return phonenumber;
                }

                public void setPhonenumber(String phonenumber) {
                    this.phonenumber = phonenumber;
                }

                public String getHeadimg() {
                    return headimg;
                }

                public void setHeadimg(String headimg) {
                    this.headimg = headimg;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getCreatedAt() {
                    return createdAt;
                }

                public void setCreatedAt(String createdAt) {
                    this.createdAt = createdAt;
                }

                public String getUpdatedAt() {
                    return updatedAt;
                }

                public void setUpdatedAt(String updatedAt) {
                    this.updatedAt = updatedAt;
                }

                public Integer get__v() {
                    return __v;
                }

                public void set__v(Integer __v) {
                    this.__v = __v;
                }
            }

            public static class CoursepricesIdBean {
                private String _id;
                private String categorys_id;
                private String name;
                private String cover;
                private List<String> detail;
                private String originalprice;
                private String presentprice;
                private String count;
                private String timelength;
                private String createdAt;
                private String updatedAt;
                private Integer __v;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getCategorys_id() {
                    return categorys_id;
                }

                public void setCategorys_id(String categorys_id) {
                    this.categorys_id = categorys_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public List<String> getDetail() {
                    return detail;
                }

                public void setDetail(List<String> detail) {
                    this.detail = detail;
                }

                public String getOriginalprice() {
                    return originalprice;
                }

                public void setOriginalprice(String originalprice) {
                    this.originalprice = originalprice;
                }

                public String getPresentprice() {
                    return presentprice;
                }

                public void setPresentprice(String presentprice) {
                    this.presentprice = presentprice;
                }

                public String getCount() {
                    return count;
                }

                public void setCount(String count) {
                    this.count = count;
                }

                public String getTimelength() {
                    return timelength;
                }

                public void setTimelength(String timelength) {
                    this.timelength = timelength;
                }

                public String getCreatedAt() {
                    return createdAt;
                }

                public void setCreatedAt(String createdAt) {
                    this.createdAt = createdAt;
                }

                public String getUpdatedAt() {
                    return updatedAt;
                }

                public void setUpdatedAt(String updatedAt) {
                    this.updatedAt = updatedAt;
                }

                public Integer get__v() {
                    return __v;
                }

                public void set__v(Integer __v) {
                    this.__v = __v;
                }
            }

            public static class AddressesIdBean {
                private String _id;
                private String users_id;
                private String province;
                private String city;
                private String area;
                private String other;
                private String name;
                private String phonenumber;
                private String createdAt;
                private String updatedAt;
                private Integer __v;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getUsers_id() {
                    return users_id;
                }

                public void setUsers_id(String users_id) {
                    this.users_id = users_id;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public String getOther() {
                    return other;
                }

                public void setOther(String other) {
                    this.other = other;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPhonenumber() {
                    return phonenumber;
                }

                public void setPhonenumber(String phonenumber) {
                    this.phonenumber = phonenumber;
                }

                public String getCreatedAt() {
                    return createdAt;
                }

                public void setCreatedAt(String createdAt) {
                    this.createdAt = createdAt;
                }

                public String getUpdatedAt() {
                    return updatedAt;
                }

                public void setUpdatedAt(String updatedAt) {
                    this.updatedAt = updatedAt;
                }

                public Integer get__v() {
                    return __v;
                }

                public void set__v(Integer __v) {
                    this.__v = __v;
                }
            }
        }
    }
}

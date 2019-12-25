package Dao;

public class Image {
    private String name;
    private String user;
    private String type;
    private String creat_time;
    private String shape;
    private String size;
    private String edit_time;
    private String resolution;
    private String longitude;
    private String latitude;
    private String location;
    private String pick_time;
    private String pick_time_long;
    private String scale;
    private String type_star;
    private String type_nation;
    private String dir;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }





    public String getType_nation() {
        return type_nation;
    }

    public void setType_nation(String type_nation) {
        this.type_nation = type_nation;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(String creat_time) {
        this.creat_time = creat_time;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEdit_time() {
        return edit_time;
    }

    public void setEdit_time(String edit_time) {
        this.edit_time = edit_time;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPick_time() {
        return pick_time;
    }

    public void setPick_time(String pick_time) {
        this.pick_time = pick_time;
    }

    public String getPick_time_long() {
        return pick_time_long;
    }

    public void setPick_time_long(String pick_time_long) {
        this.pick_time_long = pick_time_long;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getType_star() {
        return type_star;
    }

    public void setType_star(String type_star) {
        this.type_star = type_star;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", type='" + type + '\'' +
                ", creat_time='" + creat_time + '\'' +
                ", shape='" + shape + '\'' +
                ", size='" + size + '\'' +
                ", edit_time='" + edit_time + '\'' +
                ", resolution='" + resolution + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", location='" + location + '\'' +
                ", pick_time='" + pick_time + '\'' +
                ", pick_time_long='" + pick_time_long + '\'' +
                ", scale='" + scale + '\'' +
                ", type_star='" + type_star + '\'' +
                ", type_nation='" + type_nation + '\'' +
                ", dir='" + dir + '\'' +
                '}';
    }
}


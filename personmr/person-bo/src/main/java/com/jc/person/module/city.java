package main.java.com.jc.personbo.module;

/**
 * author:吴林
 * description:城市类
 * date:2020-02-19
 */
public class city {
    //主键
    private  int id;
    //父id
    private int pid;
    //城市名
    private String cityName;

    //城市类型
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package com.example.infrastructure.data;

/**
 * @author 告警类型
 */
public enum GiveAnAlarmTypeEnum {
    /** 告警类型 枚举*/
    PULL_DIRECTION_TYPE_ID(1,"拉力设备类型  give_an_alarm 主键 id"),
    SPEED_DIRECTION_TYPE_ID(2,"风速风向设备类型  give_an_alarm 主键 id"),
    INCLINATION_SENSOR_TYPE_ID(3,"倾角设备类型  give_an_alarm 主键 id"),
    UWB_TYPE_ID(4,"uwb围栏设备类型  give_an_alarm 主键 id"),
    CARD_TYPE_ID(5,"工牌告警设备类型 give_an_alarm 主键 id"),
    ;

    private final int id;
    private final String msg;

    GiveAnAlarmTypeEnum(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}

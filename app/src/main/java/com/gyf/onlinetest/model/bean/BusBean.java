package com.gyf.onlinetest.model.bean;

/**
 * Created by geyifeng on 2017/10/24.
 */


public class BusBean {


    private String bus_type;
    private int direction;
    private String name;
    private String start_time;
    private String departure;
    private String terminal;
    private String end_time;
    private long stop_id;
    private int station_index;
    private String real_time;
    private long id;
    private String next_stop;
    private String curr_stop;

    public String getBus_type() {
        return bus_type;
    }

    public void setBus_type(String bus_type) {
        this.bus_type = bus_type;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public long getStop_id() {
        return stop_id;
    }

    public void setStop_id(long stop_id) {
        this.stop_id = stop_id;
    }

    public int getStation_index() {
        return station_index;
    }

    public void setStation_index(int station_index) {
        this.station_index = station_index;
    }

    public String getReal_time() {
        return real_time;
    }

    public void setReal_time(String real_time) {
        this.real_time = real_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNext_stop() {
        return next_stop;
    }

    public void setNext_stop(String next_stop) {
        this.next_stop = next_stop;
    }

    public String getCurr_stop() {
        return curr_stop;
    }

    public void setCurr_stop(String curr_stop) {
        this.curr_stop = curr_stop;
    }

}


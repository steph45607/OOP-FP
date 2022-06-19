package com.oopfp.focustime;

// Class to create topic objects
public class TopicDesc {
//    Topic name
    private String name;
//    Description
    private String desc;

//    Constructor
    public TopicDesc(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

//    Getters
    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

}

package com.oopfp.focustime;

import java.util.ArrayList;

public class Subject {
    private String name;
    private ArrayList<TopicDesc> topicList;

    public Subject(String name, ArrayList<TopicDesc> topicList) {
        this.name = name;
        this.topicList = topicList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<TopicDesc> getTopicList() {
        return topicList;
    }
}

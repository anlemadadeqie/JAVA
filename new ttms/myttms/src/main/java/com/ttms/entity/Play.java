package com.ttms.entity;

import java.util.Date;

/**
 * Created by hjh on 16-11-16.
 */
public class Play {
    private int play_id;
    private String play_type;
    private String play_lang;
    private String play_name;
    private String play_introduction;
    private String play_image;
    private int play_length;
    private double play_ticket_price;
    private int play_status;
    private  String play_actor;
    private String play_up_time;
    private String play_down_time;
    private String play_orign;
    private String play_director;


    public Play(){}

    public int getPlay_id() {
        return play_id;
    }

    public void setPlay_id(int play_id) {
        this.play_id = play_id;
    }

    public String getPlay_type() {
        return play_type;
    }

    public void setPlay_type(String play_type) {
        this.play_type = play_type;
    }

    public String getPlay_lang() {
        return play_lang;
    }

    public void setPlay_lang(String play_lang) {
        this.play_lang = play_lang;
    }

    public String getPlay_name() {
        return play_name;
    }

    public void setPlay_name(String play_name) {
        this.play_name = play_name;
    }

    public String getPlay_introduction() {
        return play_introduction;
    }

    public void setPlay_introduction(String play_introduction) {
        this.play_introduction = play_introduction;
    }

    public String getPlay_image() {
        return play_image;
    }

    public void setPlay_image(String play_image) {
        this.play_image = play_image;
    }

    public int getPlay_length() {
        return play_length;
    }

    public void setPlay_length(int play_length) {
        this.play_length = play_length;
    }

    public double getPlay_ticket_price() {
        return play_ticket_price;
    }

    public void setPlay_ticket_price(double play_ticket_price) {
        this.play_ticket_price = play_ticket_price;
    }

    public int getPlay_status() {
        return play_status;
    }

    public void setPlay_status(int play_status) {
        this.play_status = play_status;
    }

    public String getPlay_actor() {
        return play_actor;
    }

    public void setPlay_actor(String play_actor) {
        this.play_actor = play_actor;
    }

    public String getPlay_up_time() {
        return play_up_time;
    }

    public void setPlay_up_time(String play_up_time) {
        this.play_up_time = play_up_time;
    }

    public String getPlay_down_time() {
        return play_down_time;
    }

    public void setPlay_down_time(String play_down_time) {
        this.play_down_time = play_down_time;
    }

    public String getPlay_orign() {
        return play_orign;
    }

    public void setPlay_orign(String play_orign) {
        this.play_orign = play_orign;
    }

    public String getPlay_director() {
        return play_director;
    }

    public void setPlay_director(String play_director) {
        this.play_director = play_director;
    }
}

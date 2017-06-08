package com.ttms.entity;

/**
 * Created by hacker on 17-6-5.
 */
public class User_sale {

        private int user_id;
        private int sale_id;

        public int getSale_id() {
            return sale_id;
        }

        public void setSale_id(int sale_id) {
            this.sale_id = sale_id;
        }

        private String play_name;
        private String studio_name;
        private String sced_time;
        private int    col;
        private int    row;
        private double prices;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getPlay_name() {
            return play_name;
        }

        public void setPlay_name(String play_name) {
            this.play_name = play_name;
        }

        public String getStudio_name() {
            return studio_name;
        }

        public void setStudio_name(String studio_name) {
            this.studio_name = studio_name;
        }

        public String getSced_time() {
            return sced_time;
        }

        public void setSced_time(String sced_time) {
            this.sced_time = sced_time;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public double getPrices() {
            return prices;
        }

        public void setPrices(double prices) {
            this.prices = prices;
        }
}


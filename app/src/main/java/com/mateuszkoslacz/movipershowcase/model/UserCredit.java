package com.mateuszkoslacz.movipershowcase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



    public class UserCredit {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("totalEarn")
        @Expose
        private Integer totalEarn;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getTotalEarn() {
            return totalEarn;
        }

        public void setTotalEarn(Integer totalEarn) {
            this.totalEarn = totalEarn;
        }

    }

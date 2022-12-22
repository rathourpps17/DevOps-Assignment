package com.exittest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceAbility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String pincode;
    int time;

    public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ServiceAbility [id=" + id + ", pincode=" + pincode + ", time=" + time + "]";
	}
}

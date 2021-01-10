package com.example.donacionesarquitectura;

public class DonationModel {
private int totalDonation;
public DonationModel(){
    this.totalDonation = 0;
}
public boolean saveDonation(int nuevaDonation){
    this.totalDonation = totalDonation + nuevaDonation;
    return true;
}
public int getTotalDonation(){
    return totalDonation;
}
}

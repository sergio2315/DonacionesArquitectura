package com.example.donacionesarquitectura;

public class Controller {
private DonationModel model;
    public Controller(){
        this.model=new DonationModel();
    }
    public boolean saveDonation(int amount){
        if (amount<=0){
            return false;
        }else {
            model.saveDonation(amount);
            return true;
        }
    }
    public int getTotalAmount(){
        return model.getTotalDonation();
    }

}

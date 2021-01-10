package com.example.donacionesarquitectura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.example.donacionesarquitectura.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private DonationModel model;
    private Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TVdonation.setText(getString(R.string.donacion, "0"));
        //Instanciacion de objeto controller
        controller = new Controller();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etDonation.length()!=0){
                    saveDonation();
                }else {
                    displayMessage("Ingrese un monto");
                }
            }
        });
    }
public void saveDonation(){
    Integer amount = Integer.valueOf(binding.etDonation.getText().toString());
    boolean save = controller.saveDonation(amount);
    if (save){
        String donationTotal = getString(R.string.donacion,
                String.valueOf(controller.getTotalAmount()));
        binding.TVdonation.setText(donationTotal);
        displayMessage("Se realizo la donación");
    }else {
        displayMessage("No fue posible realizar la donación");
    }
    binding.etDonation.setText("");
}
//Recibe un String y muestra un Toast con el mensaje
    private void displayMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
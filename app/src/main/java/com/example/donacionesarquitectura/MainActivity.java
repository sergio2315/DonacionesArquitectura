package com.example.donacionesarquitectura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.example.donacionesarquitectura.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IViewPresenter {
private ActivityMainBinding binding;
private DonationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TVdonation.setText(getString(R.string.donacion, "0"));
        //instanciar presentador
        presenter = new DonationPresenter();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void updateTotalDonation(int totalDonation) {
        String donationString = getString(R.string.donacion,String.valueOf(totalDonation) );
        binding.TVdonation.setText(donationString);
    }

    @Override
    public void displayConfirmationMessage() {
        Toast.makeText(this, "Donación realizada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayErrorMessage() {
        Toast.makeText(this, "No se registro la donación", Toast.LENGTH_SHORT).show();
    }
}
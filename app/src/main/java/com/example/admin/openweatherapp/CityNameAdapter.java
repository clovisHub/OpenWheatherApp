package com.example.admin.openweatherapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class CityNameAdapter extends DialogFragment {

    private EditText cityName;
    String cityValue = "";
    Linker activityLinker = null;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        activityLinker = (Linker) getActivity();

        return cityDialog();
    }


    private AlertDialog cityDialog(){

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View cityView= inflater.inflate(R.layout.city_name,null);

        AlertDialog.Builder alertDialZip = new AlertDialog.Builder(getActivity());

        alertDialZip.setTitle(R.string.city_name)
                .setView(cityView)
                .setPositiveButton("click", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        cityName = (EditText) cityView.findViewById(R.id.edit_cityNameId);

                        cityValue = cityName.getText().toString();

                        activityLinker.setCityName(cityValue);
                    }
                });

        return alertDialZip.create();
    }

    public String getCityValue(){
        return cityValue;
    }

}

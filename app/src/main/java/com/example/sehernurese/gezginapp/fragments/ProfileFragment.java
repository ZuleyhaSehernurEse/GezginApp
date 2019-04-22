package com.example.sehernurese.gezginapp.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sehernurese.gezginapp.R;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        v.findViewById(R.id.iv_instagram).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram();
            }
        });
        return v;
    }

    private void openInstagram() {
        Uri instagramUri = Uri.parse("https://www.instagram.com/sehernurese/?hl=tr");
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, instagramUri);
        instagramIntent.setPackage("com.instagram.andtoid");
        try {
            startActivity(instagramIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/sehernurese/?hl=tr")));
        }


    }


}

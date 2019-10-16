package com.example.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.text_location_name_details)
    TextView nameTextView;
    @BindView(R.id.text_location_desc_details)
    TextView descTextView;
    @BindView(R.id.img_location_details)
    ImageView locationImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        assert intent.getExtras() != null;
        if (intent.getExtras().getInt(getString(R.string.image_key)) != 0) {
            locationImageView.setImageResource(intent.getExtras().getInt(getString(R.string.image_key)));
        } else {
            locationImageView.setVisibility(View.GONE);
        }
        nameTextView.setText(intent.getExtras().getString(getString(R.string.name_key)));
        descTextView.setText(intent.getExtras().getString(getString(R.string.desc_key)));
    }
}

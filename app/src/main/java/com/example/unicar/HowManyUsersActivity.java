package com.example.unicar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class HowManyUsersActivity extends AppCompatActivity {

    Spinner howManyUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many_users);

        howManyUsers= findViewById(R.id.spinner_how_many_users);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_how_many_users, getResources().getStringArray(R.array.how_many_users_array));
        adapter.setDropDownViewResource(R.layout.spinner_item_how_many_users);
        howManyUsers.setAdapter(adapter);

        howManyUsers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = howManyUsers.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}

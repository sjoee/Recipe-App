package com.example.chapter2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //onCreate() == main() method in java or main() function in c++
    //what happens when the user launch the app
    //use setContentView() method to display everything in activity main xml file
    //go to res folder > layout folder > activity main xml file
    //in html <body> works like onCreate() method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //get the button object, btnRecipe button from activity main xml file
        //set the button to listen to the user action on the screen/view object
        //when the user click or tap on the button, onClick() method will be activated
        //start a new page or activity based on the value stored inside the intent
        //intent == URL object stored the destination URL
        //from main activity go to recipe activity
        Button button = (Button) findViewById(R.id.btnRecipe);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Recipe.class));
            }
        });
    }
}
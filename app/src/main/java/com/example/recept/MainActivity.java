package com.example.recept;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    int amount_of_people = 1;
    Button plus_btn, min_btn;
    TextView pers_tv;

    ArrayList<Ingredient> recept_array = new ArrayList<>();
    ArrayList<TextView> tv_array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pers_tv = findViewById(R.id.person);
        plus_btn = findViewById(R.id.btnplus);
        min_btn = findViewById(R.id.btnmin);

        ViewGroup layout = (ViewGroup) findViewById(R.id.rootlayout);

        recept_array.add(new Ingredient("spek", "spek", 5, "sneetje", "sneetjes"));
        recept_array.add(new Ingredient("zure room", "zure room", 200, "gram", "gram"));
        recept_array.add(new Ingredient("limoen", "limoenen", 2, "", ""));
        recept_array.add(new Ingredient("tortilla", "tortilla's", 1, "", ""));
        recept_array.add(new Ingredient("cheddar", "cheddar", 50, "gram", "gram"));
        recept_array.add(new Ingredient("avocado", "avocado's", 1, "", ""));
        recept_array.add(new Ingredient("rode ui", "rode uien", 0.5f, "", ""));
        recept_array.add(new Ingredient("trostomaat", "trostomaten", 10, "", ""));
        //Ingredient ing_ajuin = new Ingredient(0.5f); //float = 32bits double = 64bits

        for(int i = 0; i<recept_array.size(); i++){
            TextView tv = new TextView(this);
            layout.addView(tv, i+3);
            tv_array.add(tv);


        }

        update_ui();

        plus_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                amount_of_people = amount_of_people + 1;
                MainActivity.this.update_ui();
            }
        });

        min_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                amount_of_people = amount_of_people - 1;
                MainActivity.this.update_ui();
            }
        });


    }

    void update_ui() {
        pers_tv.setText(String.format("Personen: %d", amount_of_people));

        //String even_oneven = (int)tortilla % 2 == 0 ? 5 : -1;
        //als rest gelijk aan nul = even anders oneven
        //kan ook met getallen
        /*String tort;
        if(tortilla > 1) { //ternaire operator , tortilla > 1 ? "tortilla" :
            tort = String.format("%s %s", tortilla "tortilla's");
        } else{
            tort = String.format("%s %s", tortilla, " tortilla");
        }*/

        for(int i = 0; i <recept_array.size(); i++){
            TextView tv = tv_array.get(i);
            Ingredient ing = recept_array.get(i);
            tv_array.get(ing.toString(amount_of_people));
        }

        min_btn.setEnabled(amount_of_people > 1);
    }
}
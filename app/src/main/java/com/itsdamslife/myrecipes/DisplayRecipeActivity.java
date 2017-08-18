package com.itsdamslife.myrecipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String recipe = intent.getStringExtra("extra_msg");

        // Capture the layout's TextView and set the string as its text
        EditText title = (EditText) findViewById(R.id.recipeTitle);
        title.setText(recipe);

        this.setIngredientsText();
    }

    private void setIngredientsText() {
        String ingredients = this.getDummyText();
        TextView ingredientsTextView = (TextView) findViewById(R.id.ingredientsTextView);
        ingredientsTextView.setText(ingredients);
        ingredientsTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    private String getDummyText() {
        String dummy = "Ingredients: Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n \nLorem Ipsum has been the industry's standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and scrambled it to make a type specimen book.\n \nIt has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum\n-----------\nProcedure:\n\nLorem Ipsum is simply dummy text of the printing and typesetting industry.\n \nLorem Ipsum has been the industry's standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and scrambled it to make a type specimen book.\n \nIt has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum\n\nLorem Ipsum is simply dummy text of the printing and typesetting industry.\n \nLorem Ipsum has been the industry's standard dummy text ever since the 1500s, \nwhen an unknown printer took a galley of type and scrambled it to make a type specimen book.\n \nIt has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum\n\n-Dams";
        return dummy;
    }
}

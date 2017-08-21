package com.itsdamslife.myrecipes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_save_new_recipe) {
            this.saveRecipe();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveRecipe() {

        EditText title = (EditText)findViewById(R.id.recipeTitle);
        EditText ingredients = (EditText)findViewById(R.id.ingredientsEditTextView);
        EditText procedure = (EditText)findViewById(R.id.procedureEditTextView);

        if(title.getText().length() > 0 && ingredients.getText().length() > 0 && procedure.getText().length() > 0) {
            this.showToast("Saved!!");
        } else {
            this.showToast("NOTHING TO SAVE!!");
        }
    }

    private void showToast(String toastText) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }

}

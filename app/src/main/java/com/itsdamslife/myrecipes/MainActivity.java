package com.itsdamslife.myrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Recipe> recipeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecipesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recipe_recycler_view);

        mAdapter = new RecipesAdapter(recipeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Recipe recipe = recipeList.get(position);
                Intent intent = new Intent(getBaseContext(), DisplayRecipeActivity.class);
                intent.putExtra("extra_msg", recipe.getTitle());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareRecipeData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_add_new_recipe) {

            Intent intent = new Intent(getBaseContext(), AddNewRecipeActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void prepareRecipeData() {
        Recipe recipe = new Recipe("Biryani", "Mughalai");
        recipeList.add(recipe);

        recipe = new Recipe("Idli", "South Indian");
        recipeList.add(recipe);

        recipe = new Recipe("Vada", "South Indian");
        recipeList.add(recipe);

        recipe = new Recipe("Mangalore Buns", "South Indian");
        recipeList.add(recipe);

        recipe = new Recipe("South Indian Thali", "South Indian");
        recipeList.add(recipe);

        recipe = new Recipe("Aloo Paratha", "North Indian");
        recipeList.add(recipe);

        recipe = new Recipe("Kadi pakoda", "North Indian");
        recipeList.add(recipe);

        recipe = new Recipe("Kadai Paneer", "North Indian");
        recipeList.add(recipe);

        recipe = new Recipe("Posse", "Italian");
        recipeList.add(recipe);

        recipe = new Recipe("Pasta", "Italian");
        recipeList.add(recipe);

        recipe = new Recipe("Pizza", "Italian");
        recipeList.add(recipe);

        recipe = new Recipe("Choupsuey", "Chinese");
        recipeList.add(recipe);

        recipe = new Recipe("Machurian", "Chinese");
        recipeList.add(recipe);

        recipe = new Recipe("Garlic sauce", "Chinese");
        recipeList.add(recipe);

        recipe = new Recipe("Rasa Malai", "Indian sweet");
        recipeList.add(recipe);

        recipe = new Recipe("Rasa Gulla", "Indian sweet");
        recipeList.add(recipe);

        mAdapter.notifyDataSetChanged();
    }

}

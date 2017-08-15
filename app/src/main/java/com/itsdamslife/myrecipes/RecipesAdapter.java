package com.itsdamslife.myrecipes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

    private List<Recipe> recipesList;

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        public TextView title, cuisine;

        public RecipeViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            cuisine = (TextView) view.findViewById(R.id.cuisine);

        }
    }

    public RecipesAdapter(List<Recipe> recipesList) {
        this.recipesList = recipesList;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_row, parent, false);

        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Recipe recipe = recipesList.get(position);
        holder.title.setText(recipe.getTitle());
        holder.cuisine.setText(recipe.getCuisine());
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }
}
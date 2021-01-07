package com.cookies.cookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.cookies.cookbook.api.model.BaseRecipe;
import com.cookies.cookbook.api.model.Category;
import com.cookies.cookbook.api.model.Ingredient;
import com.cookies.cookbook.api.model.Recipe;
import com.cookies.cookbook.api.model.Step;
import com.cookies.cookbook.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemActivity extends AppCompatActivity {
    private TextView categoryName;
    private TextView name;
    private TableLayout ingredients;
    private ListView steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        categoryName = findViewById(R.id.category_name);
        name = findViewById(R.id.name);
        ingredients = findViewById(R.id.ingredients);
        steps = findViewById(R.id.steps);

        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("r_id"));
        Call<Recipe> res = ApiClient.getInstance()
                .getRecipeJsonApi()
                .getById(id);
        res.enqueue(new Callback<Recipe>() {
            @Override
            public void onResponse(Call<Recipe> call, Response<Recipe> response) {
                if (!response.isSuccessful()) {
                    categoryName.setText(response.code());
                }

                Recipe recipe = response.body();
                String categories = "";
                for (Category category: recipe.getCategories()) {
                    categories += category.getName();
                    categories += " * ";
                }
                categoryName.setText(categories);
                name.setText(recipe.getName());
                for (Ingredient ingredient: recipe.getIngredients()) {
                    TableRow row = new TableRow(ItemActivity.this);
                    TextView ing_name = new TextView(ItemActivity.this);
                    TextView ing_amount = new TextView(ItemActivity.this);
                    ing_name.setText(ingredient.getProduct().getName());
                    ing_amount.setText(ingredient.getAmount());
                }
                ArrayList<String> steps_s = new ArrayList<>();
                for (Step step: recipe.getSteps()){
                    steps_s.add(step.getId() + " : " + step.getDescription());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ItemActivity.this, android.R.layout.simple_list_item_2, steps_s);
                steps.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Recipe> call, Throwable t) {
                categoryName.setText(t.getMessage());
            }
        });

    }
}
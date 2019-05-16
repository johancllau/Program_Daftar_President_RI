package com.example.myrecicleview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<President> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            ActionBar ac = getSupportActionBar();
            ac.setTitle("Mode List");

       rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(PresidentData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter obj_list = new ListPresidentAdapter(this);
        obj_list.setListPresident(list);
        rvCategory.setAdapter(obj_list);
    }
    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridPresidentAdapter obj_grid = new GridPresidentAdapter(this);
        obj_grid.setGridPresident(list);
        rvCategory.setAdapter(obj_grid);
    }
    private  void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidentAdapater obj_cardview = new CardViewPresidentAdapater(this);
        obj_cardview.setCardviewPresident(list);
        rvCategory.setAdapter(obj_cardview);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list :
                setActionBar("Mode List");
                showRecyclerList();
                break;
            case R.id.action_grid :
                setActionBar("Mode Grid");
                showRecyclerGrid();
                break;
            case R.id.action_cardview :
                setActionBar("Mode Card View");
                showRecyclerCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setActionBar(String title) {
        getSupportActionBar().setTitle(title);
    }
}
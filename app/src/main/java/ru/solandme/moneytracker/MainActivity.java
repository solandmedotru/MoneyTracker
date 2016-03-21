package ru.solandme.moneytracker;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ru.solandme.moneytracker.fragments.CategoryFragment;
import ru.solandme.moneytracker.fragments.TransactionsFragment;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView left_drawer;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        left_drawer = (ListView) findViewById(R.id.left_drawer);

        String[] navigationData = new String[]{"Траты", "Категории", "Статистика"};
        ArrayAdapter<String> navigationDrawerAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                navigationData);
        left_drawer.setAdapter(navigationDrawerAdapter);
        left_drawer.setOnItemClickListener(new DrawerItemClickListener());

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);

    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerToggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle("Траты");
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, new TransactionsFragment()).commit();
                    break;
                case 1:
                    left_drawer.setItemChecked(position, true);
                    drawerLayout.closeDrawer(left_drawer);
                    setTitle("Категории");
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, new CategoryFragment()).commit();
                    break;

            }
        }
    }
}

package com.action_bar_ab2018.action_bar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.design_menu,menu);
        return  true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_search)
        {
            Intent searchIntent = new Intent(this,SearchActivity.class);
            startActivity(searchIntent);
            return true;
        }
        else if(id == R.id.action_dialog)
        {
            android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("Dialog");
            dialog.setMessage("Uyarı!");
            dialog.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            dialog.show();
            return  true;
        }

        else if(id == R.id.action_design)
        {
            Intent collapseIntent = new Intent(this,DesignActivity.class);
            startActivity(collapseIntent);
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}

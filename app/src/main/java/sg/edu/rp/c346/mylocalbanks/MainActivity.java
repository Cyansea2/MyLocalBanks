package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnD;
    Button btnO;
    Button btnU;

    int btnPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnD = findViewById(R.id.btn0);
        btnO = findViewById(R.id.btn1);
        btnU = findViewById(R.id.btn2);

        registerForContextMenu(btnD);
        registerForContextMenu(btnO);
        registerForContextMenu(btnU);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.button_menu, menu);
        btnPressed = v.getId();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.websiteSelection) {
            //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            String url = "";
            if (btnPressed == R.id.btn0) {
                url = getString(R.string.webD);
            } else if (btnPressed == R.id.btn1) {
                url = getString(R.string.webO);
            } else {
                url = getString(R.string.webU);
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);

            return true; //menu item successfully handled
        } else if (id == R.id.callSelection) {
            String tel = "";
            if (btnPressed == R.id.btn0) {
                tel = getString(R.string.noDBS);
            } else if (btnPressed == R.id.btn1) {
                tel = getString(R.string.noOCBC);
            } else {
                tel = getString(R.string.noUOB);
            }
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel));
            startActivity(intent);
            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if(id == R.id.englishSelection) {
            btnD.setText(getString(R.string.dbs));
            btnO.setText(getString(R.string.ocbc));
            btnU.setText(getString(R.string.uob));

        }
        else if(id == R.id.chineseSelection) {
            btnD.setText(getString(R.string.chi_dbs));
            btnO.setText(getString(R.string.chi_ocbc));
            btnU.setText(getString(R.string.chi_uob));
        }
        return super.onOptionsItemSelected(item);
    }
}

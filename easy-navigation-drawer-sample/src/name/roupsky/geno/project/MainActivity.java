
package name.roupsky.geno.project;

import name.roupsky.geno.easynavigationdrawer.EasyNavigationDrawerBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity implements OnClickListener {

    private static final String EXTRA_THEME = "EXTRA_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getIntent().getIntExtra(EXTRA_THEME, R.style.Theme_App));

        super.onCreate(savedInstanceState);

        new EasyNavigationDrawerBuilder()
                .setContentView(R.layout.activity_main)
                .setLeftContentView(R.layout.navigation_menu)
                .install(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // after install the menu is accessible by standard findViewById
        findViewById(android.R.id.button1).setOnClickListener(this);
        findViewById(android.R.id.button2).setOnClickListener(this);
        findViewById(android.R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case android.R.id.button1:
                startActivity(new Intent(this, getClass()).putExtra(EXTRA_THEME, R.style.Theme_App_Light));
                break;
            case android.R.id.button2:
                startActivity(new Intent(this, getClass()).putExtra(EXTRA_THEME, R.style.Theme_App));
                break;
            case android.R.id.button3:
                startActivity(new Intent(this, ChildActivity.class));
                break;
        }
    }

}

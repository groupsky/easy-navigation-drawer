
package name.roupsky.geno.project;

import name.roupsky.geno.easynavigationdrawer.EasyNavigationDrawerBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new EasyNavigationDrawerBuilder()
                .setContentView(R.layout.activity_main)
                .setLeftContentView(R.layout.navigation_menu)
                .install(this);

        // after install the menu is accessible by standard findViewById
        findViewById(android.R.id.button1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case android.R.id.button1:
                startActivity(new Intent(this, ChildActivity.class));
                break;
        }
    }

}

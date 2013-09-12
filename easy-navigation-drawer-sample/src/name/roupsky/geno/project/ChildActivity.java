
package name.roupsky.geno.project;

import name.roupsky.geno.easynavigationdrawer.EasyNavigationDrawerBuilder;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class ChildActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new EasyNavigationDrawerBuilder()
                .setContentView(R.layout.activity_child)
                .setLeftContentView(R.layout.navigation_menu)
                .install(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // after install the content is accessible by simple findViewById
        ((TextView) findViewById(android.R.id.text1)).setText("Text from code");
    }
}

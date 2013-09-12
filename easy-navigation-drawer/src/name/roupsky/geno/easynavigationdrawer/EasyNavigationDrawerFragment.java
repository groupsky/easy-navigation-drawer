
package name.roupsky.geno.easynavigationdrawer;

import static android.view.Gravity.LEFT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class EasyNavigationDrawerFragment extends Fragment implements DrawerListener {

    private static final String TAG = "GRD.Fragment";

    private static final ViewGroup.LayoutParams DRAWER_LAYOUT_PARAMS = new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT);

    private ActionBarDrawerToggle drawerToggle;

    private DrawerLayout drawerLayout;

    private int drawerIndicator;

    public EasyNavigationDrawerFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: " + item.getItemId());
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * A drawer listener can be used to respond to drawer events such as becoming fully opened or closed. You should
     * always prefer to perform expensive operations such as drastic relayout when no animation is currently in
     * progress, either before or after the drawer animates. When using ActionBarDrawerToggle, all DrawerLayout listener
     * methods should be forwarded if the ActionBarDrawerToggle is not used as the DrawerLayout listener directly.
     */
    @Override
    public void onDrawerOpened(View drawerView) {
        drawerToggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        drawerToggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        drawerToggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        drawerToggle.onDrawerStateChanged(newState);
    }

    /**
     * Executed before the fragment is attached so don't rely on it
     * 
     * @param contentLayoutResID
     * @param leftContentLayoutResID
     */
    public void setupDrawer(Activity activity, int contentLayoutResID, int leftContentLayoutResID) {
        drawerLayout = new DrawerLayout(activity);
        drawerLayout.setDrawerListener(this);
        drawerLayout.setId(R.id.grd_drawer_layout);

        styleDrawer();

        activity.setContentView(drawerLayout, DRAWER_LAYOUT_PARAMS);

        View contentView = activity.getLayoutInflater().inflate(contentLayoutResID, drawerLayout, false);
        drawerLayout.addView(contentView, MATCH_PARENT, MATCH_PARENT);

        View leftContentView = activity.getLayoutInflater().inflate(leftContentLayoutResID, drawerLayout, false);
        DrawerLayout.LayoutParams lp = new DrawerLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, LEFT);
        drawerLayout.addView(leftContentView, lp);

        drawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, drawerIndicator, R.string.grd_drawer_open, R.string.grd_drawer_close);
    }

    private void styleDrawer() {
        Theme theme = drawerLayout.getContext().getTheme();

        TypedArray a = theme.obtainStyledAttributes(null, R.styleable.EasyNavigationDrawerFragment, R.attr.drawerStyle, R.style.Widget_EasyNavigationDrawer);

        drawerIndicator = a.getResourceId(R.styleable.EasyNavigationDrawerFragment_drawerIndicator, R.drawable.ic_drawer);
        int drawerShadow = a.getResourceId(R.styleable.EasyNavigationDrawerFragment_drawerShadow, 0);
        if (drawerShadow != 0) {
            drawerLayout.setDrawerShadow(drawerShadow, LEFT);
        }

        a.recycle();
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public ActionBarDrawerToggle getDrawerToggle() {
        return drawerToggle;
    }
}

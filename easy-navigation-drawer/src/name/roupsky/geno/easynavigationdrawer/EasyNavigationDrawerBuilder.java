
package name.roupsky.geno.easynavigationdrawer;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

/**
 * Builder for configuring and attaching navigation drawer to an activity
 * 
 * @author groupsky
 */
public class EasyNavigationDrawerBuilder {

    private static final String DRAWER_FRAGMENT = "name.roupsky.geno.easynavigationdrawer.DRAWER_FRAGMENT";
    /**
     * Layout params for the drawer and main content
     */
    private static final String TAG = "GRD.Builder";

    private int contentLayoutResID = View.NO_ID;
    private int leftContentLayoutResID = View.NO_ID;
    private boolean drawerIndicatorEnabled = true;

    public EasyNavigationDrawerBuilder() {
    }

    /**
     * Sets the main content of the drawer using a layout resource. The layout SHOULD NOT have been created by beans of
     * {@link Activity#setContentView(int)}
     * 
     * @param layoutResID Main content layout resource id (R.layout.layoutId)
     */
    public EasyNavigationDrawerBuilder setContentView(int layoutResID) {
        contentLayoutResID = layoutResID;
        return this;
    }

    /**
     * Sets the main content of the drawer using a layout resource. The layout SHOULD NOT have been created by beans of
     * {@link Activity#setContentView(int)}
     * 
     * @param layoutResID Main content layout resource id (R.layout.layoutId)
     */
    public EasyNavigationDrawerBuilder setLeftContentView(int layoutResID) {
        leftContentLayoutResID = layoutResID;
        return this;
    }

    public EasyNavigationDrawerBuilder disableDrawerIndicator() {
        drawerIndicatorEnabled = false;
        return this;
    }

    public void install(FragmentActivity activity) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        EasyNavigationDrawerFragment drawerFragment = (EasyNavigationDrawerFragment) fragmentManager.findFragmentByTag(DRAWER_FRAGMENT);
        if (drawerFragment == null) {
            Log.d(TAG, "creating drawer fragment");
            drawerFragment = new EasyNavigationDrawerFragment();
            fragmentManager.beginTransaction().add(drawerFragment, DRAWER_FRAGMENT).commit();
        } else {
            Log.d(TAG, "drawer fragment exists");
        }

        drawerFragment.setupDrawer(activity, contentLayoutResID, leftContentLayoutResID);

        drawerFragment.getDrawerToggle().setDrawerIndicatorEnabled(drawerIndicatorEnabled);
    }

}

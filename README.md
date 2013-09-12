easy-navigation-drawer [![Build Status][1]][2]
======================

Easy integration of Android UX pattern Navigation Drawer (aka sliding menu)

Why easy?
=========
Compare Google's [tutorial][3] on creating navigation drawer with how it's done using this library:

```java
    new EasyNavigationDrawerBuilder()
            .setContentView(R.layout.activity_child)
            .setLeftContentView(R.layout.navigation_menu)
            .install(this);
```

And the result is:

![EasyNavigationDrawer Sample Screenshot][4]



 [1]: https://travis-ci.org/groupsky/easy-navigation-drawer.png?branch=master
 [2]: https://travis-ci.org/groupsky/easy-navigation-drawer
 [3]: http://developer.android.com/training/implementing-navigation/nav-drawer.html
 [4]: https://raw.github.com/groupsky/easy-navigation-drawer/master/easy-navigation-drawer-sample/screenshot.png

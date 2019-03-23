package com.galou.mynews.controllers.activities;

import android.os.Bundle;
import android.view.View;

import com.galou.mynews.R;
import com.galou.mynews.controllers.fragments.BaseFragmentSearch;
import com.galou.mynews.controllers.fragments.NotificationsFragment;

public class NotificationsActivity extends BaseActivity implements BaseFragmentSearch.OnButtonClickedListener {

    private NotificationsFragment notificationsFragment;

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_notifications;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.configureAndShowNotificationsFragment();
    }

    // -------------------
    // CONFIGURATION
    // -------------------

    private void configureAndShowNotificationsFragment(){
        notificationsFragment = (NotificationsFragment) getSupportFragmentManager().findFragmentById(R.id.notifications_activity_frame_layout);
        if (notificationsFragment == null){
            notificationsFragment = new NotificationsFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.notifications_activity_frame_layout, notificationsFragment)
                    .commit();
        }

    }

    @Override
    public void onButtonClicked(View view) {

    }
}

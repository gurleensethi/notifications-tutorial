package com.thetehnocafe.gurleensethi.notificationstutorialapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationUtil.createNotificationChannel(mNotificationManager);

        initializeViews();
    }

    private void initializeViews() {
        findViewById(R.id.simpleNotificationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = NotificationUtil.createSimpleNotification(MainActivity.this, "Simple Notification", "I am a boring notification.");
                mNotificationManager.notify(NotificationUtil.SIMPLE_NOTIFICATION_ID, notification);
            }
        });

        findViewById(R.id.notificationWithIntentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = NotificationUtil.createNotificationWithContentIntent(
                        MainActivity.this,
                        "Notification With Content Intent",
                        "Close the app and then click me!"
                );

                mNotificationManager.notify(NotificationUtil.NOTIFICATION_WITH_INTENT_ID, notification);
            }
        });

        findViewById(R.id.bigTextStyleNotificationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = NotificationUtil.createBigTextStyleNotification(
                        MainActivity.this,
                        "Big Text Style Notification",
                        "I am the content text of a smaller notification.",
                        "I am the content text of a Big Notification. These are some lines that don't mean anything, but I had to put them here."
                );

                mNotificationManager.notify(NotificationUtil.BIG_TEXT_STYLE_NOTIFICATION_ID, notification);
            }
        });

        findViewById(R.id.inboxStyleNotificationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = NotificationUtil.createInboxStyleNotification(
                        MainActivity.this,
                        "Inbox Style Notification",
                        "This is an inbox style Notification!",
                        "I am line 1",
                        "I am line 2",
                        "I am line 3",
                        "I am line 4",
                        "I am line 5",
                        "I am line 6"
                );

                mNotificationManager.notify(NotificationUtil.INBOX_STYLE_NOTIFICATION_ID, notification);
            }
        });

        findViewById(R.id.bigPictureStyleNotificationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = NotificationUtil.createBigPictureStyleNotification(
                        MainActivity.this,
                        "Big Picture Notification",
                        "You are going to see a big picture",
                        R.drawable.picture,
                        R.drawable.picture
                );

                mNotificationManager.notify(NotificationUtil.BIG_PICTURE_STYLE_NOTIFICATION_ID, notification);
            }
        });

        findViewById(R.id.messagingStyleNotificationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = NotificationUtil.createMessagingStyleNotification(
                        MainActivity.this,
                        "Big Picture Notification",
                        "You are going to see a big picture"
                );

                mNotificationManager.notify(NotificationUtil.MESSAGING_STYLE_NOTIFICATION_ID, notification);
            }
        });
    }
}

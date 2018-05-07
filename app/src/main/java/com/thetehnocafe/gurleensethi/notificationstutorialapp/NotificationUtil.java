package com.thetehnocafe.gurleensethi.notificationstutorialapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import java.util.Date;

public class NotificationUtil {
    private static String DEFAULT_CHANNEL_ID = "default_channel";
    private static String DEFAULT_CHANNEL_NAME = "Default";
    public static int SIMPLE_NOTIFICATION_ID = 1;
    public static int NOTIFICATION_WITH_INTENT_ID = 2;
    public static int BIG_TEXT_STYLE_NOTIFICATION_ID = 3;
    public static int INBOX_STYLE_NOTIFICATION_ID = 4;
    public static int BIG_PICTURE_STYLE_NOTIFICATION_ID = 5;
    public static int MESSAGING_STYLE_NOTIFICATION_ID = 6;

    /*
     * Create NotificationChannel as required from Android 8.0 (Oreo)
     * */
    public static void createNotificationChannel(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //Create channel only if it is not already created
            if (notificationManager.getNotificationChannel(DEFAULT_CHANNEL_ID) == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(
                        DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
                ));
            }
        }
    }

    public static Notification createSimpleNotification(Context context, String title, String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(android.R.drawable.ic_menu_view)
                .setVibrate(new long[] {250, 250, 250, 250});

        return builder.build();
    }

    public static Notification createNotificationWithContentIntent(Context context, String title, String text) {
        Intent intent = new Intent(context, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        return builder.build();
    }

    public static Notification createBigTextStyleNotification(Context context, String title, String text, String bigText) {
        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.bigText(bigText);
        style.setBigContentTitle(title);
        style.setSummaryText(text);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setStyle(style);

        return builder.build();
    }

    public static Notification createInboxStyleNotification(Context context, String title, String text, String... lines) {
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        style.setSummaryText(text);
        style.setBigContentTitle("Big Content title - " + title);
        for (String line : lines) {
            style.addLine(line);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setStyle(style);

        return builder.build();
    }

    public static Notification createBigPictureStyleNotification(Context context, String title, String text, int bigPictureResource, int bigLargeIcon) {
        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.setBigContentTitle(title);
        style.setSummaryText(text);
        style.bigPicture(BitmapFactory.decodeResource(context.getResources(), bigPictureResource));
        style.bigLargeIcon(BitmapFactory.decodeResource(context.getResources(), bigLargeIcon));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setStyle(style);

        return builder.build();
    }

    public static Notification createMessagingStyleNotification(Context context, String title, String text) {
        NotificationCompat.MessagingStyle style = new NotificationCompat.MessagingStyle("Gurleen Sethi");
        style.addMessage(new NotificationCompat.MessagingStyle.Message("Testing", new Date().getTime(), "Saru Sethi"));
        style.addMessage(new NotificationCompat.MessagingStyle.Message("Testing 123", new Date().getTime(), "Saru Sethi"));

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(android.R.drawable.ic_menu_send)
                .setStyle(style);

        return builder.build();
    }
}

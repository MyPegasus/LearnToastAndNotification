package com.example.mypegasus.learntoastandnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class NotificationActivityFragment extends Fragment {

    public NotificationActivityFragment() {
    }

    private Button createNotification;
    public static final int NOTIFICATION_ID = 1200;
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        createNotification = (Button) rootView.findViewById(R.id.btn_createNotification);
        createNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
//                builder.setSmallIcon(R.drawable.pic1);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle(counter + ":My notification");
                builder.setContentText("Hello World!");
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.pic2);
                builder.setLargeIcon(icon);

                Notification notification = builder.build();
                NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(NOTIFICATION_ID, notification);

            }
        });
        return rootView;
    }
}

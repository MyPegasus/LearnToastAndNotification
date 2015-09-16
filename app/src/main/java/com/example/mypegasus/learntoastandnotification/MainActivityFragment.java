package com.example.mypegasus.learntoastandnotification;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    public MainActivityFragment() {
    }

    private Button showToastShort;
    private Button showToastLong;
    private Button showToastImage;
    private Button showToastCustomView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        showToastShort = (Button) rootView.findViewById(R.id.btn_showToastShort);
        showToastShort.setOnClickListener(this);
        showToastLong = (Button) rootView.findViewById(R.id.btn_showToastLong);
        showToastLong.setOnClickListener(this);
        showToastImage = (Button) rootView.findViewById(R.id.btn_showToastImage);
        showToastImage.setOnClickListener(this);
        showToastCustomView = (Button) rootView.findViewById(R.id.btn_showToastCustomView);
        showToastCustomView.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_showToastShort:
                Toast toast = Toast.makeText(getActivity(), "显示一个简短的Toast", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 100, -200);
                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.setMargin(0, 0);
                toast.show();
                break;
            case R.id.btn_showToastLong:
                Toast.makeText(getActivity(), "显示一个较长的Toast", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_showToastImage:
                Toast imageToast = Toast.makeText(getActivity(), "这是一个带有图片的Toast", Toast.LENGTH_SHORT);
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(R.mipmap.ic_launcher);
                imageToast.setView(imageView);
                imageToast.show();
                break;
            case R.id.btn_showToastCustomView:
                Toast customViewToast = Toast.makeText(getActivity(), "这是一个自定义View的Toast", Toast.LENGTH_SHORT);
                View view = getActivity().getLayoutInflater().inflate(R.layout.toast_custom, null);
                customViewToast.setView(view);
                customViewToast.show();
                break;
        }
    }
}

package com.ajibarang.rsud.rsudajibarang;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class berita extends Fragment {
    Activity context;

    public berita() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getActivity();
        View view = inflater.inflate(R.layout.fragment_berita, container, false);
        WebView web = (WebView) view.findViewById(R.id.web_view);
        web.loadUrl("http://rsudajibarang.banyumaskab.go.id");
        web.setWebViewClient(new WebViewClient());

        return view;
    }

}

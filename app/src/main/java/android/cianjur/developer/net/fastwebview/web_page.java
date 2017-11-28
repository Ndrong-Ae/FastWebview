package android.cianjur.developer.net.fastwebview;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web_page extends AppCompatActivity {

    private WebView websiteku;

    //URL web, yang akan kita gunakan pada Webview
    private String URL = "http://www.wildantechnoart.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);
        websiteku = findViewById(R.id.my_web);
        settings();
        load_website();
    }

    //Method Ini Digunakan sebagai Setelan/Pengaturan Web
    private void settings(){
        WebSettings web_settings = websiteku.getSettings();
        web_settings.setJavaScriptEnabled(true);
        web_settings.setAllowContentAccess(true);
        web_settings.setUseWideViewPort(true);
        web_settings.setLoadsImagesAutomatically(true);
        web_settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        web_settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        web_settings.setEnableSmoothTransition(true);
        web_settings.setDomStorageEnabled(true);
    }

    //Untuk Mengatur, dan menampilan Halaman Web pada Aplikasi
    private void load_website(){
        if(Build.VERSION.SDK_INT >= 19){
            websiteku.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }else{
            websiteku.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        websiteku.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });

        websiteku.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        websiteku.loadUrl(URL);
    }

    public void onBackPressed() {
        if(websiteku.canGoBack()){
            websiteku.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
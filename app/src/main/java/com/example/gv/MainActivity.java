package com.example.gv;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.text.SpannableStringBuilder;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity implements OnClickListener{
//public class Test02_01 extends Activity implements OnClickListener{

    private final int FP = ViewGroup.LayoutParams.FILL_PARENT;
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

    private EditText textUrl;
    private Button buttonGo;
    private WebView webview;

    @Override protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);


        LinearLayout ctlLinearLayout = new LinearLayout(this);
        ctlLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        textUrl = new EditText(this);
        textUrl.setText("http://");

        buttonGo = new Button(this);
        buttonGo.setText("Go");
        buttonGo.setOnClickListener(this);

        ctlLinearLayout.addView(buttonGo, createParam(WC, WC));
        ctlLinearLayout.addView(textUrl, createParam(FP, WC));

/*
        webview = new WebView(this);
        //webview.loadUrl("http://www.yahoo.co.jp/");
        webview.loadUrl("https://www.data.jma.go.jp/fcd/yoho/data/jishin/kaisetsu_tanki_latest.pdf");
*/

        //       You can use Google PDF Viewer to read your pdf online:
/*
        //WebView webview = (WebView) findViewById(R.id.webview);
        webview = new WebView(this);
        webview.getSettings().setJavaScriptEnabled(true);
        String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        //webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
        webview.loadUrl("https://www.data.jma.go.jp/fcd/yoho/data/jishin/kaisetsu_tanki_latest.pdf");

 */

        webview = new WebView(this);
        String pdfUrl = "https://www.data.jma.go.jp/fcd/yoho/data/jishin/kaisetsu_tanki_latest.pdf";
        String url = "http://docs.google.com/gview?embedded=true&url=" + pdfUrl;
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);


        linearLayout.addView(ctlLinearLayout, createParam(FP, WC));
        linearLayout.addView(webview, createParam(WC, WC));
    }

    private LinearLayout.LayoutParams createParam(int w, int h){
        return new LinearLayout.LayoutParams(w, h);
    }

    public void onClick(View v) {
        SpannableStringBuilder url = (SpannableStringBuilder)textUrl.getText();
        webview.loadUrl(url.toString());
    }
}

/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

 */

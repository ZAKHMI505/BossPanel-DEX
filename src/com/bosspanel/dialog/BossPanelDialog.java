package com.bosspanel.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.util.Base64;
import java.nio.charset.StandardCharsets;

public final class BossPanelDialog {
    private BossPanelDialog() {}

    public static void show(final Activity activity) {
        if (activity == null || activity.isFinishing()) return;
        activity.runOnUiThread(new Runnable() {
            @Override public void run() {
                try {
                    final Dialog dialog = new Dialog(activity);
                    WebView web = new WebView(activity);
                    WebSettings settings = web.getSettings();
                    settings.setJavaScriptEnabled(true);
                    settings.setDomStorageEnabled(true);
                    settings.setLoadsImagesAutomatically(true);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setSupportMultipleWindows(false);
                    settings.setAllowFileAccess(false);
                    settings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
                    web.setWebChromeClient(new WebChromeClient());
                    web.setWebViewClient(new WebViewClient());
                    web.setBackgroundColor(Color.TRANSPARENT);

                    String html = new String(Base64.decode(HTML_B64, Base64.DEFAULT), StandardCharsets.UTF_8);
                    web.loadDataWithBaseURL("https://boss-panel.local/", html, "text/html", "UTF-8", null);

                    FrameLayout frame = new FrameLayout(activity);
                    frame.addView(web, new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(frame);
                    dialog.setCancelable(false);
                    dialog.setCanceledOnTouchOutside(false);
                    Window window = dialog.getWindow();
                    if (window != null) {
                        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                        window.setGravity(Gravity.CENTER);
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(Color.TRANSPARENT);
                        window.setNavigationBarColor(Color.TRANSPARENT);
                        if (Build.VERSION.SDK_INT >= 30) {
                            window.setDecorFitsSystemWindows(false);
                        }
                    }
                    dialog.show();
                    if (dialog.getWindow() != null) {
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                    }
                } catch (Throwable ignored) { }
            }
        });
    }

    // Replaced by scripts/embed_html.py during build.
    private static final String HTML_B64 = "HTML_B64_PLACEHOLDER";
}

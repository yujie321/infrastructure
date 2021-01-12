package com.example.infrastructure.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.toollib.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebSocketService extends Service {

    private final String TAG = WebSocketService.class.getSimpleName();

    private OkHttpClient CLIENT;
    private WebSocket mWebSocket;

    private static final String ID = "channel_1";
    private static final String NAME = "前台服务";
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(ID, NAME, NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(this, ID)
                    .build();
            startForeground(1, notification);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service.onStartCommand 启动");
        initOkHttpClient();
        connect("ws://116.63.53.193:88");
        return super.onStartCommand(intent, flags, startId);
    }

    private void  initOkHttpClient() {
        CLIENT = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    public void connect(String url) {
        if (mWebSocket != null) {
            mWebSocket.cancel();
        }
        Request request = new Request.Builder()
                .url(url)
                .build();
        mWebSocket = CLIENT.newWebSocket(request, new SocketListener());
    }

    public void sendMessage(String message) {
        mWebSocket.send(message);
    }

    public void sendMessage(byte... data) {
        ByteString bs = ByteString.of(data);
        mWebSocket.send(bs);
    }

    public void close(int code, String reason) {
        mWebSocket.close(code, reason);
    }

    class SocketListener extends WebSocketListener {

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
        }

        @Override
        public void onMessage(WebSocket webSocket, String msg) {
            super.onMessage(webSocket, msg);
            EventBus.getDefault().post(msg);
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            super.onMessage(webSocket, bytes);
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }
}
package com.example.sigmotoa.notificacion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.os.ParcelUuid;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int ID_MEN_BARRA_NOTIF=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void notificacion1(View v)
    {
        String mess=getResources().getString(R.string.mensaje01);

        Toast toast1=Toast.makeText(getApplicationContext(),
                mess,Toast.LENGTH_SHORT);

        toast1.show();
    }
    public void notificacion2(View v)
    {

        Toast toast1=Toast.makeText(getApplicationContext(),
                R.string.gravity,Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER|Gravity.RIGHT,0,0);

        toast1.show();;
    }
    public void notificacion3(View v)
    {

        Toast toast1= new Toast(getApplicationContext());
        LayoutInflater inflater=getLayoutInflater();

        View layout = inflater.inflate(R.layout.layout_toast,
                (ViewGroup)findViewById(R.id.layoutToast));

        TextView txtmsg = (TextView)layout.findViewById(R.id.mensajeLdl);
        txtmsg.setText(R.string.personal);
        toast1.setDuration(Toast.LENGTH_SHORT);
        toast1.setView(layout);

        toast1.show();;
    }
    public void notificacion4(View V)
    {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager notManager = (NotificationManager) getSystemService(ns);

        int icono= android.R.drawable.stat_sys_warning;
        CharSequence textoEstado =getResources().getString(R.string.atencion);
        CharSequence titulo =getResources().getString(R.string.personal);
        CharSequence descripcion=getResources().getString(R.string.ejemplo);
        long hora = System.currentTimeMillis();

        Context contexto = getApplicationContext();
        Intent notIntent = new Intent(contexto, MainActivity.class);

        PendingIntent contIntent=PendingIntent.getActivity(contexto,0,notIntent,0);

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this)
                .setAutoCancel(true)
                .setSmallIcon(icono)
                .setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.info)).getBitmap())
                .setContentTitle(titulo)
                .setContentText(descripcion)
                .setContentInfo(textoEstado)
                .setWhen(hora)
                .setContentIntent(contIntent)
                .setAutoCancel(true)
                .setColor(getResources().getColor(R.color.colorPrimaryDark))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

                notManager.notify(ID_MEN_BARRA_NOTIF,mBuilder.build());




    }




}

package fr.formation.toastdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tools  {
    private static int noNotif=0;

    public static void affToast(Activity act,String msg){
      //acceder au gonfleur d'ecran
        LayoutInflater inflater = act.getLayoutInflater();
        View v = inflater.inflate(R.layout.toast, (ViewGroup) act.findViewById(R.id.llToast));
        //Definir le texte à afficher
        TextView etToast = v.findViewById(R.id.tvToast);
        etToast.setText(msg);


        //creer le toast
        Toast toast = Toast.makeText(act,msg,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.START, 0, 0);
        toast.setView(v);
        toast.show();


    }
    public static Integer affNotif(Context ctxt , String titre,String msg) {

        NotificationManager manager = (NotificationManager) ctxt.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder;
        if(Build.VERSION.SDK_INT>=26) {
            builder = new Notification.Builder(ctxt, "CH");
        }
        else{
            builder = new Notification.Builder(ctxt);}

            builder.setContentTitle(titre);
            builder.setContentText((msg));
            builder.setSmallIcon(R.mipmap.notification);
            if(Build.VERSION.SDK_INT>=26){
                NotificationChannel channel= new NotificationChannel("CH","Channel",NotificationManager.IMPORTANCE_DEFAULT);
               manager.createNotificationChannel(channel);
                builder.setChannelId("CH");

            }
            noNotif++;

            Notification notif = builder.build();
            manager.notify(noNotif,notif);
                 return noNotif;

    }



}

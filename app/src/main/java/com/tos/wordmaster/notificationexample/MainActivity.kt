package com.tos.wordmaster.notificationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.tos.wordmaster.notificationexample.Notification.Configaration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            Log.e("Tag",it.token)
        }

        FirebaseMessaging.getInstance().subscribeToTopic(Configaration.TOPIC_GLOBAL)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Log.e("Tag","Subscribe Success")
                }else{
                    Log.e("Tag","Subscribe failed")
                }
            }
    }
}

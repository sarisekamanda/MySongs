package com.example.sarise.mysongs

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val channelId = "com.example.sarise.mysongs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var songs = arrayOf("C.S. Lewis Song", "Shoulders", "Second Chances")

        var adapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, songs)

        sSongs.adapter = adapter

        sSongs.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

                imgCover.visibility = View.GONE
                txtLyrics.text = ""
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val selectedItem = parent?.getItemAtPosition(position).toString()

                when(position){

                    0-> {
                        txtLyrics.text = (selectedItem + "\nIf I find in myself\n" +
                                "Desires nothing in this world can satisfy\n" +
                                "I can only conclude\n" +
                                "That I, I was not made for here\n" +
                                "If the flesh that I fight is at best\n" +
                                "Only light and momentary\n" +
                                "Then of course I'll feel nude\n" +
                                "When to where I'm destined I'm compared\n" +
                                "\n" +
                                "Speak to me in the light of the dawn\n" +
                                "Mercy comes with the morning\n" +
                                "I will sigh and with all creation groan\n" +
                                "As I wait for hope to come for me\n" +
                                "\n" +
                                "Am I lost or just less found?\n" +
                                "On the straight or on the roundabout\n" +
                                "Of the wrong way?\n" +
                                "Is this a soul that stirs in me\n" +
                                "Is it breaking free, wanting to come alive?\n" +
                                "'Cos my comfort would prefer for me to be numb\n" +
                                "And avoid the impending birth\n" +
                                "Of who I was born to become\n" +
                                "\n" +
                                "Speak to me in the light of the dawn\n" +
                                "Mercy comes with the morning\n" +
                                "I will sigh and with all creation groan\n" +
                                "As I wait for hope to come for me\n" +
                                "\n" +
                                "For we, we are not long here\n" +
                                "Our time is but a breath\n" +
                                "So we better breathe it\n" +
                                "And I, I was made to live\n" +
                                "I was made to love\n" +
                                "I was made to know you\n" +
                                "Hope is coming for me\n" +
                                "Hope is coming for me\n" +
                                "Hope is coming for me\n" +
                                "Hope, He's coming\n" +
                                "\n" +
                                "Speak to me in the light of the dawn\n" +
                                "Mercy comes with the morning\n" +
                                "I will sigh and with all creation groan\n" +
                                "As I wait for hope to come for me\n" +
                                "For me, for me, for me")

                        imgCover.visibility = View.VISIBLE
                        imgCover.setImageResource(R.drawable.bf)
                        notificao()
                    }

                    1-> {
                        txtLyrics.text = (selectedItem + "\n\n" +
                                "Keep on tryin’\n" +
                                "By the sweat of my brow\n" +
                                "Keep on tryin’\n" +
                                "But tell me where am I now?\n" +
                                "Its all breaking\n" +
                                "Who I wanted to be\n" +
                                "I’ve been emptied\n" +
                                "Of what never came\n" +
                                "\n" +
                                "Never gonna give up\n" +
                                "Never gonna stop it\n" +
                                "I may look done for, but I’m not even close\n" +
                                "I’m sittin’ on shoulders not my own\n" +
                                "Its obvious I'm not alone\n" +
                                "\n" +
                                "Keep on tryin’\n" +
                                "By the sweat of my brow\n" +
                                "Keep on tryin’\n" +
                                "But I keep falling right down\n" +
                                "Then you tell me\n" +
                                "That I’ve got all that I need\n" +
                                "So whisper to me, and I’ll shake off what I’ve seen\n" +
                                "\n" +
                                "If you're tired and you are weak then He says come, then He says\n" +
                                "If you’ve got nothing left to hope then He says come then He says")

                        imgCover.visibility = View.VISIBLE
                        imgCover.setImageResource(R.drawable.ta)
                        notificao()
                    }

                    2 -> {
                        txtLyrics.text = (selectedItem + "\nMy future hangs on this\n" +
                                "You make preciousness from dust\n" +
                                "Please don't\n" +
                                "Stop creating me\n" +
                                "\n" +
                                "Your blood offers the chance\n" +
                                "To rewind to innocence\n" +
                                "Reborn\n" +
                                "Perfect as a child\n" +
                                "\n" +
                                "Oh Your cross it changes everything\n" +
                                "There my world begins again with You\n" +
                                "Oh Your cross it's where my hope restarts\n" +
                                "A second chance is Heaven's heart\n" +
                                "\n" +
                                "When sin and ugliness\n" +
                                "Collide with redemption's kiss\n" +
                                "Beauty\n" +
                                "Awakens by romance\n" +
                                "\n" +
                                "Always inside this mess\n" +
                                "I have found forgiveness\n" +
                                "Mercy\n" +
                                "As infinite as You\n" +
                                "\n" +
                                "Countless second chances\n" +
                                "We've been given at the cross\n" +
                                "\n" +
                                "Fragments of brokenness\n" +
                                "Salvaged by the art of grace\n" +
                                "You craft\n" +
                                "Life from our mistakes\n" +
                                "\n" +
                                "Black skies of my regrets\n" +
                                "Outshone by this kindness\n" +
                                "New life\n" +
                                "Dawns over my soul")

                        imgCover.visibility = View.VISIBLE
                        imgCover.setImageResource(R.drawable.rc)
                        notificao()
                    }
                }

            }

        }

    }

    fun notificao(){

        val pendingIntent = PendingIntent.getActivity(this,0,intent,0)

        val mNotification = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Notification.Builder(this, channelId)
        }else{
            Notification.Builder(this)
        }.apply {
            setContentIntent(pendingIntent)
            setSmallIcon(R.drawable.m)
            setAutoCancel(true)
            setContentTitle(sSongs.selectedItem.toString())
            setContentText("MESSAGE")
        }.build()
        val mNotificationId: Int =1000
        val nManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.notify(mNotificationId,mNotification)


        /*@mipmap/ic_launcher*/

    }

}

package me.fahmisdk6.avatarviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.fahmisdk6.avatarview.AvatarView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AvatarView avatarView = (AvatarView) findViewById(R.id.avatar_user);
        avatarView.bind("Fahmi Sidik", "https://avatars2.githubusercontent.com/u/10940190?v=3&s=460");
    }
}

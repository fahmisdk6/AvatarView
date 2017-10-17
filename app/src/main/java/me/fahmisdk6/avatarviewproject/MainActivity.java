package me.fahmisdk6.avatarviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.hdodenhof.circleimageview.CircleImageView;
import me.fahmisdk6.avatarview.AvatarView;
import me.fahmisdk6.avatarview.CircleAvatarView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AvatarView avatarView = (AvatarView) findViewById(R.id.avatar_user1);
        avatarView.bind("Fahmi Sidik", "https://avatars2.githubusercontent.com/u/10940190?v=3&s=460");

        AvatarView avatarView2 = (AvatarView) findViewById(R.id.avatar_user2);
        avatarView2.bind("Fahmi Sidik", null);

        AvatarView avatarView3 = (AvatarView) findViewById(R.id.avatar_user3);
        avatarView3.bind("Fahmi Sidik", "https://avatars2.githubusercontent.com/u/10940190?v=3&s=460");

        AvatarView avatarView4 = (AvatarView) findViewById(R.id.avatar_user4);
        avatarView4.bind("Fahmi Sidik", null);

        AvatarView avatarView5 = (AvatarView) findViewById(R.id.avatar_user5);
        avatarView5.bind("Fahmi Sidik", null);

        CircleAvatarView avatarView6 = (CircleAvatarView) findViewById(R.id.avatar_user6);
        avatarView6.bind("Fahmi Sidik", null);

    }
}

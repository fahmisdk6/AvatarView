# AvatarView
Custom view to handle whether we should show avatar image or just initial of username. 
Inspired by Daniel Lew's Talk on Goto; Conference https://www.youtube.com/watch?v=X4qMBpDsVnM with other support such as custom font and custom corner radius

![alt tag](../preview.png)


## Setup

on your module's `build.gradle` file :
```
repositories {
    //other repo here


    maven {
        url 'https://dl.bintray.com/fahmisdk6/maven'
    }
}


dependencies {
  //other library here


    compile ('me.fahmisdk6.avatarview:avatarview:1.0@aar'){
        transitive = true
    }
}
```


## Implementation

on your XML :

```
        <me.fahmisdk6.avatarview.AvatarView
            android:id="@+id/avatar_user5"
            android:layout_width="48dp"
            android:layout_height="48dp"
            app:avCornerRadius="8dp"
            app:avBgTextColor="@color/colorAccent"
            app:avTextColor="@color/colorPrimary"
            app:avTextSize="10sp"
            app:avFont="font/avenir_black.ttf"/>


```

On your java 
```
AvatarView avatarView5 = (AvatarView) findViewById(R.id.avatar_user5);
avatarView5.bind("Fahmi Sidik", "https://avatars2.githubusercontent.com/u/10940190?v=3&s=460");
```


## Example 

Example are available on `app` module






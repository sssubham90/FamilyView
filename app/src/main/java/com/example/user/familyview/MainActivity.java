package com.example.user.familyview;

import android.app.ListActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity
{

    String[] name =
    {
            "Adhir Kumar Mohapatra",
            "Sandhya Rani Mohapatra",
            "Sweta",
            "Suchismita Pradhan",

    };
    String[] relation =
    {
            "Father",
            "Mother",
            "Complicated",
            "Cousin Sister"
    };

    Integer[] imageIDs =
    {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FamilyViewer adapter =new FamilyViewer(this, name, relation, imageIDs);
        setListAdapter(adapter);

    }


}

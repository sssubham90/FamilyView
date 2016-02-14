package com.example.user.familyview;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FamilyViewer extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] name;
    private final String[] relation;
    private final Integer[] imageIds;

    public FamilyViewer (Activity context, String[] name, String[] relation, Integer[] imageIds)
    {
        super(context, R.layout.lvrowlayout2, name);
        this.context = context;
        this.name = name;
        this.relation = relation;
        this.imageIds = imageIds;
    }

    static class ViewContainer
    {
        public ImageView imageView;
        public TextView txtName;
        public TextView txtRelation;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        ViewContainer viewContainer;
        View rowView = view;
        Log.d("FamilyViewer",String.valueOf(position));
        if (rowView == null)
        {
            Log.d("FamilyViewer", "New");
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.lvrowlayout2, null, true);
            viewContainer = new ViewContainer();
            viewContainer.txtName = (TextView)
                    rowView.findViewById(R.id.txtName);
            viewContainer.txtRelation = (TextView)
                    rowView.findViewById(R.id.txtRelation);
            viewContainer.imageView = (ImageView) rowView.findViewById(R.id.icon);
            rowView.setTag(viewContainer);
        }
        else
        {
            Log.d("FamilyViewer", "Recycling");
            viewContainer = (ViewContainer) rowView.getTag();
        }
        viewContainer.txtName.setText(name[position]);
        viewContainer.txtRelation.setText(relation[position]);
        viewContainer.imageView.setImageResource(imageIds[position]);
        return rowView;
    }
}

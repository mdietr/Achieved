package ca.mdietr.achieved.achievements;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ca.mdietr.achieved.R;
import ca.mdietr.achieved.database.DatabaseContract;

/**
 * Cursor adapter for a list of achievements
 * Created by Matt on 2016-02-11.
 */
public class AchievementsCursorAdapter  extends CursorAdapter {
    public AchievementsCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_achievement, parent, false);
    }

    /**
     * Bind data to the view
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Retrieve fields to populate in inflated template
        TextView txtAchievement = (TextView) view.findViewById(R.id.txt_achievement);
        TextView txtDate = (TextView) view.findViewById(R.id.txt_achievement_date);
        // Retrieve data from cursor
        String achievement = cursor.getString(cursor.getColumnIndex(DatabaseContract.GoalSchema.COLUMN_NAME_TEXT));
        String date = cursor.getString(cursor.getColumnIndex(DatabaseContract.GoalSchema.COLUMN_NAME_DATE));
        // Populate views with data
        txtAchievement.setText(achievement);
        txtDate.setText(date);
    }
}

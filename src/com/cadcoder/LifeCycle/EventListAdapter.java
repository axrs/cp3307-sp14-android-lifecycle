package com.cadcoder.LifeCycle;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xander on 8/04/2014.
 */
public class EventListAdapter extends BaseAdapter {

    private Context _context;
    private List<EventRecord> _records;

    public EventListAdapter(Context context) {
        _context = context;
    }

    private List<EventRecord> getRecords() {
        if (_records == null) {
            _records = new ArrayList<EventRecord>();
        }
        return _records;
    }

    public void addEvent(EventRecord record) {
        getRecords().add(record);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return getRecords().size();
    }

    @Override
    public Object getItem(int i) {
        return getRecords().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) _context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.partial_event_detail, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView created = (TextView) convertView.findViewById(R.id.time);

        EventRecord model = (EventRecord) getItem(position);

        title.setText(model.getMessage());
        created.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(model.getTime()));
        return convertView;
    }
}

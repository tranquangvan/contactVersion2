package com.example.contactversion2.Database;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.contactversion2.Contact;
import com.example.contactversion2.R;
import java.util.ArrayList;


public class Controller extends BaseAdapter {
    private ArrayList<Contact> contactArrayList;
    private Context context;
    public Controller(Context context, ArrayList<Contact> contactArrayList) {
        this.context = context;
        this.contactArrayList = contactArrayList;
    }
    @Override
    public int getCount() {
        return contactArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return contactArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_element, null, true);

            holder.tvName =  convertView.findViewById(R.id.name);
            holder.tvNumberPhone =  convertView.findViewById(R.id.numberPhone);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tvName.setText("Name: "+ contactArrayList.get(position).getName());
        holder.tvNumberPhone.setText("NumberPhone: "+ contactArrayList.get(position).getNumberPhone());
        return convertView;
    }
    private class ViewHolder {
        protected TextView tvName, tvNumberPhone;
    }
}

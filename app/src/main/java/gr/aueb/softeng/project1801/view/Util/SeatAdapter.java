package gr.aueb.softeng.project1801.view.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.DomainModel.Route;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.view.R;

public class SeatAdapter extends BaseAdapter {

    private Context Context;
    private Route selectedRoute;
    private int totalSeats;
    private List<Integer> dataList,copyOfData;
    private LayoutInflater inflater;

    public SeatAdapter(Context context,Route selectedRoute){
        this.Context = context;
        this.selectedRoute = selectedRoute;
        totalSeats = selectedRoute.getAvailableSeats();
        dataList = new ArrayList<>();
        copyOfData = new ArrayList<>();
        inflater = (LayoutInflater) context.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getTotalSeats(){
        return totalSeats;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int seat = dataList.get(position);
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(Context);
            convertView = layoutInflater.inflate(R.layout.custom_seat, null);
        }

        ((ImageView)convertView.findViewById(R.id.seat_image)).setImageResource(R.drawable.ic_airline_seat_recline_extra_black_24dp);
        ((TextView) convertView.findViewById(R.id.num_seat)).setText(String.valueOf(seat));

        return convertView;
    }

    public void loadData(List<Integer> data){
        this.dataList = data;
        this.copyOfData = dataList.subList(0,dataList.size());
        notifyDataSetChanged();
    }

}

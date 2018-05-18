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
import gr.aueb.softeng.project1801.SysUtils.SeatRow;
import gr.aueb.softeng.project1801.view.R;

public class SeatAdapter extends BaseAdapter {

    private Context Context;
    private List<SeatRow> dataList,copyOfData;
    private LayoutInflater inflater;

    /**
     *
     * @param context, the Context that concerns the specific activity
     */
    public SeatAdapter(Context context){
        this.Context = context;
        dataList = new ArrayList<>();
        copyOfData = new ArrayList<>();
        inflater = (LayoutInflater) context.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * This method returns the number of the objects inside the list
     * @return the number of the objects
     */
    @Override
    public int getCount() {
        return dataList.size();
    }

    /**
     * This method returns an object taking into consideration it's position inside the list.
     * @param position, the position of the object
     * @return the object
     */
    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    /**
     * This method returns the code of an object taking into consideration it's position inside the list.
     * @param position, the position of the object
     * @return the code of the object
     */
    @Override
    public long getItemId(int position){
        return position;
    }

    /**
     * This method returns the view taking into consideration the position of the object.
     * @param position, the position of the object
     * @param convertView, does not have any use
     * @param parent, the parent of the view
     * @return the view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SeatRow seat = dataList.get(position);
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(Context);
            convertView = layoutInflater.inflate(R.layout.custom_seat, null);
        }

        ((ImageView)convertView.findViewById(R.id.seat_image)).setImageResource(R.drawable.ic_airline_seat_recline_extra_black_24dp);
        if(seat.getText().equals("T")){
            ((TextView) convertView.findViewById(R.id.num_seat)).setText("T");
        }else if(seat.isChecked()){
            ((TextView) convertView.findViewById(R.id.num_seat)).setText("x");
        }else{
            ((TextView) convertView.findViewById(R.id.num_seat)).setText(String.valueOf(seat.getNum()));
        }

        return convertView;
    }

    /**
     * This method loads the data(from the list).It uses a copy of the list and not the original in order to be able to filter our search without any data loss.
     * @param data, the list with the data
     */
    public void loadData(List<SeatRow> data){
        this.dataList = data;
        this.copyOfData = dataList.subList(0,dataList.size());
        notifyDataSetChanged();
    }

}

package gr.aueb.softeng.project1801.view.Util;


import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.Route;
import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.view.R;


public class CustomAdapter extends BaseAdapter implements Filterable{

    private Context context;
    private LayoutInflater inflater;
    private List<DataRow> dataList,copyOfData;
    private SearchFilter searchFilter = new SearchFilter();

    public CustomAdapter(Context context){
        this.context = context;
        dataList = new ArrayList<>();
        copyOfData = new ArrayList<>();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return dataList.size();
    }

    @Override
    public Object getItem(int position){
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        DataRow data = (DataRow) getItem(position);

        View customView = inflater.inflate(R.layout.custom_row,parent,false);

        ((TextView) customView.findViewById(R.id.first)).setText(data.getData1());
        ((TextView) customView.findViewById(R.id.second)).setText(data.getData2());
        String text;
        if(data.getData4() == null){
            text = data.getData3();
        }else{
            text = data.getData3()+"-"+data.getData4();
        }

        ((TextView) customView.findViewById(R.id.identity)).setText(text);
        ((TextView) customView.findViewById(R.id.details)).setText("->");

        return customView;
    }

    //Εχουμε ενα αντιγραφο της λιστας ετσι ωστε οταν κανουμε αναζητηση να φιλτραρουμε το αντιγραγο
    //και οχι το original.
    public void loadData(List<DataRow> data){
        this.dataList = data;
        this.copyOfData = dataList.subList(0,dataList.size());
        notifyDataSetChanged();
    }


    @Override
    public Filter getFilter(){
        return searchFilter;
    }



    public class SearchFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String searchString = constraint.toString().toLowerCase();
            FilterResults searchResults = new FilterResults();
            List<DataRow> results = new ArrayList<>();

            for(DataRow row : copyOfData){
                if(row.getData4() != null){
                    if(row.getData1().toLowerCase().contains(searchString) || row.getData2().toLowerCase().contains(searchString)
                            || row.getData3().toLowerCase().contains(searchString) || row.getData4().toLowerCase().contains(searchString)){
                        results.add(row);
                    }
                }else{
                    if(row.getData1().toLowerCase().contains(searchString) || row.getData2().toLowerCase().contains(searchString)
                            || row.getData3().toLowerCase().contains(searchString)){
                        results.add(row);
                    }
                }
            }

            searchResults.values = results;
            searchResults.count = results.size();

            return searchResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataList = (List<DataRow>)results.values;
            notifyDataSetChanged();
        }
    }

}

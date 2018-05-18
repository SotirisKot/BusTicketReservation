package gr.aueb.softeng.project1801.view.Util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.project1801.SysUtils.DataRow;
import gr.aueb.softeng.project1801.view.R;


public class CustomAdapter extends BaseAdapter implements Filterable{

    private Context context;
    private LayoutInflater inflater;
    private List<DataRow> dataList,copyOfData;
    private SearchFilter searchFilter = new SearchFilter();

    /**
     *
     * @param context , the Context that concerns the specific activity
     */
    public CustomAdapter(Context context){
        this.context = context;
        dataList = new ArrayList<>();
        copyOfData = new ArrayList<>();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * This method returns the number of the objects inside the list
     * @return the number of the objects
     */
    @Override
    public int getCount(){
        return dataList.size();
    }

    /**
     * This method returns an object taking into consideration it's position inside the list.
     * @param position , the position of the object
     * @return the object
     */
    @Override
    public Object getItem(int position){
        return dataList.get(position);
    }

    /**
     * This method returns the code of an object taking into consideration it's position inside the list.
     * @param position , the position of the object
     * @return the code of the object
     */
    @Override
    public long getItemId(int position){
        return position;
    }

    /**
     * This method returns the view taking into consideration the position of the object.
     * @param position , the position of the object
     * @param convertView , does not have any use
     * @param parent , the parent of the view
     * @return the view
     */
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

    /**
     * This method loads the data(from the list).It uses a copy of the list and not the original in order to be able to filter our search without any data loss.
     * @param data , the list with the data
     */
    public void loadData(List<DataRow> data){
        this.dataList = data;
        this.copyOfData = dataList.subList(0,dataList.size());
        notifyDataSetChanged();
    }


    /**
     * This method return the filter.
     * @return the filter
     */
    @Override
    public Filter getFilter(){
        return searchFilter;
    }


    /**
     * This class extends the filter.
     */
    public class SearchFilter extends Filter{

        /**
         * This method filters the results.
         * @param constraint , the String of the restriction
         * @return the filtered results
         */
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

        /**
         * This method publishes the filtered results.
         * @param constraint , the String of the restriction
         * @param results , the results
         */
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataList = (List<DataRow>)results.values;
            notifyDataSetChanged();
        }
    }

}

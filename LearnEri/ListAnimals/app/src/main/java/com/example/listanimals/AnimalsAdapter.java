package com.example.listanimals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimalsAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Animals> animalsList;

    public AnimalsAdapter(Context context, int layout, List<Animals> animalsList) {
        this.context = context;
        this.layout = layout;
        this.animalsList = animalsList;
    }

    @Override
    public int getCount() {
        return animalsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // ListView (ViewHolder)
    public class ViewHolder {
        TextView tvTenDongVat, tvTuoiDongVat;
        ImageView imgAnimals;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();

            // Ánh xạ
            viewHolder.tvTenDongVat = (TextView) view.findViewById(R.id.tenDongVat);
            viewHolder.tvTuoiDongVat = (TextView) view.findViewById(R.id.tuoiDongVat);
            viewHolder.imgAnimals = (ImageView) view.findViewById(R.id.imgAnimals);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Gán giá trị
        viewHolder.tvTenDongVat.setText("Loài: " + animalsList.get(i).tenDongVat);
        viewHolder.tvTuoiDongVat.setText("Tuổi thọ: " + animalsList.get(i).tuoiDongVat);
        viewHolder.imgAnimals.setImageResource(animalsList.get(i).hinhAnh);
        return view;
    }
}

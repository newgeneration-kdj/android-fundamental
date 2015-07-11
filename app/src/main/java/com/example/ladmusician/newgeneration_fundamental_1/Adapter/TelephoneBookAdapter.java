package com.example.ladmusician.newgeneration_fundamental_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ladmusician.newgeneration_fundamental_1.DTO.TelephoneDTO;
import com.example.ladmusician.newgeneration_fundamental_1.R;

import java.util.ArrayList;

/**
 * Created by ladmusician on 15. 7. 11..
 */
public class TelephoneBookAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<TelephoneDTO> mTelephones;
    private LayoutInflater inflater = null;

    public TelephoneBookAdapter(Context ctx, ArrayList<TelephoneDTO> items) {
        mContext = ctx;
        mTelephones = items;
        this.inflater = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_item, null);

            viewHolder.mTxtName = (TextView) convertView.findViewById(R.id.txt_telephone_name);
            viewHolder.mTxtPhone = (TextView) convertView.findViewById(R.id.txt_telephone_phone);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.mTxtName.setText(getItem(position).getName());
        viewHolder.mTxtPhone.setText(getItem(position).getPhoneNm());

        return convertView;
    }

    @Override
    public TelephoneDTO getItem(int position) {
        return mTelephones.get(position);
    }

    @Override
    public int getCount() {
        return mTelephones.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        public TextView mTxtName;
        public TextView mTxtPhone;
    }
}

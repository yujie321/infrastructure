package com.example.infrastructure.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.infrastructure.R;
import com.example.infrastructure.data.SectionHeader;
import com.example.infrastructure.data.SectionItem;
import com.example.infrastructure.weight.QDLoadingItemView;
import com.qmuiteam.qmui.widget.section.QMUIDefaultStickySectionAdapter;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;

/**
 * @author Administrator
 * @date 2019/11/8 0008
 */
public class QDListSectionAdapter extends QMUIDefaultStickySectionAdapter<SectionHeader, SectionItem> {

    private Context mContext;

    @NonNull
    @Override
    protected QMUIStickySectionAdapter.ViewHolder onCreateSectionHeaderViewHolder(@NonNull ViewGroup viewGroup) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_section_header , null);
        return new ViewHolder(view);
    }

    @NonNull
    @Override
    protected ViewHolder onCreateSectionItemViewHolder(@NonNull ViewGroup viewGroup) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_section , null);
        return new ViewHolder(view);
    }

    @NonNull
    @Override
    protected ViewHolder onCreateSectionLoadingViewHolder(@NonNull ViewGroup viewGroup) {
        return new ViewHolder(new QDLoadingItemView(viewGroup.getContext()));
    }

    @Override
    protected void onBindSectionHeader(final ViewHolder holder, final int position, QMUISection<SectionHeader, SectionItem> section) {
        TextView tvItemListSectionHeader = holder.itemView.findViewById(R.id.tvItemListSectionHeader);
        tvItemListSectionHeader.setText(section.getHeader().getText());
        ImageView ivArrowView = holder.itemView.findViewById(R.id.ivArrowView);
        ivArrowView.setRotation(section.isFold() ? 90f : 180f);
        ivArrowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.isForStickyHeader ? position : holder.getAdapterPosition();
                toggleFold(pos, false);
            }
        });
    }

    @Override
    protected void onBindSectionItem(ViewHolder holder, int position, QMUISection<SectionHeader, SectionItem> section, int itemIndex) {
        TextView tvListSectionText = holder.itemView.findViewById(R.id.tvListSectionText);
        tvListSectionText.setText(section.getItemAt(itemIndex).getText());
    }

}

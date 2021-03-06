package com.galou.mynews.searchNotification;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.EditText;

import com.galou.mynews.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by galou on 2019-03-21
 */
public abstract class BaseView extends Fragment{

    // views
    @BindView(R.id.query_term) EditText userTerm;
    @BindView(R.id.search_item_art) CheckBox boxArts;
    @BindView(R.id.search_item_business) CheckBox boxBusiness;
    @BindView(R.id.search_item_entrepreneurs) CheckBox boxEntrepreneurs;
    @BindView(R.id.search_item_politics) CheckBox boxPolitics;
    @BindView(R.id.search_item_sport) CheckBox boxSport;
    @BindView(R.id.search_item_travel) CheckBox boxTravel;
    @BindView(R.id.query_term_input_layout) TextInputLayout queryTermInputLayout;
    @BindView(R.id.query_sections_input_layout) TextInputLayout querySectionInputLayout;


    //data
    protected String queryTerms;
    protected List<String> querySections;

    protected BaseView(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    // --------------
    // SET DATA
    // --------------

    protected void setQueryTerm(){
        queryTerms = userTerm.getText().toString();
    }

    protected void setQuerySections(){
        this.querySections = new ArrayList<>();
        if(this.boxArts.isChecked()){
            querySections.add("Arts");
        }
        if(this.boxBusiness.isChecked()){
            querySections.add("Business");
        }
        if(this.boxEntrepreneurs.isChecked()){
            querySections.add("Entrepreneurs");
        }
        if(this.boxPolitics.isChecked()){
            querySections.add("Politics");
        }
        if(this.boxSport.isChecked()){
            querySections.add("Sports");
        }
        if(this.boxTravel.isChecked()){
            querySections.add("Travel");
        }

    }



}

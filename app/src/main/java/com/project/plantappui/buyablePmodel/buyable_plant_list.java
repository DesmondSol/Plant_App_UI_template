package com.project.plantappui.buyablePmodel;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.plantappui.R;
import com.project.plantappui.adapter.GroupAdapter;
import com.project.plantappui.model.Group;
import com.project.plantappui.model.Plant;

import java.util.ArrayList;

public class buyable_plant_list extends Fragment {

    //private BuyablePlantListViewModel mViewModel;
    private Context mContext;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private GroupAdapter groupAdapter;
    private ArrayList<Group> groups;
    private ArrayList<Plant> All_plants;
    private ArrayList<Plant> recommended;
    public static buyable_plant_list newInstance() {
        return new buyable_plant_list();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buyable_plant_list_fragment, container, false);
    }

    // edit start


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapterType(view);
        setAdapter();
    }

    private void initGroupData() {
        groups = new ArrayList<>();
        groups.add(new Group("Recommended", "More"));
        groups.add(new Group("All Plants", "More")); //featured plants changed to all plants
    }

    private void initPlantData() {
        All_plants = new ArrayList<>();// featured to all is changed
        recommended     = new ArrayList<>();

        All_plants.add(new Plant("Colorado Columbines", "Indonesia", "$300", R.drawable.bottom_img_1));
        All_plants.add(new Plant("Common Mallows", "Russia", "$200", R.drawable.bottom_img_1));
        All_plants.add(new Plant("Cherry Blossom", "Italy", "$100", R.drawable.bottom_img_1));

        recommended.add(new Plant("Aquilegia", "Indonesia", "$600", R.drawable.image_1));
        recommended.add(new Plant("Angelica", "Russia", "$500", R.drawable.image_2));
        recommended.add(new Plant("Camellia", "Italy", "$400", R.drawable.image_3));
        recommended.add(new Plant("Narcissa", "France", "$300", R.drawable.image_1));
        recommended.add(new Plant("Orchid", "China", "$200", R.drawable.image_2));
        recommended.add(new Plant("Lily", "America", "$100", R.drawable.image_3));
    }

    private void setAdapterType(View view) {
        recyclerView    = view.findViewById(R.id.recyclerView);
        layoutManager   = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setAdapter() {
        initGroupData();
        initPlantData();
        //todo 1. Add the new object to the parameter list.
        groupAdapter = new GroupAdapter(mContext, groups, All_plants, recommended);
        recyclerView.setAdapter(groupAdapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(BuyablePlantListViewModel.class);
//        // TODO: Use the ViewModel
//    }

}
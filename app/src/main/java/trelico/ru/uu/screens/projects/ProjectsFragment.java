package trelico.ru.uu.screens.projects;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import trelico.ru.uu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsFragment extends Fragment implements IProjectsFragment{


    public ProjectsFragment(){
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

}

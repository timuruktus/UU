package trelico.ru.uu.screens.main;

import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import trelico.ru.uu.MyApp;
import trelico.ru.uu.R;

public class MainActivity extends MvpAppCompatActivity implements IMainActivity{

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item -> {
        switch(item.getItemId()){
            case R.id.nav_list_projects:
                MyApp.INSTANCE.getNavigationHost().navigate(R.id.projectsFragment);
                bottomNavigationView.setVisibility(View.VISIBLE);
                return true;
//            case R.id.navigation_projects:
//                MyApplication.INSTANCE.getNavigationHost().navigate(R.id.projectsFragment);
//                return true;
//            case R.id.navigation_settings:
//
//                return true;
//            case R.id.navigation_calendar:
//
//                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        MyApp.INSTANCE.setNavigationHost(
                Navigation.findNavController(this, R.id.nav_host_fragment));
        MyApp.INSTANCE.getNavigationHost()
                .addOnDestinationChangedListener(getDestinationChangedListener());
    }


    NavController.OnDestinationChangedListener getDestinationChangedListener(){
        return (controller, destination, arguments) -> {
            if(destination.getId() == R.id.loginFragment){
                bottomNavigationView.setVisibility(View.GONE);
            }
            if(destination.getId() == R.id.nav_list_news){
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        };
    }

    @Override
    public void onBackPressed(){
        FragmentManager fm = getSupportFragmentManager();
        List<OnBackPressedCallback> supportedFragments = new ArrayList<>();
        for(Fragment fragment : fm.getFragments()){
            if(fragment instanceof OnBackPressedCallback){
                supportedFragments.add((OnBackPressedCallback) fragment);
            }
        }
        if(supportedFragments.size() != 0){
            boolean handled = supportedFragments.get(supportedFragments.size() - 1)
                    .handleOnBackPressed();
            if(!handled){
                super.onBackPressed();
            }
        } else{
            super.onBackPressed();
        }
    }
}

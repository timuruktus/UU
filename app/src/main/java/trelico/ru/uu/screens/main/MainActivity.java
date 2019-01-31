package trelico.ru.uu.screens.main;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import trelico.ru.uu.MyApp;
import trelico.ru.uu.R;
import trelico.ru.uu.utils.view_presenter.VPStorage;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item -> {
//        switch(item.getItemId()){
//            case R.id.navigation_news:
//                MyApp.INSTANCE.getNavigationHost().navigate(R.id.loginFragment);
//                return true;
//            case R.id.navigation_projects:
//                MyApplication.INSTANCE.getNavigationHost().navigate(R.id.projectsFragment);
//                return true;
//            case R.id.navigation_settings:
//
//                return true;
//            case R.id.navigation_calendar:
//
//                return true;
//        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        MyApp.INSTANCE.getAppComponent().inject(this);
        VPStorage.addPresenterToView(mainPresenter, this);
        MyApp.INSTANCE.setNavigationHost(Navigation.findNavController(this, R.id.nav_host_fragment));
    }
}

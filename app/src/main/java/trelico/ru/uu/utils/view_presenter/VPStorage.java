package trelico.ru.uu.utils.view_presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class VPStorage{


    private static HashMap<IPresenter, ArrayList<IView>> viewPresenterMap;

    public VPStorage(){
        viewPresenterMap = new HashMap<>();
    }

    /**
     * This method should be invoked from views
     * @param presenter - presenter, which associated with current view
     * @param view - view (fragment, activity, etc.)
     */
    public static void addPresenterToView(IPresenter presenter, IView view){
        ArrayList<IView> viewsList;
        if(!viewPresenterMap.containsKey(presenter) || viewPresenterMap.get(presenter) == null){
            viewsList = new ArrayList<>();
            viewsList.add(view);
            viewPresenterMap.put(presenter, viewsList);
        }else{
            viewsList = viewPresenterMap.get(presenter);
            if(!viewsList.contains(view)){
                viewsList.add(view);
            }else{
                Log.v(TAG, "presenter " + presenter + " already attached to view " + view);
            }
        }
        CommandExecutor.executeAllCommands(presenter);
    }

    public static void removeViewFromPresenter(IPresenter presenter, IView view){
        if(viewPresenterMap.get(presenter) != null){
            viewPresenterMap.get(presenter).remove(view);
        }
    }

    public static boolean hasPresenter(IPresenter presenter){
        return viewPresenterMap.containsKey(presenter);
    }

    public static ArrayList<IView> getPresenterViews(IPresenter presenter){
        return viewPresenterMap.get(presenter);
    }


}

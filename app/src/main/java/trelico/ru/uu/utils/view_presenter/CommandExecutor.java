package trelico.ru.uu.utils.view_presenter;

import android.util.Log;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Queue;

import androidx.annotation.NonNull;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CommandExecutor{

    private static HashMap<IPresenter, Queue<Command>> commandsQueue = new HashMap<>();

    public static void sendCommand(@NonNull Command command){
        commandsQueue.get(command.getPresenter()).add(command);
    }

    public static void executeAllCommands(IPresenter presenter){
        try{
            for(Command currentCommand : commandsQueue.get(presenter)){
                Strategy commandStrategy = currentCommand.getStrategy();
                if(commandStrategy == Strategy.EVERY_CREATION){
                    executeCommand(currentCommand);
                }else if(commandStrategy == Strategy.SINGLE){
                    executeCommand(currentCommand);
                    removeCommand(presenter, currentCommand);
                }
            }
        }catch(NoSuchElementException | NullPointerException ex){
            ex.printStackTrace();
            Log.v(TAG, "command queue to view is empty");
        }
    }

    public static void removeCommand(IPresenter presenter, Command command){
        Queue<Command> commands = commandsQueue.get(presenter);
        if(commands != null){
            commands.remove(command);
        }
    }

    public static void removeCommandByClass(IPresenter presenter, Command command){
        Queue<Command> commands = commandsQueue.get(presenter);
        String commandClassName = command.getClass().getSimpleName();
        if(commands != null){
            for(Command currentCommand : commands){
                String currentCommandClassName = currentCommand.getClass().getSimpleName();
                if(commandClassName.equals(currentCommandClassName)){
                    commands.remove(currentCommand);
                }
            }
        }
    }

    public static void sendCommand(IPresenter presenter, Command command){
        if(commandsQueue.get(presenter) != null){
            commandsQueue.get(presenter).add(command);
        }
    }

    private static void executeCommand(@NonNull Command command){
        ArrayList<IView> linkedViews = VPStorage.getPresenterViews(command.getPresenter());
        try{
            for(IView view : linkedViews){
                command.setView(view);
                command.use();
            }
        }catch(NullPointerException ex){
            ex.printStackTrace();
            Log.d(TAG, "There is no linked views to presenter " + command.getPresenter().getClass());
        }catch(Exception ex){
            ex.printStackTrace();
            Log.d(TAG, "Current IView not inherited by necessary class");
        }
    }



}

package ca.resulto.loyalaction.formationlayout;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;


public class TaskActivity extends ActionBarActivity {

    private ListView listViewTasks;
    private ArrayList<Task> tasks;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        listViewTasks = (ListView) findViewById(R.id.listview_tasks);

        tasks = createTasks();

        taskAdapter = new TaskAdapter(this,R.layout.row_task,tasks);

        listViewTasks.setAdapter(taskAdapter);

        listViewTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        taskAdapter.remove(taskAdapter.getItem(position));

                        taskAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                view.startAnimation(animation);



                return true;
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Task> createTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Feed the cat",Priority.MODERATE,15));
        tasks.add(new Task("Do the dishes",Priority.TRIVIAL,60));
        tasks.add(new Task("Play minecraft",Priority.MAJOR,60*4));
        tasks.add(new Task("Pay taxes",Priority.MAJOR,30));
        tasks.add(new Task("Switch on the light",Priority.MINOR,2));
        tasks.add(new Task("Feed myself",Priority.MODERATE,40));


        return tasks;
    }
}

package kennethford.simpletodo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTaskActivity extends AppCompatActivity {

    private static final String EXTRA_TASK_DESCRIPTION = "kennethford.simpletodo.task_description";
    private static final String EXTRA_TASK_INDEX = "kennethford.simpletodo.task_index";
    private static final String EXTRA_NEW_TASK_DESCRIPTION = "kennethford.simpletodo.new_task_description";

    private String taskDescription;
    private int taskIndex;

    private EditText editTaskDescription;
    private Button saveEditTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        getSupportActionBar().setTitle("Edit Item");

        taskDescription = getIntent().getStringExtra(EXTRA_TASK_DESCRIPTION);
        taskIndex = getIntent().getIntExtra(EXTRA_TASK_INDEX, 0);

        editTaskDescription = (EditText) findViewById(R.id.editTaskText);
        editTaskDescription.setText(taskDescription);

        saveEditTaskButton = (Button) findViewById(R.id.saveEditTaskButton);
        saveEditTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskDescription = editTaskDescription.getText().toString();
                setNewTaskDescription();
                finish();
            }
        });


    }

    public static Intent newIntent (Context packageContext, String taskDescription, int index) {
        Intent i = new Intent(packageContext, EditTaskActivity.class);
        i.putExtra(EXTRA_TASK_DESCRIPTION, taskDescription);
        i.putExtra(EXTRA_TASK_INDEX, index);
        return i;
    }

    private void setNewTaskDescription() {
        Intent data = new Intent();
        data.putExtra(EXTRA_NEW_TASK_DESCRIPTION, taskDescription);
        data.putExtra(EXTRA_TASK_INDEX, taskIndex);
        setResult(RESULT_OK, data);
    }

    public static String getNewTaskDescription(Intent data) {
        return data.getStringExtra(EXTRA_NEW_TASK_DESCRIPTION);
    }

    public static int getTaskIndex (Intent data) {
        return data.getIntExtra(EXTRA_TASK_INDEX, 0);
    }
}

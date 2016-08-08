package student2.metropolitan.fit.rs.student2;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button openerButton;
    private CharSequence[] items = {"FIT", "FDU", "FM"};
    private String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onOpenerButtonListener();
    }

    public void onOpenerButtonListener() {
        openerButton = (Button)findViewById(R.id.openerButton);

        openerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final AlertDialog.Builder dialogBox = new AlertDialog.Builder(MainActivity.this);
                        dialogBox.setCancelable(true);
                        dialogBox.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Toast.makeText(MainActivity.this, "SELEKTED: " + selectedItem, Toast.LENGTH_SHORT).show();

                                Intent intentToOpenURL = new Intent("android.intent.action.VIEW");


                                switch (selectedItem) {
                                    case "FIT":
                                        intentToOpenURL.setData(Uri.parse("http://www.fit.metropolitan.edu.rs/"));
                                        break;
                                    case "FDU":
                                        intentToOpenURL.setData(Uri.parse("http://www.fdu.metropolitan.edu.rs/"));
                                        break;
                                    case "FM":
                                        intentToOpenURL.setData(Uri.parse("http://www.fm.metropolitan.edu.rs/"));
                                        break;
                                }

                                startActivity(intentToOpenURL);

                            }
                        });
                        dialogBox.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        dialogBox.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                selectedItem = (String) items[which];
                            }
                        });

                        AlertDialog alert = dialogBox.create();
                        alert.setTitle("Choose one of tree items:");
                        alert.show();
                    }
                }
        );
    }


}

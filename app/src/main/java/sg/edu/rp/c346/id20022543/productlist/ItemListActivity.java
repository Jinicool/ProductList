//Sajini Sangale 20022543
package sg.edu.rp.c346.id20022543.productlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

    public class ItemListActivity extends AppCompatActivity {
    ListView lvItems;
    ArrayList<String> alItems;
    ArrayList<String> alSpn;
    ArrayAdapter aaItems, aaSpn;
    Button btnAdd, btnUpdate, btnDelete;
    EditText etProduct, etPos, etProduct2, etPos2;
    Spinner spnProduct;
    DatePicker dpExpiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        lvItems = findViewById(R.id.listViewItems);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        etProduct = findViewById(R.id.editProduct);
        etProduct2 = findViewById(R.id.editPosition);
        etPos = findViewById(R.id.editPos);
        spnProduct = findViewById(R.id.spinner);
        dpExpiry = findViewById(R.id.dpexpiry);
        etPos2 = findViewById(R.id.editPosition);



        alItems = new ArrayList<>();
        alSpn = new ArrayList<>();

        aaItems = new ArrayAdapter(this, android.R.layout.simple_list_item_1,alItems);
        lvItems.setAdapter(aaItems);

        aaSpn = new ArrayAdapter(this, android.R.layout.simple_list_item_1,alSpn);
        lvItems.setAdapter(aaSpn);


//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONTH, +1);
//        Date date = calendar.getTime();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
//        String dateOutput = format.format(date);
//        textView.setText(dateOutput);


        alItems.add("Expires 2022-8-6 Logi mouse");
        alItems.add("Expires 2022-1-1 Pizza");
        alItems.add("Expires 2022-2-2 Oreo");
        alItems.add("Expires 2022-3-3 Pocky");
        alItems.add("Expires 2022-5-5 Maggie");


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = etProduct.getText().toString();
                int month = dpExpiry.getMonth();
                int year = dpExpiry.getYear();
                int day = dpExpiry.getDayOfMonth();
                String newDate = year + "-" + month + "-" + day;
                alItems.add("Expires " + newDate + " " + newItem);

                Collections.sort(alItems, String.CASE_INSENSITIVE_ORDER);
                aaItems.notifyDataSetChanged();

                etProduct.setText("");
                etPos.setText("");


            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateProduct = etProduct.getText().toString();
                int month = dpExpiry.getMonth();
                int year = dpExpiry.getYear();
                int day = dpExpiry.getDayOfMonth();
                String updateDate = year + "-" + month + "-" + day;
                int pos = Integer.parseInt(etPos.getText().toString());

                String updated = "Expires " + updateDate + " " + updateProduct;
                alItems.set(pos,updated);

                aaItems.notifyDataSetChanged();


                etProduct.setText("");
                etPos.setText("");

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etPos2.getText().toString());

                if(alItems.size() == 0) {
                    Toast.makeText(ItemListActivity.this,"Your don't have any task to remove",Toast.LENGTH_LONG).show();

                }
                else if(pos >= alItems.size()) {
                    Toast.makeText(ItemListActivity.this,"Wrong index number",Toast.LENGTH_LONG).show();
                }
                else {
                    alItems.remove(pos);

                    aaItems.notifyDataSetChanged();


                }
            }

        });


        spnProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Calendar calendar1 = Calendar.getInstance();
                int currentMonth = calendar1.get(Calendar.MONTH);
                int currentYear = calendar1.get(Calendar.YEAR);


                String currentDate = "";
                switch (position) {
                    case 0:
                        lvItems.setAdapter(aaItems);
                        aaItems.notifyDataSetChanged();
                        break;

                    case 1:
                        int month = 1;
                        alSpn.clear();
                        aaSpn.notifyDataSetChanged();

                        if((currentMonth + 1) + month > 12) {
                            currentYear = currentYear + 1;
                            currentMonth = (currentMonth + 1) + month - 12;
                            currentDate = currentYear + "" + currentMonth;
                        } else {
                            currentMonth = (currentMonth + 1) + month;
                            currentDate = currentYear + " " + currentMonth;
                        }

                        for(int i = 0; i < alItems.size(); i++) {
                            if(alItems.get(i).contains(currentDate)) {
                                alSpn.add(alItems.get(i));

                            }
                        }

                    case 2:
                        month = 3;
                        alSpn.clear();
                        aaSpn.notifyDataSetChanged();

                        if((currentMonth + 1) + month > 12) {
                            currentYear = currentYear + 1;
                            currentMonth = (currentMonth + 1) + month - 12;
                            currentDate = currentYear + "" + currentMonth;
                        } else {
                            currentMonth = (currentMonth + 3) + month;
                            currentDate = currentYear + " " + currentMonth;
                        }

                        for(int i = 0; i < alItems.size(); i++) {
                            if(alItems.get(i).contains(currentDate)) {
                                alSpn.add(alItems.get(i));

                            }
                        }

                    case 3:
                        month = 6;
                        alSpn.clear();
                        aaSpn.notifyDataSetChanged();

                        if((currentMonth + 1) + month > 12) {
                            currentYear = currentYear + 1;
                            currentMonth = (currentMonth + 1) + month - 12;
                            currentDate = currentYear + "" + currentMonth;
                        } else {
                            currentMonth = (currentMonth + 6) + month;
                            currentDate = currentYear + " " + currentMonth;
                        }

                        for(int i = 0; i < alItems.size(); i++) {
                            if(alItems.get(i).contains(currentDate)) {
                                alSpn.add(alItems.get(i));

                            }
                        }

                        lvItems.setAdapter(aaSpn);
                        aaSpn.notifyDataSetChanged();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
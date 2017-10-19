package ieee.lautechsb.ieeestudentactivitiesreport;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnClickListener {

	Spinner day, month, year, minute,hour;
	EditText title, description, guest, venue, branch, expense, collaborator, sponsor;
	ImageButton addGuest, addCollaborator, addSponsor, sendButton, clearButton;
	LinearLayout guestLayout, collaboratorLayout, sponsorLayout;
	String [] days,months,years,minutes,hours;
	int noOfGuest;
	int noOfCollaborator = 100;
	int  noOfsponsor = 1000;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComp();
        initArray();
        setSpinner();
        addEvent();
    }


    private void initializeComp()
    {
    	day = (Spinner) findViewById(R.id.day);
    	month = (Spinner) findViewById(R.id.month);
    	year = (Spinner) findViewById(R.id.year);
    	minute = (Spinner) findViewById(R.id.minute);
    	hour = (Spinner) findViewById(R.id.hour);
    	
    	title = (EditText) findViewById(R.id.title);
    	description = (EditText) findViewById(R.id.description);
    	guest = (EditText) findViewById(R.id.guest);
    	venue = (EditText) findViewById(R.id.venue);
    	branch = (EditText) findViewById(R.id.branch);
    	expense = (EditText) findViewById(R.id.expense);
    	collaborator = (EditText) findViewById(R.id.collaborator);
    	sponsor = (EditText) findViewById(R.id.sponsor);
    	
    	addGuest = (ImageButton) findViewById(R.id.addGuest);
    	addCollaborator = (ImageButton) findViewById(R.id.addCollaborator);
    	addSponsor = (ImageButton) findViewById(R.id.addSponsor);
    	sendButton = (ImageButton) findViewById(R.id.sendButton);
    	clearButton = (ImageButton) findViewById(R.id.clearButton);
    	
    	guestLayout = (LinearLayout) findViewById(R.id.guestLayout);
    	collaboratorLayout = (LinearLayout) findViewById(R.id.collaboratorLayout);
    	sponsorLayout = (LinearLayout) findViewById(R.id.sponsorLayout);
    }
    private void deleteField(LinearLayout layout, int index)
    {
    	LinearLayout lay = (LinearLayout) findViewById(index);
    	layout.removeView(lay);
    }
    private void addNewField(LinearLayout layout, int index, String hint)
    {
    	LinearLayout.LayoutParams lay = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    	LinearLayout guest = new LinearLayout(this);
    	guest.setId(index);
    	guest.setLayoutParams(lay);
    	guest.setWeightSum(100);
    	guest.setOrientation(LinearLayout.HORIZONTAL);
    	
    	EditText text = new EditText(this);
    	text.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 15));
    	text.setTextColor(getResources().getColor(R.color.field_color));
    	text.setHint(hint);
    	text.setId(index);
    	text.requestFocus();
    	text.setTextSize(20);
    	
    	ImageButton imButton = new ImageButton(this);
    	imButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 85));
    	imButton.setImageResource(R.drawable.delete);
    	imButton.setId(index);
    	imButton.setOnClickListener(this);
    	
    	guest.addView(text);
    	guest.addView(imButton);
    	
    	layout.addView(guest);
    }
    private void clearAllFields()
    {
    	title.setText("");
    	description.setText("");
    	guest.setText("");
    	venue.setText("");
    	branch.setText("");
    	expense.setText("");
    	collaborator.setText("");
    	sponsor.setText("");
    	title.requestFocus();
    }
    private void addEvent()
    {
    	clearButton.setOnClickListener(this);
    	addGuest.setOnClickListener(this);
    	addCollaborator.setOnClickListener(this);
    	addSponsor.setOnClickListener(this);
    }
    private void initArray()
    {
    	days = new String[32];
    	months = new String[]{"January", "February","March","April","May","June","July","August","September","Octomber","November","December"};
    	years = new String[20];
    	minutes = new String[61];
    	hours = new String[25];
    	
    	days[0] = "Day";
    	for(int i=1; i<32; i++)
    	{
    		days[i] = ""+ i;
    	}
    	
    	years[0] = "Year";
    	for(int i=1; i<20; i++)
    	{
    		years[i] = ""+(2014+i);
    	}
    	
    	minutes[0] = "Minute";
    	for(int i=1; i<61; i++)
    	{
    		minutes[i] = ""+ (i-1);
    	}
    	
    	hours[0] = "Hour";
    	for(int i=1; i<25; i++)
    	{
    		hours[i] = ""+ (i-1);
    	}
    }
    private void setSpinner()
    {
    	ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, days);
    	ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, months);
    	ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, years);
    	ArrayAdapter<String> hourAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, hours);
    	ArrayAdapter<String> minuteAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, minutes);
    	
    	day.setAdapter(dayAdapter);
    	month.setAdapter(monthAdapter);
    	year.setAdapter(yearAdapter);
    	hour.setAdapter(hourAdapter);
    	minute.setAdapter(minuteAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		
		for(int a=0; a<noOfGuest; a++)
		{
			if(arg0.getId() == a)
			{
				deleteField(guestLayout, a);
				break;
			}
		}
		for(int i=100; i<noOfCollaborator; i++)
		{
			if(arg0.getId() == i)
			{
				deleteField(collaboratorLayout, i);
				break;
			}
		}
		for(int j = 1000; j< noOfsponsor; j++)
		{
			if(arg0.getId() == j)
			{
				deleteField(sponsorLayout, j);
				break;
			}
		}
		switch(arg0.getId())
		{
		case R.id.clearButton :
			clearAllFields();
			break;
		
		case R.id.addGuest : 
			addNewField(guestLayout, noOfGuest++, "Guest Speaker");
			break;
		case R.id.addCollaborator :
			addNewField(collaboratorLayout, noOfCollaborator++, "Collaborator or Patner");
			break;
		case R.id.addSponsor :
			addNewField(sponsorLayout, noOfsponsor++, "Sponsor");
			break;
		}
	}
    
}

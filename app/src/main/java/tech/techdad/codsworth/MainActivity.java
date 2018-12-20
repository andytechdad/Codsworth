package tech.techdad.codsworth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_lists:
                    mTextMessage.setText(R.string.title_lists);
                    return true;
                case R.id.navigation_reference:
                    mTextMessage.setText(R.string.title_reference);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.title_settings);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // Database Section
        // Setting some values that are going into the database on App Creation
        Faction superMutant      = new Faction();
        Faction survivor         = new Faction();
        Faction brotherOfSteel   = new Faction();

        // Faction ID 1 (?)
        superMutant.faction      = "Super Mutant";
        // Faction ID 2 (?)
        survivor.faction         = "Survivor";
        // Faction ID 3 (?)
        brotherOfSteel.faction   = "Brotherhood of Steel";

        Skill resistBattleCry    = new Skill();
        Skill computersExpertise = new Skill();
        Skill health             = new Skill();
        Skill heavyWeapon        = new Skill();
        Skill lockpickExpertise  = new Skill();
        Skill melee              = new Skill();
        Skill mine               = new Skill();
        Skill pistol             = new Skill();
        Skill rifle              = new Skill();
        Skill thrownWeapon       = new Skill();

        // Skill ID 1
        resistBattleCry.skill    = "Resist Battle Cry";
        // Skill ID 2
        computersExpertise.skill = "Computers (Expertise)";
        // Skill ID 3
        health.skill             = "Health";
        // Skill ID 4
        heavyWeapon.skill        = "Heavy Weapon";
        // Skill ID 5
        lockpickExpertise.skill  = "Lockpick (expertise)";
        // Skill ID 6
        melee.skill              = "Melee";
        // Skill ID 7
        mine.skill               = "Mine";
        // Skill ID 8
        pistol.skill             = "Pistol";
        // Skill ID 9
        rifle.skill              = "Rifle";
        // Skill ID 10
        thrownWeapon.skill       = "Thrown Weapon";

        // Initialize the Database
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(this);

        // Create the database by adding the data
        databaseHelper.addFaction(superMutant);
        databaseHelper.addFaction(survivor);
        databaseHelper.addFaction(brotherOfSteel);
        databaseHelper.addSkill(resistBattleCry);
        databaseHelper.addSkill(computersExpertise);
        databaseHelper.addSkill(health);
        databaseHelper.addSkill(heavyWeapon);
        databaseHelper.addSkill(lockpickExpertise);
        databaseHelper.addSkill(melee);
        databaseHelper.addSkill(pistol);
        databaseHelper.addSkill(rifle);
        databaseHelper.addSkill(thrownWeapon);
    }

}

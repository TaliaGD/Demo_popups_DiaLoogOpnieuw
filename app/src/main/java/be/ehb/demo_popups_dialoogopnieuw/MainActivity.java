package be.ehb.demo_popups_dialoogopnieuw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//toolbar locatie
        Toolbar toolbar = findViewById(R.id.toolbar);
        //compatibel makenb met andere versies
        setSupportActionBar(toolbar);

        //controle over heel de navigatie
        navController = Navigation.findNavController(this, R.id.nav_container);
        appBarConfiguration = new AppBarConfiguration.Builder().build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }
    //kunnen navigeren naar een vorig scherm(navigate up)

    @Override
    public boolean onSupportNavigateUp(){
        return NavigationUI.navigateUp(navController, appBarConfiguration)||super.onSupportNavigateUp();
    }
}

package com.example.myapp14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment frag1, frag2, frag3;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new Fragment_A();
        frag2 = new Fragment_B();
        frag3 = new Fragment_C();


        getSupportFragmentManager().beginTransaction().add(R.id.contendorId,frag3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contendorId,frag2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contendorId,frag1).commit();


    }

    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btnF1:
                //transaction.replace(R.id.contendorId,frag1);
                //transaction.addToBackStack(null);

                if (frag1.isAdded()){
                    transaction.hide(frag2).hide(frag3).show(frag1);
                }
                else {
                    transaction.hide(frag2).hide(frag3).add(R.id.contendorId,frag1);
                    transaction.addToBackStack(null);
                }

                break;
            case R.id.btnF2:
                //transaction.replace(R.id.contendorId,frag2);
                //transaction.addToBackStack(null);
                if (frag2.isAdded()){
                    transaction.hide(frag3).hide(frag1).show(frag2);
                }
                else {
                    transaction.hide(frag3).hide(frag1).add(R.id.contendorId,frag2);
                    transaction.addToBackStack(null);
                }

                break;
            case R.id.btnF3:
                //transaction.replace(R.id.contendorId,frag3);
                //transaction.addToBackStack(null);

                if (frag3.isAdded()){
                    transaction.hide(frag2).hide(frag1).show(frag3);
                }
                else {
                    transaction.hide(frag2).hide(frag1).add(R.id.contendorId,frag3);
                    transaction.addToBackStack(null);
                }
                break;
        }
        transaction.commit();
    }
}

package com.example.lesson60alertdialogsimple;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import static android.content.DialogInterface.OnClickListener;

public class MainActivity extends AppCompatActivity {

    final int DIALOG_EXIT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        // вызываем диалог
        showDialog(DIALOG_EXIT);
    }

    @Override
    public void onBackPressed() {
        // вызываем диалог
        showDialog(DIALOG_EXIT);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setCancelable(false);
            // заголовок
            adb.setTitle(R.string.exit);
            // сообщение
            adb.setMessage(R.string.save_data);
            // иконка
            adb.setIcon(android.R.drawable.ic_dialog_info);
            // кнопка положительного ответа
            adb.setPositiveButton(R.string.yes, myClickListener);
            // кнопка отрицательного ответа
            adb.setNegativeButton(R.string.no, myClickListener);
            // кнопка нейтрального ответа
            adb.setNeutralButton(R.string.cancel, myClickListener);
            // создаем диалог
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    OnClickListener myClickListener = new OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                // положительная кнопка
                case Dialog.BUTTON_POSITIVE:
                    saveData();
                    finish();
                    break;
                // негативная кнопка
                case Dialog.BUTTON_NEGATIVE:
                    finish();
                    break;
                // нейтральная кнопка
                case Dialog.BUTTON_NEUTRAL:
                    break;
            }
        }
    };

    void saveData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }
}

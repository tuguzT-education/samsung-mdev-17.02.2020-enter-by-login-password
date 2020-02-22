package com.example.fragmentapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class MyDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        Bundle bundle = getArguments();
        StringBuilder message = new StringBuilder();
        if (bundle != null) {
            String login = bundle.getString("login"),
                    password = bundle.getString("password");
            if (Objects.equals(login, "login") && Objects.equals(password, "password")) {
                message.append("Вход выполнен успешно!\n\n");
            }
            else {
                message.append("Вход не выполнен!\nНеверный логин или пароль!\n\n");
            }
            message.append("Введённый логин: ").append(login)
                    .append("\nВведённый пароль: ").append(password);
        }
        else {
            message.append("Ошибка!");
        }
        builder.setMessage(message)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }
}

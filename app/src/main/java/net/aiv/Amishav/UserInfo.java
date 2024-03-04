package net.aiv.Amishav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class UserInfo extends Fragment {

    private ImageView profilePicture;
    private Button changeProfileButton;

    private EditText username;
    private TextView score;

    private Button addUser;

    public UserInfo() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_user_info, container, false);

        profilePicture = view.findViewById(R.id.profile_picture);
        changeProfileButton = view.findViewById(R.id.change_picture);

        username = view.findViewById(R.id.frag_username);
        score = view.findViewById(R.id.score);

        addUser = view.findViewById(R.id.add_user_button);



        return view;

    }
}
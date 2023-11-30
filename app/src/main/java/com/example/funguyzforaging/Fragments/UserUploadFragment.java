package com.example.funguyzforaging.Fragments;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.funguyzforaging.ImageAdapter.ImageAdapter;
import com.example.funguyzforaging.MainActivity;
import com.example.funguyzforaging.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserUploadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserUploadFragment extends Fragment {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;

    private List<Uri> imageList;
    private ImageAdapter imageAdapter;

    private ActivityResultLauncher<Intent> cameraLauncher;
    private ActivityResultLauncher<Intent> galleryLauncher;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserUploadFragment() {
        // Required empty public constructor
    }
    @Override
    public void onResume() {
        super.onResume();

        // Check if the text size multiplier has changed
        if (getActivity() instanceof MainActivity && ((MainActivity) getActivity()).getTextSizeMultiplier() != 1.0f) {
            ((MainActivity) getActivity()).applyTextSizeMultiplier(requireView());
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserUploadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserUploadFragment newInstance(String param1, String param2) {
        UserUploadFragment fragment = new UserUploadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user_upload, container, false);
        Button cameraButton=view.findViewById(R.id.btnCamera);
        Button galleryButton=view.findViewById(R.id.btnGallery);
        imageList = new ArrayList<>();
        imageAdapter = new ImageAdapter(requireContext(), imageList);

        initializeActivityLaunchers();
        GridView photoGridView = view.findViewById(R.id.photoGridView);
        photoGridView.setAdapter(imageAdapter);
        photoGridView.setOnItemClickListener((parent, view1, position, id) -> {
            // Get the clicked Uri
            Uri clickedImageUri = imageList.get(position);

            // Show the full-size image in a dialog
            showImageDialog(clickedImageUri);
        });

        galleryButton.setOnClickListener(v -> pickFromGallery());
        cameraButton.setOnClickListener(v -> takePhoto());

        return view;
    }

    private void initializeActivityLaunchers() {
        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> handleCameraResult(result.getResultCode(), result.getData())
        );

        galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> handleGalleryResult(result.getResultCode(), result.getData())
        );
    }

    private void handleCameraResult(int resultCode, Intent data) {
        if (resultCode == getActivity().RESULT_OK && data != null && data.getExtras() != null) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            Uri imageUri = saveImageLocally(imageBitmap);
            if (imageUri != null) {
                imageList.add(imageUri);
                imageAdapter.notifyDataSetChanged();
            }
        }
    }

    private void handleGalleryResult(int resultCode, Intent data) {
        if (resultCode == getActivity().RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            if (imageUri != null) {
                imageList.add(imageUri);
                imageAdapter.notifyDataSetChanged();
            }
        }
    }

    private void takePhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraLauncher.launch(takePictureIntent);
    }

    private void pickFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryIntent.setType("image/*");
        galleryLauncher.launch(galleryIntent);
    }

    private Uri saveImageLocally(Bitmap bitmap) {
        // create file to store images
        File storageDir = requireContext().getFilesDir();
        File imageFile = new File(storageDir, "image.jpg");

        try {
            // compress the bitmap and write it to the file
            FileOutputStream fos = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // return the Uri of the saved image file
        return Uri.fromFile(imageFile);
    }

    private void showImageDialog(Uri imageUri) {
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.dialog_image_fullscreen);

        ImageView fullImageView = dialog.findViewById(R.id.fullImageView);
        fullImageView.setImageURI(imageUri);

        ImageButton closeButton = dialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> dialog.dismiss());

        // Show the dialog
        dialog.show();
    }


}
package com.cruz.lantaw.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cruz.lantaw.R;
import com.cruz.lantaw.Singleton.AppSingleton;
import com.cruz.lantaw.activities.MovieInfoActivity;
import com.cruz.lantaw.adapters.GridAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SavedFragment extends Fragment {

    String movies[] = new String[0];
    String ids[] = new String[11];
    String slugs[] = new String[11];
    String titles[] = new String[11];
    String poster_image_thumbnails[] = new String[11];


    public static final String TAG = "movies";


    private View rootView;
    private GridView gridView;

    public SavedFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        volleyStringRequst("https://api.cinepass.de/v4/movies/?apikey=465NWAaWLP4bkRQrVmArERbwwBuxxIp3");
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_saved, container, false);

        gridView = rootView.findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(movies,getContext());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e(TAG, "onItemClick: " + i );
//                String value= getIntent().getStringExtra("keyName");
                Intent intent = new Intent(getActivity(), MovieInfoActivity.class);
                intent.putExtra("id", ids[i]);
                startActivity(intent);
//                Log.e(TAG, "onItemClick: " + ids[i] + "\n" + slugs[i] + "\n" + titles[i] + "\n" + poster_image_thumbnails[i] );
            }
        });

        return rootView;
    }

//    public void volleyStringRequst(String url){
//
//        String  REQUEST_TAG = "com.androidtutorialpoint.volleyStringRequest";
////        progressDialog.setMessage("Loading...");
////        progressDialog.show();
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
//                url, null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
////                Log.d(TAG, response.toString());
//
//
//
//                try {
//                    // Parsing json object response
//                    // response will be a json object
//                    JSONArray obj = response.getJSONArray("movies");
//                    for (int i = 0; i < 10; i++) {
//
//                        JSONObject jsonObject = obj.getJSONObject(i);
//                        String slug = jsonObject.getString("slug");
//                        String title = jsonObject.getString("title");
//                        String poster_image_thumbnail = jsonObject.getString("poster_image_thumbnail");
//                        poster_image_thumbnail = poster_image_thumbnail.replace("http", "https");
//                        String id = jsonObject.getString("id");
//
//                        movies[i] = poster_image_thumbnail;
//                        ids[i] = id;
//                        slugs[i] = slug;
//                        titles[i] = title;
//                        poster_image_thumbnails[i] = poster_image_thumbnail;
//
//
//
//                    }
//
//                    Log.d(TAG, movies[0]);
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    Toast.makeText(getContext(),
//                            "Error: " + e.getMessage(),
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//            }
//        });
//        // Adding String request to request queue
//        AppSingleton.getInstance(getContext()).addToRequestQueue(jsonObjReq, REQUEST_TAG);
//    }

}

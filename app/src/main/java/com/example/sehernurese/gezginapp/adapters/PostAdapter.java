package com.example.sehernurese.gezginapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.sehernurese.gezginapp.R;
import com.example.sehernurese.gezginapp.models.PostModel;

public class PostAdapter  extends BaseAdapter{
    private LayoutInflater layoutInflater;
    private List<PostModel> postModelList;

   public PostAdapter( LayoutInflater layoutInflater,List<PostModel> postModelList){
       this.layoutInflater=layoutInflater;
       this.postModelList=postModelList;
   }

    @Override
    public int getCount() {
        return postModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return postModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View postView=layoutInflater.inflate(R.layout.post_list, null);
        ImageView postPicture=(ImageView) postView.findViewById(R.id.iv_post);
        TextView postTitle=(TextView) postView.findViewById(R.id.tv_title);
        TextView postDescription=(TextView) postView.findViewById(R.id.tv_description);

        PostModel postModel=postModelList.get(position);
        postPicture.setImageResource(postModel.getPostPicture());
        postTitle.setText(postModel.getPostName());
        postDescription.setText(postModel.getPostDescription());

        return postView;

    }
}

package com.example.sehernurese.gezginapp.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sehernurese.gezginapp.R;
import com.example.sehernurese.gezginapp.adapters.PostAdapter;
import com.example.sehernurese.gezginapp.models.PostModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private List<PostModel> postList = new ArrayList<>();
    private ListView myPostList;

    public HomeFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null);
        ListView myPostList = (ListView) view.findViewById(R.id.lv_post);

        postList.add(new PostModel(R.drawable.foto1, "İzmir", "İzmir, hayatın tadını çıkarmayı bilenlerin yaşadığı, büyük şehirlerin karmaşasına tezat, huzurun vücut bulduğu bir şehir. Türkiye’nin üçüncü büyük yerleşimi ve cıvıl cıvıl bir Akdeniz şehri olsa da bir tatil kasabası sakinliğinde yaşayan İzmir’de hayat aceleye gelmez. Buna görülecek yerlerini keşfetmek de dahil. Antik dönemden bu yana sayısız kültürü harmanlamış 8 bin 500 yıllık köklü tarihi, sıcak kanlı insanları, her mevsim güneşli iklimiyle bu Avrupai kenti sadece gezmeyin, yaşayın."));
        postList.add(new PostModel(R.drawable.foto2, "Mardin", "Halkların ve dinlerin buluşma noktası olan Mardin, zengin sosyolojik yapısı ile dikkat çekiyor. Bu özelliği sayesinde kültür turlarının vazgeçilmez duraklarından birisi haline gelen kentte keşfedilmeyi bekleyen düzinelerce tarihi yapı, lezzetli mutfak kültürü ve eşsiz el işi ürünler sizleri bekliyor."));
        postList.add(new PostModel(R.drawable.foto3, "Makedonya", "Balkanlar’daki en güzel yerlerden birisi olan Makedonya, yaklaşık 5 milyon kişinin yaşadığı bir ülke. Para birimi olarak Makedonya Dinarı kullanılan ülkede, resmi dil Makedonca. Ulaşım kolay. Yemekler efsane."));
        postList.add(new PostModel(R.drawable.foto4, "Londra", "Çağdaşlığın simgesi Londra, gelenekçi kimlikle tarihi dokusu özenle korunmuş, gecesi ve gündüzü capcanlı, nezaketin yaşayan bir değer olarak saygı gördüğü şahsına münhasır bir İngiliz kenti. Şehri boydan boya kat eden Thames Nehri kıyısına 2000 yıl önce Romalılar tarafından ‘Londinium’ adı verilerek kurulmuş. Her daim popülerliğini koruyan Londra, bugün dünyanın en önemli iş ve finans merkezlerinde biri olarak dünyanın merkezi olarak adlandırılıyor"));
        postList.add(new PostModel(R.drawable.foto5, "Barselona", "İspanya’nın ikinci büyük şehri, 17 özerk bölgeden biri olan Katalonya’nın başkenti Barselona, ünlü Katalan mimar Antoni Gaudi’nin sıradışı eserleri, sayısız modernisme sanat eserleri, müzeleri, gece hayatı, gurme restoranları, tapas barları ve şehrin merkezinden başlayan ince kumlu plajları ile dünyanın önde gelen seyahat destinasyonlarından biridir."));
        postList.add(new PostModel(R.drawable.foto6, "Hallstatt", "Avusturya’da Viyana’nın popülerliğini devralan, insanı bir masalın tam da ortasında hissettiren Hallstatt, son dönemlerde bir çok gezginin ve fotoğraf meraklıların en uğrak yeri oldu. Hatta Nat Geo’nun bir araştırmasına göre dünyada en çok fotoğrafı çekilen 5 yerden biriymiş! Daha da enteresanı, buranın turizm patlamasına “görüyorum ve arttırıyorum” diyen Çin, kasabanın bir replikasını kendi topraklarına yaptırmış!"));


        PostAdapter postAdapter = new PostAdapter(getLayoutInflater(), postList);
        myPostList.setAdapter(postAdapter);
        myPostList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Bilgiler");
                String selectedName = postList.get(position).getPostName();
                String selectedDescription = postList.get(position).getPostDescription();
                int selectedIcon = postList.get(position).getPostPicture();
                String message = selectedName + " " + selectedDescription;
                builder.setIcon(selectedIcon);
                builder.setMessage(message);
                builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }

        });


        return view;

    }

}

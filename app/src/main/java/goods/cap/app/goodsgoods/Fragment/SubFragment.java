package goods.cap.app.goodsgoods.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import goods.cap.app.goodsgoods.R;

/* main 화면 하단 Grid view, created by supermoon. */

public class SubFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_sub, container, false);

        return view;
    }

}

package com.example.yunmei.headlinenews;

import android.os.Parcelable;


import com.example.yunmei.newslist.NewsListFragment;

import java.util.HashMap;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class HeadlineNewsFragmentAdapter extends FragmentPagerAdapter {
    private ObservableList<ChannelsModel.Channel> mChannels = new ObservableArrayList<>();
    private HashMap<String, Fragment> fragmentHashMap = new HashMap<>();

    public HeadlineNewsFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setChannels(ObservableList<ChannelsModel.Channel> channels) {
        this.mChannels = new ObservableArrayList<>();
        this.mChannels.addAll(channels);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int pos) {
        String key = mChannels.get(pos).channelId + ":" + mChannels.get(pos).channelName;
        if (fragmentHashMap.get(key) != null) {
            return fragmentHashMap.get(key);
        }
        Fragment fragment = NewsListFragment.newInstance(mChannels.get(pos).channelId, mChannels.get(pos).channelName);
        fragmentHashMap.put(key, fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        if (mChannels != null && mChannels.size() > 0) {
            return mChannels.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels.get(position).channelName;
    }
    
    @Override
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
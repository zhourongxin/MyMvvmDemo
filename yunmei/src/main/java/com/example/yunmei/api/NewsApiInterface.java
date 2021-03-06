package com.example.yunmei.api;

import com.arch.demo.common.beans.NewsChannelsBean;
import com.arch.demo.common.beans.NewsListBean;
import com.arch.demo.common.beans.YunMeiChannelsBean;
import com.arch.demo.common.beans.YunMeiNewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public interface NewsApiInterface {
    @GET("release/news")
    Observable<NewsListBean> getNewsList(@Query("channelId") String channelId,
                                         @Query("channelName") String channelName,
                                         @Query("page") String page);


    @GET("release/channel")
    Observable<NewsChannelsBean> getNewsChannels();

}

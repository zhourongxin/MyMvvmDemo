package com.example.yunmei.headlinenews;

import com.arch.demo.common.api.CommonApiInterface;
import com.arch.demo.core.model.MvvmBaseModel;
import com.example.yunmei.api.NewsApiInterface;
import com.arch.demo.common.beans.YunMeiChannelsBean;
import com.xiangxue.network.YunMeiApi;
import com.xiangxue.network.observer.BaseObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2017/7/20.
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public class ChannelsModel extends MvvmBaseModel<YunMeiChannelsBean, ArrayList<ChannelsModel.Channel>> {
    private static final String PREF_KEY_HOME_CHANNEL = "pref_key_home_channel";
    public static final String PREDEFINED_CHANNELS = "{\"showapi_res_body\":{\"channelList\":[{\"channelId\":\"5572a108b3cdc86cf39001cd\",\"name\":\"国内焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001ce\",\"name\":\"国际焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001cf\",\"name\":\"军事焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d0\",\"name\":\"财经焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d1\",\"name\":\"互联网焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d2\",\"name\":\"房产焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d3\",\"name\":\"汽车焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d4\",\"name\":\"体育焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d5\",\"name\":\"娱乐焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d6\",\"name\":\"游戏焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d7\",\"name\":\"教育焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d8\",\"name\":\"女人焦点\"},{\"channelId\":\"5572a108b3cdc86cf39001d9\",\"name\":\"科技焦点\"},{\"channelId\":\"5572a109b3cdc86cf39001da\",\"name\":\"社会焦点\"},{\"channelId\":\"5572a109b3cdc86cf39001db\",\"name\":\"国内最新\"},{\"channelId\":\"5572a109b3cdc86cf39001dc\",\"name\":\"台湾最新\"},{\"channelId\":\"5572a109b3cdc86cf39001dd\",\"name\":\"港澳最新\"},{\"channelId\":\"5572a109b3cdc86cf39001de\",\"name\":\"国际最新\"},{\"channelId\":\"5572a109b3cdc86cf39001df\",\"name\":\"军事最新\"},{\"channelId\":\"5572a109b3cdc86cf39001e0\",\"name\":\"财经最新\"},{\"channelId\":\"5572a109b3cdc86cf39001e1\",\"name\":\"理财最新\"},{\"channelId\":\"5572a109b3cdc86cf39001e2\",\"name\":\"宏观经济最新\"},{\"channelId\":\"5572a109b3cdc86cf39001e3\",\"name\":\"互联网最新\"},{\"channelId\":\"5572a109b3cdc86cf39001e4\",\"name\":\"房产最新\"},{\"channelId\":\"5572a109b3cdc86cf39001e5\",\"name\":\"汽车最新\"},{\"channelId\":\"5572a109b3cdc86cf39001e6\",\"name\":\"体育最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001e7\",\"name\":\"国际足球最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001e8\",\"name\":\"国内足球最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001e9\",\"name\":\"CBA最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001ea\",\"name\":\"综合体育最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001eb\",\"name\":\"娱乐最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001ec\",\"name\":\"电影最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001ed\",\"name\":\"电视最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001ee\",\"name\":\"游戏最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001ef\",\"name\":\"教育最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001f0\",\"name\":\"女人最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001f1\",\"name\":\"美容护肤最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001f2\",\"name\":\"情感两性最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001f3\",\"name\":\"健康养生最新\"},{\"channelId\":\"5572a10ab3cdc86cf39001f4\",\"name\":\"科技最新\"},{\"channelId\":\"5572a10bb3cdc86cf39001f5\",\"name\":\"数码最新\"},{\"channelId\":\"5572a10bb3cdc86cf39001f6\",\"name\":\"电脑最新\"},{\"channelId\":\"5572a10bb3cdc86cf39001f7\",\"name\":\"科普最新\"},{\"channelId\":\"5572a10bb3cdc86cf39001f8\",\"name\":\"社会最新\"},{\"channelId\":\"57463656a44a13cf\",\"name\":\"旅游最新\"},{\"channelId\":\"9a15d3d4b5cab17f34e6d7976b1b1f30\",\"name\":\"电商最新\"},{\"channelId\":\"5b4fe11ec1239b0805568da6e90fd875\",\"name\":\"物流最新\"},{\"channelId\":\"3f4794412eaa17ed\",\"name\":\"创业最新\"}],\"ret_code\":0,\"totalNum\":48},\"showapi_res_code\":0,\"showapi_res_error\":\"\"}";

    public class Channel {
        public String channelId;
        public String channelName;
    }

    public ChannelsModel() {
        super(YunMeiChannelsBean.class, false, PREF_KEY_HOME_CHANNEL, PREDEFINED_CHANNELS);
    }

    @Override
    public void onSuccess(YunMeiChannelsBean yunMeiChannelsBean, boolean isFromCache) {
        if (yunMeiChannelsBean==null){
            return;
        }
        ArrayList<Channel> channels = new ArrayList<>();
        List<YunMeiChannelsBean.Data> dataList = yunMeiChannelsBean.data;
        if (dataList!=null&&dataList.size()>0){
//            for (int i = 0; i < dataList.size(); i++) {
//                YunMeiChannelsBean.Data data = dataList.get(i);
//                Channel channel = new Channel();
//                channel.channelId = data.columnId;
//                channel.channelName = data.name;
//                channels.add(channel);
//            }
            for (YunMeiChannelsBean.Data source : dataList) {
                Channel channel = new Channel();
                channel.channelId = source.columnId;
                channel.channelName = source.name;
                channels.add(channel);
            }
            loadSuccess(yunMeiChannelsBean, channels, isFromCache);
        }

    }

    @Override
    public void onFailure(Throwable e) {
        e.printStackTrace();
        loadFail(e.getMessage());
    }

    @Override
    public void refresh() {
    }

    @Override
    protected void load() {
//        TecentNetworkApi.getService(NewsApiInterface.class)
//                .getNewsChannels()
//                .compose(TecentNetworkApi.
//                        getInstance().
//                        applySchedulers(new BaseObserver<NewsChannelsBean>(this, this)));

        YunMeiApi.getService(CommonApiInterface.class)
                .getYunMeiNewsChannels("qxy", "1", 0, "zh")
                .compose(YunMeiApi.
                        getInstance().
                        applySchedulers(new BaseObserver<YunMeiChannelsBean>(this, this)));
    }
}

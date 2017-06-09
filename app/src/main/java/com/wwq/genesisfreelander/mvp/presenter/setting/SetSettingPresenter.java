package com.wwq.genesisfreelander.mvp.presenter.setting;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import com.wwq.genesisfreelander.R;
import com.wwq.genesisfreelander.controller.utils.T;
import com.wwq.genesisfreelander.model.json.CheckUpgradeApkEntity;
import com.wwq.genesisfreelander.mvp.contract.setting.SetSettingContract;
import com.wwq.genesisfreelander.mvp.model.setting.SetSettingModel;
import com.wwq.genesisfreelander.view.base.BaseApplication;

import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.OnekeyShareTheme;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by wwq on 2017/6/8.
 */

public class SetSettingPresenter extends SetSettingContract.Presenter {
    public SetSettingPresenter(SetSettingContract.View view) {
        mView = view;
        mModel = new SetSettingModel();
    }

    @Override
    public void getAppUpdate() {
        Subscription subscribe = mModel.getAppUpdate()
                .subscribe(new Subscriber<CheckUpgradeApkEntity>() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                    }

                    @Override
                    public void onNext(CheckUpgradeApkEntity checkUpgradeApkEntity) {
                        mView.onAppUpdateSucceed(checkUpgradeApkEntity);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void jpushRegistrationId(String registrationId, int type, int status, String token) {
        Subscription subscribe = mModel.jpushRegistrationId(registrationId, type, status, token)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        onCompleted();
                    }

                    @Override
                    public void onNext(String str) {
                        T.showShort(BaseApplication.getApplication(), str);
                    }
                });
        addSubscribe(subscribe);
    }

    @Override
    public void showShare(Context context, String platformToShare, boolean showContentEdit) {
        OnekeyShare oks = new OnekeyShare();
        oks.setSilent(!showContentEdit);
        if (platformToShare != null) {
            oks.setPlatform(platformToShare);
        }
        //ShareSDK快捷分享提供两个界面第一个是九宫格 CLASSIC  第二个是SKYBLUE
        oks.setTheme(OnekeyShareTheme.CLASSIC);
        // 令编辑页面显示为Dialog模式
        oks.setDialogMode();
        // 在自动授权时可以禁用SSO方式
        oks.disableSSOWhenAuthorize();
        //oks.setAddress("12345678901"); //分享短信的号码和邮件的地址
        oks.setTitle("ShareSDK--Title");
        oks.setTitleUrl("http://mob.com");
        oks.setText(context.getString(R.string.app_share_text));
        //oks.setImagePath("/sdcard/test-pic.jpg");  //分享sdcard目录下的图片
        oks.setImageUrl("http://f1.webshare.mob.com/dimgs/1c950a7b02087bf41bc56f07f7d3572c11dfcf36.jpg");
        oks.setUrl("http://www.mob.com"); //微信不绕过审核分享链接
        /**
         * 分享视频的文件路径
         */
        oks.setFilePath("");  //filePath用于视频分享

        oks.setComment(context.getString(R.string.app_share_comment)); //我对这条分享的评论，仅在人人网和QQ空间使用，否则可以不提供
        oks.setSite("ShareSDK");  //QZone分享完之后返回应用时提示框上显示的名称
        oks.setSiteUrl("http://mob.com");//QZone分享参数
        oks.setVenueName("ShareSDK");
        oks.setVenueDescription("This is a beautiful place!");
        oks.setLatitude(23.169f);
        oks.setLongitude(112.908f);
        // 将快捷分享的操作结果将通过OneKeyShareCallback回调
        // oks.setCallback(new OneKeyShareCallback());
        // 去自定义不同平台的字段内容
        // oks.setShareContentCustomizeCallback(new
        // ShareContentCustomizeDemo());
        // 在九宫格设置自定义的图标
        Bitmap logo = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
        String label = "ShareSDK";
        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {

            }
        };
        oks.setCustomerLogo(logo, label, listener);

        // 为EditPage设置一个背景的View
        //oks.setEditPageBackground(getPage());
        // 隐藏九宫格中的新浪微博
        // oks.addHiddenPlatform(SinaWeibo.NAME);

        // String[] AVATARS = {
        // 		"http://99touxiang.com/public/upload/nvsheng/125/27-011820_433.jpg",
        // 		"http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339485237265.jpg",
        // 		"http://diy.qqjay.com/u/files/2012/0523/f466c38e1c6c99ee2d6cd7746207a97a.jpg",
        // 		"http://diy.qqjay.com/u2/2013/0422/fadc08459b1ef5fc1ea6b5b8d22e44b4.jpg",
        // 		"http://img1.2345.com/duoteimg/qqTxImg/2012/04/09/13339510584349.jpg",
        // 		"http://diy.qqjay.com/u2/2013/0401/4355c29b30d295b26da6f242a65bcaad.jpg" };
        // oks.setImageArray(AVATARS);              //腾讯微博和twitter用此方法分享多张图片，其他平台不可以

        // 启动分享
        oks.show(context);
    }

//    @Override
//    public void showShare(Activity mActivity) {
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
//        oks.setTitle("闪递人");
//        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
//        oks.setTitleUrl("http://app.qq.com/#id=detail&appid=1106071862");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("闪递人新版本上线了,快来加入我们吧!");
//        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
//        oks.setImageUrl("http://pp.myapp.com/ma_icon/0/icon_52446630_1490780266/96");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        // url仅在微信（包括好友和朋友圈）中使用
//        oks.setUrl("http://app.qq.com/#id=detail&appid=1106071862");
//        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("闪递人新版本上线了,快来加入我们吧!");
//        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite("跑跑闪送");
//        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://app.qq.com/#id=detail&appid=1106071862");
//
//// 启动分享GUI
//        oks.show(mActivity);
//    }
}
package com.wwq.genesisfreelander.mvp.api;

import com.wwq.genesisfreelander.model.json.LoginEntity;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wwq on 2017/4/12.
 */

public interface ApiService {
    /**
     * 服务器地址
     */
    String BASE_URL = "http://192.168.0.241:8080/";//124.165.205.15//211.159.158.126

//    /**
//     *  以下为接口地址
//     * ---------------------------------------- 强大分割线 ----------------------------------------
//     */
//
    /**
     * 登录
     */
    @GET("app/shopping/login")
    Observable<LoginEntity> ShoppingLogin(@Query("phoneNumber") String phoneNumber,
                                          @Query("password") String password);
//    public static final String SHOPPING_LOGIN = SERVER_URL + "/app/shopping/login";
    /**
     * 极光 绑定 registrationId
     */
    @POST("app/registration/jpush")
    Observable<String> jpushRegistrationId(@Query("registrationId") String registrationId,
                                           @Query("type") int type,
                                           @Query("status") int status,
                                           @Query("token") String token);
//    /**
//     * 修改密码
//     */
//    public static final String USER_UPDATEPWD = SERVER_URL + "/app/shopping/user/updatePwd";
//    /**
//     * 忘记密码
//     */
//    public static final String USER_FORGETPWD = SERVER_URL + "/app/shopping/user/forgetPwd";
//
//    /**
//     * 菜单列表
//     */
//    @POST("app/shopping/menus")
//    Observable<CommodityEntity> ShoppingMenus(@Query("token") String token);
//
//    public static final String SHOPPING_MENUS = SERVER_URL + "/app/shopping/menus";
//
//    /**
//     * 添加菜单
//     */
//    @POST("app/shopping/menus/addMenus")
//    Observable<RequestErrorEntity> AddMenus(@Query("token") String token,
//                                            @Query("name") String name);
//
//    public static final String MENUS_ADDMENUS = SERVER_URL + "/app/shopping/menus/addMenus";
//
//    /**
//     * 删除菜单
//     */
//    @POST("app/shopping/menus/delMenu")
//    Observable<RequestErrorEntity> DelMenu(@Query("token") String token,
//                                           @Query("menuId") String menuId);
//
//    public static final String MENUS_DELMENU = SERVER_URL + "/app/shopping/menus/delMenu";
//
//    /**
//     * 修改菜单
//     */
//    @POST("app/shopping/menus/update")
//    Observable<RequestErrorEntity> UpdateMenus(@Query("token") String token,
//                                               @Query("id") String id,
//                                               @Query("name") String name);
//
//    public static final String MENUS_UPDATE = SERVER_URL + "/app/shopping/menus/update";
//
//    /**
//     * 添加商品
//     */
//    @Multipart
//    @POST("app/shopping/product/addProduct")
//    Observable<RequestErrorEntity> AddProduct(@Part("token") RequestBody token,
//                                              @Part("proName") RequestBody proName,
//                                              @Part("inventory") RequestBody inventory,
//                                              @Part("mealBoxNum") RequestBody mealBoxNum,
//                                              @Part("mealBoxPrice") RequestBody mealBoxPrice,
//                                              @Part("proMenuId") RequestBody proMenuId,
//                                              @Part("proDes") RequestBody proDes,
//                                              @Part MultipartBody.Part multipartFile,
//                                              @Part("feature") RequestBody feature,
//                                              @Part("picOperType") RequestBody picOperType,
//                                              @Part("json") RequestBody json);
//
//    public static final String PRODUCT_ADDPRODUCT = SERVER_URL + "/app/shopping/product/addProduct";
//
//    /**
//     * 删除商品(不可恢复)
//     */
//    @POST("app/shopping/product/delProduct")
//    Observable<RequestErrorEntity> DelProduct(@Query("token") String token,
//                                              @Query("id") String id);
//
//    public static final String PRODUCT_DELPRODUCT = SERVER_URL + "/app/shopping/product/delProduct";
//
//    /**
//     * 编辑商品信息
//     */
//    @Multipart
//    @POST("app/shopping/product/addProduct")
//    Observable<RequestErrorEntity> UpdateProduct(@Part("token") RequestBody token,
//                                                 @Part("id") RequestBody id,
//                                                 @Part("proName") RequestBody proName,
//                                                 @Part("inventory") RequestBody inventory,
//                                                 @Part("mealBoxNum") RequestBody mealBoxNum,
//                                                 @Part("mealBoxPrice") RequestBody mealBoxPrice,
//                                                 @Part("proMenuId") RequestBody proMenuId,
//                                                 @Part("proDes") RequestBody proDes,
//                                                 @Part MultipartBody.Part multipartFile,
//                                                 @Part("feature") RequestBody feature,
//                                                 @Part("picOperType") RequestBody picOperType,
//                                                 @Part("json") RequestBody json);
//
//    public static final String PRODUCT_UPDATEPRODUCT = SERVER_URL + "/app/shopping/product/updateProduct";
//
//    /**
//     * 商家上架商品
//     */
//    @POST("app/shopping/product/onProduct")
//    Observable<RequestErrorEntity> OnProduct(@Query("token") String token,
//                                             @Query("id") String id);
//
//    public static final String PRODUCT_ONPRODUCT = SERVER_URL + "/app/shopping/product/onProduct";
//
//    /**
//     * 查看下架商品
//     */
//    @POST("app/shopping/product/downProduct")
//    Observable<CommodityEntity> DownProduct(@Query("token") String token);
//
//    public static final String PRODUCT_DOWNPRODUCT = SERVER_URL + "/app/shopping/product/downProduct";
//
//    /**
//     * 商家删除商品（下架）
//     */
//    @POST("app/shopping/product/proDelete")
//    Observable<RequestErrorEntity> ProProduct(@Query("token") String token,
//                                              @Query("id") String id);
//
//    public static final String PRODUCT_PRODELETE = SERVER_URL + "/app/shopping/product/proDelete";
//    /**
//     * 订单管理-待接单列表
//     */
//    public static final String ORDER_WAITINGORDER = SERVER_URL + "/app/shopping/order/waitingOrder";
//    /**
//     * 活动列表
//     */
//    public static final String SHOPACTIVITY_LOOKSHOPACTIVITY = SERVER_URL + "/app/shopping/shopactivity/lookShopActivity";
//
//    /**
//     * 商家更新自己的营业时间
//     */
//    @POST("app/shopping/shop/businessTime")
//    Observable<RequestErrorEntity> BusinessTime(@Query("token") String token,
//                                                @Query("week") String week,
//                                                @Query("startTime") String startTime,
//                                                @Query("endTime") String endTime);
//
//    public static final String SHOP_BUSINESSTIME = SERVER_URL + "/app/shopping/shop/businessTime";
//    /**
//     * 商家设置营业状态
//     */
//    public static final String USER_ISBUSINESS = SERVER_URL + "/app/shopping/user/isBusiness";
//    /**
//     * 操作活动
//     */
//    public static final String SHOPACTIVITY_OPERATESHOPACTIVITY = SERVER_URL + "/app/shopping/shopactivity/operateShopActivity";
//    /**
//     * 接单退单接口
//     */
//    public static final String ORDER_RECEIVEORDER = SERVER_URL + "/app/shopping/order/receiveOrder";
//    /**
//     * 回复催单
//     */
//    public static final String ORDER_REPLAYREMINDER = SERVER_URL + "/app/shopping/order/replayReminder";
//    /**
//     * 订单管理列表
//     */
//    public static final String ORDERMANAGE_ORDERMANAGELIST = SERVER_URL + "/app/shopping/ordermanage/orderManageList";
//    /**
//     * 判断用户是否存在
//     */
//    /**
//     * 获取商品属性
//     */
//    @POST("app/shopping/product/getProperty")
//    Observable<CommodityGetPropertyEntity> GetProperty(@Query("token") String token);
//
//    /**
//     * 添加商品属性
//     */
//    @POST("app/shopping/product/addProperty")
//    Observable<RequestErrorEntity> AddProperty(@Query("token") String token,
//                                               @Query("proName") String proName);
//
//    /**
//     * 查看商家未回复评价和已回复评价
//     */
//    @GET("app/shopping/user/findUser")
//    Observable<FindTalkEntity> isFindUser(@Query("phoneNumber") String phoneNumber);
//
//    /**
//     * 查看评论
//     */
//    public static final String ORDERTALK_LOOKORDERTALK = SERVER_URL + "/app/shoppping/ordertalk/lookOrderTalk";
//    /**
//     * 回复评论
//     */
//    public static final String ORDERTALK_REPLAYORDERTALK = SERVER_URL + "/app/shoppping/ordertalk/replayOrderTalk";
//
//    /**
//     * 今日销售量
//     */
//    @GET("app/shopping/shop/shopSale")
//    Observable<StoresRunEntity> ShopShopsale(@Query("token") String token);
//
//    public static final String SHOP_SHOPSALE = SERVER_URL + "/app/shopping/shop/shopSale";
//
//    /**
//     * 商家更新公告
//     */
//    public static final String SHOP_UPDATESHOPDESC = SERVER_URL + "/app/shopping/shop/updateShopDesc";
//    /**
//     * 商家反馈意见
//     */
//    public static final String USER_ADDCOMPLAIN = SERVER_URL + "/app/shopping/user/addComplain";
//
//    /**
//     * 检查新版本，App升级
//     */
//    @POST("application/flashgordon/update.json")
//    Observable<CheckUpgradeApkEntity> getAppUpdate();
//
//    /**
//     * 查看商家未回复评价和已回复评价
//     */
//    @GET("app/shopping/talk/findTalk")
//    Observable<FindTalkEntity> getFindTalk(@Query("token") String token,
//                                           @Query("type") int type,
//                                           @Query("start") int start);
//
//    /**
//     * 添加商家回复内容
//     */
//    @POST("app/shopping/talk/shopReply")
//    Observable<String> getShopReply(@Query("id") long id,
//                                    @Query("replyContent") String replyContent,
//                                    @Query("orderId") String orderId);
//
//    /**
//     * 查看商家的评价统计内容
//     */
//    @GET("app/shopping/talk/talkSummary")
//    Observable<TalkSummaryEntity> getTalkSummary(@Query("token") String token);
//
//    /**
//     * 查看商家的评价统计内容
//     */
//    @GET("app/details/detailsshop")
//    Observable<DetailsShopEntity> getDetailsShop(@Query("token") String token,
//                                                 @Query("page") String page);
//

}

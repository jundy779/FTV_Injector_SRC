package com.slipkprojects.sockshttp;

import androidx.appcompat.app.AppCompatDelegate;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomappbar.BottomAppBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.slipkprojects.sockshttp.activities.BaseActivity;
import com.slipkprojects.sockshttp.activities.ConfigGeralActivity;
import com.slipkprojects.sockshttp.adapter.LogsAdapter;
import com.slipkprojects.sockshttp.util.AESCrypt;
import com.slipkprojects.sockshttp.util.ConfigUtil;
import com.slipkprojects.ultrasshservice.util.securepreferences.model.vagol;
import com.slipkprojects.sockshttp.util.Utils;
import com.slipkprojects.ultrasshservice.LaunchVpn;
import com.slipkprojects.ultrasshservice.config.Settings;
import com.slipkprojects.ultrasshservice.logger.ConnectionStatus;
import com.slipkprojects.ultrasshservice.logger.SkStatus;
import com.slipkprojects.ultrasshservice.tunnel.TunnelManagerHelper;
import com.slipkprojects.ultrasshservice.tunnel.TunnelUtils;
import com.slipkprojects.ultrasshservice.util.SkProtect;
import com.slipkprojects.ultrasshservice.util.securepreferences.SecurePreferences;
import com.slipkprojects.ultrasshservice.util.securepreferences.SecurePreferences.Editor;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.art.vpn.R;
import android.widget.Toast;
import android.os.CountDownTimer;

import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ProgressDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Locale;
import com.slipkprojects.ultrasshservice.SocksHttpService;
import androidx.appcompat.app.ActionBarDrawerToggle;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import androidx.appcompat.widget.Toolbar;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.view.LayoutInflater;
import com.slipkprojects.sockshttp.activities.ConfigGeralActivity;
import java.security.GeneralSecurityException;
import android.text.Html;
import android.view.Gravity;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.InetSocketAddress;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.net.Uri;
import android.content.Intent;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.analytics.FirebaseAnalytics;
import android.os.StrictMode;
import android.util.TypedValue;
import com.slipkprojects.ultrasshservice.StatisticGraphData;
import com.slipkprojects.ultrasshservice.StatisticGraphData.DataTransferStats;

import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import android.content.IntentSender;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.model.InstallStatus;
import android.widget.RelativeLayout;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.slipkprojects.sockshttp.custom.ServerDialog;
import com.slipkprojects.sockshttp.custom.SpinnerListener;
import com.slipkprojects.sockshttp.custom.PayloadDialog;
import android.widget.EditText;
import java.util.Random;
import androidx.preference.PreferenceManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.PagerAdapter;
import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.appcompat.widget.PopupMenu;
import com.github.mikephil.charting.charts.*;
import com.github.Graph.*;
import java.util.List;
import android.graphics.Color;
import com.slipkprojects.sockshttp.ui.ProxySettings;

import java.util.Calendar;
import java.text.SimpleDateFormat;



import com.slipkprojects.sockshttp.adapter.SpinnerAdapter;
import com.slipkprojects.sockshttp.adapter.PromoAdapter;

public class MainActivity extends BaseActivity implements  SkStatus.StateListener,
View.OnLongClickListener,View.OnClickListener {


	
	private static final String TAG = MainActivity.class.getSimpleName();
	private static final String UPDATE_VIEWS = "MainUpdate";
	public static final String OPEN_LOGS = "com.slipkprojects.sockshttp:openLogs";
	private boolean isLoading;
    private boolean cancelProgressBar;
	private Settings mConfig;
	private Toolbar toolbar_main;
	private Handler mHandler;
	private LinearLayout mainLayout;
	private Button starterButton;
	private AdView adsBannerView;
	private ConfigUtil config;
	private SecurePreferences sp;
	private SecurePreferences.Editor edit;
	private LinearLayout card1;
	private LinearLayout card2;
    private LogsAdapter mLogAdapter;
    private RecyclerView logList;
	private View bshl;
	private String deviceid = "";
	private String notes1 = "";
	private TextView tb1;
    private LogsAdapter mAdapter;
    private boolean isDelete;
	private TextView config_ver_txt;
	private DrawerLayout drawerLayout;
    private TextView connectionStatus;
    private InterstitialAd interstitialAd;
    private boolean mShown, mShown2;
    private boolean running;
	private static final String[] tabTitle = {"HOME","LOGS", "ABOUT"};
    private ViewPager vp;
    private String picture = "";
    private ImageView imageview1;
    private TabLayout tabs;
    private long pauseOffset;
	private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917";
    private static final String AD_UNIT_INTERS = "ca-app-pub-3940256099942544/5224354917";
	private RewardedAd rewardedAd;
    private Thread dataThread;
	private Thread dataUpdate;
	private Handler fHandler = new Handler();
	private GraphHelper graph;
	private LineChart mChart;
	
	 private FloatingActionButton fab;
	private BottomAppBar bottomAppBar;

private TextView mTextViewCountDown;
private CountDownTimer mCountDownTimer;
	 private boolean mTimerRunning;
	 private long mStartTimeInMillis;
	 private long mTimeLeftInMillis;
	private long mEndTime;
    private long saved_ads_time;
	private boolean mTimerEnabled;
    private SharedPreferences sk;
    private Button mButtonSet;
    
    private CountDownTimer mBtnCountDown;
	private long mTimeLeftBtn;
	private AlertDialog ppd;
    
	private SharedPreferences prefs;
	public static boolean mConnected;
	private ProgressDialog verifyconnection;
  private DrawerPanelMain mDrawerPanel;
  private AppUpdateManager mAppUpdateManager;
	private static final int RC_APP_UPDATE = 100;
  public static final String ll ="http://noloadbalance.globe.com.ph";
	public static final String ill ="104.16.213.74";
  public static int PICK_FILE = 1;
  private AdView mAdView;
	private double ok = 99;
	private AlertDialog dialog;
	private EditText token;
	private Button da;
  private Button da2;
  private AlertDialog progdialog;
    
  private Spinner serverSpinner;
	private Spinner payloadSpinner;
	private SpinnerAdapter serverAdapter;
	private PromoAdapter payloadAdapter;
	private ArrayList<JSONObject> serverList;
	private ArrayList<JSONObject> payloadList;
    private TextView bytesIn;

	private TextView bytesOut;
	
    
	@Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
       
        mDrawerPanel = new DrawerPanelMain(this);
        super.onCreate(savedInstanceState);
        FirebaseAnalytics.getInstance(this);
        mHandler = new Handler(Looper.getMainLooper());
        mConfig = new Settings(this);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        doLayout();
        mAppUpdateManager = AppUpdateManagerFactory.create(this);	mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>()
			{
				@Override
				public void onSuccess(AppUpdateInfo result) {
					if(result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE && result.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE))
					{
						try {
							mAppUpdateManager.startUpdateFlowForResult(result, AppUpdateType.IMMEDIATE, MainActivity.this,
															RC_APP_UPDATE);

						} catch (IntentSender.SendIntentException e) {}}
				}
			});
		mAppUpdateManager.registerListener(installUpdatelistener);
		SkProtect.CharlieProtect();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPDATE_VIEWS);
		filter.addAction(OPEN_LOGS);
        LocalBroadcastManager.getInstance(this).registerReceiver(mActivityReceiver, filter);
		
		sp = mConfig.getPrefsPrivate();
        edit = sp.edit();
        doTabs();
		doUpdateLayout();
	}
    private void doLayout() {
		setContentView(R.layout.activity_main_drawer);
		toolbar_main = (Toolbar) findViewById(R.id.toolbar_main);
		setSupportActionBar(toolbar_main);
		mDrawerPanel.setDrawer(toolbar_main);
        mChart = (LineChart) findViewById(R.id.chart1);
		graph = GraphHelper.getHelper().with(this).color(Color.parseColor(getString(R.color.edsonPrimaryDark))).chart(mChart);
        if (!StoredData.isSetData)
		{
			StoredData.setZero();
		}
		graph.start();
		liveData();
		adsBannerView = (AdView) findViewById(R.id.adBannerMainView);	
		if (TunnelUtils.isNetworkOnline(MainActivity.this)) {
			adsBannerView.setAdListener(new AdListener() {
				
				@Override
				public void onAdLoaded() {
					if (adsBannerView != null) {
						adsBannerView.setVisibility(View.VISIBLE);
					}
				}
			});
			adsBannerView.loadAd(new AdRequest.Builder().build());
		}
        mTextViewCountDown = (TextView)findViewById(R.id.timerTextView);
        if(mTextViewCountDown.getVisibility() == View.GONE) {
	finishAffinity();
}
		mButtonSet = (Button) findViewById(R.id.btnAddTime);
		if(mButtonSet.getVisibility() == View.GONE) {
	finishAffinity();
}
		mButtonSet.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
                    if(mConnected)
				{
                    watcher();
					showRewardedVideo();
                    loadRewardedAd();
					return;
				} else {
				//	showSnackBar("Connect VPN First.");
				Toast.makeText(MainActivity.this, "Connect VPN First!", 0).show();
				}
                    }
			});
        final SharedPreferences prefs = mConfig.getPrefsPrivate();
        SharedPreferences.Editor edit = prefs.edit();
		SharedPreferences sPrefs = mConfig.getPrefsPrivate();
        config = new ConfigUtil(this);
        config_ver_txt = (TextView)findViewById(R.id.config_version_txt);
		config_ver_txt.setText(config.getVersion());
        bytesIn = (TextView) findViewById(R.id.bytes_in);
        bytesOut = (TextView) findViewById(R.id.bytes_out);
        connectionStatus = (TextView)findViewById(R.id.connect_status);
		mainLayout = (LinearLayout) findViewById(R.id.activity_mainLinearLayout);
		starterButton = (Button) findViewById(R.id.activity_starterButtonMain);
        starterButton.setOnClickListener(this);
        GreenAd();	
        serverSpinner = (Spinner) findViewById(R.id.serverSpinner);
        serverSpinner.setLongClickable(true);
		serverSpinner.setOnLongClickListener(this);
		payloadSpinner = (Spinner) findViewById(R.id.payloadSpinner);
		payloadSpinner.setLongClickable(true);
		payloadSpinner.setOnLongClickListener(this);
        tb1 = (TextView)findViewById(R.id.tb1);
        imageview1 = (ImageView)findViewById(R.id.image);
       joinjoins();
       deviceid = android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
		notes1 = config.geNote1();
tb1.setText("Android Device: ".concat(deviceid));
	if (notes1.contains(deviceid)) {
		
		finishAffinity();
	   //  restart_app();
}	
         fab = findViewById(R.id.fab);
     	bottomAppBar = findViewById(R.id.bottomAppBar);

        fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (notes1.contains(deviceid)) {
		
		finishAffinity();
	  
}else{
            
			
				doSaveData();
				startOrStopTunnel(MainActivity.this);
				loadServerData();
				}
			}
		});
		_Bottom_App_Bar();
		bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
		bottomAppBar.setFabAnimationMode(bottomAppBar.FAB_ANIMATION_MODE_SLIDE);

        
		serverList = new ArrayList<>();
		payloadList = new ArrayList<>();
		serverAdapter = new SpinnerAdapter(this, R.id.serverSpinner, serverList);
		payloadAdapter = new PromoAdapter(this, R.id.payloadSpinner, payloadList);
		serverSpinner.setSelection(prefs.getInt("LastSelectedServer", 0));
        serverSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4) {
                    SharedPreferences prefs = mConfig.getPrefsPrivate();
                    SharedPreferences.Editor edit = prefs.edit();
                    edit.putInt("LastSelectedServer", p3).apply();
                    showInterstitial();
                }

                @Override
                public void onNothingSelected(AdapterView<?> p1) {
                }
            });
		payloadSpinner.setSelection(prefs.getInt("LastSelectedPayload", 0));
        payloadSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4) {
                    SharedPreferences prefs = mConfig.getPrefsPrivate();
                    SharedPreferences.Editor edit = prefs.edit();
                    edit.putInt("LastSelectedPayload", p3).apply();
                    showInterstitial();
                }

                @Override
                public void onNothingSelected(AdapterView<?> p1) {
                }
            });

		serverSpinner.setAdapter(serverAdapter);
        
		payloadSpinner.setAdapter(payloadAdapter);
        
        
        loadServer();
		loadNetworks();
		
	}
	
	  public void _Bottom_App_Bar() {
		bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
				@Override
				public boolean onMenuItemClick(MenuItem item) {
						
						switch (item.getItemId()) {
								
								case R.id.btn_calendar:
								iphunt();
                                break;
						//    hostpots();
                       //MainActivity.toast(getApplicationContext(), R.color.green, "Add Event Here");
								
                                
					            //case R.id.btn_download:
                                //break;
                      
                        
                            //Intent speedtest = new Intent(MainActivity.this, SpeedTestActivity.class);
		                	//startActivity(speedtest);
								//break;
						}
						return false;
				}
		});
		
	}
  
public void joinjoins()
    {
		View inflate = LayoutInflater.from(this).inflate(R.layout.notif, null);
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
		alertDialogBuilder.setView(inflate); 
		TextView title = inflate.findViewById(R.id.notiftext1);
		TextView ms = inflate.findViewById(R.id.confimsg);
		Button ok = inflate.findViewById(R.id.appButton1);
		title.setText("CONTACT DEVELOPER IT.");
		ms.setText("Please Contact Developer For More Info !!!");
		ok.setText("Click Here .");
		final AlertDialog alert = alertDialogBuilder.create(); 
		alert.setCanceledOnTouchOutside(false);
		alert.getWindow().setGravity(Gravity.CENTER); 
		ok.setOnClickListener(new View.OnClickListener() { 
				@Override
				public void onClick(View p1){
                  String url = "https://t.me/TempestVPNOfficial";
                            Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            MainActivity.this.startActivity(Intent.createChooser(intent3, MainActivity.this.getText(R.string.open_with)));
					alert.dismiss();
				}
			});
		alert.show();
	}
	
    private void liveData()
	{
        dataUpdate = new Thread(new Runnable() {
				@Override
				public void run()
				{

					while (!dataUpdate.getName().equals("stopped"))
					{

						fHandler.post(new Runnable() {

								//private static final long xup = 0;

								@Override
								public void run()
								{
									if(toString().equals("Connected")){
										graph.start();
									}
								}
							});

						try
						{
							Thread.sleep(1000);
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
						//  progressStatus--;
					}

				}
			});

        dataUpdate.setName("started");
        dataUpdate.start();
    }
	final class MyThreadClass implements Runnable{
        @Override
        public void run(){
            int i = 0;
            synchronized (this)
			{
                while (dataThread.getName() == "showDataGraph")
				{
                    //  Log.e("insidebroadcast", Integer.toString(service_id) + " " + Integer.toString(i));
                    getData2();
                    try
					{
                        wait(1000);
                        i++;
                    }
					catch (InterruptedException e)
					{
						// sshMsg(e.getMessage());
                    }

                }
				// stopSelf(service_id);
            }

        }
    }
	public void getData2(){
        List<Long> allData;
        allData = RetrieveData.findData();
		long mDownload = DataTransferGraph2.download;
		long mUpload = DataTransferGraph2.upload;
		mDownload = allData.get(0);
        mUpload = allData.get(1);
		storedData2(mUpload,mDownload);
    }

	public void storedData2(Long mUpload,Long mDownload){
        StoredData.downloadSpeed = mDownload;
        StoredData.uploadSpeed = mUpload;
        if (StoredData.isSetData){
            StoredData.downloadList.remove(0);
            StoredData.uploadList.remove(0);
            StoredData.downloadList.add(mDownload);
            StoredData.uploadList.add(mUpload);
        }
    }
	

@Override
	protected void onStop() {
		if(mAppUpdateManager != null) mAppUpdateManager.unregisterListener(installUpdatelistener);
		super.onStop();
	}
      @Override
    public boolean onLongClick(View p1) {
        switch (p1.getId()) {
            case R.id.serverSpinner:
                editServer(p1, serverSpinner.getSelectedItemPosition());
                break;
                case R.id.payloadSpinner:
              editPayload(p1, payloadSpinner.getSelectedItemPosition());
            break;
        }
        return false;
    }
    private void editServer(View p1,final int selectedItemPosition) {
        PopupMenu pupup =new PopupMenu(this, p1);
        pupup.getMenu().add(0, 0, 0, "Edit");
        pupup.getMenu().add(1, 1, 1, "Delete");
        pupup.getMenu().add(2, 2, 2, "Cancel");
        pupup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem p1) {
                    switch (p1.getItemId()) {
                        case 0:
                            ServerDialog.Server a=new ServerDialog.Server(MainActivity.this);
                            try {
                                final JSONArray ja=new JSONArray(sp.getString("Servers", "[]"));
                                a.edit(ja.getJSONObject(selectedItemPosition));
                                a.onServerAdd(new SpinnerListener()
                                    {
                                        @Override
                                        public void onAdd(JSONObject json) {
                                            try {
                                               // String[] ob={"Name","FLAG", "ServerIP", "ServerPort", "SSLPort", "ProxyIP",  "ProxyPort", "ServerUser", "ServerPass", "Sfrep", "sInfo" ,"Slowchave",  "Nameserver", "servermessage",  }
                                                String[] ob={"Name","FLAG", "ServerIP", "ServerPort", "SSLPort","ProxyPort", "ServerUser", "ServerPass", "Sfrep", "sInfo" ,"Slowchave",  "Nameserver", "servermessage",  };
                                                for (int i=0;i < ob.length;i++) {
                                                    ja.getJSONObject(selectedItemPosition).remove(ob[i]);
                                                }
                                                for (int i=0;i < json.length();i++) {
                                                    ja.getJSONObject(selectedItemPosition).put(ob[i], json.getString(ob[i]));
                                                }
                                                sp.edit().putString("Servers", ja.toString()).apply();
                                                isDelete = false;
                                                saveData();
                                            } catch (JSONException e) {
                                                Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
                                            }
                                        }
                                    });
                                a.init();
                            } catch (JSONException e) {
                                Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
                            }
                            break;
                        case 1:  
                            deleteServer(serverSpinner.getSelectedItemPosition());
                            break;      
                    }         
                    return false;
                }});
		String str = "";
		try {
			JSONObject testar = new JSONObject(serverSpinner.getSelectedItem().toString());
			str = testar.getString("sInfo");
		} catch (JSONException e) {

		}
		if (str.contains("Custom Server")) {
			pupup.show();
		}
	}
    
    public void deleteServer(final int position) {

        try {
            JSONArray ja=new JSONArray(sp.getString("Servers", "[]"));
            ja.remove(position);
            sp.edit().putString("Servers", ja.toString()).apply();
            isDelete = true;
            saveData();
        } catch (JSONException e) {
            Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
        }

    }
    private void editPayload(View p1,final int selectedItemPosition) {
        PopupMenu pupup =new PopupMenu(this, p1);
        pupup.getMenu().add(0, 0, 0, "Edit");
        pupup.getMenu().add(1, 1, 1, "Remove");
        pupup.getMenu().add(2, 2, 2, "Cancel");
        pupup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem p1) {
                    switch (p1.getItemId()) {
                        case 0:
                            PayloadDialog.Payload a=new PayloadDialog.Payload(MainActivity.this);
                            try {
                                final JSONArray ja=new JSONArray(sp.getString("Payloads", "[]"));
                                a.edit(ja.getJSONObject(selectedItemPosition));
                                a.onPayloadAdd(new SpinnerListener()
                                    {
                                        @Override
                                        public void onAdd(JSONObject json) {
                                            try {
                                                String[] ob={"Name","Payload", "SNI", "pInfo" , "Slowdns", "WebProxy", "WebPort" , "isSSL", "isPayloadSSL","isSlow", "isHatok", "isInject","isDirect","isWeb"};
												for (int i=0;i < ob.length;i++) {
                                                    ja.getJSONObject(selectedItemPosition).remove(ob[i]);
                                                }
                                                for (int i=0;i < json.length();i++) {
                                                    ja.getJSONObject(selectedItemPosition).put(ob[i], json.getString(ob[i]));
                                                }
                                                sp.edit().putString("Payloads", ja.toString()).apply();
                                                saveData();

                                            } catch (JSONException e) {
                                                Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
                                            }
                                        }
                                    });
                                a.init();
                            } catch (JSONException e) {
                                Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
                            }                    
                            break;
                        case 1:  
                            deletePayload(payloadSpinner.getSelectedItemPosition());
                            break;      
                    }         
                    return false;
                }});
        //   popupMenu2.setOnMenuItemClickListener(onMenuItemClickListener);
        String str = "";
		try {
			JSONObject testar = new JSONObject(payloadSpinner.getSelectedItem().toString());
			str = testar.getString("pInfo");
		} catch (JSONException e) {

		}
		if (str.contains("Custom Payload")) {
			pupup.show();
		}
	}
    public void deletePayload(final int position) {

        try {
            JSONArray ja=new JSONArray(sp.getString("Payloads", "[]"));
            ja.remove(position);
            sp.edit().putString("Payloads", ja.toString()).apply();
            saveData();

        } catch (JSONException e) {
            Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
        }

    }
    public void getData() {
        String jSONArray = config.getServersArray().toString();
        String jSONArray2 = config.getNetworksArray().toString();
        String version = config.getVersion();
        String notes = config.geNote();
        String notes1 = config.geNote1();
        sp.edit().putString("Version", version).apply();
        sp.edit().putString("ReleaseNotes", notes).apply();
        sp.edit().putString("ReleaseNotes1", notes1).apply();
        sp.edit().putString("Servers", jSONArray).apply();
        sp.edit().putString("Payloads", jSONArray2).apply();
    }
    private JSONObject custom() {
        String ja=sp.getString("Config", "{}");
        try {

            JSONArray a=new JSONArray(sp.getString("Servers", "[]"));
            JSONArray b=new JSONArray(sp.getString("Payloads", "[]"));
            return new JSONObject(ja).put("Version",sp.getString("Version", "")).put("ReleaseNotes",sp.getString("ReleaseNotes", "")).put("ReleaseNotes1",sp.getString("ReleaseNotes1", "")).put("Servers", a).put("Networks", b);
        } catch (JSONException e) {
            return null;
        }

    }
    public void addserver() {

        ServerDialog.Server a=new ServerDialog.Server(this);
        a.add();
        a.onServerAdd(new SpinnerListener()
            {
                @Override
                public void onAdd(JSONObject json) {
                    try {
                        getData();
                        JSONArray ja=new JSONArray(sp.getString("Servers", "[]"));
                        ja.put(json);
                        sp.edit().putString("Servers", ja.toString()).apply();
                        saveData();
                    } catch (JSONException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
                    }
                }
            });
        a.init();
    }

    public String getJson() {
        String str = "";
        try {
            str = AESCrypt.encrypt(ConfigUtil.PASSWORD, custom().toString());
        } catch (GeneralSecurityException e) {
            //  GeneralSecurityException generalSecurityException = e;
        }
        return str;
    }
    public void saveData() {
		try {
			//   uri = getData();
			//  String intentData = importer(uri);
			//String cipter = AESCrypt.decrypt(ConfigUtil.PASSWORD, intentData);
			File file = new File(getFilesDir(), "Config.json");
			OutputStream out = new FileOutputStream(file);
			out.write(getJson().getBytes());
			out.flush();
			out.close();
			loadServer();
			loadNetworks();
			// restart_app();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public void addPayload() {

        PayloadDialog.Payload a=new PayloadDialog.Payload(this);
        a.add();
        a.onPayloadAdd(new SpinnerListener()
            {
                @Override
                public void onAdd(JSONObject json) {
                    try {
                        getData();
                        JSONArray ja=new JSONArray(sp.getString("Payloads", "[]"));
                        ja.put(json);
                        sp.edit().putString("Payloads", ja.toString()).apply();
                        saveData();

                    } catch (JSONException e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), 1).show();
                    }
                }
            });
        a.init();
    }
    

    
	private InstallStateUpdatedListener installUpdatelistener = new InstallStateUpdatedListener()
	{
		@Override
		public void onStateUpdate(InstallState state) {
			if(state.installStatus() == InstallStatus.DOWNLOADED)
			{
				showCompleterUpdate();
			}
		}
	};

	private void showCompleterUpdate()
	{
		Snackbar snacks = Snackbar.make(findViewById(android.R.id.content), "New app is ready!",
										Snackbar.LENGTH_INDEFINITE);
		snacks.setAction("Install", new View.OnClickListener()
			{
				@Override
				public void onClick(View view) {
					mAppUpdateManager.completeUpdate();
				}
			});
		snacks.setActionTextColor(Color.parseColor("#ffffff"));
		snacks.show();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == RC_APP_UPDATE && resultCode != RESULT_OK)
		{
			Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
		}
		super.onActivityResult(requestCode, resultCode, data);
        
        if (requestCode == PICK_FILE)
		{
			if (resultCode == RESULT_OK) {
				try {
					Uri uri = data.getData();
					String intentData = importer(uri);
					//String cipter = AESCrypt.decrypt(ConfigUtil.PASSWORD, intentData);
					File file = new File(getFilesDir(), "Config.json");
					OutputStream out = new FileOutputStream(file);
					out.write(intentData.getBytes());
					out.flush();
					out.close();
					loadServer();
					loadNetworks();
                    restart_app();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
    
    private void iphunt () {
		View inflate = LayoutInflater.from(this).inflate(R.layout.notif2, null);
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
		alertDialogBuilder.setView(inflate); 
		TextView title = inflate.findViewById(R.id.notiftext1);
		final TextView ms = inflate.findViewById(R.id.confimsg);
		final TextView ok = inflate.findViewById(R.id.appButton1);
		TextView cancel = inflate.findViewById(R.id.appButton2);
		title.setText("GTM IP Hunter");
		ms.setText("To connect to GTM No Load No Blocking, Make sure that you are now in the Magic IP. Click the button to check your IP!");
		ok.setText("Check Now");
		cancel.setText("Close");
		final AlertDialog alert = alertDialogBuilder.create(); 
		alert.setCanceledOnTouchOutside(false);
		alert.getWindow().setGravity(Gravity.CENTER); 
		alert.show();
		ok.setOnClickListener(new View.OnClickListener() { 
				@Override
				public void onClick(View p1){
					ms.setText("Please wait while we are checking your IP...");
					ok.setEnabled(false);
					ok.setText("Checking...");
					new Handler().postDelayed(new Runnable(){

							@Override
							public void run() {
								try {
									int l = 0;
									URL whatismyip = new URL(MainActivity.ll);
									String magic = "✅ Congrats!! You are now connected to MAGIC IP.";
									String fail = "🚫 Disconnected. Please Airplane Mode On/Off and Try Again.";
									try{		
										Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(MainActivity.ill, 80));
										HttpURLConnection connection = (HttpURLConnection) whatismyip.openConnection(proxy);
										connection.setRequestMethod("GET");
										connection.connect();
										connection.getContentLength();
										connection.setConnectTimeout(3000);
										InputStream in = connection.getInputStream();
										byte[] buffer = new byte[4096];
										int countBytesRead;
										while((countBytesRead = in.read(buffer)) != -1) {
											l += countBytesRead;
										}
										in.markSupported();
										if (l == 333){
											ms.setText(magic);
											ok.setText("Check Again");
											ok.setEnabled(true);
											return;
										}
										if (connection.getResponseCode() == 200){
											ms.setText(magic);
											ok.setText("Check Again");
											ok.setEnabled(true);
											return;
										}
										in.close();
										ms.setText(fail);;
										ok.setText("Check Again");
										ok.setEnabled(true);
									} catch (IOException e) {
										ok.setText("Check Again");
										ok.setEnabled(true);
										ms.setText(fail);
									}

								}catch (MalformedURLException e) {}}
						}, 1000);

				}

			});

		cancel.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1) {

					alert.dismiss();
				}
			});
		alert.show();

	}
    
    private void updateHeaderCallback() {
		DataTransferStats dataTransferStats = StatisticGraphData.getStatisticData().getDataTransferStats();
		bytesIn.setText(dataTransferStats.byteCountToDisplaySize(dataTransferStats.getTotalBytesReceived(), false));
		bytesOut.setText(dataTransferStats.byteCountToDisplaySize(dataTransferStats.getTotalBytesSent(), false));
	}
	private void doUpdateLayout() {
        SharedPreferences prefs = mConfig.getPrefsPrivate();
        
		setStarterButton(starterButton, this);
	}
	
	
	private synchronized void doSaveData() {
		try {
			SharedPreferences prefs = mConfig.getPrefsPrivate();
			SharedPreferences.Editor edit = prefs.edit();
			
			edit.apply();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadServerData() {
		try {
			SharedPreferences prefs = mConfig.getPrefsPrivate();
			SharedPreferences.Editor edit = prefs.edit();

            int pos2 = payloadSpinner.getSelectedItemPosition();
			int pos1 = serverSpinner.getSelectedItemPosition();
            
            String ssh_server = config.getServersArray().getJSONObject(pos1).getString("ServerIP");
			//String remote_proxy = config.getServersArray().getJSONObject(pos1).getString("ProxyIP");
			
    String proxy_port = config.getServersArray().getJSONObject(pos1).getString("ProxyPort");
            String ssh_user = config.getServersArray().getJSONObject(pos1).getString("ServerUser");
            String ssh_password = config.getServersArray().getJSONObject(pos1).getString("ServerPass");
			String ssh_port = config.getServersArray().getJSONObject(pos1).getString("ServerPort");
			String ssl_port = config.getServersArray().getJSONObject(pos1).getString("SSLPort");
			String payload = config.getNetworksArray().getJSONObject(pos2).getString("Payload");
			String sni = config.getNetworksArray().getJSONObject(pos2).getString("SNI");
            String sirbir = config.getServersArray().getJSONObject(pos1).getString("servermessage");
			String chaveKey = config.getServersArray().getJSONObject(pos1).getString("Slowchave");
			String serverNameKey = config.getServersArray().getJSONObject(pos1).getString("Nameserver");
			String dnsKey = config.getNetworksArray().getJSONObject(pos2).getString("Slowdns");
            String dnsPort = config.getServersArray().getJSONObject(pos1).getString("Sfrep");
            String webPrtt = config.getNetworksArray().getJSONObject(pos2).getString("WebProxy");
            String webPstt = config.getNetworksArray().getJSONObject(pos2).getString("WebPort");
            String u = config.getServersArray().getJSONObject(pos1).getString("Name");
            String o = config.getNetworksArray().getJSONObject(pos2).getString("Name");
            
            edit.putString("ServerName", u);
            edit.putString("PayloadName", o);
            edit.putString(Settings.USUARIO_KEY, ssh_user);
            edit.putString(Settings.SENHA_KEY, ssh_password);
			edit.putString(Settings.SERVIDOR_KEY, ssh_server);
			edit.putString("SIRBIRNETH", sirbir);
            
			boolean sslType = config.getNetworksArray().getJSONObject(pos2).getBoolean("isSSL");
			boolean sslpayload = config.getNetworksArray().getJSONObject(pos2).getBoolean("isPayloadSSL");
			boolean inject = config.getNetworksArray().getJSONObject(pos2).getBoolean("isInject");
			boolean direct = config.getNetworksArray().getJSONObject(pos2).getBoolean("isDirect");
			boolean sslpayloadrp = config.getNetworksArray().getJSONObject(pos2).getBoolean("isHatok");
			boolean slow = config.getNetworksArray().getJSONObject(pos2).getBoolean("isSlow");
            boolean web = config.getNetworksArray().getJSONObject(pos2).getBoolean("isWeb");
            
            if (web){
                    edit.putString(Settings.PROXY_IP_KEY, webPrtt);
                    edit.putString(Settings.PROXY_PORTA_KEY, webPstt);
                }else{
                  edit.putString(Settings.PROXY_IP_KEY, ssh_server).apply();
			edit.putString(Settings.PROXY_PORTA_KEY, proxy_port).apply();
                }


            //SSH DIRECT
			if (direct)
			{
				prefs.edit().putBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, false).apply();
				prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_DIRECT).apply();
				prefs.edit().putString(Settings.SERVIDOR_KEY, ssh_server).apply();
				prefs.edit().putString(Settings.SERVIDOR_PORTA_KEY, ssh_port).apply();
				prefs.edit().putString(Settings.CUSTOM_PAYLOAD_KEY, payload).apply();
			}

			//SSH PROXY
			if (inject)
			{
				prefs.edit().putBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, false).apply();
				prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_PROXY).apply();
				prefs.edit().putString(Settings.SERVIDOR_KEY, ssh_server).apply();
				prefs.edit().putString(Settings.SERVIDOR_PORTA_KEY, ssh_port).apply();
				prefs.edit().putString(Settings.CUSTOM_PAYLOAD_KEY, payload).apply();
			}
            //SSH SSL
			if (sslType)
			{
				prefs.edit().putBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, true).apply();
				prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSH_SSLTUNNEL).apply();
				prefs.edit().putString(Settings.SERVIDOR_KEY, ssh_server).apply();
				prefs.edit().putString(Settings.SERVIDOR_PORTA_KEY, ssl_port).apply();
				prefs.edit().putString(Settings.CUSTOM_PAYLOAD_KEY, payload).apply();
				prefs.edit().putString(Settings.CUSTOM_SNI, sni).apply();
			}
			//SSL PAYLOAD
			if (sslpayload)
			{
				prefs.edit().putBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, false).apply();
				prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_PAY_SSL).apply();
				prefs.edit().putString(Settings.SERVIDOR_KEY, ssh_server).apply();
				prefs.edit().putString(Settings.SERVIDOR_PORTA_KEY, ssl_port).apply();
				prefs.edit().putString(Settings.CUSTOM_PAYLOAD_KEY, payload).apply();
				prefs.edit().putString(Settings.CUSTOM_SNI, sni).apply();
			}
			//SSL PAYLOAD
			if (sslpayloadrp)
			{
				prefs.edit().putBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, false).apply();
				prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SSL_RP).apply();
				prefs.edit().putString(Settings.SERVIDOR_KEY, ssh_server).apply();
				prefs.edit().putString(Settings.SERVIDOR_PORTA_KEY, ssl_port).apply();
				prefs.edit().putString(Settings.CUSTOM_PAYLOAD_KEY, payload).apply();
				//prefs.edit().putString(Settings.PROXY_IP_KEY, remote_proxy).apply();
				prefs.edit().putString(Settings.CUSTOM_SNI, sni).apply();
			}
            //SLOW DIRECT
			if (slow)
			{
				prefs.edit().putString(Settings.CHAVE_KEY, chaveKey).apply();
				prefs.edit().putString(Settings.NAMESERVER_KEY, serverNameKey).apply();
				prefs.edit().putString(Settings.DNS_KEY, dnsKey).apply();
                edit.putString(Settings.SERVIDOR_KEY, "127.0.0.1");
				prefs.edit().putString(Settings.SERVIDOR_PORTA_KEY, dnsPort).apply();
				prefs.edit().putBoolean(Settings.PROXY_USAR_DEFAULT_PAYLOAD, true).apply();
				prefs.edit().putInt(Settings.TUNNELTYPE_KEY, Settings.bTUNNEL_TYPE_SLOWDNS).apply();
			}
		
			edit.apply();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void loadServer() {
		try {
			if (serverList.size() > 0) {
				serverList.clear();
				serverAdapter.notifyDataSetChanged();
			}
			for (int i = 0; i < config.getServersArray().length(); i++) {
				JSONObject obj = config.getServersArray().getJSONObject(i);
				serverList.add(obj);
				serverAdapter.notifyDataSetChanged();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void loadNetworks() {
		try {
			if (payloadList.size() > 0) {
				payloadList.clear();
				payloadAdapter.notifyDataSetChanged();
			}
			for (int i = 0; i < config.getNetworksArray().length(); i++) {
				JSONObject obj = config.getNetworksArray().getJSONObject(i);
				payloadList.add(obj);
				payloadAdapter.notifyDataSetChanged();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public void offlineUpdate() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("*/*");
		startActivityForResult(intent, PICK_FILE);
	}

	private String importer(Uri uri)
	{
		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();
		try
		{
			reader = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(uri)));

			String line = "";
			while ((line = reader.readLine()) != null)
			{
				builder.append(line);
			}
			reader.close();
		}
		catch (IOException e) {e.printStackTrace();}
		return builder.toString();
	} 

	private void updateConfig(final boolean isOnCreate) {
		new vagol(this, new vagol.OnUpdateListener() {
			@Override
				public void onUpdateListener(String result) {
					try {
						if (!result.contains("Error on getting data")) {
							String json_data = AESCrypt.decrypt(config.PASSWORD, result);
							if (isNewVersion(json_data)) {
								letUpdate(result);
							} else {
								if (!isOnCreate) {
									noUpdateDialog();
								}
							}
						} else if(result.contains("Error on getting data") && !isOnCreate){
							errorUpdateDialog(result);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start(isOnCreate);
	}
    int status = 0 ;
	ProgressDialog pd;
	byte[] YourDataA;

	private void letUpdate(final String result /* KJAYDev */){
		YourDataA=result.getBytes();
	  pd = new ProgressDialog(this);
		pd.setTitle("New Config Update");
		pd.setMessage("Updating data..");
		pd.setMax(100);
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setOnDismissListener(new DialogInterface.OnDismissListener(){

				@Override
				public void onDismiss(DialogInterface p1) {
					try {
						File file = new File(getFilesDir(), "Config.json");
						OutputStream out = new FileOutputStream(file);
						out.write(result.getBytes());
						out.flush();
						out.close();
						restart_app();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					//.setText(getConfig());
					status = 0;
				}
			});

		new Thread(new Runnable() {

                @Override
                public void run() {
                    while (status < 100) {
                        status += 1;
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    pd.setProgress(status);
									if(status == 100) {
                                        pd.dismiss();
                                    }
                                }
							});
					}
				}
            }).start();
		pd.show();
	}


	private boolean isNewVersion(String result) {
		try {
			String current = config.getVersion();
			String update = new JSONObject(result).getString("Version");
			return config.versionCompare(update, current);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}
public void Changelogs()
    {
		View inflate = LayoutInflater.from(this).inflate(R.layout.notif, null);
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
		alertDialogBuilder.setView(inflate); 
		TextView title = inflate.findViewById(R.id.notiftext1);
		TextView ms = inflate.findViewById(R.id.confimsg);
		Button ok = inflate.findViewById(R.id.appButton1);
		title.setText("Release Notes!");
		ms.setText(this.config.geNote());
		ok.setText("Hide");
		final AlertDialog alert = alertDialogBuilder.create(); 
		alert.setCanceledOnTouchOutside(false);
		alert.getWindow().setGravity(Gravity.CENTER); 
		ok.setOnClickListener(new View.OnClickListener() { 
				@Override
				public void onClick(View p1){
					alert.dismiss();
					GreenAd();
                    showInterstitial();
				}
			});
		alert.show();
	}
    public void Changelogs1()
    {
		View inflate = LayoutInflater.from(this).inflate(R.layout.notif, null);
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
		alertDialogBuilder.setView(inflate); 
		TextView title = inflate.findViewById(R.id.notiftext1);
		TextView ms = inflate.findViewById(R.id.confimsg);
		Button ok = inflate.findViewById(R.id.appButton1);
		title.setText("Announcement!");
		ms.setText(this.config.geNote1());
		ok.setText("Hide");
		final AlertDialog alert = alertDialogBuilder.create(); 
		alert.setCanceledOnTouchOutside(false);
		alert.getWindow().setGravity(Gravity.CENTER); 
		ok.setOnClickListener(new View.OnClickListener() { 
				@Override
				public void onClick(View p1){
					alert.dismiss();
					GreenAd();
                    showInterstitial();
				}
			});
		alert.show();
	}
	private void restart_app() {
		loadServer();
		loadNetworks();
        config_ver_txt.setText(config.getVersion());
        Changelogs();
	}
    public void noUpdateDialog()
    {
		View inflate = LayoutInflater.from(this).inflate(R.layout.notif, null);
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
		alertDialogBuilder.setView(inflate); 
		TextView title = inflate.findViewById(R.id.notiftext1);
		TextView ms = inflate.findViewById(R.id.confimsg);
		Button ok = inflate.findViewById(R.id.appButton1);
		title.setText("No Update Available!");
		ms.setText("Please Try Again Later");
		ok.setText("Hide");
		final AlertDialog alert = alertDialogBuilder.create(); 
		alert.setCanceledOnTouchOutside(false);
		alert.getWindow().setGravity(Gravity.CENTER); 
		ok.setOnClickListener(new View.OnClickListener() { 
				@Override
				public void onClick(View p1){
					alert.dismiss();
                    showInterstitial();
				}
			});
		alert.show();
	}
	private void errorUpdateDialog(String error) {
            MaterialAlertDialogBuilder dialogo = new MaterialAlertDialogBuilder(this);
            dialogo.setMessage("Error on update")
            .setPositiveButton("Ok", null)
            .create().show();
    }
	/**
	 * Tunnel SSH
	 */
     public void doTabs() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mLogAdapter = new LogsAdapter(layoutManager,this);
        logList = (RecyclerView) findViewById(R.id.recyclerLog);
        logList.setAdapter(mLogAdapter);
        logList.setLayoutManager(layoutManager);
        mLogAdapter.scrollToLastPosition();
        vp = (ViewPager)findViewById(R.id.viewpager);
        tabs = (TabLayout)findViewById(R.id.tablayout);
        vp.setAdapter(new MyzAdapter(Arrays.asList(tabTitle)));
        vp.setOffscreenPageLimit(3);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        tabs.setupWithViewPager(vp);
		vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
            {
                @Override
                public void onPageSelected(int position)
                {
                    if (position == 0) {
                        toolbar_main.getMenu().clear();
						getMenuInflater().inflate(R.menu.main_menu, toolbar_main.getMenu());
                    } else if (position == 1) {                                        
						toolbar_main.getMenu().clear();
						getMenuInflater().inflate(R.menu.logs_menu, toolbar_main.getMenu());
                    } 
                     else if (position == 2) {                                        
						toolbar_main.getMenu().clear();
						getMenuInflater().inflate(R.menu.main_menu, toolbar_main.getMenu());
                    } 
                }
			});
	}

	public class MyzAdapter extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            // TODO: Implement this method
            return 2;
        }

        @Override
        public boolean isViewFromObject(View p1, Object p2)
        {
            // TODO: Implement this method
            return p1 == p2;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            int[] ids = new int[]{R.id.tab1, R.id.tab2, R.id.tab3};
            int id = 0;
            id = ids[position];
            // TODO: Implement this method
            return findViewById(id);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            // TODO: Implement this method
            return titles.get(position);
        }

        private List<String> titles;
        public MyzAdapter(List<String> str)
        {
            titles = str;
        }
	}

	public void startOrStopTunnel(Activity activity) {
		if (SkStatus.isTunnelActive()) {
			TunnelManagerHelper.stopSocksHttp(activity);
        	
		} else {
			Settings config = new Settings(activity);
            	if (!running) {
			mShown = false;		
			mShown2 = false;	
            }
			Intent intent = new Intent(activity, LaunchVpn.class);
			intent.setAction(Intent.ACTION_MAIN);
			
			activity.startActivity(intent);
		}
	}

public class DrawerPanelMain
	implements NavigationView.OnNavigationItemSelectedListener
{
	private AppCompatActivity mActivity;
	
	public DrawerPanelMain(AppCompatActivity activity) {
		mActivity = activity;
	}
	

	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle toggle;

	public void setDrawer(Toolbar toolbar) {
		NavigationView drawerNavigationView = (NavigationView) mActivity.findViewById(R.id.drawerNavigationView);
		drawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawerLayoutMain);

		// set drawer
		toggle = new ActionBarDrawerToggle(mActivity,
			drawerLayout, toolbar, R.string.open, R.string.cancel);

        drawerLayout.setDrawerListener(toggle);

		toggle.syncState();

		// set navigation view
		drawerNavigationView.setNavigationItemSelectedListener(this);
	}
	
	public ActionBarDrawerToggle getToogle() {
		return toggle;
	}
	
	public DrawerLayout getDrawerLayout() {
		return drawerLayout;
	}
	
	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		int id = item.getItemId();

		switch(id)
		{
				
                
              case R.id.configUpdate:
              if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
        		}
				updateConfig(false);
				break; 
                
                case R.id.pogs:
              if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
        		}
				Changelogs();
				break; 
                
                case R.id.item5:
              if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
        		}
		    	String url2 = "https://facebook.com/groups/968833691026609/";
				Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
				intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(Intent.createChooser(intent2, getText(R.string.open_with)));
				return true;
                
				
		
               case R.id.item7:
              if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
        		}
		    	String url4 = "https://t.me/federasitempest";
				Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(url4));
				intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(Intent.createChooser(intent4, getText(R.string.open_with)));
				return true;

                
                
                case R.id.pogse:
              if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
        		}
                addserver();
				break; 
				    
                case R.id.pogse1:
              if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
        		}
                Intent hostshare2 = new Intent(mActivity, ProxySettings.class);
	                	     	mActivity.startActivity(hostshare2);
				break; 

			case R.id.miSettings:
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawers();
        		}
				Intent intent = new Intent(mActivity, ConfigGeralActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				mActivity.startActivity(intent);
                
				break;
                
                
                
                
              
                
                case R.id.hostshare:
	             addPayload();
		  	break;
			
		}

		return true;
	}
	
}
@Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        if (mDrawerPanel.getToogle() != null)
			mDrawerPanel.getToogle().syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mDrawerPanel.getToogle() != null)
			mDrawerPanel.getToogle().onConfigurationChanged(newConfig);
    }
	public void setStarterButton(Button starterButton, Activity activity) {
		String state = SkStatus.getLastState();
		boolean isRunning = SkStatus.isTunnelActive();
		if (starterButton != null) {
			int resId;
			if (SkStatus.SSH_INICIANDO.equals(state)) {
				resId = R.string.stop;
                dataThread = new Thread(new MyThreadClass());
				//new edsongraphflip(SocksHttpMainActivity.this, "start");
				dataThread.setName("showDataGraph");
				dataThread.start();
                serverSpinner.setEnabled(false);
                payloadSpinner.setEnabled(false);
				starterButton.setEnabled(false);
			} else if (SkStatus.SSH_PARANDO.equals(state)) {
            dataThread = new Thread(new MyThreadClass());
				dataThread.setName("stopDataGraph");
                serverSpinner.setEnabled(true);
                payloadSpinner.setEnabled(true);
				resId = R.string.state_stopping;
				starterButton.setEnabled(false);
			} else {
				resId = isRunning ? R.string.stop : R.string.start;
				starterButton.setEnabled(true);
			}
			starterButton.setText(resId);
		}
	}
	@Override
	public void onClick(View p1)
	{
		SharedPreferences prefs = mConfig.getPrefsPrivate();

		switch (p1.getId()) {
			case R.id.activity_starterButtonMain:
				doSaveData();
				startOrStopTunnel(this);
				loadServerData();
				break;
			
		}
	}
	

	@Override
	public void updateState(final String state, String msg, int localizedResId, final ConnectionStatus level, Intent intent)
	{
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				doUpdateLayout();
				if (SkStatus.isTunnelActive()){

					if (level.equals(ConnectionStatus.LEVEL_CONNECTED)){
						connectionStatus.setText("Connected");
                     fab.setImageResource(R.drawable.ic_baseline_near_me_disabled_24);
                         // ImageView con =(ImageView)findViewById(R.id.ic);
		          	 // con.setImageResource(R.drawable.ic_connected);
		          	 showInterstitial();
                        start();
                        if (!mShown){
						    
                            
						//	Toast.makeText(MainActivity.this, "Connected", 0).show();		
						    MainActivity.toast(getApplicationContext(), R.color.green, "Connected");
                        	mShown = true;
						}		
						//	Toast.makeText(MainActivity.this, "Connected", 0).show();		
					
                    }

					if (level.equals(ConnectionStatus.LEVEL_NOTCONNECTED)){
						connectionStatus.setText(R.string.servicestop);
					}   

					if (level.equals(ConnectionStatus.LEVEL_CONNECTING_SERVER_REPLIED)){
						connectionStatus.setText(R.string.authenticating);
					}       

					if (level.equals(ConnectionStatus.LEVEL_CONNECTING_NO_SERVER_REPLY_YET)){
						connectionStatus.setText(R.string.connecting);
                      //@interface  ImageView con =(ImageView)findViewById(R.id.ic);
		          	 // con.setImageResource(R.drawable.ic_connecting);
					}           
					if (level.equals(ConnectionStatus.LEVEL_AUTH_FAILED)){
						connectionStatus.setText(R.string.authfailed);
					}                   
					if (level.equals(ConnectionStatus.UNKNOWN_LEVEL)){
						connectionStatus.setText("Disconnected");
                     //   ImageView con =(ImageView)findViewById(R.id.ic);
	          		 // con.setImageResource(R.drawable.ic_disconnected);
	          		 fab.setImageResource(R.drawable.ic_baseline_near_me_24);
	          		 GreenAd();
                     showInterstitial();
                        if (!mShown2){
                            MainActivity.toast(getApplicationContext(), R.color.red, "Disconnected");	
					     	
								mShown2 = true;
                            
						}		
                        stop();
						//Toast.makeText(MainActivity.this, "Disconnected", 0).show();
						
					}
				}               
				if (level.equals(ConnectionStatus.LEVEL_NONETWORK)){
					connectionStatus.setText(R.string.nonetwork);
				}          
            }
		});
		
		switch (state) {
			case SkStatus.SSH_CONECTADO:
				mHandler.postDelayed(new Runnable() {
						@Override
						public void run() {
							if (adsBannerView != null && TunnelUtils.isNetworkOnline(MainActivity.this)) {
								adsBannerView.setAdListener(new AdListener() {
										@Override
										public void onAdLoaded() {
											if (adsBannerView != null) {
												adsBannerView.setVisibility(View.VISIBLE);
											}
										}
									});
								adsBannerView.loadAd(new AdRequest.Builder()
													 .build());                                                                      
							}
						}
					}, 1000);
				break;
		}
	}


	/**
	 * Recebe locais Broadcast
	 */
     
	private BroadcastReceiver mActivityReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null)
                return;

            if (action.equals(UPDATE_VIEWS) && !isFinishing()) {
				doUpdateLayout();
			}

        }
    };


	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerPanel.getToogle() != null && mDrawerPanel.getToogle().onOptionsItemSelected(item)) {
            return true;
        }

		// Menu Itens
		switch (item.getItemId()) {
            
            case R.id.miSettings:
				offlineUpdate();
			break;
            
            case R.id.miSettings1:
				showExitDialog();
			break;
            
            case R.id.CopyLogs:
            darkModes();
		   	//Intent Intent = new Intent(this, ConfigGeralActivity.class);
			   // startActivity(Intent);
			break;
           
	    	case R.id.miLimparLogs:
			mLogAdapter.clearLog();
			SkStatus.logInfo("Log Clear!");
			break;
            
            case R.id.Share_Logs:
				Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,SkStatus.CopyLogs());
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, SkStatus.CopyLogs());
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
				break;

            case R.id.pogso:
               Intent Intent1 = new Intent(this, ServerStatusActivity.class);
			   startActivity(Intent1);
				break; 
            
           // case R.id.pogso:
              // Intent Intent1 = new Intent(this, ServerStatusActivity.class);
			 //  startActivity(Intent1);
				//break; 

		}

		return super.onOptionsItemSelected(item);
	}

	@Override
    public void onResume() {
        super.onResume();
        if (!mTimerEnabled) {

            resumeTime(); 
        }
        
        SharedPreferences prefs = mConfig.getPrefsPrivate();
        SharedPreferences.Editor edit = prefs.edit();
        int server = prefs.getInt("LastSelectedServer", 0);
        int payload = prefs.getInt("LastSelectedPayload", 0);
		serverSpinner.setSelection(server);
        payloadSpinner.setSelection(payload);
        if(SkStatus.isTunnelActive()){
			serverSpinner.setEnabled(false);
			payloadSpinner.setEnabled(false);
		} else {
			serverSpinner.setEnabled(true);
			payloadSpinner.setEnabled(true);
		}
        edit.apply();
        new Timer().schedule(new TimerTask()
			{
				@Override
				public void run()
				{
					runOnUiThread(new Runnable()
						{
							@Override
							public void run()
							{
								//adsPopUp();
								updateHeaderCallback();
								// TODO: Implement this method
							}
						});
					// TODO: Implement this method
				}
			}, 0,1000);
		SkStatus.addStateListener(this);
		if (adsBannerView != null) {
			adsBannerView.resume();
		}
        mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>()
			{
				@Override
				public void onSuccess(AppUpdateInfo result) {
					if(result.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS)
					{
						try {
							mAppUpdateManager.startUpdateFlowForResult(result, AppUpdateType.IMMEDIATE, MainActivity.this,
																	   RC_APP_UPDATE);

						} catch (IntentSender.SendIntentException e) {}}
				}
			});
    }

	@Override
	protected void onPause() {
		super.onPause();
		doSaveData();
		SkStatus.removeStateListener(this);
		if (adsBannerView != null) {
			adsBannerView.pause();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
        
       SharedPreferences prefs = mConfig.getPrefsPrivate();
        SharedPreferences.Editor edit = prefs.edit();
        int server = serverSpinner.getSelectedItemPosition();
        int payload = payloadSpinner.getSelectedItemPosition();
        edit.putInt("LastSelectedServer", server);
        edit.putInt("LastSelectedPayload", payload);
        edit.apply();

		LocalBroadcastManager.getInstance(this).unregisterReceiver(mActivityReceiver);	
		if (adsBannerView != null) {
			adsBannerView.destroy();
		}
	}

	public static void updateMainViews(Context context) {
		Intent updateView = new Intent(UPDATE_VIEWS);
		LocalBroadcastManager.getInstance(context).sendBroadcast(updateView);
	}
     private void darkModes() {
		
		final boolean isNightMode = new Settings(this).getModoNoturno().equals("on");
		

		if (isNightMode){
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
			new Settings(this).setModoNoturno("off");
			recreate();
		}else{
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
			new Settings(this).setModoNoturno("on");
			recreate();
		}
		
	}
    @Override
	public void onBackPressed() {

if (mDrawerPanel.getDrawerLayout().isDrawerOpen(GravityCompat.START)) {
            mDrawerPanel.getDrawerLayout().closeDrawers();
        }
		else {
			// mostra opção para sair
			showExitDialog();
            showInterstitial();
		}
	}
    private void showExitDialog() {
		MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
		alertDialogBuilder.setMessage("Are you sure you want to exit?");
		alertDialogBuilder.setNegativeButton("Minimize", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					Intent startMain = new Intent(Intent.ACTION_MAIN);
					startMain.addCategory(Intent.CATEGORY_HOME);
					startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(startMain);
				}
			});
		alertDialogBuilder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					android.os.Process.killProcess(android.os.Process.myPid());
					System.exit(0);
					if (TunnelUtils.isActiveVpn(MainActivity.this)) {
						Utils.exitAll(MainActivity.this);
					}
				}
			});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}
    
    private void watcher(){
       MaterialAlertDialogBuilder prog = new MaterialAlertDialogBuilder(this);
        prog.setView(R.layout.custom1);
        ppd = prog.create();
        ppd.getWindow().getAttributes().windowAnimations = R.style.dialog;
		ppd.setCanceledOnTouchOutside(false);
        ppd.show();
        
        }

    
    private void start(){

		if (saved_ads_time == 0){

			Toast.makeText(MainActivity.this, "Your time is expiring soon, please click ADD TIME to renew access!", Toast.LENGTH_LONG).show();

			long millisInput = 3600 * 1000;

			setTime(millisInput);
		}

		if (!mTimerRunning){
			goGreenTimer();
		}

    }


    private void stop() {
        if (mTimerRunning) {
            stopGreenTimer();
        }

    }

    private void stopGreenTimer() {
		mCountDownTimer.cancel();
		mTimerRunning = false;
		mConnected = false;
	}

    private void updateCountDownText() {
        long toDays = TimeUnit.MILLISECONDS.toDays(mTimeLeftInMillis);
        long toMillis = TimeUnit.DAYS.toMillis(toDays);
        long toHours = TimeUnit.MILLISECONDS.toHours(mTimeLeftInMillis - toMillis);
        long toMillis2 = TimeUnit.HOURS.toMillis(toHours);
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes((mTimeLeftInMillis - toMillis) - toMillis2);
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(((mTimeLeftInMillis - toMillis) - toMillis2) - TimeUnit.MINUTES.toMillis(toMinutes));
        String timeLeftFormatted;
        if (toDays > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                                              "%02d:%02d:%02d:%02d", toDays, toHours, toMinutes, toSeconds);
        }else{
            timeLeftFormatted = String.format(Locale.getDefault(), 
											  "%02d:%02d:%02d:%02d", toDays, toHours, toMinutes, toSeconds);            
        }
        mTextViewCountDown.setText(timeLeftFormatted);
    }


    private void addTime(long time){

        setTime(time);

        if (mTimerRunning){
            stopGreenTimer();
        }

        goGreenTimer();
    }


	private void setTime(long milliseconds) {

		saved_ads_time = mTimeLeftInMillis + milliseconds;

		mTimeLeftInMillis = saved_ads_time;
		updateCountDownText();

	}

	private void saveTime(){
		SharedPreferences saved_current_time = getSharedPreferences("time", Context.MODE_PRIVATE);

		SharedPreferences.Editor time_edit = saved_current_time.edit();

		time_edit.putLong("ADD_EVENT", mTimeLeftInMillis);

		time_edit.apply();
	}

	private void resumeTime(){
		SharedPreferences time = getSharedPreferences("time", Context.MODE_PRIVATE);
        long saved_time = time.getLong("ADD_EVENT", 0);

		setTime(saved_time);

		// Use this code to continue time if app close accidentally while connected

		String state = SkStatus.getLastState();

	    if (SkStatus.SSH_CONECTADO.equals(state)) {
			if (!mTimerRunning){
				goGreenTimer();
			}
		}
		mTimerEnabled = true;
	}

    private void btnTimer() {

		mBtnCountDown = new CountDownTimer(10000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {
				mTimeLeftBtn = millisUntilFinished;
				mButtonSet.setEnabled(false);
				updateBtnText();
			}
			@Override
			public void onFinish() {
				mButtonSet.setEnabled(true);
				mButtonSet.setText("ADD TIME");
			}

		}.start();

	}

	private void updateBtnText() {
		int seconds = (int) (mTimeLeftBtn / 1000) % 60;
		String timeLeftFormatted;
		if (seconds > 0) {
			timeLeftFormatted = String.format(Locale.getDefault(),
											  "%02d", seconds);

			mButtonSet.setText("Refresh in " + timeLeftFormatted);

		}
	}

    private void goGreenTimer() {
		mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;
		mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {


			@Override
			public void onTick(long millisUntilFinished) {
				mTimeLeftInMillis = millisUntilFinished;
				saveTime();
				updateCountDownText();

			}
			@Override
			public void onFinish() {
				mTimerRunning = false;
				stopGreenTimer();
				saved_ads_time = 0;
				Intent stopVPN = new Intent(SocksHttpService.TUNNEL_SSH_STOP_SERVICE);
				LocalBroadcastManager.getInstance(MainActivity.this)
					.sendBroadcast(stopVPN);

				Toast.makeText(MainActivity.this,"Time expired! Click Add + Time to renew access!", Toast.LENGTH_LONG).show();

			}

		}.start();
		mTimerRunning = true;

		mConnected = true;
	}
	
	
	private void stopService (){
		Intent stopVPN = new Intent(SocksHttpService.TUNNEL_SSH_STOP_SERVICE);
		LocalBroadcastManager.getInstance(MainActivity.this)
			.sendBroadcast(stopVPN);
	}
    
	private void GreenAd() {
		AdRequest adRequest = new AdRequest.Builder().build();
		InterstitialAd.load(
			this,
			AD_UNIT_ID,
			adRequest,
			new InterstitialAdLoadCallback() {
				@Override
				public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
					MainActivity.this.interstitialAd = interstitialAd;
					interstitialAd.setFullScreenContentCallback(
						new FullScreenContentCallback() {
							@Override
							public void onAdDismissedFullScreenContent() {
								MainActivity.this.interstitialAd = null;

							}

							@Override
							public void onAdFailedToShowFullScreenContent(AdError adError) {
								MainActivity.this.interstitialAd = null;

							}

							@Override
							public void onAdShowedFullScreenContent() {

							}
						});
				}

				@Override
				public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
					interstitialAd = null;
					MainActivity.toast(getApplicationContext(), R.color.red, "Failed To Load Inters Ads");	


				}
			});
	}
	
	private void showInterstitial() {
		// Show the ad if it's ready. Otherwise toast and restart the game.
		if (interstitialAd != null) {
			interstitialAd.show(this);

		}else{
			GreenAd();
		}


    }
    private void showRewardedVideo() {
        if (rewardedAd == null) {
            return;
        }
        rewardedAd.setFullScreenContentCallback(
            new FullScreenContentCallback() {
                @Override
                public void onAdShowedFullScreenContent() {


                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    rewardedAd = null;

                }
                @Override
                public void onAdDismissedFullScreenContent() {
                    rewardedAd = null;
                    btnTimer();
                }
            });
        Activity activityContext = MainActivity.this;
        rewardedAd.show(
            activityContext,
            new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(RewardItem rewardItem) {
                    MainActivity.toast(MainActivity.this,R.color.green,"+2hr added to your time");
					addTime(Long.valueOf(2*3600*1000));
			    	btnTimer();
					ppd.dismiss();
                }
            });
    }
	private void loadRewardedAd() {
        if (rewardedAd == null) {
            isLoading = true;
            AdRequest adRequest = new AdRequest.Builder().build();
            RewardedAd.load(
                this,
                AD_UNIT_INTERS,
                adRequest,
                new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad( LoadAdError loadAdError) {
                        rewardedAd = null;
                        ppd.dismiss();
                        MainActivity.toast(MainActivity.this,R.color.red,"Failed to load Ads !");
                    }

                    @Override
                    public void onAdLoaded(RewardedAd rewardedAd) {
                        MainActivity.this.rewardedAd = rewardedAd;
                        MainActivity.this.isLoading = false;
                        showRewardedVideo();
                        ppd.dismiss();
                    }
                });
        }
    }
	
        public static void toast(Context contxt, int color, String string){
		LayoutInflater inflater = (LayoutInflater) contxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.toast, (ViewGroup) null );
        LinearLayout ll1 = new LinearLayout(contxt);
		Toast llIl = Toast.makeText(contxt,Html.fromHtml(""),Toast.LENGTH_LONG);
		final TextView text1 = (TextView)inflate.findViewById(R.id.textqt);
		final ImageView img = (ImageView)inflate.findViewById(R.id.img);
        final RelativeLayout toastlayout = (RelativeLayout)inflate.findViewById(R.id.toastlayout);
		GradientDrawable var1 = new GradientDrawable();
		var1.setColor(contxt.getResources().getColor(color));
		if (color == R.color.red){
			img.setBackgroundResource(R.drawable.ic_info);

		} else if (color == R.color.colorPrimary){
			img.setBackgroundResource(R.drawable.err);

		} else if (color == R.color.green){
			img.setBackgroundResource(R.drawable.cnt);

		} else {
			img.setBackgroundResource(R.drawable.err);

		}
        var1.setCornerRadius((float)50);
        var1.setOrientation(Orientation.RIGHT_LEFT);
        var1.setStroke(0, Color.parseColor("#ffffff"));
		text1.setText(Html.fromHtml(string));
        ll1.setBackgroundDrawable(var1);
        ll1.addView(inflate);
		llIl.setView(ll1);
		llIl.show();

	}
}


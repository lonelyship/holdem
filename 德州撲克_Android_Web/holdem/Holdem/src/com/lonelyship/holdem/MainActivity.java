package com.lonelyship.holdem;

import java.util.ArrayList;

import com.lonelyship.holdem.ShakeWorker.OnShakeWorkerListener;

import android.R.integer;
import android.app.Activity;
import android.app.Service;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,OnShakeWorkerListener{

	private ImageView iv_mCard1 = null;
	private ImageView iv_mCard2 = null;
	private ImageView iv_cCard1 = null;
	private ImageView iv_cCard2 = null;
	private ImageView iv_tCard1 = null;
	private ImageView iv_tCard2 = null;
	private ImageView iv_tCard3 = null;
	private ImageView iv_tCard4 = null;
	private ImageView iv_tCard5 = null;
	private ImageView iv_giveCard = null;
	private ImageView iv_addBet = null;
	private ImageView iv_pass = null;
	private ImageView iv_quit = null;
	private ImageView iv_finish = null;
	private ImageView iv_mTie = null;
	private ImageView iv_mWin = null;
	private ImageView iv_mLose = null;
	private ImageView iv_cTie = null;
	private ImageView iv_cWin = null;
	private ImageView iv_cLose = null;
	private ImageView iv_money = null;
	private ImageView iv_bet = null;
	private ImageView iv_deathwing = null;
	private ImageView iv_janna = null;
	private ImageView iv_walila = null;

	private TextView tv_money = null;
	private TextView tv_bet = null;

	private TextView tv_mType = null;
	private TextView tv_cType = null;

	private ArrayList<Integer> al_card = new ArrayList<Integer>();
	private ArrayList<Integer> al_cardRemain = new ArrayList<Integer>();
	private ArrayList<Integer> al_mAllPoint = new ArrayList<Integer>();
	private ArrayList<Integer> al_mAllSuit = new ArrayList<Integer>();
	private ArrayList<Integer> al_cAllPoint = new ArrayList<Integer>();
	private ArrayList<Integer> al_cAllSuit = new ArrayList<Integer>();
	private ArrayList<Integer> al_allPointNum = new ArrayList<Integer>(); // 七張牌1~13點各點張數
	// private int iM_point1;
	// private int iM_point2;
	// private int iM_suit1;
	// private int iM_suit2;
	// private int iC_point1;
	// private int iC_point2;
	// private int iC_suit1;
	// private int iC_suit2;
	// private int iT_point1;
	// private int iT_point2;
	// private int iT_point3;
	// private int iT_point4;
	// private int iT_point5;
	// private int iT_suit1;
	// private int iT_suit2;
	// private int iT_suit3;
	// private int iT_suit4;
	// private int iT_suit5;
	private int step = 0;
	private int iMoney = 0;
	private int iBet = 0;
	private int iBetUnit = 0;

	private int mX[] = new int[9];
	private int mS[] = new int[9];

	private int cX[] = new int[9];
	private int cS[] = new int[9];
	
	private ShakeWorker shakeWorker=null;
	private int shakeWorkerTimes = 0;
	

	enum cardType {
		straightFlush, fourOfAKind, flush, fullHouse, straight, threeOfAKind, twoPair, onePair, highCard; // 牌形有9種可能
																											// :同花順(8)
																											// 四條(7)
																											// 同花(6)
																											// 葫蘆(5)
																											// 順子(4)
																											// 三條(3)
																											// 兩對(2)
																											// 一對(1)
																											// 高牌(0)
		public int getLevel() {
			switch (this) {
			case straightFlush:
				return 8;
			case fourOfAKind:
				return 7;
			case flush:
				return 6;
			case fullHouse:
				return 5;
			case straight:
				return 4;
			case threeOfAKind:
				return 3;
			case twoPair:
				return 2;
			case onePair:
				return 1;
			case highCard:
				return 0;
			default:
				return 0;

			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		shakeWorker = new ShakeWorker(this, this);
		
		iMoney = 100000;
		iBetUnit = 1000;

		for (int i = 0; i <= 52; i++) {
			al_cardRemain.add(1);
		}

		al_card.add(R.drawable.card_0);
		al_card.add(R.drawable.card_1);
		al_card.add(R.drawable.card_2);
		al_card.add(R.drawable.card_3);
		al_card.add(R.drawable.card_4);
		al_card.add(R.drawable.card_5);
		al_card.add(R.drawable.card_6);
		al_card.add(R.drawable.card_7);
		al_card.add(R.drawable.card_8);
		al_card.add(R.drawable.card_9);
		al_card.add(R.drawable.card_10);
		al_card.add(R.drawable.card_11);
		al_card.add(R.drawable.card_12);
		al_card.add(R.drawable.card_13);
		al_card.add(R.drawable.card_14);
		al_card.add(R.drawable.card_15);
		al_card.add(R.drawable.card_16);
		al_card.add(R.drawable.card_17);
		al_card.add(R.drawable.card_18);
		al_card.add(R.drawable.card_19);
		al_card.add(R.drawable.card_20);
		al_card.add(R.drawable.card_21);
		al_card.add(R.drawable.card_22);
		al_card.add(R.drawable.card_23);
		al_card.add(R.drawable.card_24);
		al_card.add(R.drawable.card_25);
		al_card.add(R.drawable.card_26);
		al_card.add(R.drawable.card_27);
		al_card.add(R.drawable.card_28);
		al_card.add(R.drawable.card_29);
		al_card.add(R.drawable.card_30);
		al_card.add(R.drawable.card_31);
		al_card.add(R.drawable.card_32);
		al_card.add(R.drawable.card_33);
		al_card.add(R.drawable.card_34);
		al_card.add(R.drawable.card_35);
		al_card.add(R.drawable.card_36);
		al_card.add(R.drawable.card_37);
		al_card.add(R.drawable.card_38);
		al_card.add(R.drawable.card_39);
		al_card.add(R.drawable.card_40);
		al_card.add(R.drawable.card_41);
		al_card.add(R.drawable.card_42);
		al_card.add(R.drawable.card_43);
		al_card.add(R.drawable.card_44);
		al_card.add(R.drawable.card_45);
		al_card.add(R.drawable.card_46);
		al_card.add(R.drawable.card_47);
		al_card.add(R.drawable.card_48);
		al_card.add(R.drawable.card_49);
		al_card.add(R.drawable.card_50);
		al_card.add(R.drawable.card_51);
		al_card.add(R.drawable.card_52);
		al_card.add(R.drawable.card_0);

		initData();
		initialLayoutComponent();

	}

	public void initialLayoutComponent() {
		iv_mCard1 = (ImageView) findViewById(R.id.iv_mcard1);
		iv_mCard2 = (ImageView) findViewById(R.id.iv_mcard2);
		iv_cCard1 = (ImageView) findViewById(R.id.iv_ccard1);
		iv_cCard2 = (ImageView) findViewById(R.id.iv_ccard2);
		iv_tCard1 = (ImageView) findViewById(R.id.iv_tcard1);
		iv_tCard2 = (ImageView) findViewById(R.id.iv_tcard2);
		iv_tCard3 = (ImageView) findViewById(R.id.iv_tcard3);
		iv_tCard4 = (ImageView) findViewById(R.id.iv_tcard4);
		iv_tCard5 = (ImageView) findViewById(R.id.iv_tcard5);
		iv_giveCard = (ImageView) findViewById(R.id.iv_givecard);
		iv_addBet = (ImageView) findViewById(R.id.iv_addbet);
		iv_pass = (ImageView) findViewById(R.id.iv_pass);
		iv_quit = (ImageView) findViewById(R.id.iv_quit);
		iv_finish = (ImageView) findViewById(R.id.iv_finish);
		iv_mTie = (ImageView) findViewById(R.id.iv_mtie);
		iv_mWin = (ImageView) findViewById(R.id.iv_mwin);
		iv_mLose = (ImageView) findViewById(R.id.iv_mlose);
		iv_cTie = (ImageView) findViewById(R.id.iv_ctie);
		iv_cWin = (ImageView) findViewById(R.id.iv_cwin);
		iv_cLose = (ImageView) findViewById(R.id.iv_close);
		iv_money = (ImageView) findViewById(R.id.iv_money);
		iv_bet = (ImageView) findViewById(R.id.iv_bet);
		iv_deathwing = (ImageView) findViewById(R.id.iv_deathwing);
		iv_janna = (ImageView) findViewById(R.id.iv_janna);
		iv_walila = (ImageView) findViewById(R.id.iv_walila);
		tv_money = (TextView) findViewById(R.id.tv_money);
		tv_bet = (TextView) findViewById(R.id.tv_bet);
		tv_mType = (TextView) findViewById(R.id.tv_mType);
		tv_cType = (TextView) findViewById(R.id.tv_cType);

		iv_mCard1.setVisibility(View.INVISIBLE);
		iv_mCard2.setVisibility(View.INVISIBLE);
		iv_cCard1.setVisibility(View.INVISIBLE);
		iv_cCard2.setVisibility(View.INVISIBLE);
		iv_tCard1.setVisibility(View.INVISIBLE);
		iv_tCard2.setVisibility(View.INVISIBLE);
		iv_tCard3.setVisibility(View.INVISIBLE);
		iv_tCard4.setVisibility(View.INVISIBLE);
		iv_tCard5.setVisibility(View.INVISIBLE);
		iv_addBet.setVisibility(View.INVISIBLE);
		iv_pass.setVisibility(View.INVISIBLE);
		iv_quit.setVisibility(View.INVISIBLE);
		iv_finish.setVisibility(View.INVISIBLE);
		iv_mTie.setVisibility(View.INVISIBLE);
		iv_mWin.setVisibility(View.INVISIBLE);
		iv_mLose.setVisibility(View.INVISIBLE);
		iv_cTie.setVisibility(View.INVISIBLE);
		iv_cWin.setVisibility(View.INVISIBLE);
		iv_cLose.setVisibility(View.INVISIBLE);
		iv_deathwing.setVisibility(View.INVISIBLE);
		tv_mType.setVisibility(View.INVISIBLE);
		tv_cType.setVisibility(View.INVISIBLE);

		iv_giveCard.setVisibility(View.VISIBLE);

		iv_giveCard.setOnClickListener(this);
		iv_addBet.setOnClickListener(this);
		iv_pass.setOnClickListener(this);
		iv_quit.setOnClickListener(this);
		iv_finish.setOnClickListener(this);
		iv_deathwing.setOnClickListener(this);
        iv_addBet.setOnClickListener(this);
        iv_janna.setOnClickListener(this);
        iv_walila.setOnClickListener(this);
		
		tv_money.setText(iMoney + "");
		tv_bet.setText(iBet + "");
		
	}

	public void initData() {

		iBet = 0;

		al_mAllPoint.clear();
		al_mAllSuit.clear();
		al_cAllPoint.clear();
		al_cAllSuit.clear();

		for (int i = 0; i <= 52; i++) {
			al_cardRemain.set(i, 1);
		}

		step = 0;
		shakeWorkerTimes = 0;
	}

	// 發牌流程
	public void giveCardStep(int step) {
		switch (step) {
		case 0:
			iMoney -= iBetUnit;
			iBet += iBetUnit * 2;
			tv_money.setText(iMoney + "");
			tv_bet.setText(iBet + "");

			int index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			iv_mCard1.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			iv_mCard1.setVisibility(View.VISIBLE);

			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			iv_mCard2.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			iv_mCard2.setVisibility(View.VISIBLE);

			index = drawCard();
			index = checkReapet(index);
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_cCard1.setImageDrawable(getResources().getDrawable(
					al_card.get(0)));
			iv_cCard1.setVisibility(View.VISIBLE);

			index = drawCard();
			index = checkReapet(index);
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_cCard2.setImageDrawable(getResources().getDrawable(
					al_card.get(0)));
			iv_cCard2.setVisibility(View.VISIBLE);

			iv_giveCard.setVisibility(View.INVISIBLE);
			iv_addBet.setVisibility(View.VISIBLE);
			iv_pass.setVisibility(View.VISIBLE);
			iv_quit.setVisibility(View.VISIBLE);

			break;
		case 1:
			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard1.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			iv_tCard1.setVisibility(View.VISIBLE);

			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard2.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			iv_tCard2.setVisibility(View.VISIBLE);

			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard3.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			iv_tCard3.setVisibility(View.VISIBLE);

			break;
		case 2:
			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard4.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			iv_tCard4.setVisibility(View.VISIBLE);
			break;
		case 3:
			iv_deathwing.setVisibility(View.VISIBLE);
			
			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard5.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			iv_tCard5.setVisibility(View.VISIBLE);
			break;
		case 4:
			iv_deathwing.setVisibility(View.INVISIBLE);
			
			int iMCardType = checkCardType(al_mAllPoint, al_mAllSuit, 0)
					.getLevel();

			int iCCardType = checkCardType(al_cAllPoint, al_cAllSuit, 1)
					.getLevel();

			// Ace最大!!
			for (int i = 0; i <= 8; i++)
				if (mX[i] == 1)
					mX[i] = 14;
			for (int i = 0; i <= 8; i++)
				if (cX[i] == 1)
					cX[i] = 14;

			Boolean win = false;
			Boolean even = false; // 平手

			if (iMCardType > iCCardType)
				win = true;

			else if (iMCardType == iCCardType) {
				if (mX[iMCardType] > cX[iCCardType])
					win = true;

				else if (mX[iMCardType] == cX[iCCardType]) {

					if (mS[iCCardType] > cS[iCCardType])
						win = true;

					else if (mS[iMCardType] == cS[iCCardType])
						even = true;

					else
						win = false;

				} else
					win = false;
			}

			else
				win = false;

			if (even == true) {
				iBet = iBet / 2;
				iv_mTie.setVisibility(View.VISIBLE);
				iv_cTie.setVisibility(View.VISIBLE);// 播放平手音效
				
				MediaPlayer mp=MediaPlayer.create(this, R.raw.tie);
			    mp.start();
				

			}

			else if (win == true) {
				iBet = iBet; // 如果贏了賭池金額不變

				iv_mWin.setVisibility(View.VISIBLE);
				iv_cLose.setVisibility(View.VISIBLE);

				MediaPlayer mp=MediaPlayer.create(this, R.raw.win);
			    mp.start();
				
				// 顯示勝負結果

			} else {

				iBet = 0; // 如果輸了賭池歸0

				iv_mLose.setVisibility(View.VISIBLE);
				iv_cWin.setVisibility(View.VISIBLE);
				
				MediaPlayer mp=MediaPlayer.create(this, R.raw.lose);
			    mp.start();
			}

			int cIndex1 = al_cAllPoint.get(0) + al_cAllSuit.get(0) * 13;
			int cIndex2 = al_cAllPoint.get(1) + al_cAllSuit.get(1) * 13;
			iv_cCard1.setImageDrawable(getResources().getDrawable(
					al_card.get(cIndex1)));
			iv_cCard2.setImageDrawable(getResources().getDrawable(
					al_card.get(cIndex2)));

			iv_addBet.setVisibility(View.INVISIBLE);
			iv_pass.setVisibility(View.INVISIBLE);
			iv_quit.setVisibility(View.INVISIBLE);
			iv_finish.setVisibility(View.VISIBLE);

			 Log.e("我的點數", al_mAllPoint.toString());
			// Log.e("我的花色", al_mAllSuit.toString());
			// Log.e("電腦的點數", al_cAllPoint.toString());
			// Log.e("電腦的花色", al_cAllSuit.toString());
			// Log.e("我的牌形", checkCardType(al_mAllPoint, al_mAllSuit,0) + ":"
			// + iMCardType);
			// Log.e("我的牌形各點數張數", al_allPointNum.toString());
			// Log.e("電腦的牌形", checkCardType(al_cAllPoint, al_cAllSuit,1) + ":"
			// + iCCardType);
			// Log.e("電腦的牌形各點數張數", al_allPointNum.toString());

			break;
		default:
			break;
		}

	}

	public int drawCard() {
		int points = 0;
		int suit = 0;
		int index = 0;
		points = (int) (Math.random() * 13 + 1); // 產生隨機點數 1~13
		suit = (int) (Math.random() * 4); // 產生隨機花色 0:梅花 1:磚塊 2:愛心 3:黑桃
		index = points + suit * 13;
		return index;
	}

	public int checkReapet(int index) {
		do {
			index = drawCard();
		} while (al_cardRemain.get(index) != 1);
		al_cardRemain.set(index, 0);
		return index;
	}

	public int getPoint(int index) {
		int point = 0;
		if (index % 13 == 0) {
			point = 13;
		} else {
			point = index % 13;
		}
		return point;
	}

	public int getSuit(int index) {
		int suit = 0;
		if (index % 13 == 0) {
			suit = (index / 13) - 1;
		} else {
			suit = index / 13;
		}
		return suit;
	}

	// 檢查牌形
	public cardType checkCardType(ArrayList<Integer> al_point,
			ArrayList<Integer> al_suit, int who) {
		Boolean straightFlush = false; // 同花順
		Boolean fourOfAKind = false; // 四條
		Boolean flush = false; // 同花
		Boolean fullHouse = false; // 葫蘆
		Boolean straight = false; // 順子
		Boolean threeOfAKind = false; // 三條
		Boolean twoPair = false; // 兩對
		Boolean onePair = false; // 一對
		Boolean highCard = false; // 高牌

		int myX[] = new int[9];
		int myS[] = new int[9];

		al_allPointNum.clear();

		for (int i = 0; i < 13; i++) {
			al_allPointNum.add(0);
		}

		int tempPoint = 0;
		for (int i = 0; i < 7; i++) {
			tempPoint = al_point.get(i);
			al_allPointNum.set(tempPoint - 1,
					al_allPointNum.get(tempPoint - 1) + 1);
		}

		for (int i = 0; i <= 8; i++) { // 初始化各陣列
			myX[i] = 0;
			myS[i] = 0;
		}

		ArrayList<Integer> al_TempOne = (ArrayList<Integer>) al_allPointNum
				.clone();
		ArrayList<Integer> al_TempTwo = (ArrayList<Integer>) al_allPointNum
				.clone();

		for (int i = 0; i < 13; i++) {
			if (al_allPointNum.get(i) == 4) {
				fourOfAKind = true; // 如果其中一個點數有四張 四條成立
				if (i + 1 > myX[7])
					myX[7] = i + 1; // 牌形為四條時最大點數為(i+1)點
				if (myX[7] == 1)
					myX[7] = 14; // 如果愈打最大點數為Ace 暫時將最大點數設為14
			}

			else if (al_allPointNum.get(i) == 3) {

				threeOfAKind = true; // 如果其中一個點數有三張 三條成立
				if (i + 1 > myX[3])
					myX[3] = i + 1;
				if (myX[3] == 1)
					myX[3] = 14;
				// 牌形為三條時最大點數為(i+1)點
				al_TempOne.set(i, 0); // 把myTempOne[]中該點張數歸0
				for (int j = 0; j < 13; j++) {
					if (al_TempOne.get(j) >= 2) {
						fullHouse = true; // 如果其中一個點數有三張 而且另一個點數有兩張以上 則葫蘆成立
						if (i + 1 > myX[5])
							myX[5] = i + 1;
						if (myX[5] == 1)
							myX[5] = 14; // 牌形為葫蘆時最大點數為(i+1)
					}
				}

				al_TempOne.set(i, 3); // 回復myTempOne[i]=3
			} else if (al_allPointNum.get(i) == 2) {
				onePair = true; // 如果如果其中一個點數有兩張 一對成立
				if (i + 1 > myX[1])
					myX[1] = i + 1;
				if (myX[1] == 1)
					myX[1] = 14; // 牌形為一對時最大點數為(i+1)
				al_TempTwo.set(i, 0); // 把myTempTwo[]中該點張數歸0
				for (int j = 0; j < 13; j++) {
					if (al_TempTwo.get(j) == 2) {
						twoPair = true; // 如果如果其中一個點數有兩張 而且另一個點數有兩張兩對成立
						if (i + 1 > myX[2])
							myX[2] = i + 1;
						if (myX[2] == 1)
							myX[2] = 14; // 當牌形為兩對時最大點數為(i+1)點
					}
				}

				al_TempTwo.set(i, 2); // 回復myTempTwo[i]=2;
			}

			else if (al_allPointNum.get(i) == 1) {

				highCard = true;
				if (i + 1 > myX[0])
					myX[0] = i + 1;
				if (myX[0] == 1)
					myX[0] = 14; // 當牌形為高牌時大點數為(i+1)點
			}
		}

		// 以下判斷是否為順子,如果是順子 ,找出順子中的最大點數給myX[4]存 ;
		// myCardResult[i] (i=[0~12] :1~13 點各個點張數)
		// 最大的順子為 (9 , 10 , 11 , 12, 1)

		ArrayList<Integer> al_TempF = (ArrayList<Integer>) al_allPointNum
				.clone();
		// 創一個 myTempF[i]陣列存個點張數 (i=0~13)
		// myTempF[13]用來複製 myTempF[0]的張數
		// 用來判斷 順子[10,11,12,13,1]的情形

		// myTempF[i]複製myCardResult[i]
		// 存1~13各點張數

		al_TempF.add(al_TempF.get(0)); // myTempF[13]用來複製 myTempF[0](一點) 的張數

		int count = 0; // count用來記錄出現連續幾個數字,如果count>=5則為順子

		for (int i = 0; i < 14; i++) {
			if (al_TempF.get(i) >= 1) {
				count++;
			} else {
				count = 0; // 若myTempF[i]<1 代表連續數字中斷 把count歸0
			}

			if (count >= 5) {

				straight = true;
				myX[4] = (i + 1); // 如果為順子,myX[4]最大點數為(i+1)
									// 若最大點數為Ace,暫時存為14,後面再處理回1
			}
		}

		// 判斷是否為同花 並找出同花時的花色及最大數字

		int mySuitCount[] = new int[4]; // mySuitCount[] 各種花色總張數
		for (int i = 0; i < 4; i++)
			mySuitCount[i] = 0;

		for (int i = 0; i < 7; i++) {

			mySuitCount[al_suit.get(i)] += 1;

		}
		for (int i = 0; i < 4; i++) {
			int temp = 0;
			if (mySuitCount[i] >= 5) {

				for (int j = 0; j < 7; j++) {

					if (al_suit.get(j) == i) {

						if (al_point.get(j) == 1)
							myX[6] = 14;

						else if (al_point.get(j) > temp) {

							myX[6] = al_point.get(j); // 算出同花時的最大點數

						}

						temp = myX[6];

					}
				}

				flush = true; // 如果其中一花色超過5張 同花成立
			}

		}

		for (int i = 0; i <= 8; i++)
			if (myX[i] == 14)
				myX[i] = 1; // 判斷完最大點數後 如果myX[i]=14; 將myX[i]回復為Ace

		// 當雙方牌形為兩對或一對或高牌時 最大點數可能與對手相同 這時候需用myS[]比較花色

		for (int i = 0; i <= 8; i++) {
			// 同花順(8) 四條(7) 同花(6) 葫蘆(5) 順子(4) 三條(3) 兩對(2) 一對(1) 高牌(0)

			for (int j = 0; j < 7; j++) {
				if (al_point.get(j) == myX[i]) // 如果我的牌中第j張牌之點數等於i牌形的最大點數時
				{
					if (al_point.get(j) >= myS[i]) // 如果我的牌中第j張牌之花色>=myS[i]
													// (先前最大點數之花色)
					{
						myS[i] = al_suit.get(j); // 紀錄最大點數之花色為第j張牌之花色
					}
				}
			}
		}
		if (who == 0) {
			mX = myX;
			mS = myS;
		} else {
			cX = myX;
			cS = myS;
		}

		tv_mType.setVisibility(View.VISIBLE);
		tv_cType.setVisibility(View.VISIBLE);

		if (who == 0) {

			if (straightFlush == true) {
				tv_mType.setText("同花順");
				return cardType.straightFlush;
			} else if (fourOfAKind == true) {
				tv_mType.setText("四條");
				return cardType.fourOfAKind;
			} else if (flush == true) {
				tv_mType.setText("同花");
				return cardType.flush;
			} else if (fullHouse == true) {
				tv_mType.setText("葫蘆");
				return cardType.fullHouse;
			} else if (straight == true) {
				tv_mType.setText("順子");
				return cardType.straight;
			} else if (threeOfAKind == true) {
				tv_mType.setText("三條");
				return cardType.threeOfAKind;
			} else if (twoPair == true) {
				tv_mType.setText("兩對");
				return cardType.twoPair;
			} else if (onePair == true) {
				tv_mType.setText("一對");
				return cardType.onePair;
			} else {
				tv_mType.setText("高牌");
				return cardType.highCard;
			}
		} else {
			if (straightFlush == true) {
				tv_cType.setText("同花順");
				return cardType.straightFlush;
			} else if (fourOfAKind == true) {
				tv_cType.setText("四條");
				return cardType.fourOfAKind;
			} else if (flush == true) {
				tv_cType.setText("同花");
				return cardType.flush;
			} else if (fullHouse == true) {
				tv_cType.setText("葫蘆");
				return cardType.fullHouse;
			} else if (straight == true) {
				tv_cType.setText("順子");
				return cardType.straight;
			} else if (threeOfAKind == true) {
				tv_cType.setText("三條");
				return cardType.threeOfAKind;
			} else if (twoPair == true) {
				tv_cType.setText("兩對");
				return cardType.twoPair;
			} else if (onePair == true) {
				tv_cType.setText("一對");
				return cardType.onePair;
			} else {
				tv_cType.setText("高牌");
				return cardType.highCard;
			}

		}

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		MediaPlayer mp;
		switch (id) {
		case R.id.iv_givecard:
			giveCardStep(step);
			step++;
			break;
		case R.id.iv_addbet:
			mp=MediaPlayer.create(this, R.raw.addbet);
		    mp.start();
			if ((iMoney - iBetUnit) > 0) {
				iMoney -= iBetUnit;
				iBet += iBetUnit * 2;
			} else if ((iMoney - iBetUnit) < 0) {
				iBet += iMoney;
				iMoney = 0;
			}
			tv_money.setText(iMoney + "");
			tv_bet.setText(iBet + "");
			break;
		case R.id.iv_pass:
			giveCardStep(step);
			step++;
			break;
		case R.id.iv_quit:
			iMoney += iBet / 4; // 中途棄牌能拿回自己下注一半的錢
			initData();
			initialLayoutComponent();
			break;
		case R.id.iv_finish:
			iMoney += iBet;
			initData();
			initialLayoutComponent();
			break;
		case R.id.iv_deathwing:
			onClickDeathWing();
			shakeWorkerTimes++;
			break;
		case R.id.iv_janna:
			mp=MediaPlayer.create(this, R.raw.jannathreat);
		    mp.start();
			break;
		case R.id.iv_walila:
			mp=MediaPlayer.create(this, R.raw.walilathreat);
		    mp.start();
			break;	
		default:
			break;
		}
	}
	
	public void onClickDeathWing(){
		
		MediaPlayer mp=MediaPlayer.create(this, R.raw.deathwing);
	    mp.start();
		
		Toast.makeText(this, "我~~~是力量的化身!!", Toast.LENGTH_SHORT).show();
		
		for(int i = 2 ; i < 7 ; i++){
			al_cAllPoint.remove(2);
			al_cAllSuit.remove(2);
			al_mAllPoint.remove(2);
			al_mAllSuit.remove(2);
		}
		
			int index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard1.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			
			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard2.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));

			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard3.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			
			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard4.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			
			index = drawCard();
			index = checkReapet(index);
			al_mAllPoint.add(getPoint(index));
			al_mAllSuit.add(getSuit(index));
			al_cAllPoint.add(getPoint(index));
			al_cAllSuit.add(getSuit(index));
			iv_tCard5.setImageDrawable(getResources().getDrawable(
					al_card.get(index)));
			
			
			iv_deathwing.setVisibility(View.INVISIBLE);
			
			
	}

	@Override
	public void onMShakeWork() {

	if(step == 4){
		shakeWorkerTimes++;
		if(shakeWorkerTimes <= 8){
			Vibrator myVibrator = (Vibrator) getApplication().getSystemService(Service.VIBRATOR_SERVICE);
			myVibrator.vibrate(3000);
			onClickDeathWing();	
		}
		else {
			Toast.makeText(this, "搖那麼多次~~手不會酸嗎  ╮(╯◇╰)╭", Toast.LENGTH_SHORT).show();	
		}
		
		Log.e("召喚死亡之翼次數",shakeWorkerTimes+"");
	}
		
	}

	@Override
	protected void onResume() {
	super.onResume();
	shakeWorker.uiOnResume();
	}

	@Override
	protected void onPause() {
		shakeWorker.uiOnPause();
		super.onPause();
		
	}
}

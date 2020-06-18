package com.test.cinema;

public class Member { // 현재 로그인한 멤버의 정보를 담는 클래
	
	public static String mNum = "0";
	public static String mId;
	public static String mPwd;
	public static String mName;
	public static String mJumin;
	public static String mAddress;
	public static String mPhone;
	public static String mEmail;
	public static String mGrade;
	public static int mMileage;
	public static int mCard;	
	
	public Member(String mNum, String mId, String mPwd, String mName, String mJumin, String mAddress, String mPhone,
			String mEmail) {
		this(mNum, mId, mPwd, mName, mJumin, mAddress, mPhone,mEmail, "실버", 0,0);
		
	}
	
	public Member(String mNum, String mId, String mPwd, String mName, String mJumin, String mAddress, String mPhone,
			String mEmail, String mGrade, int mMileage, int mCard) {
		this.mNum = mNum;
		this.mId = mId;
		this.mPwd = mPwd;
		this.mName = mName;
		this.mJumin = mJumin;
		this.mAddress = mAddress;
		this.mPhone = mPhone;
		this.mEmail = mEmail;
		this.mGrade = mGrade;
		this.mMileage = mMileage;
		this.mCard = mCard;
	}
	

	public static String getmNum() {
		return mNum;
	}

	public static String getmId() {
		return mId;
	}

	public static String getmPwd() {
		return mPwd;
	}

	public static String getmName() {
		return mName;
	}

	public static String getmJumin() {
		return mJumin;
	}

	public static String getmAddress() {
		return mAddress;
	}

	public static String getmPhone() {
		return mPhone;
	}

	public static String getmEmail() {
		return mEmail;
	}

	public static String getmGrade() {
		return mGrade;
	}

	public static int getmMileage() {
		return mMileage;
	}
	public static int getmCard() {
		return mCard;
	}
	
	

	@Override
	public String toString() {
		return "Member [mNum=" + mNum + ", mId=" + mId + ", mPwd=" + mPwd + ", mName=" + mName + ", mJumin=" + mJumin
				+ ", mAddress=" + mAddress + ", mPhone=" + mPhone + ", mEmail=" + mEmail + ", mGrade=" + mGrade
				+ ", mMileage=" + mMileage + ",mCard=" + mCard + "]";
	}
	
}

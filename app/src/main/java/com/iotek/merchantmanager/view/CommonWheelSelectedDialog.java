package com.iotek.merchantmanager.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;

import iotek.com.merchantmanager.R;


/**
 * Created by admin on 2017/11/4.
 */
public class CommonWheelSelectedDialog extends BaseWheelFragment {
    private static final int TYPE_GENDER = 0;
    private static final int TYPE_AGE = 1;
    private static final int TYPE_TALL = 2;
    private static final int TYPE_NUMBER = 3;
    private static final int TYPE_PASSWORD = 4;

    private static final String UNIT_TALL = "cm";
    private String currentItem;
    private WheelView wheelView;

    public enum Type {
        Gender(TYPE_GENDER), Age(TYPE_AGE), Tall(TYPE_TALL), Number(TYPE_NUMBER), Password(TYPE_PASSWORD);

        Type(int type) {

        }

        public static int valueOf(Type type) {
            switch (type) {
                case Gender:
                    return TYPE_GENDER;
                case Age:
                    return TYPE_AGE;
                case Tall:
                    return TYPE_TALL;
                case Number:
                    return TYPE_NUMBER;
                case Password:
                    return TYPE_PASSWORD;
                default:
                    return TYPE_GENDER;
            }
        }
    }

    private static final String[] mAgeArray;
    private static final String[] mGenderArray;
    private static final String[] mTallArray;
    private static final String[] mNumberArray;
    private static final String[] mPasswordArray;

    static {
        mAgeArray = new String[91];
        for (int i = 0; i <= 90; i++) {
            mAgeArray[i] = String.valueOf(i + 10);
        }

        mGenderArray = new String[]{"男", "女"};

        mPasswordArray = new String[]{"免密", "启用"};

        mTallArray = new String[171];
        for (int i = 0; i <= 170; i++) {
            mTallArray[i] = String.valueOf(i + 50);
        }

        mNumberArray = new String[5];
        for (int i = 0; i < 5; i++) {
            mNumberArray[i] = String.valueOf(i + 1);
        }
    }

    private static final String TAG = CommonWheelSelectedDialog.class.getSimpleName();

    public static CommonWheelSelectedDialog newInstance(Context context, String title, int height, Type type) {
        CommonWheelSelectedDialog dialogFragment = new CommonWheelSelectedDialog();
        dialogFragment.mContext = context;
        if (type == null) {
            type = Type.Gender;
        }
        dialogFragment.setArguments(initArgs(title, height, Type.valueOf(type)));
        return dialogFragment;
    }

    @Override
    public int setStyleId() {
        return R.style.CustomDarkDialog;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_wheel_selected, container,
                false);
        initDialogTitle(view);

        TextView closeDialog = (TextView) view.findViewById(R.id.close);
        TextView sureDialog = (TextView) view.findViewById(R.id.sure);

        wheelView = (WheelView) view.findViewById(R.id.wheel_view);
        wheelView.setOffset(1);

        if (!TextUtils.isEmpty(mSelectioned)) {
            setSelectioned(mSelectioned);
            if (mType == TYPE_TALL) {
                currentItem = mSelectioned.replace(UNIT_TALL, "").trim();
            } else {
                currentItem = mSelectioned;
            }
        } else {
            wheelView.setSeletion(1);
        }
        if (mType == TYPE_GENDER) {
            wheelView.setItems(Arrays.asList(getGenderDatas()));
            if (TextUtils.isEmpty(mSelectioned)) {
                currentItem = mGenderArray[1];
            }
        } else if (mType == TYPE_PASSWORD) {
            wheelView.setItems(Arrays.asList(getPasswordDatas()));
            if (TextUtils.isEmpty(mSelectioned)) {
                currentItem = mPasswordArray[1];
            }
        } else if (mType == TYPE_AGE) {
            wheelView.setItems(Arrays.asList(getAgeDatas()));
            if (TextUtils.isEmpty(mSelectioned)) {
                currentItem = mAgeArray[1];
            }
        } else if (mType == TYPE_NUMBER) {
            wheelView.setItems(Arrays.asList(getNumberDatas()));
            if (TextUtils.isEmpty(mSelectioned)) {
                currentItem = mNumberArray[1];
            }
        } else if (mType == TYPE_TALL) {
            wheelView.setItems(Arrays.asList(getTallDatas()));
            if (TextUtils.isEmpty(mSelectioned)) {
                currentItem = mTallArray[1];
            }
        } else {
            wheelView.setItems(Arrays.asList(getGenderDatas()));
            if (TextUtils.isEmpty(mSelectioned)) {
                currentItem = mGenderArray[1];
            }
        }

        wheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Log.d(TAG, "[Dialog]selectedIndex: " + selectedIndex + ", item: " + item);
                currentItem = item;
            }
        });

        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCancelListener != null) {
                    String itemContent = currentItem;
                    if (mType == TYPE_TALL) {
                        itemContent += " " + UNIT_TALL;
                    }
                    mCancelListener.doCancel(itemContent);
                }
                dismiss();
            }
        });
        sureDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSureListener != null) {
                    String itemContent = currentItem;
                    if (mType == TYPE_TALL) {
                        itemContent += " " + UNIT_TALL;
                    }
                    mSureListener.doSure(itemContent);
                }
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void setSelectioned(String item) {
        if (TextUtils.isEmpty(item)) {
            return;
        }

        if (mType == TYPE_GENDER) {
            int index = Arrays.asList(mGenderArray).indexOf(item);
            if (index != -1) {
                wheelView.setSeletion(index);
            }
        } else if (mType == TYPE_PASSWORD) {
            int index = Arrays.asList(mPasswordArray).indexOf(item);
            if (index != -1) {
                wheelView.setSeletion(index);
            }
        } else if (mType == TYPE_AGE) {
            int index = Arrays.asList(mAgeArray).indexOf(item);
            if (index != -1) {
                wheelView.setSeletion(index);
            }
        } else if (mType == TYPE_NUMBER) {
            int index = Arrays.asList(mNumberArray).indexOf(item);
            if (index != -1) {
                wheelView.setSeletion(index);
            }
        } else if (mType == TYPE_TALL) {
            if (!item.endsWith(UNIT_TALL)) {
                return;
            }

            item = item.replace(UNIT_TALL, "").trim();
            int index = Arrays.asList(mTallArray).indexOf(item);
            if (index != -1) {
                wheelView.setSeletion(index);
            }
        }
    }

    public static String[] getAgeDatas() {
        return mAgeArray;
    }

    public static String[] getGenderDatas() {
        return mGenderArray;
    }

    public static String[] getTallDatas() {
        return mTallArray;
    }

    public static String[] getNumberDatas() {
        return mNumberArray;
    }

    public static String[] getPasswordDatas() {
        return mPasswordArray;
    }

}

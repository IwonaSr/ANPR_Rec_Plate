/*
package com.example.ejwon.anpr_rec_plate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Camera;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

*/
/**
 * Created by Ejwon on 2016-05-28.
 *//*

public class NumberPlateClass extends View implements Camera.PreviewCallback {
    Mat mRgba;
    Mat mGray;
    int cols;
    int rows;
    private float mRelativePlateSize = 0.2f;
    private int mAbsolutePlateSize = 0;
    MatOfRect plates;
    private CascadeClassifier mJavaDetector;
    Rect[] platesArray;
    Bitmap og;
    List<Point> currentPlatePointList = new ArrayList<Point>();
    List<Rect> currentPlates = new ArrayList<Rect>();
    List<Point> platePointList;



    public NumberPlateClass(Context context) {
        super(context);
    }

    @Override
    public void onPreviewFrame(final byte[] data, final Camera camera) {

        try {
            Camera.Size size = camera.getParameters().getPreviewSize();
            loadImage(data, size.height, size.width);

            camera.addCallbackBuffer(data);
        } catch (RuntimeException e) {
            // The camera has probably just been released, ignore.
        }
    }

    public void loadImage(byte [] tab, int height, int width)
    {
        mRgba = new Mat(height,width, CvType.CV_8UC4);
        mGray = new Mat(height,width, CvType.CV_8UC1);

        Mat mYuv = new Mat(height + height / 2, width, CvType.CV_8UC1);
        mYuv.put(0, 0, tab);

        Imgproc.cvtColor(mYuv, mGray, Imgproc.COLOR_YUV420sp2GRAY);
        Imgproc.cvtColor(mYuv, mRgba, Imgproc.COLOR_YUV2RGB_NV21, 4); //before 3

        if (mAbsolutePlateSize == 0) {
            int heightGray = mGray.rows();
            if (Math.round(heightGray * mRelativePlateSize) > 0) {
                mAbsolutePlateSize = Math.round(heightGray
                        * mRelativePlateSize);
            }
        }
        plates = new MatOfRect();

        if (mJavaDetector != null)
            mJavaDetector.detectMultiScale(mGray, plates, 1.1, 2, 2,
                    new Size(mAbsolutePlateSize, mAbsolutePlateSize),
                    new Size());
        // Display display = getWindowManager().getDefaultDisplay();

        postInvalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setTextSize(20);
        if (plates != null) {
            paint.setStrokeWidth(3);
            paint.setStyle(Paint.Style.STROKE);

            platesArray = plates.toArray();
            boolean isHasNewPlate = false;
            currentPlates.clear();

            for (int i = 0; i < platesArray.length; i++) {
                int x = platesArray[i].x, y = platesArray[i].y, w = platesArray[i].width, h = platesArray[i].height;
                canvas.drawRect(x, y, (x + w), (y + h), paint);

                // isNewPlate?
                Point platePoint = new Point(platesArray[i].x,
                        platesArray[i].y);

                currentPlatePointList.add(platePoint);

                currentPlates.add(platesArray[i]);

                if (utils.isNewPlate(platePointList, platePoint)) {
                    isHasNewPlate = true;
                }
            }

            if (platesArray.length > 0) {
                platePointList.clear();
                platePointList.addAll(currentPlatePointList);
            } else {
                platePointList.clear();
            }

            // If isHasNewPlate --> get sub images (ROI) --> Add to Adapter
            // (from
            // currentPlates)
            if ((isHasNewPlate || isFail) && !isRunningTask) {
                Log.e(TAG, "START DoOCR task!!!!");
                new DoOCR(currentPlates, mRgba, this).execute();
            }
        }
    }

    public void updateResult(String result) {
        // TODO Auto-generated method stub
        resultOCR.setText(result);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        String toFile = "Date: " + timeStamp + "\n";
        toFile += "Latitude: " + latitude + "\n";
        toFile += "Longitude: " + longitude + "\n";
        toFile += "Speed: " + String.valueOf(utils.roundDecimal(utils.convertSpeed(speed), 2)) + "km/h" + "\n";
        toFile += "NP: " + result + "\n\n\n";
        if(result!=null && !TextUtils.isEmpty(result) && result!=""){
            FileWriter f;
            try{
                f = new FileWriter(Environment.getExternalStorageDirectory() + "/UIT-ANPR.txt", true);
                Log.e("DON", "BAT DAU GHI FILE 2222");
                f.write(toFile);
                f.flush();
                f.close();
            }catch (Exception e) {
                // TODO: handle exception
            }
        }

    }


}
*/

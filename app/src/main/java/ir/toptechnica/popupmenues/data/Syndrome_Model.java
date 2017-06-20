package ir.toptechnica.popupmenues.data;

import android.content.Context;

import ir.toptechnica.popupmenues.R;

/**
 * Created by admin1 on 4/12/17.
 */

public class Syndrome_Model {

    private String [] Syndrome_Title;
    private String [] Syndrome_Description;
    private String [] Syndrome_Incidence;
    private String [] Syndrome_Inheritance;
    private String [] Syndrome_DDX;
    private String [] Syndrome_Menu_title;
    private int [] Syndrome_Image;
    private Context mContext;


    public Syndrome_Model(Context mContext){
        this.mContext = mContext;
        this.Syndrome_Title = mContext.getResources().getStringArray(R.array.Syndrome_item);
        this.Syndrome_Description = mContext.getResources().getStringArray(R.array.Syndrome_Description);
        this.Syndrome_Incidence = mContext.getResources().getStringArray(R.array.Syndrome_Incidence_item);
        this.Syndrome_Inheritance = mContext.getResources().getStringArray(R.array.Syndrome_Inheritance_item);
        this.Syndrome_DDX = mContext.getResources().getStringArray(R.array.Syndrome_DDX_item);
        this.Syndrome_Menu_title = mContext.getResources().getStringArray(R.array.Syndrome_Menu_title);

    }

        public String getSyndrome_Title(int index) {
            return Syndrome_Title[index];
        }
        public String getSyndrome_Description(int index) {
            return Syndrome_Description[index];
        }
        public String getSyndrome_Incidence(int index) {
            return Syndrome_Incidence[index];
        }
        public String getSyndrome_Inheritance(int index) {
            return Syndrome_Inheritance[index];
        }
        public String getSyndrome_DDX(int index) {
            return Syndrome_DDX[index];
        }
        public String getSyndrome_Menu_title(int index) {
        return Syndrome_Menu_title[index];
        }
        public int getSyndrome_Image(int index) {
        return Syndrome_Image[index];
        }
        public void setSyndrome_Image(int[] syndrome_Image) {
            Syndrome_Image = syndrome_Image;
        }

        }


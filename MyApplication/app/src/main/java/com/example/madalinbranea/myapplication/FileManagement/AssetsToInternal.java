package com.example.madalinbranea.myapplication.FileManagement;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class AssetsToInternal {
    public void copy(Context context)
    {
        copyAllFiles( context);
    }
    private void copyAllFiles(Context context)
    {
        try
        {
            String[] list = context.getAssets().list("");
            if (list.length == 0)
                return;

            for (String file : list)
            {
                copyFile(context,context.getFilesDir().getParentFile().getPath() + "/asdf/", file);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void copyFile(Context context , String $path, String $filename)
    {
        String fullPath = $path + "/" + $filename;

        File path = new File($path);
        if (!path.exists())
            path.mkdirs();

        File destPath = new File(fullPath);
        if (destPath.exists())
            destPath.delete();

        try
        {
            InputStream is = context.getResources().getAssets().open($filename, AssetManager.ACCESS_BUFFER);
            if (is == null)
                return;
            byte[] tempdata = new byte[is.available()];

            is.read(tempdata);
            is.close();
            destPath.createNewFile();
            FileOutputStream fo = new FileOutputStream(destPath);
            fo.write(tempdata);
            fo.close();
        }
        catch (Exception e)
        {
//      e.printStackTrace();
        }
    }



}

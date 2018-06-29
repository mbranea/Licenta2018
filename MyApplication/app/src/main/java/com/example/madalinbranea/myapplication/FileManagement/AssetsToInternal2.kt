package com.example.madalinbranea.myapplication.FileManagement

import android.content.Context
import android.content.res.AssetManager
import com.google.common.io.ByteStreams
import java.io.*
import java.nio.file.Files.exists
import java.io.File.separator





class AssetsToInternal2 {

    private fun copyFile(context: Context, filename: String) {
       //


            // do something

            val targetFile = File(context.filesDir, filename)
        val content =  context.assets.open("example.json");

        val output = FileOutputStream(targetFile)
        ByteStreams.copy(content, output);
        //targetFile.writeText(content);

    }

    private fun copyFile(context: Context,filename:String,value:Int) {


        val input: InputStream = context.assets.open(filename);
        val outFile: File = File(context.getExternalFilesDir(null), filename);
        val out: OutputStream = FileOutputStream(outFile);
        val buffer: ByteArray = ByteArray(1024);
        var read: Int = input.read(buffer)
        while (read != -1) {
            out.write(buffer, 0, read)
            read=input.read(buffer)
        }

        input.close();

            out.flush();
            out.close();


    }

    fun fileExist(context:Context,fname: String): Boolean {
        val file = context.getFileStreamPath(fname)
        return file.exists()
    }

    fun copy(context: Context) {
        copyFile(context,"example.json")
    }


}

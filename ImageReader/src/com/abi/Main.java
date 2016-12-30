package com.abi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Main {

	static Map<Integer,Integer> blackPixels = new TreeMap<>();
	static Map<Integer,Integer> whitePixels = new TreeMap<>();
	static Map<Integer,Integer> conflictPixels = null;

	public static final String IMG = "C:\\Users\\Abdul\\Desktop\\SigTuple_data\\Train_Data\\train-0.jpg";
	public static final String SAMPLEPATH = "C:\\Users\\Abdul\\Desktop\\SigTuple_data\\Train_Data\\";
	public static final String MASKIMG = "C:\\Users\\Abdul\\Desktop\\SigTuple_data\\Train_Data\\train-0-mask.jpg";
	public static final String OUTPUTPATH = "C:\\Users\\Abdul\\Desktop\\SigTuple_data\\";

	public static void main(String[] args) {



		try {

			List<String> sampleFiles = getSampleFile(SAMPLEPATH);

			//System.out.println(sampleFiles);

			for (String file : sampleFiles) {
				String maskFile = getMaskFile(file);
				populateBlackWhitePixels(file, maskFile);
				//System.out.println(file + "\t" + maskFile);
			}


			String img = SAMPLEPATH +"train-0.jpg";

			String output = createMask(img);


			createDataFile();




		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String createMask(String imgFile) throws IOException {
		String maskFile = getMaskFile(imgFile);
		BufferedImage img, maskImg;
		
		img = ImageIO.read(new File(imgFile));
		
		int[][] pixelData = new int[img.getHeight() * img.getWidth()][3];
		int[] maskPixelData = new int[img.getHeight() * img.getWidth()];
		int[] rgb, m;

		int counter = 0;
		for(int i = 0; i < img.getHeight(); i++){
			for(int j = 0; j < img.getWidth(); j++){
					/*rgb = getPixelData(img, i, j);
					m = getPixelData(img, i, j);
	
					for(int k = 0; k < rgb.length; k++){
						pixelData[counter][k] = rgb[k];
					}*/
				if(blackPixels.containsKey(img.getRGB(i, j))){
					maskPixelData[counter] = Color.BLACK.getRGB();
					
				}else{
					maskPixelData[counter] = Color.WHITE.getRGB();
					
				}
				

				counter++;
			}
		}
		
		maskImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);    
		maskImg.setRGB(0, 0, img.getWidth(), img.getHeight(), maskPixelData, 0, img.getWidth());
		
		File outputfile = new File(OUTPUTPATH + "abc.jpg");
		//outputfile.createNewFile();
		ImageIO.write(maskImg, "jpg", outputfile);

		
		return maskFile;
	}

	private static void createDataFile() throws IOException {
		FileOutputStream black = new FileOutputStream("black.csv");
		FileOutputStream white = new FileOutputStream("white.csv");
		FileOutputStream common = new FileOutputStream("common.csv");

		/*
		 * (argb >> 16) & 0xff, //red
				(argb >>  8) & 0xff, //green
				(argb      ) & 0xff
		 */

		for (Integer info : blackPixels.keySet()) {
			String line = info + "," + ((info>>16) & 0xff) + "," + ((info>>8) & 0xff) + "," + (info & 0xff) + 
					"," + blackPixels.get(info) + "\n";
			black.write(line.getBytes());
		}

		for (Integer info : whitePixels.keySet()) {
			String line = info + "," + ((info>>16) & 0xff) + "," + ((info>>8) & 0xff) + "," + (info & 0xff) + 
					"," + whitePixels.get(info) + "\n";
			white.write(line.getBytes());
		}

		/*for (Integer info : whitePixels.keySet()) {
			if(blackPixels.containsKey(info)){
				String line = info + "," + ((info>>16) & 0xff) + "," + ((info>>8) & 0xff) + "," + (info & 0xff) + 
						"," + whitePixels.get(info) + "," + blackPixels.get(info) + "\n";
				common.write(line.getBytes());
			}
		}*/

		for (Integer info : conflictPixels.keySet()) {

			String line = info + "," + ((info>>16) & 0xff) + "," + ((info>>8) & 0xff) + "," + (info & 0xff) + 
					"," + whitePixels.get(info) + "," + blackPixels.get(info) + "\n";
			common.write(line.getBytes());

		}

	}

	private static void populateBlackWhitePixels(String file, String maskFile) throws IOException {
		BufferedImage img, maskImg;

		img = ImageIO.read(new File(SAMPLEPATH + file));
		maskImg = ImageIO.read(new File(SAMPLEPATH +maskFile));

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				//System.out.println(maskImg.getRGB(x, y));

				if(maskImg.getRGB(x, y) == -1){

					if(whitePixels.containsKey(img.getRGB(x, y)))
						whitePixels.put(img.getRGB(x, y), whitePixels.get(img.getRGB(x, y)) + 1);
					else
						whitePixels.put(img.getRGB(x, y),1);	
				}else{
					if(blackPixels.containsKey(img.getRGB(x, y)))
						blackPixels.put(img.getRGB(x, y), blackPixels.get(img.getRGB(x, y)) + 1);
					else
						blackPixels.put(img.getRGB(x, y),1);
				}
			}

		}

		conflictPixels = new TreeMap<>(blackPixels);
		conflictPixels.keySet().retainAll(whitePixels.keySet());

		/*int[][] pixelData = new int[img.getHeight() * img.getWidth()][3];
		int[][] maskPixelData = new int[maskImg.getHeight() * maskImg.getWidth()][3];
		int[] rgb, m;

		int counter = 0;
		for(int i = 0; i < img.getHeight(); i++){
			for(int j = 0; j < img.getWidth(); j++){
				rgb = getPixelData(img, i, j);
				m = getPixelData(img, i, j);

				for(int k = 0; k < rgb.length; k++){
					pixelData[counter][k] = rgb[k];
				}

				counter++;
			}
		}*/


	}

	private static String getMaskFile(String file) {
		return file.substring(0, file.length() - 4) + "-mask.jpg";		
	}

	private static List<String> getSampleFile(String path){

		List<String> sampleFiles = new ArrayList<>();
		File folder = new File(path);

		if(folder.isDirectory()){

			File[] files = folder.listFiles();

			for (int i = 0; i < files.length; i++) {
				//System.out.println(files[i].getName());
				if(files[i].getName().endsWith(".jpg")){
					if(!files[i].getName().contains("mask"))
						sampleFiles.add(files[i].getName());
				}

			}

		}
		return sampleFiles;
	}

	private static int[] getPixelData(BufferedImage img, int x, int y) {
		int argb = img.getRGB(x, y);

		int rgb[] = new int[] {
				(argb >> 16) & 0xff, //red
				(argb >>  8) & 0xff, //green
				(argb      ) & 0xff  //blue
		};

		//System.out.println("rgb: " + rgb[0] + " " + rgb[1] + " " + rgb[2]);
		return rgb;
	}

}
